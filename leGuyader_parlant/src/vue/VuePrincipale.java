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

  public void affichage() {
    jc = new JCanvas();
    jc.setBackground(Color.WHITE);
    jc.setPreferredSize(new Dimension(400, 200));
    Dimension dim = new Dimension(20, 20);

    jc.addDrawable(rect);
    GUIHelper.showOnFrame(jc, "test JCanvas with IDrawables");
  }

  public void miseAJour() {
    List<Place> placesAdultes = terrain.getPlacesAdultes();
    List<Place> placesProies = terrain.getPlaceProies();

    Place fourmilière = terrain.getPlaceNid();

    for (Place place : placesAdultes) {
      IDrawable rect = new RectangleDrawable(Color.RED, new Point(10, 10), dim);
      jc.addDrawable(d);
    }
  }
}
