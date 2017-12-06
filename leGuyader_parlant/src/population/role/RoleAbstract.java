package population.role;

import population.Fourmi;
import population.etat.Etats;
import temps.Duree;

/**
 * Fonctions n�cessaires � l'utilisation des roles. Constructeur g�n�ral.
 * 
 * @author M�lissa
 *
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
