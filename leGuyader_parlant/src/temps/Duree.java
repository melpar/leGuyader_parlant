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

  /**
   * Créé une durée à partir d'une autre durée (copie en profondeur).
   * 
   * @param duree
   *          durée de base
   */
  public Duree(Duree duree) {
    this.annee = new Integer(duree.annee);
    this.mois = new Integer(duree.mois);
    this.jour = new Integer(duree.jour);
    this.heure = new Integer(duree.heure);
    this.minute = new Integer(duree.minute);
  }

  /**
   * Vérifie si les deux durées sont égales.
   */
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Duree)) {
      return false;
    }
    Duree duree = (Duree) obj;
    if (duree.getAnnee() == this.annee && duree.getMois() == this.mois
        && duree.getJour() == this.jour && duree.getHeure() == this.heure
        && this.minute == duree.getMinute()) {
      return true;
    }
    return false;
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

  /**
   * Permet d'augmenter le nombre de minutes.
   * 
   * @param minuteAajouter
   *          nombre des minutes à ajouter
   */
  public void addMinute(int minuteAajouter) {
    this.minute += minuteAajouter;

    if (this.minute >= 60) {
      this.minute = this.minute - 60;
      this.addHeure(1);
    }
  }

  /**
   * Permet d'augmenter le nombre d'heures.
   * 
   * @param heureAajouter
   *          nombre d'heures à ajouter
   */
  public void addHeure(int heureAajouter) {
    this.heure += heureAajouter;

    if (this.heure >= 24) {
      this.heure = this.heure - 24;
      this.addJour(1);
    }
  }

  /**
   * Permet d'augmenter le nombre de jours.
   * 
   * @param jourAajouter
   *          nombre de jours à ajouter
   */
  public void addJour(int jourAajouter) {
    this.jour += jourAajouter;
    if (this.mois == 1 || this.mois == 3 || this.mois == 5 || this.mois == 7 || this.mois == 8
        || this.mois == 10 || this.mois == 12) {

      if (this.jour > 31) {
        this.jour = this.jour - 31;
        this.addMois(1);
      }
    } else if (this.mois == 2) {
      if (this.jour > 28) {
        this.jour = this.jour - 29;
        this.addMois(1);
      }
    } else {
      if (this.jour > 30) {
        this.jour = this.jour - 30;
        this.addMois(1);
      }
    }
  }

  /**
   * Permet d'augmenter le nombre de mois.
   * 
   * @param moisAajouter
   *          nombre de mois à ajouter
   */
  public void addMois(int moisAajouter) {
    this.mois += moisAajouter;

    if (this.mois > 12) {
      this.mois = this.mois - 12;
      this.addAnnee(1);
    }
  }

  public void addAnnee(int anneeAajouter) {
    this.annee += anneeAajouter;

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
    } else if (duree.getAnnee() == this.annee) {
      if (duree.getMois() < this.mois) {
        return true;
      } else if (duree.getMois() == this.mois) {
        if (duree.getJour() < this.jour) {
          return true;
        } else if (duree.getJour() == this.jour) {
          if (duree.getHeure() < this.heure) {
            return true;
          } else if (duree.getHeure() == this.heure) {
            if (duree.getMinute() < this.minute) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  /**
   * Permet d'additionner deux durées.
   * 
   * @param date1
   *          premiere durée à additionner
   * @param date2
   *          deuxième durée à additionner
   * @return résultat de l'addition
   */
  public static Duree ajouter(Duree date1, Duree date2) {
    Duree ret = new Duree(date1);
    ret.addMinute(date2.minute);
    ret.addHeure(date2.heure);
    ret.addJour(date2.jour);
    ret.addMois(date2.mois);
    ret.addAnnee(date2.annee);
    return ret;
  }

  /**
   * Permet d'afficher une durée.
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Annee : ").append(this.annee).append("  |   ");
    stringBuilder.append("Mois : ").append(this.mois).append("  |   ");
    stringBuilder.append("Jour : ").append(this.jour).append("  |   ");
    stringBuilder.append("Heure : ").append(this.heure).append("  |   ");
    stringBuilder.append("Minute : ").append(this.minute).append("  |   ");
    return stringBuilder.toString();
  }

}
