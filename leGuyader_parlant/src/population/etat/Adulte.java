package population.etat;

import population.role.RoleAbstract;

/**
 * Etat d'une fourmie adulte. Contient son role
 * 
 * @author parlanme
 *
 */
public class Adulte extends EtatAbstract {
  /**
   * Role de la fourmie.
   */
  private RoleAbstract role;

  public RoleAbstract getRole() {
    return role;
  }

  public void setRole(RoleAbstract role) {
    this.role = role;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.ADULTE);
  }
}
