package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportFourmi extends Report {

  private Place place;
  private String etat;

  /**
   * Retourne l'ensemble des éléments de l'instance sous la forme d'une chaine de
   * caractere.
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.etat);
    stringBuilder.append(" à la position ");
    ReportPlace reportPlace = new ReportPlace();
    reportPlace.tracePlace(this.place);
    stringBuilder.append(reportPlace.toString());
    return stringBuilder.toString();
  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    this.place = uneFourmi.getPlace();
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

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
    // TODO Auto-generated method stub

  }

}
