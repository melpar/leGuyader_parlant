package mediateur;

import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.TempsObserver;
import temps.Duree;
import temps.Temps;

public class MediateurCombat extends MediateurCombatAbstract implements TempsObserver {

  /**
   * Permet de créer le médiateur.
   * 
   * @param uneProie
   *          proie associée
   * @param tempsCourant
   *          temps courant
   */
  public MediateurCombat(Proie uneProie, Temps tempsCourant) {
    System.out.println("nouveau combat");
    this.uneProie = uneProie;
    this.lesFourmis = new ArrayList<Fourmi>();
    this.tempsCourant = tempsCourant;
    this.dureeDebut = new Duree(tempsCourant.getTempsCourant());
  }

  @Override
  public void agitSur() {
    Duree ajouter = new Duree();
    ajouter.addMinute(10);
    if (!besoinAide()) {

      System.out.println("debut " + dureeDebut + " " + tempsCourant.getTempsCourant());
      if (tempsCourant.getTempsCourant().estSuperieur(Duree.ajouter(ajouter, dureeDebut))) {
        this.lesFourmis.get(0).getTempsCourant().removeObserveur(this);
        MediateurCombatRetour enCombatRetour = new MediateurCombatRetour(uneProie,
            uneProie.isEnCombat().lesFourmis, tempsCourant);
        uneProie.setEnCombat(enCombatRetour);
        this.lesFourmis.get(0).getTempsCourant().removeObserveur(this);
        this.lesFourmis.get(0).getTempsCourant().addObserveur(enCombatRetour);
      }
    }
  }

  public boolean besoinAide() {
    return sommePoidsFourmis() < this.uneProie.getPoids();
  }

  private double sommePoidsFourmis() {
    double somme = 0;
    for (Fourmi uneFourmi : this.lesFourmis) {
      somme += uneFourmi.getPoids();
    }
    System.out.println("somme : " + somme + " " + this.uneProie.getPoids());
    return somme;
  }
}
