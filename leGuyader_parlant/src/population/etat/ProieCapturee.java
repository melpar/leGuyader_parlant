package population.etat;

import temps.Duree;

/**
 * Lorsqu'une proie est capturée par une fourmi.
 * 
 * @author parlanme
 *
 */
public class ProieCapturee extends EtatProieAbstract {
  private Duree resteAVivre;

  public Duree getResteAVivre() {
    return resteAVivre;
  }

  public void setResteAVivre(Duree resteAVivre) {
    this.resteAVivre = resteAVivre;
  }
}
