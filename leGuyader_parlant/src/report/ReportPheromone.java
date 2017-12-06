package report;

import java.util.ArrayList;
import java.util.List;

import environnement.Fourmiliere;
import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.ReportObserver;
import population.etat.EtatAbstract;
import temps.Temps;

public class ReportPheromone extends Report implements ReportObservable {
  private Place place;

  List<ReportObserver> observers;

  private static ReportPheromone instance;

  private ReportPheromone() {
    this.observers = new ArrayList<ReportObserver>();
  }

  /**
   * Pattern singleton.
   * 
   * @return retourne l'instance du report
   */
  public static ReportPheromone getInstance() {
    if (instance == null) {
      instance = new ReportPheromone();
    }
    return instance;
  }

  public void addObserver(ReportObserver obs) {
    this.observers.add(obs);
  }

  @Override
  public void applique() {
    for (ReportObserver obs : observers) {
      obs.agitSur(this);
    }

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
  public void traceProie(Proie proie) {
    // TODO Auto-generated method stub

  }

  @Override
  public void tracePlace(Place place) {
    this.setPlace(place);
    this.applique();
  }

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
  }

  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }

}
