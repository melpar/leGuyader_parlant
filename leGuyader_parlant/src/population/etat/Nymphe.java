package population.etat;

import temps.Duree;

/**
 * Lorsque la fourmi est à l'état de nymphe.
 * 
 * @author parlanme
 *
 */
public class Nymphe extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 5;
  private Duree avantEvolution;

  public Nymphe() {
    this.avantEvolution = new Duree();
    this.avantEvolution.setJour(JOUR_EVOLUTION);
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.NYMPHE);
  }
}
