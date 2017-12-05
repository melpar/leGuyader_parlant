package test.vue;

import java.util.ArrayList;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.Etats;
import report.ReportTerrain;
import temps.Temps;
import vue.VuePrincipale;

public class VueTest {
  public static void main(String[] args) {
    Terrain terrainTest = new Terrain(500, 500);
    Temps tempsCourant = new Temps();
    Fourmi fourmiReine = new Fourmi(true, terrainTest.getPlace(30, 45), tempsCourant);
    fourmiReine.setReine();
    terrainTest.premiereReine(fourmiReine);
    fourmiReine.pond();

    terrainTest.genProie(15);

    for (Proie proie : terrainTest.getListeProie()) {
      tempsCourant.addObserveur(proie);
    }
    // ReportTerrain reportTerrainTest = new ReportTerrain();
    // reportTerrainTest.traceTerrain(terrainTest);

    VuePrincipale vue = new VuePrincipale(terrainTest);
    vue.affichage();

    Thread th = new Thread(tempsCourant);
    th.start();
  }
}
