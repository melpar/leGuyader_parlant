package mediateur;

import java.util.ArrayList;
import java.util.List;

import environnement.Place;
import environnement.Terrain;
import population.Fourmi;
import population.Proie;
import population.TempsObserver;
import population.etat.Adulte;
import population.etat.EtatProieAbstract;
import population.etat.ProieCapturee;
import population.etat.ProieStopee;
import report.CompteurNid;
import report.ReportMouvementChasse;
import report.ReportMouvementDepot;
import report.ReportMouvementProie;
import temps.Duree;
import temps.Temps;

/**
 * Permet de gérer le déplacement de fourmis, dans le cadre du retour aprés un
 * combat.
 * 
 * @author LeGuyader Parlant
 */
public class MediateurCombatRetour extends MediateurCombatAbstract implements TempsObserver {

  /**
   * Permet de créer un médiateur.
   * 
   * @param uneProie
   *          proieà associer
   * @param lesFourmis
   *          liste de fourmis qui participent au combat
   * @param tempsCourant
   *          temps courant
   */
  public MediateurCombatRetour(Proie uneProie, List<Fourmi> lesFourmis, Temps tempsCourant) {
    this.uneProie = uneProie;
    this.uneProie.setEtat(new ProieStopee(tempsCourant, uneProie));
    this.lesFourmis = lesFourmis;
    this.tempsCourant = tempsCourant;
    this.dureeDebut = new Duree(tempsCourant.getTempsCourant());
  }

  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }

  /**
   * A chaque �volution du temps, les fourmis avec la proie se rapprochent du nid.
   */
  @Override
  public void agitSur() {
    Terrain terrain = Terrain.getInstance();
    Fourmi uneFourmi = this.lesFourmis.get(0);
    Place ancienne = uneFourmi.getPlace();
    // Calcul de la nouvelle place
    int positionX = uneFourmi.getPlace().getX();
    int positionY = uneFourmi.getPlace().getY();
    int positionXFinal = positionX;
    int positionYFinal = positionY;
    Place place = terrain.getFourmiliere().getPlaceFourmiliere();
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
      // Modification de la place
      for (Fourmi fourmi : this.lesFourmis) {
        fourmi.setPlace(terrain.getPlace(positionXFinal, positionYFinal));
        ReportMouvementChasse report = ReportMouvementChasse.getInstance();
        report.setFourmi(fourmi);
        report.traceMouvement(ancienne, fourmi.getPlace());
      }
      uneProie.setPlaceProie(terrain.getPlace(positionXFinal, positionYFinal));
      ReportMouvementProie report = ReportMouvementProie.getInstance();
      report.setProie(uneProie);
      report.traceMouvement(ancienne, uneProie.getPlaceProie());
    } else {
      Terrain unTerrain = Terrain.getInstance();
      unTerrain.supprimerProie(uneProie);
      unTerrain.getFourmiliere().getNidFourmiliere().ajouterProie(uneProie);
      uneProie.setEnCombat(null);
      CompteurNid cpt = CompteurNid.getInstance();
      cpt.applique();
      for (Fourmi laFourmi : lesFourmis) {
        laFourmi.setEnCombat(false);
      }
      uneProie.setEtat(new ProieCapturee(uneFourmi.getTempsCourant(), uneProie));
      uneFourmi.getTempsCourant().removeObserveur(this);
    }

  }

}
