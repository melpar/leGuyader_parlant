package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportProie extends Report {

  private Place place;
  private double poids;

  @Override
  public void traceProie(Proie uneProie) {
    this.place = uneProie.getPlaceProie();
    this.poids = uneProie.getPoids();
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Proie ( ").append(this.poids).append(" mg)");
    stringBuilder.append(" à la position ");
    ReportPlace reportPlace = new ReportPlace();
    reportPlace.tracePlace(this.place);
    stringBuilder.append(reportPlace.toString());
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

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

}
