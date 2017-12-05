package population;

import environnement.Place;
import mediateur.MediateurDeplacementChasse;
import mediateur.MediateurDeplacementProie;
import population.etat.EtatProieAbstract;
import population.etat.ProieVivante;
import population.role.RoleAbstract;

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
  private MediateurDeplacementProie mediateurProie;

  public Proie(Place place, double poids) {
    super();
    this.placeProie = place;
    this.poids = poids;
    this.etat = new ProieVivante();
    this.mediateurProie = MediateurDeplacementProie.getInstance();
  }

  public EtatProieAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatProieAbstract etat) {
    this.etat = etat;
  }

  @Override
  public void agitSur() {
    System.out.print("Proie [" + this.getPlaceProie().getX() + " : ");
    System.out.print(this.getPlaceProie().getY() + "]\n");
    this.etat.changeTemps();

  }

  /**
   * Permet de déplacer la fourmi associée.
   */
  public void deplace() {
    mediateurProie.setProie(this);
    mediateurProie.deplacement();
    System.out.println(
        "Nouvelle place : " + this.getPlaceProie().getX() + "," + this.getPlaceProie().getY());
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
