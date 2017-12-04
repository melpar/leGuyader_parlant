package test.environnement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import environnement.Fourmiliere;

import environnement.Terrain;
import environnement.fourmiliere.Depot;
import environnement.fourmiliere.Nid;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import population.Fourmi;
import population.Proie;
import report.ReportFourmiliere;
import temps.Temps;

public class EnvironnementTest {

  private Terrain terrainTest;
  private Fourmi fourmiReine;

  @Before
  public void initTest() {
    this.terrainTest = new Terrain(500, 500);
    Temps tempsCourant = new Temps();
    this.fourmiReine = new Fourmi(true, this.terrainTest.getPlace(30, 45), tempsCourant);
    this.fourmiReine.setReine();
    this.terrainTest.premiereReine(fourmiReine);
  }

  @Test
  public void testCreationTerrain() {
    assertTrue(this.terrainTest != null);
    assertTrue(this.terrainTest.getLargeurTerrain() == 500);
    assertTrue(this.terrainTest.getLongueurTerrain() == 500);
    assertTrue(this.terrainTest.getNombrePlace() == 250000);
  }

  @Test
  public void testAjoutProieTerrain() {
    assertTrue(this.terrainTest.getNombreProie() == 0);
    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 30; i++) {
      this.terrainTest.ajouterProie(listeProie.get(i));
    }
    assertTrue(this.terrainTest.getNombreProie() == 30);
  }

  @Test
  public void testSupprimerProieTerrain() {
    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 30; i++) {
      this.terrainTest.ajouterProie(listeProie.get(i));
    }

    for (int i = 0; i < 10; i++) {
      assertTrue(this.terrainTest.supprimerProie(listeProie.get(i + 10)));
    }

    assertTrue(this.terrainTest.getNombreProie() == 20);
    for (int i = 10; i < 20; i++) {
      assertFalse(this.terrainTest.supprimerProie(listeProie.get(i)));
    }

  }

  @Test
  public void testCreationFourmiliere() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    assertTrue(fourmiliereTest != null);
  }

  @Test
  public void testCreationNid() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    assertTrue(nidFourmiliere != null);
    assertTrue(nidFourmiliere.getNombreFourmi() == 1);
    assertTrue(nidFourmiliere.getNombreProie() == 0);
  }

  @Test
  public void testCreationDepot() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Depot depotFourmiliere = fourmiliereTest.getDepotFourmiliere();
    assertTrue(depotFourmiliere != null);
    assertTrue(depotFourmiliere.getNombreCadavreFourmi() == 0);
    assertTrue(depotFourmiliere.getNombreCadavreProie() == 0);
  }

  @Test
  public void testAjoutFourmiNid() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();

    Temps tempsCourant = new Temps();
    for (int i = 0; i < 30; i++) {
      listeFourmi.add(new Fourmi(true, this.terrainTest.getPlace(i, i), tempsCourant));
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterFourmi(listeFourmi.get(i));
    }
    assertTrue(nidFourmiliere.getNombreFourmi() == 31);
  }

  @Test
  public void testSupprimerFourmiNid() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();

    Temps tempsCourant = new Temps();
    for (int i = 0; i < 30; i++) {
      listeFourmi.add(new Fourmi(true, this.terrainTest.getPlace(i, i), tempsCourant));
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterFourmi(listeFourmi.get(i));
    }

    for (int i = 0; i < 10; i++) {
      assertTrue(nidFourmiliere.supprimerFourmi(listeFourmi.get(i + 10)));
    }
    assertTrue(nidFourmiliere.getNombreFourmi() == 21);

    for (int i = 10; i < 20; i++) {
      assertFalse(nidFourmiliere.supprimerFourmi(listeFourmi.get(i)));
    }

  }

  @Test
  public void testAjoutProieNid() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    assertTrue(nidFourmiliere.getNombreProie() == 0);
    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterProie(listeProie.get(i));
    }
    assertTrue(nidFourmiliere.getNombreProie() == 30);
  }

  @Test
  public void testSupprimerProieNid() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterProie(listeProie.get(i));
    }

    for (int i = 0; i < 10; i++) {
      assertTrue(nidFourmiliere.supprimerProie(listeProie.get(i + 10)));
    }
    assertTrue(nidFourmiliere.getNombreProie() == 20);

    for (int i = 10; i < 20; i++) {
      assertFalse(nidFourmiliere.supprimerProie(listeProie.get(i)));
    }
  }

  @Test
  public void testAjoutDepot() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Depot depotFourmiliere = fourmiliereTest.getDepotFourmiliere();
    assertTrue(depotFourmiliere.getNombreCadavreProie() == 0);
    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 15; i++) {
      depotFourmiliere.ajouterCadavreProie(listeProie.get(i));
    }
    assertTrue(depotFourmiliere.getNombreCadavreProie() == 15);

    ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();
    Temps tempsCourant = new Temps();
    for (int i = 0; i < 30; i++) {
      listeFourmi.add(new Fourmi(true, this.terrainTest.getPlace(i, i), tempsCourant));
    }
    for (int i = 0; i < 27; i++) {
      depotFourmiliere.ajouterCadavreFourmi(listeFourmi.get(i));
    }
    assertTrue(depotFourmiliere.getNombreCadavreFourmi() == 27);
    assertTrue(depotFourmiliere.getNombreCadavre() == 42);
  }

  @Test
  public void testReportTerrain() {
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    Nid nidFourmiliere = fourmiliereTest.getNidFourmiliere();
    ArrayList<Fourmi> listeFourmi = new ArrayList<Fourmi>();

    Temps tempsCourant = new Temps();
    for (int i = 0; i < 30; i++) {
      listeFourmi.add(
          new Fourmi(true, this.terrainTest.getFourmiliere().getPlaceFourmiliere(), tempsCourant));
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterFourmi(listeFourmi.get(i));
    }

    ArrayList<Proie> listeProie = new ArrayList<Proie>();

    for (int i = 0; i < 30; i++) {
      listeProie.add(new Proie());
    }
    for (int i = 0; i < 30; i++) {
      nidFourmiliere.ajouterProie(listeProie.get(i));
    }

    ReportFourmiliere report = new ReportFourmiliere();
    report.traceFourmiliere(this.terrainTest.getFourmiliere());
    System.out.println(report.toString());
  }

}
