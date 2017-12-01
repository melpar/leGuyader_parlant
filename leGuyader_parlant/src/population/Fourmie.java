package population;

import population.etat.EtatAbstract;

public class Fourmie {
  private EtatAbstract etat;

  public EtatAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatAbstract etat) {
    this.etat = etat;
  }
}
