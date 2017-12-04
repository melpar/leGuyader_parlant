package report;

import population.Fourmi;
import population.etat.EtatAbstract;
import population.etat.Etats;

public class CompteurFourmi extends Report {
  int cptOeuf;
  int cptLarve;
  int cptNymphe;
  int cptAdulte;
  int cptCadavre;

  public void traceForFourmi(Fourmi uneFourmi) {
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
  public void traceForEtat(EtatAbstract etatAbstract) {

  }
}
