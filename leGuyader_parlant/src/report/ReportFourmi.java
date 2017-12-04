package report;

import environnement.Place;
import population.Fourmi;
import population.etat.EtatAbstract;
import temps.Duree;
import temps.Temps;

public class ReportFourmi extends Report {

  private int positionX;
  private int positionY;
  private String etat;

  /**
   * Retourne l'ensemble des éléments de l'instance sous la forme d'une chaine de
   * caractere.
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

}
