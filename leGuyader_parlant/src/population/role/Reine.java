package population.role;

import environnement.Fourmiliere;
import environnement.Terrain;
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
  private Duree finFecondation;
  private final int NOMBRE_MOIS_FECONDATION = 1;
  private boolean enFecondation;
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
    this.dateFin.addAnnee((int) (Math.random() * 6) + 4);
    this.enFecondation = false;
  }

  public void setFourmiliere(Fourmiliere fourmiliere) {
    this.fourmiliere = fourmiliere;
  }

  /**
   * Permet à la reine de pondre 50 fourmis.
   */
  public void pond() {
    if (this.fourmiliere != null) {
      this.enFecondation = false;
      int nombreOeufs = 40 + (int) (Math.random() * 60);
      for (int i = 0; i < nombreOeufs; i++) {
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
      this.enFecondation = true;
      this.finFecondation = new Duree(this.maFourmi.getTempsCourant().getTempsCourant());
      finFecondation.addMois(NOMBRE_MOIS_FECONDATION);
    }
  }

  @Override
  public void agitSur() {
    // ponte
    if (maFourmi.getTempsCourant().getTempsCourant().estSuperieur(finFecondation)) {
      this.pond();

    }
    // mort
    if (maFourmi.getTempsCourant().getTempsCourant()
        .estSuperieur(Duree.ajouter(this.maFourmi.getNaissance(), dateFin))) {
      this.maFourmi.changeEtat(this.maFourmi.getEtat().getEtat(),
          this.maFourmi.getTempsCourant().getTempsCourant());
    }
  }
}
