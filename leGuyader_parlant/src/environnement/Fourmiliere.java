package environnement;

import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;

/**
 * Representation de la fourmiliere. Cette classe possede un Nid et un Depot.
 * 
 * @author LeGuyader
 */
public class Fourmiliere {
  private Nid nidFourmiliere;
  private Depot depotFourmiliere;
  private Place placeFourmiliere;

  /**
   * Constructeur d'une Fourmiliere.
   * 
   * @param placeF
   *          Place de la Fourmiliere et du nid
   * @param placeD
   *          Place du Depot.
   */
  public Fourmiliere(Place placeF, Place placeD) {
    this.nidFourmiliere = new Nid(placeF);
    this.depotFourmiliere = new Depot(placeD);
    this.placeFourmiliere = placeF;
  }

  /**
   * Permet de créer une fourmiliere sur une place donnée
   * 
   * @param place
   *          place donnée
   */
  public Fourmiliere(Place place) {
    this.placeFourmiliere = place;
    this.nidFourmiliere = new Nid(place);
  }

  public Nid getNidFourmiliere() {
    return nidFourmiliere;
  }

  public void setNidFourmiliere(Nid nidFourmiliere) {
    this.nidFourmiliere = nidFourmiliere;
  }

  public Depot getDepotFourmiliere() {
    return depotFourmiliere;
  }

  public void setDepotFourmiliere(Depot depotFourmiliere) {
    this.depotFourmiliere = depotFourmiliere;
  }

  public Place getPlaceFourmiliere() {
    return placeFourmiliere;
  }

  public void setPlaceFourmiliere(Place placeFourmiliere) {
    this.placeFourmiliere = placeFourmiliere;
  }

  public void ajouterFourmiNid(Fourmi nouvelleFourmi) {
    this.nidFourmiliere.ajouterFourmi(nouvelleFourmi);
  }

  public void ajouterProieNisd(Proie nouvelleProie) {
    this.nidFourmiliere.ajouterProie(nouvelleProie);
  }

}
