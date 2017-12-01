package temps;

public class Duree {
  private int annee;
  private int mois;
  private int jour;
  private int heure;
  private int minute;

  /**
   * Permet d'initialiser un durée à 0.
   */
  public Duree() {
    this.annee = 0;
    this.mois = 0;
    this.jour = 0;
    this.heure = 0;
    this.minute = 0;
  }

  public int getAnnee() {
    return annee;
  }

  public void setAnnee(int annee) {
    this.annee = annee;
  }

  public int getMois() {
    return mois;
  }

  public void setMois(int mois) {
    this.mois = mois;
  }

  public int getJour() {
    return jour;
  }

  public void setJour(int jour) {
    this.jour = jour;
  }

  public int getHeure() {
    return heure;
  }

  public void setHeure(int heure) {
    this.heure = heure;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public void addJour(int jour) {
    this.jour += jour;
  }

  /**
   * Methode pour comparer deux Duree.
   * 
   * @param duree
   *          Duree de comparaison.
   * @return True si superieur a la duree passer en parametre, False sinon.
   */
  public boolean estSuperieur(Duree duree) {
    if (duree.getAnnee() < this.annee) {
      return true;
    }

    if (duree.getMois() < this.mois) {
      return true;
    }

    if (duree.getJour() < this.jour) {
      return true;
    }

    if (duree.getMinute() < this.minute) {
      return true;
    }
    return false;
  }

}
