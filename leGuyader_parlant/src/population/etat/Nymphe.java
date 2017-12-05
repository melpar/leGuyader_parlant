package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Lorsque la fourmi est à l'état de nymphe.
 * 
 * @author parlanme
 *
 */
public class Nymphe extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 5;

  /**
   * Permet de créé un état Nymphe.
   * 
   * @param fourmi
   *          fourmi associée
   * @param dureeCourante
   *          durée courante
   */
  public Nymphe(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.dateFin = new Duree(dureeCourante);
    this.dateFin.addJour(JOUR_EVOLUTION);
    this.etat = Etats.NYMPHE;
    this.tempsCourant = dureeCourante;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.NYMPHE, this.tempsCourant);
  }

  /**
   * Activer lors de la modification du temps. Change l'état si nécessaire
   */
  public void agitSur() {

    if (this.estFini()) {
      this.changeEtat();
    }
  }
}
