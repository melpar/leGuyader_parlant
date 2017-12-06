package population.etat;

import environnement.Terrain;
import mediateur.MediateurDeplacement;
import mediateur.MediateurDeplacementDepot;
import mediateur.MediateurDeplacementFourmiliere;
import population.Fourmi;
import population.role.Ouvriere;
import population.role.RoleAbstract;
import population.role.Roles;
import population.role.Sexue;
import population.role.Soldat;
import report.ReportMouvementChasse;
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
  private MediateurDeplacement mediateur;

  /**
   * Créé un état adulte.
   * 
   * @param fourmi
   *          fourmi associée
   * @param dureeCourante
   *          durée courante
   */
  public Adulte(Fourmi fourmi, Duree dureeCourante) {
    super(fourmi);
    this.dateFin = new Duree(dureeCourante);
    this.etat = Etats.ADULTE;
    this.tempsCourant = dureeCourante;
    int roleAdulte = (int) (Math.random() * (10));
    switch (roleAdulte) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        this.role = new Ouvriere(maFourmi);
        break;
      case 6:
      case 7:
        this.role = new Soldat(maFourmi);
        break;
      case 8:
      case 9:
        this.role = new Sexue(maFourmi);
        break;
      default:
        break;
    }
    this.mediateur = new MediateurDeplacementDepot(Terrain.getInstance());
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
    if (this.getRole().getRole() == Roles.OUVRIERE) {
      ((Ouvriere) this.getRole()).deplace();
    } else {
      if (this.getRole().getRole() != Roles.REINE) {
        this.deplace();
      }
    }

  }

  public void changerTrajet() {
    if (this.mediateur instanceof MediateurDeplacementFourmiliere) {
      this.mediateur = new MediateurDeplacementDepot(Terrain.getInstance());
    } else {
      this.mediateur = new MediateurDeplacementFourmiliere(Terrain.getInstance());
    }
  }

  public void deplace() {
    if (mediateur.getFourmi() == null) {
      mediateur.setFourmi(maFourmi);
    }
    mediateur.deplacement();
    // System.out.println(
    // "fourmi :[" + maFourmi.getPlace().getX() + " : " + maFourmi.getPlace().getX()
    // + "]");

  }
}
