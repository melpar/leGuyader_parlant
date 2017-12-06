package mediateur;

import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import temps.Duree;
import temps.Temps;

public class MediateurCombat {
  private List<Fourmi> lesFourmis;
  private Proie uneProie;
  private Temps tempsCourant;
  private Duree dureeDebut;

  public MediateurCombat(Proie uneProie) {
    System.out.println("nouveau combat");
    this.uneProie = uneProie;
    this.lesFourmis = new ArrayList<Fourmi>();
  }

  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }
}
