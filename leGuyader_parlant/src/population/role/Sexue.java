package population.role;

import population.Fourmi;

/**
 * Fourmi adulte, sexué.
 * 
 * @author parlanme
 *
 */
public class Sexue extends RoleAbstract {
  public Sexue(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.SEXUE;
  }
}
