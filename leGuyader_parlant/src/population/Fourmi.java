package population;

import environnement.Place;
import population.etat.Adulte;
import population.etat.Cadavre;
import population.etat.EtatAbstract;
import population.etat.Etats;
import population.etat.Larve;
import population.etat.Nymphe;
import temps.Duree;

public class Fourmi implements TempsObserver {
  private Duree age;
  private boolean isMale;
  private double poids;
  private double aMange;
  private Place place;

  private EtatAbstract etat;

  /**
   * Permet de créer une fourmi.
   * 
   * @param isMale
   *          vrai s'il s'agit d'un male, faux sinon
   * @param positionX
   *          position x à la création
   * @param positionY
   *          position y à la création
   */
  public Fourmi(boolean isMale, int positionX, int positionY, Place place) {
    this.age = new Duree();
    this.isMale = isMale;
    this.poids = 0;
    this.setaMange(0);
    this.place = place;
  }

  public double mange(double aManger) {
    return (this.aMange += aManger);
  }

  public void nettoie() {
    // La fourmie récupère un cadavre et l'amène au dépot
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
  public void changeEtat(Etats etat) {
    switch (etat) {
      case OEUF:
        this.etat = new Larve();
        break;
      case LARVE:
        this.etat = new Nymphe();
        break;
      case NYMPHE:
        this.etat = new Adulte();
        break;
      default:
        this.etat = new Cadavre();
        break;
    }

  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub

  }
}
