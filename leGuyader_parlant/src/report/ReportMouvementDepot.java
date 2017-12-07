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
import population.ReportObserver;
import population.etat.EtatAbstract;
import temps.Temps;

public class ReportMouvementDepot extends Report implements ReportObservable {
  Place anciennePlace;
  Place nouvellePlace;
  Fourmi fourmi;
  List<ReportObserver> observers;

  private static ReportMouvementDepot instance;

  private ReportMouvementDepot() {
    this.observers = new ArrayList<ReportObserver>();
  }

  /**
   * Permet de retourn l'instance de ReportMouvementDepot. Appelle le constructeur
   * si null. Singleton.
   * 
   * @return instance
   */
  public static ReportMouvementDepot getInstance() {
    if (instance == null) {
      instance = new ReportMouvementDepot();
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
    // TODO Auto-generated method stub

  }

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
    this.anciennePlace = placeDep;
    this.nouvellePlace = placeFin;
    this.applique();

  }

  public Place getAnciennePlace() {
    return anciennePlace;
  }

  public void setAnciennePlace(Place anciennePlace) {
    this.anciennePlace = anciennePlace;
  }

  public Place getNouvellePlace() {
    return nouvellePlace;
  }

  public void setNouvellePlace(Place nouvellePlace) {
    this.nouvellePlace = nouvellePlace;
  }

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }

}
