package mediateur;

import environnement.Place;
import environnement.Terrain;
import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import report.ReportMouvementDepot;

/**
 * Permet de g�rer le d�placement de fourmis, pour revenir � la fourmili�re.
 * 
 * @author parlanme
 *
 */
public class MediateurDeplacementFourmiliere implements MediateurDeplacement {
  private Terrain terrain;
  private Fourmi uneFourmi;

  public MediateurDeplacementFourmiliere(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de réaliser un déplacement. Permet � une fourmi de retourner � la
   * fourmili�re.
   */
  public void deplacement() {
    Place ancienne = this.uneFourmi.getPlace();
    // Calcul de la nouvelle place
    int positionX = this.uneFourmi.getPlace().getX();
    int positionY = this.uneFourmi.getPlace().getY();
    int positionXFinal = positionX;
    int positionYFinal = positionY;
    Place place = this.terrain.getFourmiliere().getPlaceFourmiliere();
    if ((place.getX() != positionX) || (place.getY() != positionY)) {
      if (place.getX() != positionX) {
        if (positionX < place.getX()) {
          positionXFinal = positionX + 1;
        }
        if (positionX > place.getX()) {
          positionXFinal = positionX - 1;
        }
      } else {
        if (positionY < place.getY()) {
          positionYFinal = positionY + 1;
        }
        if (positionY > place.getY()) {
          positionYFinal = positionY - 1;
        }
      }
    } else {
      ((Adulte) this.uneFourmi.getEtat()).changerTrajet();
    }
    // Modification de la place
    this.uneFourmi.setPlace(this.terrain.getPlace(positionXFinal, positionYFinal));
    ReportMouvementDepot report = ReportMouvementDepot.getInstance();
    report.traceMouvement(ancienne, this.uneFourmi.getPlace());
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.uneFourmi = uneFourmi;
  }

  @Override
  public Fourmi getFourmi() {
    return this.uneFourmi;
  }

}
