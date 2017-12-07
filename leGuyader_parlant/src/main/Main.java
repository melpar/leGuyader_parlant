package main;

import environnement.Terrain;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.Adulte;
import population.role.Reine;
import temps.Temps;
import vue.VuePrincipale;

public class Main {
  /**
   * Lance l'application.
   * 
   * @param args
   *          arguments (rien à renseigner)
   */
  public static void main(String[] args) {
    Temps tempsCourant = new Temps();
    Terrain terrainTest = Terrain.getInstance(200, 200, tempsCourant);

    Fourmi fourmiReine = new Fourmi(true, terrainTest.getPlace(30, 45), tempsCourant);
    fourmiReine.setReine();
    terrainTest.premiereReine(fourmiReine);
    fourmiReine.pond();
    tempsCourant.addObserveur((Reine) ((Adulte) fourmiReine.getEtat()).getRole());
    Nid nid = terrainTest.getFourmiliere().getNidFourmiliere();

    terrainTest.genProie(100);

    for (Proie proie : terrainTest.getListeProie()) {
      tempsCourant.addObserveur(proie);
    }

    VuePrincipale vue = new VuePrincipale(terrainTest, tempsCourant);
    vue.affichage();

    Thread th = new Thread(tempsCourant);
    th.start();
  }
}
