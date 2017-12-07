package population.role;

import population.Fourmi;

/**
 * Fourmi adulte, sexué.
 * 
 * @author LeGuyader Parlant
 */
public class Sexue extends RoleAbstract {
  public Sexue(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.SEXUE;
  }
}
