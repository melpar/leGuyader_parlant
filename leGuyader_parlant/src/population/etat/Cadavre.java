package population.etat;

/**
 * Etat lorsqu'une fourmi meurt
 * 
 * @author parlanme
 *
 */
public class Cadavre extends EtatAbstract {
  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.CADAVRE);
  }
}
