package report;

import population.Fourmi;
import population.etat.EtatAbstract;

public abstract class Report {
  public abstract void traceFourmi(Fourmi uneFourmi);

  public abstract void traceEtat(EtatAbstract etatAbstract);
}
