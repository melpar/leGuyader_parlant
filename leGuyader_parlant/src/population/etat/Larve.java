package population.etat;

import population.Fourmi;
import temps.Duree;

/**
 * Lorsque la fourmi est à l'état de larve.
 * 
 * @author parlanme
 *
 */
public class Larve extends EtatAbstract {
  private static final int JOUR_EVOLUTION = 10;

  public Larve(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.avantEvolution = new Duree(dureeCourante);
    this.avantEvolution.setJour(JOUR_EVOLUTION);
    this.debutEtat = new Duree(dureeCourante);
    this.etat = Etats.LARVE;
    this.tempsCourant = dureeCourante;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.LARVE, this.tempsCourant);
  }

  public void agitSur() {
    if (this.estFini()) {
      System.out.println("larve");
      this.changeEtat();
      System.out.println("nymphe");
    }

  }
}
