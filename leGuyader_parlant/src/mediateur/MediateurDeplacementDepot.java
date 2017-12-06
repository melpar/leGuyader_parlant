package mediateur;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import report.CompteurNid;
import report.ReportMouvementDepot;
import report.ReportMouvementProie;

/**
 * Permet de gérer le déplacement de fourmis, pour aller au dépot.
 * 
 * @author parlanme
 *
 */
public class MediateurDeplacementDepot implements MediateurDeplacement {
  private Terrain terrain;
  private Fourmi uneFourmi;
  private Fourmi cadavreFourmi;
  private Proie uneProie;

  public MediateurDeplacementDepot(Terrain terrain) {
    this.terrain = terrain;
  }

  /**
   * Permet de rÃ©aliser un dÃ©placement, permet à une fourmi d'aller dépot.
   */
  public void deplacement() {

    if (this.uneProie != null || this.cadavreFourmi != null) {
      Place ancienne = this.uneFourmi.getPlace();
      // Calcul de la nouvelle place
      int positionX = this.uneFourmi.getPlace().getX();
      int positionY = this.uneFourmi.getPlace().getY();
      int positionXFinal = positionX;
      int positionYFinal = positionY;
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
        this.uneFourmi.setPlace(this.terrain.getPlace(positionXFinal, positionYFinal));
        ReportMouvementDepot report = ReportMouvementDepot.getInstance();
        ReportMouvementProie reportProie = ReportMouvementProie.getInstance();
        report.traceMouvement(ancienne, this.uneFourmi.getPlace());

      } else {
        if (this.uneProie != null) {
          this.terrain.getFourmiliere().getDepotFourmiliere().ajouterCadavreProie(this.uneProie);
          this.uneProie = null;
        } else {
          this.terrain.getFourmiliere().getDepotFourmiliere().ajouterCadavreFourmi(cadavreFourmi);
          this.cadavreFourmi = null;
        }
        ((Adulte) uneFourmi.getEtat()).changerTrajet();
      }
      // Modification de la place

    } else {
      miseAJourCadavre();
    }
  }

  private void miseAJourCadavre() {
    Nid nid = this.terrain.getFourmiliere().getNidFourmiliere();
    Proie uneProie = nid.getCadavreProie();
    if (uneProie != null) {
      this.setProie(uneProie);
      CompteurNid cpt = CompteurNid.getInstance();
      cpt.applique();
    } else {
      if (CompteurNid.getInstance().getcptCadavre() != 0) {
        this.setCadavre(nid.getCadavreFourmi());
        CompteurNid cpt = CompteurNid.getInstance();
        cpt.applique();
      }
    }
  }

  public void setFourmi(Fourmi uneFourmi) {
    this.uneFourmi = uneFourmi;
    Nid nid = this.terrain.getFourmiliere().getNidFourmiliere();
    if ((nid.getListeProie().size() > 0) && nid.possedeCadavreProie()) {
      this.setProie(nid.getProieCadavre());
      CompteurNid cpt = CompteurNid.getInstance();
      cpt.applique();
    } else {
      if (CompteurNid.getInstance().getcptCadavre() != 0) {
        this.setCadavre(nid.getCadavreFourmi());
        CompteurNid cpt = CompteurNid.getInstance();
        cpt.applique();
      }
    }
  }

  public void setProie(Proie uneProie) {
    this.terrain.getFourmiliere().getNidFourmiliere().supprimerProie(uneProie);
    this.uneProie = uneProie;
  }

  public void setCadavre(Fourmi cadavreFourmi) {
    this.terrain.getFourmiliere().getNidFourmiliere().supprimerFourmi(cadavreFourmi);
    this.cadavreFourmi = cadavreFourmi;
  }

  @Override
  public Fourmi getFourmi() {
    return this.uneFourmi;
  }

}
