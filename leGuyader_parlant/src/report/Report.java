package report;

import population.Fourmi;
import population.etat.EtatAbstract;

public abstract class Report {
  public abstract void traceForFourmi(Fourmi uneFourmi);

  public abstract void traceForEtat(EtatAbstract etatAbstract);
}
