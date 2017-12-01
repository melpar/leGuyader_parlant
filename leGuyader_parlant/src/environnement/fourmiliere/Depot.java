package environnement.fourmiliere;

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

  /**
   * Constructeur du Depot.
   */
  public Depot() {
    this.listeCadavreFourmi = new ArrayList<Fourmi>();
    this.listeCadavreProie = new ArrayList<Proie>();
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

}
