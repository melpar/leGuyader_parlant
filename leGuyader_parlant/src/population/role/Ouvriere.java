package population.role;

import environnement.Terrain;
import mediateur.MediateurDeplacementChasse;
import population.Fourmi;

/**
 * Fourmi adulte, ouvrière.
 * 
 * @author parlanme
 *
 */
public class Ouvriere extends RoleAbstract {

  private MediateurDeplacementChasse mediateur;

  /**
   * permet de créer un role ouvrier.
   * 
   * @param fourmi
   *          fourmi associée au role
   * @param terrain
   *          terrain utilisable pour le déplacement
   */
  public Ouvriere(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.OUVRIERE;
    this.mediateur = MediateurDeplacementChasse.getInstance();
  }

  /**
   * Permet de déplacer la fourmi associée.
   */
  public void deplace() {
    mediateur.setFourmi(maFourmi);
    mediateur.deplacement();
    System.out.println("Nouvelle place : " + this.maFourmi.getPlace().getX() + ","
        + this.maFourmi.getPlace().getY());
  }
}
