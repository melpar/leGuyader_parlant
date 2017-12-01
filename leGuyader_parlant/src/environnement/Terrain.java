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
  private Place[][] placeTerrain;
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
    this.placeTerrain = new Place[this.longueurTerrain][this.largeurTerrain];
    for (int axeX = 0; axeX < this.longueurTerrain; axeX++) {
      for (int axeY = 0; axeY < this.largeurTerrain; axeY++) {
        this.placeTerrain[axeX][axeY] = new Place(axeX, axeY);
      }
    }
    this.fourmiliere = new Fourmiliere();
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

}
