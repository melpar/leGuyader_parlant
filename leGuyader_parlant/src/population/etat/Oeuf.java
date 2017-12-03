package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Lorsque la fourmi est a l'etat d'oeuf
 * 
 * @author parlanme
 *
 */
public class Oeuf extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 3;

  public Oeuf(Duree dureeCourante, Fourmi fourmi) {
    super(fourmi);
    this.avantEvolution = new Duree();
    this.avantEvolution.setJour(JOUR_EVOLUTION);
    this.debutEtat = new Duree(dureeCourante);
    this.etat = Etats.OEUF;
    this.tempsCourant = dureeCourante;
  }

  public void changeEtat() {
    this.maFourmi.changeEtat(this.etat, this.tempsCourant);
  }

  public void agitSur() {

    if (this.estFini()) {
      System.out.println("oeuf");
      this.changeEtat();
      System.out.println("larve");
    }
  }

}
