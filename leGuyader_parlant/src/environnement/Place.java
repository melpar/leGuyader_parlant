package environnement;

import java.util.ArrayList;
import java.util.List;

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

  public void ajouterPheromone(Pheromone pheromone) {
    this.listePheromone.add(pheromone);
  }

}
