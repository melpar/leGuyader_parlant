package test.environnement;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import environnement.Fourmiliere;
import environnement.Terrain;

public class EnvironnementTest {

  private Terrain terrainTest;

  @Before
  public void initTest() {
    this.terrainTest = new Terrain(500, 500);
  }

  @Test
  public void testCreationTerrain() {
    assertTrue(this.terrainTest != null);
    assertTrue(this.terrainTest.getLargeurTerrain() == 500);
    assertTrue(this.terrainTest.getLongueurTerrain() == 500);
    Fourmiliere fourmiliereTest = this.terrainTest.getFourmiliere();
    assertTrue(fourmiliereTest != null);
    assertTrue(this.terrainTest.getNombrePlace() == 250000);
  }

}
