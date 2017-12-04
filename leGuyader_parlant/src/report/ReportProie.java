package report;

import environnement.Fourmiliere;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportProie extends Report {

  private int positionX;
  private int positionY;
  private String etat;

  @Override
  public void traceProie(Proie uneProie) {
    // a completer

  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Proie");
    return stringBuilder.toString();
  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceFourmiliere(Fourmiliere uneFourmiliere) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceNid(Nid unNid) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceDepot(Depot uneDepot) {
    // TODO Auto-generated method stub

  }

}
