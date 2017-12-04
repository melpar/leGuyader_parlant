package population.role;

import population.Fourmi;
import population.etat.Etats;
import temps.Duree;

public abstract class RoleAbstract {
  protected Fourmi maFourmi;
  protected Roles monRole;

  public RoleAbstract(Fourmi fourmi) {
    this.maFourmi = fourmi;
  }

  public Roles getRole() {
    return this.monRole;
  }
}
