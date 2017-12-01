package population;

import population.etat.Adulte;
import population.etat.Cadavre;
import population.etat.EtatAbstract;
import population.etat.Etats;
import population.etat.Larve;
import population.etat.Nymphe;
import temps.Duree;

public class Fourmi {
  private Duree age;
  private boolean isMale;
  private double poids;
  private double aMange;
  private int positionX;
  private int positionY;

  private EtatAbstract etat;

  public Fourmi(boolean isMale, int positionX, int positionY) {
    this.age = new Duree();
    this.isMale = isMale;
    this.poids = 0;
    this.setaMange(0);
    this.setPositionX(positionX);
    this.setPositionY(positionY);
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

  public int getPositionX() {
    return positionX;
  }

  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }

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
}
