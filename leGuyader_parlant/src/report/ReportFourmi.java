package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportFourmi extends Report {

  private int positionX;
  private int positionY;
  private String etat;

  /**
   * Retourne l'ensemble des éléments de l'instance sous la forme d'une chaine
   * de caractere.
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.etat);
    stringBuilder.append(" à la position (").append(positionX).append(",").append(positionY);
    stringBuilder.append(")\n");
    return stringBuilder.toString();
  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    this.positionX = uneFourmi.getPlace().getX();
    this.positionY = uneFourmi.getPlace().getY();
    this.etat = uneFourmi.getEtat().getEtat().name();
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
  public void traceProie(Proie proie) {
    // TODO Auto-generated method stub

  }

  @Override
  public void tracePlace(Place place) {
    // TODO Auto-generated method stub

  }

}
