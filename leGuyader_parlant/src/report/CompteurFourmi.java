package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class CompteurFourmi extends Report {
  private int cptOeuf;
  private int cptLarve;
  private int cptNymphe;
  private int cptAdulte;
  private int cptCadavre;

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
}
