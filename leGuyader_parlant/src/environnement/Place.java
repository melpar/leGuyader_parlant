package environnement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mediateur.MediateurPheromone;
import temps.Duree;
import temps.Temps;

/**
 * Representation d'une positition sur le terrain.
 * 
 * @author LeGuyader
 * 
 */
public class Place {
  private int positionX;
  private int positionY;
  private Temps tempsCourant;
  private Map<Pheromone, MediateurPheromone> listePheromone;

  /**
   * Constructeur de Place.
   * 
   * @param x
   *          Position sur l'axe X.
   * @param y
   *          Position sur l'axe Y.
   */
  public Place(int x, int y, Temps tempsCourant) {
    this.positionX = x;
    this.positionY = y;
    this.listePheromone = new HashMap<Pheromone, MediateurPheromone>();
    this.tempsCourant = tempsCourant;
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
      MediateurPheromone gestion = new MediateurPheromone(pheromone, this.tempsCourant);
      this.listePheromone.put(pheromone, gestion);
      return true;
    }
    return true;
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
      if (this.listePheromone.get(indice) != null) {
        return indice;
      }
    }
    return -1;
  }

  public List<Pheromone> getListePheromone() {
    return new ArrayList<Pheromone>(listePheromone.keySet());
  }

}
