package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportProie extends Report {

  private int positionX;
  private int positionY;
  private double poids;

  @Override
  public void traceProie(Proie uneProie) {
    this.positionX = uneProie.getPlaceProie().getX();
    this.positionY = uneProie.getPlaceProie().getY();
    this.poids = uneProie.getPoids();
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Proie  ");
    stringBuilder.append(" à la position (").append(positionX).append(",").append(positionY);
    stringBuilder.append(") Poids (").append(this.poids).append(")\n");
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

  @Override
  public void tracePlace(Place place) {
    // TODO Auto-generated method stub

  }

}
