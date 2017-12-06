package report;

import java.util.ArrayList;
import java.util.List;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;
import temps.Temps;

public class ReportPlace extends Report {
  private int positionX;
  private int positionY;

  private CompteurNid cpt;

  @Override
  public void tracePlace(Place place) {
    this.cpt = CompteurNid.getInstance();
    List<Fourmi> lesFourmis = new ArrayList<Fourmi>();
    for (Fourmi uneFourmi : lesFourmis) {
      cpt.traceFourmi(uneFourmi);
    }
    this.positionX = place.getX();
    this.positionY = place.getY();

  }

  /**
   * 
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("( ").append(this.positionX).append(" : ");
    stringBuilder.append(this.positionY).append(" )\n");
    return stringBuilder.toString();
  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {

  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {

  }

  @Override
  public void traceFourmiliere(Fourmiliere uneFourmiliere) {

  }

  @Override
  public void traceNid(Nid unNid) {

  }

  @Override
  public void traceDepot(Depot uneDepot) {

  }

  @Override
  public void traceProie(Proie proie) {

  }

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }
}
