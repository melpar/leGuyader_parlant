package test.population;

import environnement.Terrain;
import environnement.fourmiliere.Depot;
import population.Fourmi;
import population.Proie;
import population.etat.Etats;
import temps.Temps;

public class TestDeplacement {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Temps tempsCourant = new Temps();
    Terrain terrain = new Terrain(500, 500);
    TestDeplacement test = new TestDeplacement();
    // test.testDeplacementFourmi(terrain, tempsCourant);
    // test.testDeplacementProie(terrain, tempsCourant);
    test.testDeplacementDepot(terrain, tempsCourant);
  }

  public void testDeplacementFourmi(Terrain terrain, Temps tempsCourant) {

    Fourmi fourmi = new Fourmi(false, terrain.getPlace(0, 0), tempsCourant);
    tempsCourant.addObserveur(fourmi);

    assert (fourmi.getEtat().getEtat() == Etats.OEUF);
    Thread th = new Thread(tempsCourant);
    th.start();
  }

  public void testDeplacementProie(Terrain terrain, Temps tempsCourant) {

    Proie proie = new Proie(terrain.getPlace(0, 10), 3.7);
    tempsCourant.addObserveur(proie);
    Thread th = new Thread(tempsCourant);
    th.start();
  }

  public void testDeplacementDepot(Terrain terrain, Temps tempsCourant) {

    Fourmi fourmi = new Fourmi(false, terrain.getPlace(0, 0), tempsCourant);
    Fourmi fourmiReine = new Fourmi(false, terrain.getPlace(0, 0), tempsCourant);
    fourmiReine.setReine();
    terrain.premiereReine(fourmiReine);
    tempsCourant.addObserveur(fourmi);
    Thread th = new Thread(tempsCourant);
    th.start();
  }

}
