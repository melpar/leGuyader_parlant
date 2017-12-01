package environnement;

import java.util.ArrayList;
import java.util.List;

import population.Proie;

/**
 * Representation du terrain.
 * 
 * @author LeGuyader
 *
 */
public class Terrain {
  private int largeurTerrain;
  private int longueurTerrain;
  private Fourmiliere fourmiliere;
  private Place[] placeTerrain;
  private List<Proie> listeProie;

  /**
   * Contructeur du terrain.
   * 
   * @param largeurTerrain
   *          Entier qui represente la largeur du terrain.
   * @param longueurTerrain
   *          Entier qui represente la longueur du terrain.
   */
  public Terrain(int largeurTerrain, int longueurTerrain) {
    this.largeurTerrain = largeurTerrain;
    this.longueurTerrain = longueurTerrain;
    this.placeTerrain = new Place[this.longueurTerrain * this.largeurTerrain];
    for (int position = 0; position < this.longueurTerrain * this.largeurTerrain; position++) {
      this.placeTerrain[position] = new Place(position % this.largeurTerrain,
          position % this.longueurTerrain);

    }
    this.fourmiliere = new Fourmiliere(this.getPlace(0, 0));
    this.listeProie = new ArrayList<Proie>();

  }

  public int getLargeurTerrain() {
    return largeurTerrain;
  }

  public void setLargeurTerrain(int largeurTerrain) {
    this.largeurTerrain = largeurTerrain;
  }

  public int getLongueurTerrain() {
    return longueurTerrain;
  }

  public void setLongueurTerrain(int longueurTerrain) {
    this.longueurTerrain = longueurTerrain;
  }

  public Fourmiliere getFourmiliere() {
    return fourmiliere;
  }

  public void setFourmiliere(Fourmiliere fourmiliere) {
    this.fourmiliere = fourmiliere;
  }

  public void ajouterProie(Proie nouvelleProie) {
    this.listeProie.add(nouvelleProie);
  }

  /**
   * Methode pour supprimer la proie du terrain.
   * 
   * @param proie
   *          Proie a suppprimer.
   * @return True si la Proie a ete supprimer , False sinon.
   */
  public boolean supprimerProie(Proie proie) {
    if (proie == null) {
      return false;
    }
    return this.listeProie.remove(proie);
  }

  public int getNombrePlace() {
    return this.largeurTerrain * this.longueurTerrain;
  }

  /**
   * Methode pour recuperer une Place.
   * 
   * @param positionX
   *          Position sur l'axe X.
   * @param positionY
   *          Position sur l'axe Y.
   * @return La Place recherchee.
   */
  public Place getPlace(int positionX, int positionY) {
    int posX = positionX;
    int posY = positionY;

    if (posX >= this.longueurTerrain) {
      posX = this.longueurTerrain - 1;
    }
    if (posX < 0) {
      posX = 0;
    }
    if (posY >= this.largeurTerrain) {
      posY = this.largeurTerrain;
    }

    if (posY < 0) {
      posY = 0;
    }
    return this.placeTerrain[posX * posY];
  }

  public int getNombreProie() {
    return this.listeProie.size();
  }

}
