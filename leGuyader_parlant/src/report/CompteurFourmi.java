package report;

import java.util.ArrayList;
import java.util.List;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.CompteurObserver;
import population.Fourmi;
import population.Proie;
import population.ReportObserver;
import population.etat.EtatAbstract;

public class CompteurFourmi extends Report implements CompteurObservable {
  private int cptOeuf;
  private int cptLarve;
  private int cptNymphe;
  private int cptAdulte;
  private int cptCadavre;
  List<CompteurObserver> observers;

  private static CompteurFourmi instance;

  private Nid nid;

  private CompteurFourmi() {
    this.observers = new ArrayList<CompteurObserver>();
  }

  public static CompteurFourmi getInstance() {
    if (instance == null) {
      instance = new CompteurFourmi();
    }
    return instance;
  }

  /**
   * Permet de faire une trace d'une fourmi.
   */
  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    switch (uneFourmi.getEtat().getEtat()) {
      case OEUF:
        this.cptOeuf++;
        break;
      case LARVE:
        this.cptLarve++;
        break;
      case NYMPHE:
        this.cptNymphe++;
        break;
      case ADULTE:
        this.cptAdulte++;
        break;
      default:
        this.cptCadavre++;
        break;
    }
  }

  /**
   * Retourne l'ensemble des éléments de l'instance sous la forme d'une chaine de
   * caractere.
   */
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append("Nombre d'oeufs : ").append(cptOeuf).append("\n");
    ret.append("Nombre de larves : ").append(cptLarve).append("\n");
    ret.append("Nombre de nymphes : ").append(cptNymphe).append("\n");
    ret.append("Nombre d'adultes : ").append(cptAdulte).append("\n");
    ret.append("Nombre de cadavre : ").append(cptCadavre).append("\n");
    return ret.toString();
  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {

  }

  @Override
  public void traceFourmiliere(Fourmiliere uneFourmiliere) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceNid(Nid unNid) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceDepot(Depot uneDepot) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceProie(Proie proie) {
    // TODO Auto-generated method stub

  }

  @Override
  public void tracePlace(Place place) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceTerrain(Terrain unterrain) {
    // TODO Auto-generated method stub

  }

  public int getCptOeuf() {
    return cptOeuf;
  }

  public void setCptOeuf(int cptOeuf) {
    this.cptOeuf = cptOeuf;
  }

  public int getCptLarve() {
    return cptLarve;
  }

  public void setCptLarve(int cptLarve) {
    this.cptLarve = cptLarve;
  }

  public int getCptNymphe() {
    return cptNymphe;
  }

  public void setCptNymphe(int cptNymphe) {
    this.cptNymphe = cptNymphe;
  }

  public int getCptAdulte() {
    return cptAdulte;
  }

  public void setCptAdulte(int cptAdulte) {
    this.cptAdulte = cptAdulte;
  }

  public int getCptCadavre() {
    return cptCadavre;
  }

  public void setCptCadavre(int cptCadavre) {
    this.cptCadavre = cptCadavre;
  }

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
    // TODO Auto-generated method stub

  }

  @Override
  public void applique() {
    this.remiseAZero();

    for (CompteurObserver obs : observers) {
      obs.agitSur(this);
    }

  }

  private void remiseAZero() {
    this.cptAdulte = 0;
    this.cptCadavre = 0;
    this.cptLarve = 0;
    this.cptNymphe = 0;
    this.cptOeuf = 0;

  }

  public void setNid(Nid nid2) {
    this.nid = nid2;
  }

  public void ajoutObserver(CompteurObserver compteur) {
    this.observers.add(compteur);
  }
}
