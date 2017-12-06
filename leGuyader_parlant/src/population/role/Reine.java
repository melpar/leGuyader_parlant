package population.role;

import environnement.Fourmiliere;
import population.Fourmi;
import population.TempsObserver;
import temps.Duree;

/**
 * Fourmi adulte, reine.
 * 
 * @author parlanme
 *
 */
public class Reine extends RoleAbstract implements TempsObserver {

  private Fourmiliere fourmiliere;

  /**
   * Créé un role reine.
   * 
   * @param fourmi
   *          fourmi associée
   */

  private Duree dateFin;

  public Reine(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.REINE;
    this.fourmiliere = null;
    this.dateFin = new Duree();
    this.dateFin.addMois((int) (Math.random() * 12));
    this.dateFin.addMois((int) (Math.random() * 6) + 4);
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

  @Override
  public void agitSur() {
    this.maFourmi.changeEtat(this.maFourmi.getEtat().getEtat(),
        this.maFourmi.getTempsCourant().getTempsCourant());

  }
}
