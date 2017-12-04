package test.population;

import org.junit.Test;

import environnement.Place;
import environnement.Terrain;
import population.Fourmi;
import population.etat.Etats;
import report.CompteurFourmi;
import temps.Duree;
import temps.Temps;

public class PopulationTest {
  @Test
  public void creationFourmi() {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    assert (fourmi.getAge().equals(new Duree()));
    assert (fourmi.getaMange() == 0);
    assert (fourmi.getEtat().getEtat() == Etats.OEUF);
  }

  @Test
  public void changementEtat() {
    Temps tempsCourant = new Temps();
    Duree dureeOeuf = new Duree(tempsCourant.getTempsCourant());
    dureeOeuf.addJour(3);
    Duree dureeLarve = new Duree(dureeOeuf);
    dureeLarve.addJour(10);
    Duree dureeNymphe = new Duree(dureeLarve);
    dureeNymphe.addJour(5);

    Place place = new Place(0, 0);
    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    assert (fourmi.getEtat().getEtat() == Etats.OEUF);
    fourmi.changeEtat(fourmi.getEtat().getEtat(), dureeOeuf);
    assert (fourmi.getEtat().getEtat() == Etats.LARVE);
    fourmi.changeEtat(fourmi.getEtat().getEtat(), dureeLarve);
    assert (fourmi.getEtat().getEtat() == Etats.NYMPHE);
    fourmi.changeEtat(fourmi.getEtat().getEtat(), dureeNymphe);
    assert (fourmi.getEtat().getEtat() == Etats.ADULTE);
  }

  /**
   * Permet de lancer un thread temps. Permet de suivre l'évolution d'une fourmi.
   * 
   * @param args
   *          liste des arguments.
   */
  public static void main(String[] args) {
    Terrain terrain = new Terrain(500, 500);
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();

    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    tempsCourant.addObserveur(fourmi);

    assert (fourmi.getEtat().getEtat() == Etats.OEUF);
    Thread th = new Thread(tempsCourant);
    th.start();

  }

  @Test
  public void testIsReine() {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    fourmi.setReine();
    assert (fourmi.isReine());
  }

  @Test
  public void testReine() {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    fourmi.setReine();
    Terrain terrainTest = new Terrain(500, 500);
    terrainTest.premiereReine(fourmi);
    fourmi.pond();
    CompteurFourmi cpt = new CompteurFourmi();
    assert (terrainTest.getFourmiliere().getNidFourmiliere().getNombreFourmi() == 51);
    for (Fourmi uneFourmi : terrainTest.getFourmiliere().getNidFourmiliere().getListeFourmi()) {
      cpt.traceFourmi(uneFourmi);
    }
    System.out.println(cpt);
  }
}
