package environnement;

import java.util.List;

public class Terrain {
  private int largeurTerrain;
  private int longueurTerrain;
  private Fourmiliere fourmiliere;
  private Place[][] placeTerrain;
  //private List<Proie> listeProie;
  
  private Terrain(int largeurTerrain, int longueurTerrain) {
    this.largeurTerrain = largeurTerrain;
    this.longueurTerrain = longueurTerrain;
    this.placeTerrain = new Place[this.largeurTerrain][this.longueurTerrain];
    this.fourmiliere=new Fourmiliere();
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
  
  

}
