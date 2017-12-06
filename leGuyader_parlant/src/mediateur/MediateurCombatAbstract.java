package mediateur;

import java.util.List;

import population.Fourmi;
import population.Proie;
import temps.Duree;
import temps.Temps;

public abstract class MediateurCombatAbstract {
  protected List<Fourmi> lesFourmis;
  protected Proie uneProie;
  protected Temps tempsCourant;
  protected Duree dureeDebut;

  public boolean besoinAide() {
    return sommePoidsFourmis() < this.uneProie.getPoids();
  }

  private double sommePoidsFourmis() {
    double somme = 0;
    for (Fourmi uneFourmi : this.lesFourmis) {
      somme += uneFourmi.getPoids();
    }
    return somme;
  }

  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }
}
