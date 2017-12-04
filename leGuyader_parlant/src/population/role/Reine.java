package population.role;

import environnement.Fourmiliere;
import population.Fourmi;

/**
 * Fourmi adulte, reine.
 * 
 * @author parlanme
 *
 */
public class Reine extends RoleAbstract {

  private Fourmiliere fourmiliere;

  public Reine(Fourmi fourmi, Fourmiliere fourmiliere) {
    super(fourmi);
    this.fourmiliere = fourmiliere;
  }

  /**
   * Permet à la reine de pondre 50 fourmis.
   */
  public void pond() {
    for (int i = 0; i < 50; i++) {
      boolean isMale = false;
      if (i % 2 == 0) {
        isMale = true;
      }
      Fourmi uneFourmi = new Fourmi(isMale, this.fourmiliere.getPlaceFourmiliere(),
          this.maFourmi.getTempsCourant());
      this.fourmiliere.getNidFourmiliere().ajouterFourmi(uneFourmi);
    }
  }
}
