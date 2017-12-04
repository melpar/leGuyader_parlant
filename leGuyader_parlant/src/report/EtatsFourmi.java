package report;

import population.Fourmi;
import population.etat.EtatAbstract;
import population.etat.Etats;
import temps.Duree;

public class EtatsFourmi extends Report {
  Etats etat;
  Duree dateFin;

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {
    this.etat = etatAbstract.getEtat();
    this.dateFin = etatAbstract.getDateFin();

  }

  /**
   * Retourne l'ensemble des éléments de l'instance sous la forme d'une chaine de
   * caractere.
   */
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append("Etat : ").append(etat).append("\n");
    ret.append("Date de fin de l'état : ").append(dateFin.toString()).append("\n");
    return ret.toString();
  }
}
