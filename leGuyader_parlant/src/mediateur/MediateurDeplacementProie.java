package mediateur;

import java.util.ArrayList;
import java.util.List;

import environnement.Place;
import environnement.Terrain;
import population.Fourmi;
import population.Proie;

public class MediateurDeplacementProie {
  private static MediateurDeplacementProie instance;
  private Terrain terrain;
  private Proie uneProie;

  private MediateurDeplacementProie(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @param terrain
   *          terrain de référence
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementProie getInstance(Terrain terrain) {
    if (MediateurDeplacementProie.instance == null) {
      MediateurDeplacementProie.instance = new MediateurDeplacementProie(terrain);
    }
    return MediateurDeplacementProie.instance;
  }

  /**
   * Permet de récupérer une instance du médiateur (singleton).
   * 
   * @return retourne l'instance de MediateurDeplacementChasse
   */
  public static MediateurDeplacementProie getInstance() {
    return MediateurDeplacementProie.instance;
  }

  /**
   * Permet de réaliser un déplacement.
   */
  public void deplacement() {
    // Calcul de la nouvelle place
    int x = this.uneProie.getPlaceProie().getX();
    int y = this.uneProie.getPlaceProie().getY();
    List<Place> placePossibles = new ArrayList<Place>();
    if (x < this.terrain.getLongueurTerrain()) {
      placePossibles.add(terrain.getPlace(x + 1, y));
    }
    if (x > 0) {
      placePossibles.add(terrain.getPlace(x - 1, y));
    }
    if (y < this.terrain.getLargeurTerrain()) {
      placePossibles.add(terrain.getPlace(x, y + 1));
    }
    if (y > 0) {
      placePossibles.add(terrain.getPlace(x, y - 1));
    }
    int nombreAleatoire = (int) (Math.random() * placePossibles.size());

    Place nouvellePlace = placePossibles.get(nombreAleatoire);

    // Modification de la place
    this.uneProie.setPlaceProie(nouvellePlace);
    System.out.println("test");
  }

  public void setProie(Proie uneProie) {
    this.uneProie = uneProie;
  }

}
