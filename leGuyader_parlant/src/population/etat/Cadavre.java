package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Etat lorsqu'une fourmi meurt.
 * 
 * @author LeGuyader Parlant
 */
public class Cadavre extends EtatAbstract {

  /**
   * Créé un état cadavre.
   * 
   * @param fourmi
   *          fourmi associée
   * @param dureeCourante
   *          duree courante
   */
  public Cadavre(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.dateFin = new Duree(dureeCourante);
    this.etat = Etats.CADAVRE;
    this.tempsCourant = dureeCourante;

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
