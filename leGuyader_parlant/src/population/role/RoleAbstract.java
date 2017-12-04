package population.role;

import population.Fourmi;
import population.etat.Etats;
import temps.Duree;

public abstract class RoleAbstract {
  protected Fourmi maFourmi;

  public RoleAbstract(Fourmi fourmi) {
    this.maFourmi = fourmi;
  }
}
