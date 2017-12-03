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

  public Nymphe(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.avantEvolution = new Duree(dureeCourante);
    this.avantEvolution.setJour(JOUR_EVOLUTION);
    this.debutEtat = new Duree(dureeCourante);
    this.etat = Etats.NYMPHE;
    this.tempsCourant = dureeCourante;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.NYMPHE, this.tempsCourant);
  }

  public void agitSur() {

    if (this.estFini()) {
      System.out.println("nymphe");
      this.changeEtat();
      System.out.println("adulte");
    }
  }
}
