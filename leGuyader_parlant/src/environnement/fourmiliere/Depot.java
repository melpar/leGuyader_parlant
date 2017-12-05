package environnement.fourmiliere;

import environnement.Place;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;

/**
 * Representation du Depot. Cette classe possede une liste de cadavre de proies
 * et une liste de cadavre de fourmis.
 * 
 * @author LeGuyader
 */
public class Depot {
  List<Fourmi> listeCadavreFourmi;
  List<Proie> listeCadavreProie;
  Place placeDepot;

  /**
   * Constructeur du Depot.
   */
  public Depot(Place place) {
    this.listeCadavreFourmi = new ArrayList<Fourmi>();
    this.listeCadavreProie = new ArrayList<Proie>();
    this.placeDepot = place;
  }

  public void ajouterCadavreProie(Proie nouvelleProie) {
    this.listeCadavreProie.add(nouvelleProie);
  }

  public void ajouterCadavreFourmi(Fourmi nouvelleFourmi) {
    this.listeCadavreFourmi.add(nouvelleFourmi);
  }

  public int getNombreCadavreFourmi() {
    return this.listeCadavreFourmi.size();
  }

  public int getNombreCadavreProie() {
    return this.listeCadavreProie.size();
  }

  public int getNombreCadavre() {
    return this.getNombreCadavreFourmi() + this.getNombreCadavreProie();
  }

  public List<Fourmi> getListeCadavreFourmi() {
    return listeCadavreFourmi;
  }

  public void setListeCadavreFourmi(List<Fourmi> listeCadavreFourmi) {
    this.listeCadavreFourmi = listeCadavreFourmi;
  }

  public List<Proie> getListeCadavreProie() {
    return listeCadavreProie;
  }

  public void setListeCadavreProie(List<Proie> listeCadavreProie) {
    this.listeCadavreProie = listeCadavreProie;
  }

  public Place getPlaceDepot() {
    return placeDepot;
  }

  public void setPlaceDepot(Place placeDepot) {
    this.placeDepot = placeDepot;
  }

}
