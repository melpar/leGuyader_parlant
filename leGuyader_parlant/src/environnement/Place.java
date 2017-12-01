package environnement;

import java.util.ArrayList;
import java.util.List;

import temps.Duree;

/**
 * Representation d'une positition sur le terrain.
 * 
 * @author LeGuyader
 * 
 */
public class Place {
  private int positionX;
  private int positionY;
  private List<Pheromone> listePheromone;

  /**
   * Constructeur de Place.
   * 
   * @param x
   *          Position sur l'axe X.
   * @param y
   *          Position sur l'axe Y.
   */
  public Place(int x, int y) {
    this.positionX = x;
    this.positionY = y;
    this.listePheromone = new ArrayList<Pheromone>();
  }

  public int getX() {
    return positionX;
  }

  public void setX(int x) {
    this.positionX = x;
  }

  public int getY() {
    return positionY;
  }

  public void setY(int y) {
    this.positionY = y;
  }

  /**
   * Methode qui ajoute un pheromone a la Place.
   * 
   * @param pheromone
   *          Pheromone a ajouter.
   * @return True si le pheromone est ajouter ou mise a jours, False sinon.
   * 
   */
  public Boolean ajouterPheromone(Pheromone pheromone) {
    int indice = this.contientPheromone(pheromone);
    if (indice == (-1)) {
      this.listePheromone.add(pheromone);
      return true;
    }

    Duree nouvelleDuree = this.listePheromone.get(indice).getDuree();

    if (pheromone.getDuree().estSuperieur(nouvelleDuree)) {
      this.listePheromone.get(indice).setDuree(nouvelleDuree);
      return true;
    }
    return false;
  }

  /**
   * Methode qui recherche la presence d'un Pheromone.
   * 
   * @param pheromone
   *          Pheromone a rechercher.
   * @return l'indice du pheromone , -1 si le pheromone n'est pas trouve.
   */
  public int contientPheromone(Pheromone pheromone) {
    if (this.listePheromone.size() == 0) {
      return -1;
    }
    for (int indice = 0; indice < this.listePheromone.size(); indice++) {
      if (this.listePheromone.get(indice).equals(pheromone.name())) {
        return indice;
      }
    }
    return -1;
  }

}
