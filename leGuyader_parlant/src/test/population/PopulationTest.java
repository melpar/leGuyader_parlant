package test.population;

import org.junit.Test;

import environnement.Place;
import population.Fourmi;
import population.etat.Etats;
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

  public static void main(String[] args) {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();

    Fourmi fourmi = new Fourmi(false, place, tempsCourant);
    tempsCourant.addObserveur(fourmi);

    assert (fourmi.getEtat().getEtat() == Etats.OEUF);
    Thread th = new Thread(tempsCourant);
    th.start();

  }
}
