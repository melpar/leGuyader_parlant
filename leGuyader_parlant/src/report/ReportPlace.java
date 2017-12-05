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

public class ReportPlace extends Report {
  private int x;
  private int y;

  private CompteurFourmi cpt;

  @Override
  public void tracePlace(Place place) {
    this.cpt = new CompteurFourmi();
    List<Fourmi> lesFourmis = new ArrayList<Fourmi>();
    for (Fourmi uneFourmi : lesFourmis) {
      cpt.traceFourmi(uneFourmi);
    }
    this.x = place.getX();
    this.y = place.getY();

  }

  public String toString() {
    return "test";
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
}
