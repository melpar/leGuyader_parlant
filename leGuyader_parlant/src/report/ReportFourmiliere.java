package report;

import environnement.Fourmiliere;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportFourmiliere extends Report {
  private Nid unNid;
  private Depot unDepot;

  /**
   * Redefinition de la methode toString().
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    ReportNid reportNid = new ReportNid();
    reportNid.traceNid(this.unNid);
    stringBuilder.append(reportNid.toString());
    ReportDepot reportDepot = new ReportDepot();
    reportDepot.traceDepot(this.unDepot);
    stringBuilder.append(reportDepot.toString());
    return stringBuilder.toString();

  }

  @Override
  public void traceFourmiliere(Fourmiliere uneFourmiliere) {
    this.unNid = uneFourmiliere.getNidFourmiliere();
    this.unDepot = uneFourmiliere.getDepotFourmiliere();

  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {

  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {

  }

  @Override
  public void traceNid(Nid unNid) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceDepot(Depot uneDepot) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceProie(Proie proie) {
    // TODO Auto-generated method stub

  }

}
