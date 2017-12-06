package population.etat;

import population.Fourmi;
import population.TempsObserver;
import report.Report;
import temps.Duree;

/**
 * Regroupe les fonctions nécessaires à la gestion des états des fourmis.
 * 
 * @author parlanme
 *
 */
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
   * Permet de crÃ©er une trace de l'Ã©tat.
   * 
   * @param report
   *          ensemble des informations
   */
  public void trace(Report report) {
    report.traceEtat(this);
  }

  protected boolean estFini() {

    return this.tempsCourant.estSuperieur(dateFin);
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
