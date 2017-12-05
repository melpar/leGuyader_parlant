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

  /**
   * Créé un role reine.
   * 
   * @param fourmi
   *          fourmi associée
   */
  public Reine(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.REINE;
    this.fourmiliere = null;
  }

  public void setFourmiliere(Fourmiliere fourmiliere) {
    this.fourmiliere = fourmiliere;
  }

  /**
   * Permet à la reine de pondre 50 fourmis.
   */
  public void pond() {
    if (this.fourmiliere != null) {
      for (int i = 0; i < 100; i++) {
        boolean isMale = false;
        if (i % 2 == 0) {
          isMale = true;
        }
        Fourmi uneFourmi = new Fourmi(isMale, this.fourmiliere.getPlaceFourmiliere(),
            this.maFourmi.getTempsCourant());
        this.maFourmi.getTempsCourant().addObserveur(uneFourmi);
        uneFourmi.setTempsCourant(this.maFourmi.getTempsCourant());
        this.fourmiliere.getNidFourmiliere().ajouterFourmi(uneFourmi);
      }
    }
  }
}
