package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;

public class ReportDepot extends Report {

  private List<Fourmi> listeCadavreFourmi;
  private List<Proie> listeCadavreProie;

  /**
   * Redefinition de la methode toString().
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int indice = 0; indice < this.listeCadavreFourmi.size(); indice++) {
      ReportFourmi reportFourmi = new ReportFourmi();
      reportFourmi.traceFourmi(this.listeCadavreFourmi.get(indice));
      stringBuilder.append(reportFourmi.toString());
    }

    for (int indice = 0; indice < this.listeCadavreProie.size(); indice++) {
      ReportProie reportProie = new ReportProie();
      reportProie.traceProie(this.listeCadavreProie.get(indice));
      stringBuilder.append(reportProie.toString());
    }
    return stringBuilder.toString();
  }

  @Override
  public void traceDepot(Depot uneDepot) {
    this.listeCadavreFourmi = uneDepot.getListeCadavreFourmi();
    this.listeCadavreProie = uneDepot.getListeCadavreProie();
  }

  @Override
  public void traceFourmi(Fourmi uneFourmi) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceEtat(EtatAbstract etatAbstract) {
    // TODO Auto-generated method stub

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

}
