package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import environnement.Place;
import environnement.Terrain;

public class VuePrincipale {

  private Terrain terrain;
  private JCanvas jc;

  public VuePrincipale(Terrain terrain) {
    this.terrain = terrain;
  }

  public void affichage() {
    jc = new JCanvas();
    jc.setBackground(Color.WHITE);
    jc.setPreferredSize(new Dimension(terrain.getLargeurTerrain(), terrain.getLongueurTerrain()));

    GUIHelper.showOnFrame(jc, "test JCanvas with IDrawables");
  }

  public void miseAJour() {
    List<Place> placesAdultes = terrain.getPlacesAdultes();
    List<Place> placesProies = terrain.getPlaceProies();

    Place placeNid = terrain.getPlaceNid();

    for (Place place : placesAdultes) {
      Dimension dim = new Dimension(place.getX(), place.getY());
      IDrawable rect = new RectangleDrawable(Color.RED, new Point(1, 1), dim);
      jc.addDrawable(rect);
    }

    for (Place place : placesProies) {
      Dimension dim = new Dimension(3, 3);
      IDrawable rect = new RectangleDrawable(Color.BLUE, new Point(place.getX(), place.getY()),
          dim);
      jc.addDrawable(rect);
    }

    Dimension dim = new Dimension(10, 10);
    IDrawable rect = new RectangleDrawable(Color.BLACK, new Point(placeNid.getX(), placeNid.getY()),
        dim);
    jc.addDrawable(rect);
  }
}
