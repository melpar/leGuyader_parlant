package test.vue;

import java.util.ArrayList;

import environnement.Fourmiliere;
import environnement.Place;
import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
import population.etat.EtatProieAbstract;
import population.etat.Etats;
import population.etat.ProieMorte;
import report.ReportTerrain;
import temps.Temps;
import vue.VuePrincipale;

public class VueTest {
  public static void main(String[] args) {
    Temps tempsCourant = new Temps();
    Terrain terrainTest = Terrain.getInstance(200, 200, tempsCourant);

    Fourmi fourmiReine = new Fourmi(true, terrainTest.getPlace(30, 45), tempsCourant);
    fourmiReine.setReine();
    terrainTest.premiereReine(fourmiReine);
    fourmiReine.pond();
    Nid nid = terrainTest.getFourmiliere().getNidFourmiliere();

    for (int i = 0; i < 500; i++) {
      Proie proie = new Proie(terrainTest.getFourmiliere().getPlaceFourmiliere(), 2);
      proie.setEtat(new ProieMorte());
      nid.ajouterProie(proie);

    }
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
