package population.etat;

import population.Fourmi;
import population.TempsObserver;
import temps.Duree;

public abstract class EtatAbstract {
  protected Fourmi maFourmi;
  protected Etats etat;
  protected Duree tempsCourant;
  protected Duree avantEvolution;
  protected Duree debutEtat;

  public EtatAbstract(Fourmi fourmi) {
    this.maFourmi = fourmi;
  }

  protected abstract void changeEtat();

  public void setTempsCourant(Duree tps) {
    this.tempsCourant = tps;
  }

  public Etats getEtat() {
    return this.etat;
  }

  protected boolean estFini() {
    System.out.println("debut : " + debutEtat);
    System.out.println("avant : " + avantEvolution);
    Duree fin = Duree.ajouter(this.debutEtat, this.avantEvolution);
    System.out.println("fin : " + fin);

    return this.tempsCourant.equals(fin);
  }

  public abstract void agitSur();
}
