package mediateur;

import java.util.List;

import population.Fourmi;
import population.Proie;
import population.etat.ProieStopee;
import population.etat.ProieVivante;
import temps.Duree;
import temps.Temps;

/**
 * Permet de définir les éléments nécessaires au combat. Est implémenté par
 * MediateurCombat et MediateurCombatRetour.
 * 
 * @author LeGuyader Parlant
 */
public abstract class MediateurCombatAbstract {
  protected List<Fourmi> lesFourmis;
  protected Proie uneProie;
  protected Temps tempsCourant;
  protected Duree dureeDebut;

  public void setProie(Proie proie) {
    this.uneProie = proie;
  }

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

  /**
   * Permet d'ajouter une fourmi à la liste.
   * 
   * @param uneFourmi
   *          fourmi à ajouter
   */
  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
    if (uneProie.getEtat() instanceof ProieVivante) {
      uneProie.setEtat(new ProieStopee(lesFourmis.get(0).getTempsCourant(), uneProie));
    }
  }
}
