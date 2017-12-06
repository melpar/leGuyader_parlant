package population;

import report.CompteurObservable;
import report.ReportObservable;

/**
 * Repr�sente les observeurs de CompteurFourmis.
 * 
 * @author parlanme
 *
 */
public interface CompteurObserver {
  void agitSur(CompteurObservable report);
}
