package mediateur;

import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.TempsObserver;
import temps.Duree;
import temps.Temps;

/**
 * Permet de gérer le combat d'une proie avec une ou des fourmi(s).
 * 
 * @author LeGuyader Parlant
 */
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
    this.uneProie = uneProie;

    this.lesFourmis = new ArrayList<Fourmi>();
    this.tempsCourant = tempsCourant;
    this.dureeDebut = new Duree(tempsCourant.getTempsCourant());
  }

  /**
   * Si la/les fourmi(s) n'ont pas besoin d'aide suppl�mentaire, la proie est
   * ramen�e au d�pot.
   */
  @Override
  public void agitSur() {
    Duree ajouter = new Duree();
    ajouter.addMinute(10);
    if (!besoinAide()) {

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
    return somme;
  }

  public List<Fourmi> getFourmis() {
    return this.lesFourmis;
  }
}
