package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Lorsque la fourmi est à l'etat d'oeuf.
 * 
 * @author parlanme
 *
 */
public class Oeuf extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 3;

  /**
   * Permet d'initialiser un état oeuf.
   * 
   * @param dureeCourante
   *          temps à la création
   * @param fourmi
   *          fourmi associée
   */
  public Oeuf(Duree dureeCourante, Fourmi fourmi) {
    super(fourmi);
    this.dateFin = new Duree();
    this.dateFin.addJour(JOUR_EVOLUTION);
    this.etat = Etats.OEUF;
    this.tempsCourant = dureeCourante;
  }

  public void changeEtat() {
    this.maFourmi.changeEtat(this.etat, this.tempsCourant);
  }

  /**
   * Mise à jour en fonction du temps.
   */
  public void agitSur() {

    if (this.estFini()) {
      this.changeEtat();
    }
  }

}
