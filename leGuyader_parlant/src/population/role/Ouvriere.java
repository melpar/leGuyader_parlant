package population.role;

import environnement.Place;
import environnement.Terrain;
import mediateur.MediateurDeplacementChasse;
import population.Fourmi;
import report.ReportMouvementChasse;
import report.ReportPheromone;

/**
 * Fourmi adulte, ouvrière.
 * 
 * @author LeGuyader Parlant
 */
public class Ouvriere extends RoleAbstract {

  private MediateurDeplacementChasse mediateur;

  /**
   * permet de créer un role ouvrier.
   * 
   * @param fourmi
   *          fourmi associée au role
   */
  public Ouvriere(Fourmi fourmi) {
    super(fourmi);
    this.monRole = Roles.OUVRIERE;
    this.mediateur = new MediateurDeplacementChasse(Terrain.getInstance());
  }

  /**
   * Permet de déplacer la fourmi associée.
   */
  public void deplace() {
    mediateur.setFourmi(maFourmi);
    Place ancienne = this.maFourmi.getPlace();

    mediateur.deplacement();

    ReportPheromone reportPhero = ReportPheromone.getInstance();
    reportPhero.tracePlace(this.maFourmi.getPlace());
    ReportMouvementChasse report = ReportMouvementChasse.getInstance();
    report.setFourmi(maFourmi);
    report.traceMouvement(ancienne, this.maFourmi.getPlace());
  }
}
