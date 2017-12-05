package mediateur;

import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import population.Fourmi;

public class MediateurDeplacementDepot {
  private static MediateurDeplacementDepot instance;
  private Terrain terrain;
  private Fourmi uneFourmi;

  private MediateurDeplacementDepot(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @param terrain
   *          terrain de référence
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementDepot getInstance(Terrain terrain) {
    if (MediateurDeplacementDepot.instance == null) {
      MediateurDeplacementDepot.instance = new MediateurDeplacementDepot(terrain);
    }
    return MediateurDeplacementDepot.instance;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementDepot getInstance() {
    return MediateurDeplacementDepot.instance;
  }

  /**
   * Permet de réaliser un déplacement.
   */
  public void deplacement() {
    // Calcul de la nouvelle place
    int positionX = this.uneFourmi.getPlace().getX();
    int positionY = this.uneFourmi.getPlace().getY();
    int positionXFinal = positionX;
    int positionYFinal = positionY;
    Depot depot = this.terrain.getFourmiliere().getDepotFourmiliere();
    Place place = depot.getPlaceDepot();
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
    }

    // Modification de la place
    this.uneFourmi.setPlace(this.terrain.getPlace(positionXFinal, positionYFinal));
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.uneFourmi = uneFourmi;
  }

}
