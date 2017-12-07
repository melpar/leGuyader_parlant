package population.role;

import population.Fourmi;

/**
 * Fourmi adulte, soldat.
 * 
 * @author LeGuyader Parlant
 */
public class Soldat extends RoleAbstract {
  public Soldat(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.SOLDAT;
  }
}
