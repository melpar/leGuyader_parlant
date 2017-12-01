package population.etat;

import temps.Duree;

/**
 * Lorsque la fourmi est à l'état de larve.
 * 
 * @author parlanme
 *
 */
public class Larve extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 10;
  private Duree avantEvolution;

  public Larve() {
    this.avantEvolution = new Duree();
    this.avantEvolution.setJour(JOUR_EVOLUTION);
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.LARVE);
  }
}
