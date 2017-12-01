package population.etat;

import temps.Duree;

/**
 * Lorsque la fourmi est à l'état d'oeuf
 * 
 * @author parlanme
 *
 */
public class Oeuf extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 3;
  private Duree avantEvolution;

  public Oeuf() {
    this.avantEvolution = new Duree();
    this.avantEvolution.setJour(JOUR_EVOLUTION);
  }

  public void changeEtat() {
    this.maFourmi.changeEtat(Etats.OEUF);
  }
}
