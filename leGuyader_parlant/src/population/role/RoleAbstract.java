package population.role;

import population.Fourmi;

/**
 * Fonctions nécessaires à l'utilisation des roles. Constructeur général.
 * 
 * @author LeGuyader Parlant
 */
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
