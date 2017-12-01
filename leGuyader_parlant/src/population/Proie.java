package population;

import population.etat.EtatProieAbstract;

/**
 * 
 * @author parlanme
 *
 */
public class Proie {
  private EtatProieAbstract etat;

  public EtatProieAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatProieAbstract etat) {
    this.etat = etat;
  }
}
