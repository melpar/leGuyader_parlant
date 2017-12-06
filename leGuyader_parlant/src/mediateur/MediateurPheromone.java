package mediateur;

import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.TempsObserver;
import report.ReportPheromone;
import temps.Duree;
import temps.Temps;

/**
 * Permet de gérer les phéromones.
 * 
 * @author parlanme
 *
 */
public class MediateurPheromone implements TempsObserver {
  Pheromone pheromone;
  Temps tempsCourant;
  Duree dureeCourante;
  Place place;

  public MediateurPheromone(Pheromone pheromone, Temps tempsCourant, Place place) {
    this.pheromone = pheromone;
    this.tempsCourant = tempsCourant;
    this.dureeCourante = new Duree(tempsCourant.getTempsCourant());
    this.place = place;
    this.tempsCourant.addObserveur(this);
  }

  /**
   * Si le temps est écoulé, le phéromone est détruit.
   */
  @Override
  public void agitSur() {
    // TODO Auto-generated method stub
    if (tempsCourant.getTempsCourant()
        .estSuperieur(Duree.ajouter(pheromone.getDuree(), this.dureeCourante))) {
      this.place.removePheromone(this.pheromone);
      ReportPheromone reportPhero = ReportPheromone.getInstance();
      reportPhero.tracePlace(this.place);
      this.tempsCourant.removeObserveur(this);
    }

  }

}
