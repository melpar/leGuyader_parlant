package population;

import environnement.Place;
import population.etat.Adulte;
import population.etat.Cadavre;
import population.etat.EtatAbstract;
import population.etat.Etats;
import population.etat.Larve;
import population.etat.Nymphe;
import population.etat.Oeuf;
import temps.Duree;
import temps.Temps;

public class Fourmi implements TempsObserver {
  private Duree age;
  private boolean isMale;
  private double poids;
  private double aMange;
  private Place place;
  private Temps tempsCourant;

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
    this.poids = 0;
    this.setaMange(0);
    this.place = place;
    this.etat = new Oeuf(dureeCourante.getTempsCourant(), this);
    this.tempsCourant = dureeCourante;
  }

  public double mange(double aManger) {
    return (this.aMange += aManger);
  }

  public void nettoie() {
    // La fourmie recupere un cadavre et l'amene au depot
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
    return aMange;
  }

  public void setaMange(double aMange) {
    this.aMange = aMange;
  }

  public Place getPlace() {
    return this.place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * Permet de changer l'état d'une fourmi.
   * 
   * @param etat
   *          ancien état de la fourmi
   */
  public void changeEtat(Etats etat, Duree tempsCourant) {
    this.tempsCourant.removeObserveur(this.etat);
    switch (etat) {
      case OEUF:
        this.etat = new Larve(this, tempsCourant);
        break;
      case LARVE:
        this.etat = new Nymphe(this, tempsCourant);
        break;
      case NYMPHE:
        this.etat = new Adulte(this, tempsCourant);
        break;
      default:
        this.etat = new Cadavre(this);
        break;
    }

  }

  @Override
  public void agitSur() {
    System.out.println("Ancien etat : " + this.etat.getEtat());
    this.etat.agitSur();
    System.out.println("Nouvel etat : " + this.etat.getEtat());
  }
}
