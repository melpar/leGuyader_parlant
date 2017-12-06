package report;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;
import temps.Temps;

public class ReportNid extends Report {
  private List<Fourmi> listeFourmi;
  private List<Proie> listeProie;

  public ReportNid() {
    this.listeFourmi = new ArrayList<Fourmi>();
    this.listeProie = new ArrayList<Proie>();
  }

  /**
   * Redefinition de la methode toString().
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fourmi dans le Nid\n");
    for (int indice = 0; indice < this.listeFourmi.size(); indice++) {
      ReportFourmi reportFourmi = new ReportFourmi();
      reportFourmi.traceFourmi(this.listeFourmi.get(indice));

      stringBuilder.append(reportFourmi.toString());
    }
    stringBuilder.append("Proies dans le Nid\n");
    for (int indice = 0; indice < this.listeProie.size(); indice++) {
      ReportProie reportProie = new ReportProie();
      reportProie.traceProie(this.listeProie.get(indice));
      stringBuilder.append(reportProie.toString());
    }
    return stringBuilder.toString();
  }

  @Override
  public void traceNid(Nid unNid) {
    this.listeFourmi = unNid.getListeFourmi();
    this.listeProie = unNid.getListeProie();
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

  @Override
  public void traceMouvement(Place placeDep, Place placeFin) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }

}
