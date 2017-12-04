package population;

import environnement.Place;
import population.etat.EtatProieAbstract;

/**
 * Permet de gérer les proies.
 * 
 * @author parlanme
 *
 */
public class Proie implements TempsObserver {
  private EtatProieAbstract etat;
  private double poids;
  private Place placeProie;

  public Proie(Place place, double poids) {
    this.placeProie = place;
    this.poids = poids;
  }

  public EtatProieAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatProieAbstract etat) {
    this.etat = etat;
  }

  @Override
  public void agitSur() {
    this.etat.changeTemps();

  }

  public double getPoids() {
    return poids;
  }

  public void setPoids(double poids) {
    this.poids = poids;
  }

  public Place getPlaceProie() {
    return placeProie;
  }

  public void setPlaceProie(Place placeProie) {
    this.placeProie = placeProie;
  }

}
