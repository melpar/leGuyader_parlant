package population;

import population.etat.EtatProieAbstract;

/**
 * 
 * @author parlanme
 *
 */
public class Proie implements TempsObserver {
  private EtatProieAbstract etat;
  private double poids;

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
}
