package population;

import report.CompteurObservable;
import report.ReportObservable;

public interface CompteurObserver {
  void agitSur(CompteurObservable report);
}
