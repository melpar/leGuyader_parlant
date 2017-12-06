package mediateur;

import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;

/**
 * Permet de gérer le déplacement de fourmis, dans le cadre de la chasse.
 * 
 * @author parlanme
 *
 */
public class MediateurDeplacementChasse {
  private Terrain terrain;
  private Fourmi fourmi;

  public MediateurDeplacementChasse(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de rÃ©aliser un dÃ©placement (aléatoire, augementation de probabilité
   * si phéromone).
   */
  public void deplacement() {
    if (!fourmi.isEnCombat()) {
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
      Proie uneProie = terrain.aProieALaPlace(nouvellePlace);

      if (uneProie != null) {
        if ((uneProie.isEnCombat() == null && uneProie.getTempsAttenteCombat())) {
          MediateurCombat combat = new MediateurCombat(uneProie, fourmi.getTempsCourant());
          combat.ajouterFourmi(fourmi);
          fourmi.setEnCombat(true);
          uneProie.setEnCombat(combat);
          fourmi.getTempsCourant().addObserveur(combat);
        } else if (uneProie.isEnCombat() instanceof MediateurCombat) {
          if (uneProie.isEnCombat().besoinAide()) {
            System.out.println("besoin aide");
            uneProie.isEnCombat().ajouterFourmi(fourmi);
            fourmi.setEnCombat(true);
          }
        } else if (uneProie.isEnCombat() instanceof MediateurCombatRetour) {
        }

      }
    }
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.fourmi = uneFourmi;
  }
}
