package population.etat;

import population.Fourmi;
import population.TempsObserver;
import report.Report;
import temps.Duree;

public abstract class EtatAbstract {
  protected Fourmi maFourmi;
  protected Etats etat;
  protected Duree tempsCourant;
  protected Duree dateFin;

  public EtatAbstract(Fourmi fourmi) {
    this.maFourmi = fourmi;
  }

  protected abstract void changeEtat();

  /**
   * Permet de créer une trace de l'état.
   * 
   * @param report
   *          ensemble des informations
   */
  public void trace(Report report) {
    report.traceForEtat(this);
  }

  protected boolean estFini() {

    return this.tempsCourant.equals(dateFin);
  }

  public void setTempsCourant(Duree tps) {
    this.tempsCourant = tps;
  }

  public Etats getEtat() {
    return this.etat;
  }

  public abstract void agitSur();

  public Duree getDateFin() {
    return dateFin;
  }

  public void setDateFin(Duree dateFin) {
    this.dateFin = dateFin;
  }
}
