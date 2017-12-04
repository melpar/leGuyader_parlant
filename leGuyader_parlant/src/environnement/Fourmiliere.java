package environnement;

import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;

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
   *          Place de la Fourmiliere.
   * @param placeN
   *          Place du Nid.
   * @param placeD
   *          Place du Depot.
   */
  public Fourmiliere(Place placeF, Place placeN, Place placeD) {
    this.nidFourmiliere = new Nid(placeN);
    this.depotFourmiliere = new Depot(placeD);
    this.placeFourmiliere = placeF;
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

}
