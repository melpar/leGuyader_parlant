package population.etat;

import population.Fourmi;
import population.role.RoleAbstract;
import temps.Duree;

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

  public Adulte(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.dateFin = new Duree(dureeCourante);
    this.etat = Etats.ADULTE;
    this.tempsCourant = dureeCourante;
  }

  public RoleAbstract getRole() {
    return role;
  }

  public void setRole(RoleAbstract role) {
    this.role = role;
  }

  @Override
  protected void changeEtat() {
    this.maFourmi.changeEtat(Etats.ADULTE, this.tempsCourant);
  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub

  }
}
