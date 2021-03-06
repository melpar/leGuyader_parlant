package environnement;

import environnement.fourmiliere.Depot;
import java.util.ArrayList;
import java.util.List;

import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import population.role.Reine;
import temps.Temps;

/**
 * Representation du terrain.
 * 
 * @author LeGuyader Parlant
 */
public class Terrain {
  private int largeurTerrain;
  private int longueurTerrain;
  private Fourmiliere fourmiliere;
  private Place[] placeTerrain;
  private List<Proie> listeProie;
  private static Terrain instanceTerrain;
  private static final int LARGEUR_MIN_TERRAIN = 5;
  private static final int LONGUEUR_MIN_TERRAIN = 5;
  private static final int DISTANCE_MAX_DEPOT = 50;

  public static Terrain getInstance() {
    return Terrain.instanceTerrain;
  }

  /**
   * Permet de retourner le terrain (singleton), en créé un si l'instance est à
   * null.
   * 
   * @param largeurTerrain
   *          largeur souhaitée
   * @param longueurTerrain
   *          longueur souhaitée
   * @param tempsCourant
   *          temps courant (pour les évènements)
   * @return instance du terrain
   */
  public static Terrain getInstance(int largeurTerrain, int longueurTerrain, Temps tempsCourant) {
    if (Terrain.instanceTerrain == null) {
      Terrain.instanceTerrain = new Terrain(largeurTerrain, longueurTerrain, tempsCourant);
    }
    return Terrain.instanceTerrain;
  }

  /**
   * Contructeur du terrain.
   * 
   * @param largeurTerrain
   *          Entier qui represente la largeur du terrain.
   * @param longueurTerrain
   *          Entier qui represente la longueur du terrain.
   */
  private Terrain(int largeurTerrain, int longueurTerrain, Temps tempsCourant) {
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
            positionY, tempsCourant);
      }
    }
    this.listeProie = new ArrayList<Proie>();

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
    this.fourmiliere.setDepotFourmiliere(this.genDepot(DISTANCE_MAX_DEPOT));
    this.fourmiliere.ajouterFourmiNid(fourmiReine);
  }

  /**
   * Permet de générer des proies, à poids variable.
   * 
   * @param nombreProie
   *          nombre de proies à créer.
   */
  public void genProie(int nombreProie) {
    for (int indice = 0; indice < nombreProie; indice++) {
      double poids = Math.random() * (50 - 2);
      Place placeProie = this.genPlace();
      this.listeProie.add(new Proie(placeProie, Math.floor(poids)));
    }
  }

  /**
   * Permet de générer un dépot à une distance donnée du nid.
   * 
   * @param distance
   *          distance entre le nid et le dépot
   * @return dépot créé
   */
  public Depot genDepot(int distance) {
    Place placeFourmiliere = this.fourmiliere.getPlaceFourmiliere();

    int maxX = (placeFourmiliere.getX() + distance);
    int minX = (placeFourmiliere.getX() - distance);
    int axeX = (int) (Math.random() * (maxX - minX)) + minX;

    int maxY = (placeFourmiliere.getY() + distance);
    int minY = (placeFourmiliere.getY() - distance);
    int axeY = (int) (Math.random() * (maxY - minY)) + minY;

    if (axeX < 0) {
      axeX = 0;
    }
    if (axeY < 0) {
      axeY = 0;
    }
    if (axeX > this.longueurTerrain - 1) {
      axeX = this.longueurTerrain;
    }
    if (axeY > this.largeurTerrain - 1) {
      axeY = this.largeurTerrain;
    }

    return new Depot(this.getPlace(axeX, axeY));
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
      posY = this.largeurTerrain - 1;
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

  /**
   * Permet de retourner la liste des places où se trouvent des proies.
   * 
   * @return liste de places
   */
  public List<Place> getPlaceProies() {
    List<Place> places = new ArrayList<Place>();
    for (Proie proie : this.listeProie) {
      places.add(proie.getPlaceProie());
    }
    return places;
  }

  /**
   * Permet de retourner la liste des places où se trouvent des fourmis adultes.
   * 
   * @return liste de places
   */
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

  public Place getPlaceDepot() {
    return this.fourmiliere.getDepotFourmiliere().getPlaceDepot();
  }

  /**
   * Obtenir la proie à une place.
   * 
   * @param nouvellePlace
   *          place a chercher
   * @return proie trouvée, null si n'existe pas
   */
  public Proie aProieALaPlace(Place nouvellePlace) {
    for (Proie uneProie : this.listeProie) {
      if (uneProie.getPlaceProie() == nouvellePlace) {
        return uneProie;
      }
    }
    return null;
  }

}
