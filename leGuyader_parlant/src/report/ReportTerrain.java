package report;

import java.util.List;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatAbstract;
import temps.Temps;

public class ReportTerrain extends Report {
  private int unelargeur;
  private int unelongueur;
  private Fourmiliere unefourmiliere;
  private List<Proie> uneListeProie;

  /**
   * Permet de retourner l'ensemble des attributs sous la forme d'un string.
   * 
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Terrain :\n");
    stringBuilder.append("Dimension (").append(this.unelongueur).append(" X ");
    stringBuilder.append(this.unelargeur).append(")\n");
    stringBuilder.append("Liste de proie ").append(this.uneListeProie.size());
    stringBuilder.append(":\n");
    for (int indice = 0; indice < this.uneListeProie.size(); indice++) {
      ReportProie reportProie = new ReportProie();
      reportProie.traceProie(this.uneListeProie.get(indice));
      stringBuilder.append(reportProie.toString());
    }
    stringBuilder.append("Fourmiliere:\n");
    ReportFourmiliere reportFourmiliere = new ReportFourmiliere();
    reportFourmiliere.traceFourmiliere(this.unefourmiliere);
    stringBuilder.append(reportFourmiliere.toString());
    stringBuilder.append("\n");
    return stringBuilder.toString();

  }

  @Override
  public void traceTerrain(Terrain unTerrain) {
    this.unelargeur = unTerrain.getLargeurTerrain();
    this.unelongueur = unTerrain.getLongueurTerrain();
    this.unefourmiliere = unTerrain.getFourmiliere();
    this.uneListeProie = unTerrain.getListeProie();

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
  public void traceMouvement(Place placeDep, Place placeFin) {
    // TODO Auto-generated method stub

  }

  @Override
  public void traceTemps(Temps temps) {
    // TODO Auto-generated method stub

  }

}
