package population;

import report.CompteurObservable;
import report.ReportObservable;

/**
 * Représente les observeurs de CompteurFourmis.
 * 
 * @author parlanme
 *
 */
public interface CompteurObserver {
  void agitSur(CompteurObservable report);
}
