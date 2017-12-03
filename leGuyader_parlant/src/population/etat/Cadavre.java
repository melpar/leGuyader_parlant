package population.etat;

import population.Fourmi;

/**
 * Etat lorsqu'une fourmi meurt
 * 
 * @author parlanme
 *
 */
public class Cadavre extends EtatAbstract {

  public Cadavre(Fourmi fourmi) {
    super(fourmi);
    this.etat = Etats.CADAVRE;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.CADAVRE, this.tempsCourant);
  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub

  }
}
