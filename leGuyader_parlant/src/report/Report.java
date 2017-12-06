package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;
import temps.Temps;
import vue.GUIHelper;

public abstract class Report {
  public abstract void traceFourmi(Fourmi uneFourmi);

  public abstract void traceEtat(EtatAbstract etatAbstract);

  public abstract void traceFourmiliere(Fourmiliere uneFourmiliere);

  public abstract void traceNid(Nid unNid);

  public abstract void traceDepot(Depot uneDepot);

  public abstract void traceProie(Proie proie);

  public abstract void tracePlace(Place place);

  public abstract void traceTerrain(Terrain unterrain);

  public abstract void traceMouvement(Place placeDep, Place placeFin);

  public abstract void traceTemps(Temps temps);
}
