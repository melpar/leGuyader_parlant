package test.vue;

import java.util.ArrayList;

import environnement.Fourmiliere;
import environnement.Terrain;
import environnement.fourmiliere.Nid;
import population.Fourmi;
import population.Proie;
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
    Fourmiliere fourmiliereTest = terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();
    terrainTest.genProie(15);
    for (int i = 0; i < 30; i++) {
      listeFourmi
          .add(new Fourmi(true, terrainTest.getFourmiliere().getPlaceFourmiliere(), tempsCourant));
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterFourmi(listeFourmi.get(i));
    }

    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    // for (int i = 0; i < 30; i++) {
    // listeProie.add(new Proie(nidFourmiliere.getPlaceNid(), 2.4));
    // }
    // for (int i = 0; i < 30; i++) {
    // nidFourmiliere.ajouterProie(listeProie.get(i));
    // }

    ReportTerrain reportTerrainTest = new ReportTerrain();
    reportTerrainTest.traceTerrain(terrainTest);
    System.out.println(reportTerrainTest.toString());

    VuePrincipale vue = new VuePrincipale(terrainTest);
    vue.affichage();
    vue.miseAJour();
  }
}
