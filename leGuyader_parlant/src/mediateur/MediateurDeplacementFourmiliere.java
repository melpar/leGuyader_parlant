package mediateur;

import environnement.Place;
import environnement.Terrain;
import population.Fourmi;
import population.Proie;
import report.ReportMouvementDepot;

public class MediateurDeplacementFourmiliere implements MediateurDeplacement {
  private static MediateurDeplacementFourmiliere instance;
  private Terrain terrain;
  private Fourmi uneFourmi;

  private MediateurDeplacementFourmiliere(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @param terrain
   *          terrain de référence
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementFourmiliere getInstance(Terrain terrain) {
    if (MediateurDeplacementFourmiliere.instance == null) {
      MediateurDeplacementFourmiliere.instance = new MediateurDeplacementFourmiliere(terrain);
    }
    return MediateurDeplacementFourmiliere.instance;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementFourmiliere getInstance() {
    return MediateurDeplacementFourmiliere.instance;
  }

  /**
   * Permet de réaliser un déplacement.
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
      System.out.println("____________________________fourmiliere");
    }
    System.out.println(positionXFinal + " " + positionYFinal);
    // Modification de la place
    this.uneFourmi.setPlace(this.terrain.getPlace(positionXFinal, positionYFinal));
    ReportMouvementDepot report = ReportMouvementDepot.getInstance();
    report.traceMouvement(ancienne, this.uneFourmi.getPlace());
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.uneFourmi = uneFourmi;
  }

}
