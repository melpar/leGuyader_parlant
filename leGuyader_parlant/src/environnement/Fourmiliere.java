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

  public Fourmiliere() {
    this.nidFourmiliere = new Nid();
    this.depotFourmiliere = new Depot();
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

}
