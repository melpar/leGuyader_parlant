package mediateur;

import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;

public class MediateurDeplacementChasse {
  private Terrain terrain;
  private Fourmi fourmi;

  public MediateurDeplacementChasse(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de réaliser un déplacement.
   */
  public void deplacement() {
    // Calcul de la nouvelle place
    int x = this.fourmi.getPlace().getX();
    int y = this.fourmi.getPlace().getY();
    List<Place> placePossibles = new ArrayList<Place>();
    if (x < this.terrain.getLongueurTerrain()) {
      placePossibles.add(terrain.getPlace(x + 1, y));
      if (terrain.getPlace(x + 1, y).getListePheromone().contains(Pheromone.PHEROMONE_CHASSE)) {
        placePossibles.add(terrain.getPlace(x + 1, y));
      }
    }
    if (x > 0) {
      placePossibles.add(terrain.getPlace(x - 1, y));
      if (terrain.getPlace(x - 1, y).getListePheromone().contains(Pheromone.PHEROMONE_CHASSE)) {
        placePossibles.add(terrain.getPlace(x - 1, y));
      }
    }
    if (y < this.terrain.getLargeurTerrain()) {
      placePossibles.add(terrain.getPlace(x, y + 1));
      if (terrain.getPlace(x, y + 1).getListePheromone().contains(Pheromone.PHEROMONE_CHASSE)) {
        placePossibles.add(terrain.getPlace(x, y + 1));
      }
    }
    if (y > 0) {
      placePossibles.add(terrain.getPlace(x, y - 1));
      if (terrain.getPlace(x, y - 1).getListePheromone().contains(Pheromone.PHEROMONE_CHASSE)) {
        placePossibles.add(terrain.getPlace(x, y - 1));
      }
    }
    int nombreAleatoire = (int) (Math.random() * placePossibles.size());

    Place nouvellePlace = placePossibles.get(nombreAleatoire);

    // Modification de la place
    this.fourmi.setPlace(nouvellePlace);
    nouvellePlace.ajouterPheromone(Pheromone.PHEROMONE_CHASSE);
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.fourmi = uneFourmi;
  }
}
