package environnement.fourmiliere;

import environnement.Place;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.etat.Etats;
import population.etat.EtatsProies;
import population.etat.ProieMorte;
import population.etat.ProieVivante;

/**
 * Representation du Nid. Cette classe possede une liste de proies et une liste
 * de fourmis.
 * 
 * @author LeGuyader
 */
public class Nid {
  private List<Fourmi> listeFourmi;
  private List<Proie> listeProie;
  private Place placeNid;

  /**
   * Constructeur de Nid.
   * 
   */
  public Nid(Place place) {
    this.listeFourmi = new ArrayList<Fourmi>();
    this.listeProie = new ArrayList<Proie>();
    this.placeNid = place;
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

  public Place getPlaceNid() {
    return placeNid;
  }

  public void setPlaceNid(Place placeNid) {
    this.placeNid = placeNid;
  }

  public List<Fourmi> getListeFourmi() {
    return listeFourmi;
  }

  public void setListeFourmi(List<Fourmi> listeFourmi) {
    this.listeFourmi = listeFourmi;
  }

  public List<Proie> getListeProie() {
    return listeProie;
  }

  public void setListeProie(List<Proie> listeProie) {
    this.listeProie = listeProie;
  }

  public boolean possedeCadavreProie() {
    for (int indice = 0; indice < this.listeProie.size(); indice++) {
      if (this.listeProie.get(indice).getEtat() instanceof ProieMorte) {
        return true;
      }
    }
    return false;
  }

  public Proie getProieCadavre() {
    for (int indice = 0; indice < this.listeProie.size(); indice++) {
      if (this.listeProie.get(indice).getEtat() instanceof ProieMorte) {
        return this.listeProie.get(indice);
      }
    }
    return null;
  }

  /**
   * Methode qui recupere la premiere fourmi dans l'etat cadavre. *
   * 
   * @return Fourmi dans l'etat cadavre
   */
  public Fourmi getCadavreFourmi() {
    // TODO Auto-generated method stub
    for (int indice = 0; indice < this.listeFourmi.size(); indice++) {
      if (this.listeFourmi.get(indice).getEtat().getEtat() == Etats.CADAVRE) {
        return this.listeFourmi.get(indice);
      }
    }
    return null;
  }

  public Proie getCadavreProie() {
    for (int indice = 0; indice < this.listeProie.size(); indice++) {
      if (this.listeProie.get(indice).getEtat().getLibelle() == EtatsProies.CADAVRE) {
        return this.listeProie.get(indice);
      }
    }
    return null;
  }

}
