package mediateur;

import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import temps.Duree;
import temps.Temps;

public class MediateurPheromone {
  Pheromone pheromone;
  Temps tempsCourant;
  Duree dureeCourante;

  public MediateurPheromone(Pheromone pheromone, Temps tempsCourant) {
    this.pheromone = pheromone;
    this.tempsCourant = tempsCourant;
    this.dureeCourante = new Duree(tempsCourant.getTempsCourant());
  }

}
