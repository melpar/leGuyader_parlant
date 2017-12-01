package environnement.fourmiliere;

import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;

/**
 * Representation du Nid. Cette classe possede une liste de proies et une liste
 * de fourmis.
 * 
 * @author LeGuyader
 */
public class Nid {
  private List<Fourmi> listeFourmi;
  private List<Proie> listeProie;

  /**
   * Constructeur de Nid.
   * 
   */
  public Nid() {
    this.listeFourmi = new ArrayList<Fourmi>();
    this.listeProie = new ArrayList<Proie>();
  }

  public void ajouterProie(Proie nouvelleProie) {
    this.listeProie.add(nouvelleProie);
  }

  /**
   * Methode pour supprimer la proie du Nid.
   * 
   * @param proie
   *          Proie a suppprimer.
   * @return True si la Proie a ete supprimer , False sinon.
   */
  public boolean supprimerProie(Proie proie) {
    if (proie == null) {
      return false;
    }
    return this.listeProie.remove(proie);
  }

  public void ajouterFourmi(Fourmi nouvelleFourmi) {
    this.listeFourmi.add(nouvelleFourmi);
  }

  /**
   * Methode pour supprimer la fourmi du Nid.
   * 
   * @param fourmi
   *          Proie a suppprimer.
   * @return True si la Fourmi a ete supprimer , False sinon.
   */
  public boolean supprimerFourmi(Fourmi fourmi) {
    if (fourmi == null) {
      return false;
    }
    return this.listeFourmi.remove(fourmi);
  }

  public int getNombreFourmi() {
    return this.listeFourmi.size();
  }

  public int getNombreProie() {
    return this.listeProie.size();
  }

}
