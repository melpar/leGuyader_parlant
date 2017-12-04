package environnement;

import java.util.ArrayList;
import java.util.List;

import environnement.fourmiliere.Depot;
import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import population.role.Reine;

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

  private static final int LARGEUR_MIN_TERRAIN = 5;
  private static final int LONGUEUR_MIN_TERRAIN = 5;

  /**
   * Contructeur du terrain.
   * 
   * @param largeurTerrain
   *          Entier qui represente la largeur du terrain.
   * @param longueurTerrain
   *          Entier qui represente la longueur du terrain.
   */
  public Terrain(int largeurTerrain, int longueurTerrain) {
    if (largeurTerrain > LARGEUR_MIN_TERRAIN) {
      this.largeurTerrain = largeurTerrain;
    } else {
      this.largeurTerrain = LARGEUR_MIN_TERRAIN;
    }

    if (longueurTerrain > LONGUEUR_MIN_TERRAIN) {
      this.longueurTerrain = longueurTerrain;
    } else {
      this.longueurTerrain = LONGUEUR_MIN_TERRAIN;
    }
    this.placeTerrain = new Place[this.longueurTerrain * this.largeurTerrain];
    for (int position = 0; position < this.longueurTerrain * this.largeurTerrain; position++) {
      this.placeTerrain[position] = new Place(position % this.largeurTerrain,
          position % this.longueurTerrain);

    }
    this.listeProie = new ArrayList<Proie>();

  }

  /**
   * Methode qui genere un depot aleatoirement.
   * 
   * @return Place du depot.
   */
  public Place genPlaceDepot() {
    int axeX = (int) (Math.random() * (this.longueurTerrain - 0));
    int axeY = (int) (Math.random() * (this.largeurTerrain - 0));
    System.out.println("pos :" + axeX + " : " + axeY);
    Place place = this.getPlace(axeX, axeY);
    return place;
  }

  /**
   * Methode qui cree la premiere Reine.
   * 
   * @param fourmiReine
   *          La premiere Reine.
   */
  public void premiereReine(Fourmi fourmiReine) {
    fourmiReine.setReine();
    this.setFourmiliere(fourmiReine.creeFourmiliere());
    ((Reine) ((Adulte) fourmiReine.getEtat()).getRole()).setFourmiliere(this.fourmiliere);
    this.fourmiliere.setDepotFourmiliere(new Depot(this.genPlaceDepot()));
    this.fourmiliere.ajouterFourmiNid(fourmiReine);
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
