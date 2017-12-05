package environnement;

import environnement.fourmiliere.Depot;
import java.util.ArrayList;
import java.util.List;

import mediateur.MediateurDeplacementChasse;
import mediateur.MediateurDeplacementProie;
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
    for (int positionX = 0; positionX < this.longueurTerrain; positionX++) {
      for (int positionY = 0; positionY < this.largeurTerrain; positionY++) {
        this.placeTerrain[positionX + (positionY * this.largeurTerrain)] = new Place(positionX,
            positionY);
      }
    }
    this.listeProie = new ArrayList<Proie>();

    // initialisation instance Mediateur
    MediateurDeplacementChasse.getInstance(this);
    MediateurDeplacementProie.getInstance(this);
  }

  /**
   * Methode qui genere un depot aleatoirement.
   * 
   * @return Place du depot.
   */
  public Place genPlace() {
    int axeX = (int) (Math.random() * (this.longueurTerrain - 0));
    int axeY = (int) (Math.random() * (this.largeurTerrain - 0));
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
    this.fourmiliere.setDepotFourmiliere(new Depot(this.genPlace()));
    this.fourmiliere.ajouterFourmiNid(fourmiReine);
  }

  public void genProie(int nombreProie) {
    for (int indice = 0; indice < nombreProie; indice++) {
      double poids = Math.random() * (200 - 2);
      Place placeProie = this.genPlace();
      this.listeProie.add(new Proie(placeProie, Math.floor(poids)));
    }
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
    return this.placeTerrain[posX + (posY * this.longueurTerrain)];
  }

  public int getNombreProie() {
    return this.listeProie.size();
  }

  public List<Proie> getListeProie() {
    return listeProie;
  }

  public void setListeProie(List<Proie> listeProie) {
    this.listeProie = listeProie;
  }

  public Place[] getPlaceTerrain() {
    return placeTerrain;
  }

  public void setPlaceTerrain(Place[] placeTerrain) {
    this.placeTerrain = placeTerrain;
  }

  public Place getPlaceNid() {
    return this.fourmiliere.getNidFourmiliere().getPlaceNid();
  }

  public List<Place> getPlaceProies() {
    List<Place> places = new ArrayList<Place>();
    for (Proie proie : this.listeProie) {
      places.add(proie.getPlaceProie());
    }
    return places;
  }

  public List<Place> getPlacesAdultes() {
    List<Place> places = new ArrayList<Place>();
    List<Fourmi> fourmis = this.fourmiliere.getNidFourmiliere().getListeFourmi();
    for (Fourmi fourmi : fourmis) {
      if (fourmi.isAdulte() && fourmi.getPlace().equals(this.fourmiliere.getPlaceFourmiliere())) {
        places.add(fourmi.getPlace());
      }
    }
    return places;
  }

}
