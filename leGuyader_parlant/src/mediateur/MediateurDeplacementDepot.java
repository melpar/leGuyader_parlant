package mediateur;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import report.ReportMouvementDepot;

public class MediateurDeplacementDepot implements MediateurDeplacement {
  private Terrain terrain;
  private Fourmi uneFourmi;
  private Proie uneProie;

  public MediateurDeplacementDepot(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de réaliser un déplacement.
   */
  public void deplacement() {
    if (this.uneProie != null) {
      Place ancienne = this.uneFourmi.getPlace();
      // Calcul de la nouvelle place
      int positionX = this.uneFourmi.getPlace().getX();
      int positionY = this.uneFourmi.getPlace().getY();
      int positionXFinal = positionX;
      int positionYFinal = positionY;
      // Depot depot = this.terrain.getFourmiliere().getDepotFourmiliere();
      Place place = this.terrain.getPlaceDepot();
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
        this.terrain.getFourmiliere().getDepotFourmiliere().ajouterCadavreProie(this.uneProie);
        ((Adulte) uneFourmi.getEtat()).changerTrajet();
        System.out.println("____________________________dépot");
      }
      System.out.println(positionXFinal + " " + positionYFinal);
      // Modification de la place
      this.uneFourmi.setPlace(this.terrain.getPlace(positionXFinal, positionYFinal));
      ReportMouvementDepot report = ReportMouvementDepot.getInstance();
      report.traceMouvement(ancienne, this.uneFourmi.getPlace());
    }
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.uneFourmi = uneFourmi;
    Depot depot = this.terrain.getFourmiliere().getDepotFourmiliere();
    if (depot.getListeCadavreProie().size() > 0) {
      System.out.println("proie" + depot.getListeCadavreProie().size());
      this.setProie(depot.getListeCadavreProie().get(0));
    }
  }

  public void setProie(Proie uneProie) {
    this.terrain.getFourmiliere().getNidFourmiliere().supprimerProie(uneProie);
    this.uneProie = uneProie;
  }

}
