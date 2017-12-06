package population;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fabrique.FabriqueFourmiliere;
import population.etat.Adulte;
import population.etat.Cadavre;
import population.etat.EtatAbstract;
import population.etat.Etats;
import population.etat.Larve;
import population.etat.Nymphe;
import population.etat.Oeuf;
import population.role.Reine;
import population.role.RoleAbstract;
import population.role.Roles;
import report.CompteurFourmi;
import report.Report;
import temps.Duree;
import temps.Temps;

public class Fourmi implements TempsObserver {
  private Duree age;
  private boolean isMale;
  private double poids;
  private double amange;
  private Place place;
  private Temps tempsCourant;
  private boolean enCombat;
  private EtatAbstract etat;

  /**
   * Permet de créer une fourmi.
   * 
   * @param isMale
   *          vrai s'il s'agit d'un male, faux sinon
   * @param place
   *          position a la creation
   */
  public Fourmi(boolean isMale, Place place, Temps dureeCourante) {
    this.age = new Duree();
    this.isMale = isMale;
    double poids = 15 + Math.random() * (20 - 15);
    this.poids = Math.floor(poids);
    this.setaMange(0);
    this.place = place;
    this.etat = new Oeuf(dureeCourante.getTempsCourant(), this);
    this.tempsCourant = dureeCourante;
    this.enCombat = false;

  }

  /**
   * Permet de passer une fourmi à létat de reine.
   */
  public void setReine() {
    Adulte etatReine = new Adulte(this, this.tempsCourant.getTempsCourant());
    etatReine.setRole(new Reine(this));
    this.setEtat(etatReine);
  }

  /**
   * Permet de savoir si la fourmi est une reine.
   * 
   * @return vrai si la fourmi est une reine, faux sinon
   */
  public boolean isReine() {
    if (this.etat.getEtat() != Etats.ADULTE) {
      return false;
    } else {
      return (((Adulte) this.etat).getRole().getRole() == Roles.REINE);
    }
  }

  public double mange(double amanger) {
    return (this.amange += amanger);
  }

  public void nettoie() {
    // La fourmie recupere un cadavre et l'amene au depot
  }

  /**
   * Permet de changer l'état d'une fourmi.
   * 
   * @param etat
   *          ancien état de la fourmi
   */
  public void changeEtat(Etats etat, Duree tempsCourant) {
    this.tempsCourant.removeObserveur(this.etat);
    CompteurFourmi cpt = CompteurFourmi.getInstance();
    switch (etat) {
      case OEUF:
        this.etat = new Larve(this, tempsCourant);
        cpt.applique();
        break;
      case LARVE:
        this.etat = new Nymphe(this, tempsCourant);
        cpt.applique();
        break;
      case NYMPHE:
        this.etat = new Adulte(this, tempsCourant);
        cpt.applique();
        break;
      default:
        this.etat = new Cadavre(this, tempsCourant);
        cpt.applique();
        break;
    }

  }

  @Override
  public void agitSur() {
    this.etat.agitSur();

  }

  void trace(Report report) {
    report.traceFourmi(this);
    this.etat.trace(report);
  }

  public Temps getTempsCourant() {
    return tempsCourant;
  }

  public void setTempsCourant(Temps tempsCourant) {
    this.tempsCourant = tempsCourant;
  }

  public EtatAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatAbstract etat) {
    this.etat = etat;
  }

  public Duree getAge() {
    return age;
  }

  public void setAge(Duree age) {
    this.age = age;
  }

  public boolean isMale() {
    return isMale;
  }

  public void setMale(boolean isMale) {
    this.isMale = isMale;
  }

  public double getPoids() {
    return poids;
  }

  public void setPoids(double poids) {
    this.poids = poids;
  }

  public double getaMange() {
    return amange;
  }

  public void setaMange(double amange) {
    this.amange = amange;
  }

  public Place getPlace() {
    return this.place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * Permet de créer une fourmiliere, si la foumil est une reine.
   * 
   * @return nouvelle fourmiliere
   */
  public Fourmiliere creeFourmiliere() {
    if (this.isReine()) {
      FabriqueFourmiliere fabrique = new FabriqueFourmiliere();
      return fabrique.creeFourmiliere(this.place);
    } else {
      return null;
    }
  }

  /**
   * permet, si la fourmi est une reine, de pondre les oeufs.
   */
  public void pond() {
    if (this.isReine()) {
      ((Reine) ((Adulte) this.getEtat()).getRole()).pond();
    }
  }

  public boolean isAdulte() {
    return this.etat.getEtat().equals(Etats.ADULTE);
  }

  public boolean isEnCombat() {
    return enCombat;
  }

  public void setEnCombat(boolean enCombat) {
    this.enCombat = enCombat;
  }
}
