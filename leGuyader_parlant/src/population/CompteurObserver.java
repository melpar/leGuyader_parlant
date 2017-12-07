package population;

import report.CompteurObservable;

/**
 * Représente les observeurs de CompteurFourmis.
 *
 * @author LeGuyader Parlant
 */
public interface CompteurObserver {
  void agitSur(CompteurObservable report);
}
