package population.etat;

import population.role.RoleAbstract;

public class Adulte extends EtatAbstract {
  private RoleAbstract role;

  public RoleAbstract getRole() {
    return role;
  }

  public void setRole(RoleAbstract role) {
    this.role = role;
  }
}
