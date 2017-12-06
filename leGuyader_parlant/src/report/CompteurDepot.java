package report;

import java.util.ArrayList;
import java.util.List;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.CompteurObserver;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;
import temps.Temps;

public class CompteurDepot extends Report implements CompteurObservable {
  private int cptCadavreProie;
  private int cptCadavreFourmi;
  List<CompteurObserver> observers;

  private static CompteurDepot instance;

  private CompteurDepot() {
    this.observers = new ArrayList<CompteurObserver>();
  }

  public static CompteurDepot getInstance() {
    if (instance == null) {
      instance = new CompteurDepot();
    }
    return instance;
  }

  public void remiseAZero() {
    this.cptCadavreFourmi = 0;
    this.cptCadavreProie = 0;
  }

  public void ajoutObserver(CompteurObserver compteur) {
    this.observers.add(compteur);
  }

  public int getCptCadavreProie() {
    return cptCadavreProie;
  }

  public int getCptCadavreFourmi() {
    return cptCadavreFourmi;
  }

  @Override
  public void applique() {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    // TODO Auto-generated method stub
    this.cptCadavreFourmi++;

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
    this.cptCadavreProie++;

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

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }

}
