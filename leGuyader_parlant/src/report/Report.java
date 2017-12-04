package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public abstract class Report {
  public abstract void traceFourmi(Fourmi uneFourmi);

  public abstract void traceEtat(EtatAbstract etatAbstract);

  public abstract void traceFourmiliere(Fourmiliere uneFourmiliere);

  public abstract void traceNid(Nid unNid);

  public abstract void traceDepot(Depot uneDepot);

  public abstract void traceProie(Proie proie);

  public abstract void tracePlace(Place place);

}
