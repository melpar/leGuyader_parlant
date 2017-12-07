package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Lorsque la fourmi est à l'état de larve.
 * 
 * @author LeGuyader Parlant
 */
public class Larve extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 10;

  /**
   * Créé un état larve.
   * 
   * @param fourmi
   *          fourmi associée à l'état
   * @param dureeCourante
   *          durée courante
   */
  public Larve(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.dateFin = new Duree(dureeCourante);
    this.dateFin.addJour(JOUR_EVOLUTION);
    this.etat = Etats.LARVE;
    this.tempsCourant = dureeCourante;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.LARVE, this.tempsCourant);
  }

  /**
   * Action lors de la modification du temps. Change d'état si nécessaire
   */
  public void agitSur() {
    if (this.estFini()) {
      this.changeEtat();
    }

  }
}
