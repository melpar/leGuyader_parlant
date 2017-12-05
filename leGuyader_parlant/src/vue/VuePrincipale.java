package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import environnement.Place;
import environnement.Terrain;
import population.ReportObserver;
import population.TempsObserver;
import report.ReportMouvementChasse;
import report.ReportObservable;

public class VuePrincipale implements ReportObserver {

  private Terrain terrain;
  private JCanvas jc;
  private ListenerNid listenerNid;

  private Map<Place, Integer> placesFourmi;
  private Map<Place, Integer> placesProie;

  public VuePrincipale(Terrain terrain) {
    this.terrain = terrain;
    listenerNid = new ListenerNid(this.terrain);
    this.placesFourmi = new HashMap<Place, Integer>();
    this.placesProie = new HashMap<Place, Integer>();
    ReportMouvementChasse report = ReportMouvementChasse.getInstance();
    report.addObserver(this);
  }

  public void affichage() {
    jc = new JCanvas();
    jc.setBackground(Color.WHITE);
    jc.setPreferredSize(new Dimension(terrain.getLargeurTerrain(), terrain.getLongueurTerrain()));
    jc.addMouseListener(listenerNid);
    GUIHelper.showOnFrame(jc, "Fourmilière");
    this.initialisation();
  }

  public void initialisation() {
    List<Place> placesAdultes = terrain.getPlacesAdultes();
    List<Place> placesProies = terrain.getPlaceProies();

    Place placeNid = terrain.getPlaceNid();
    this.listenerNid.setPlaceNid(placeNid);
    for (Place place : placesAdultes) {
      Dimension dim = new Dimension(10, 10);
      IDrawable rect = new RectangleDrawable(Color.RED, new Point(place.getX(), place.getY()), dim);
      jc.addDrawable(rect);
      ajoutePlace(this.placesFourmi, place);
    }

    for (Place place : placesProies) {
      Dimension dim = new Dimension(3, 3);
      IDrawable rect = new RectangleDrawable(Color.BLUE, new Point(place.getX(), place.getY()),
          dim);
      jc.addDrawable(rect);
      ajoutePlace(this.placesProie, place);
    }

    Dimension dim = new Dimension(10, 10);
    IDrawable rect = new RectangleDrawable(Color.BLACK, new Point(placeNid.getX(), placeNid.getY()),
        dim);

    jc.addDrawable(rect);
  }

  private void ajoutePlace(Map<Place, Integer> liste, Place place) {
    int value = 1;
    if (liste.containsKey(place)) {
      value = liste.get(place);
      value++;
    }
    liste.put(place, value);

  }

  @Override
  public void agitSur(ReportObservable report) {
    System.out.println("maj");
    this.miseAJour(report);

  }

  private void miseAJour(ReportObservable report) {
    if (report instanceof ReportMouvementChasse) {
      miseAJourChasse(report);
    }

  }

  private void miseAJourChasse(ReportObservable rep) {
    ReportMouvementChasse report = (ReportMouvementChasse) rep;
    Place ancienne = report.getAnciennePlace();
    Place nouvelle = report.getNouvellePlace();

    enleve(ancienne, this.placesFourmi);
    ajouteFourmiChasse(nouvelle);
  }

  private void ajouteFourmiChasse(Place place) {
    int value = 1;
    if (this.placesFourmi.containsKey(place)) {
      value = this.placesFourmi.get(place);
      value++;
    } else {
      Dimension dim = new Dimension(3, 3);
      IDrawable rect = new RectangleDrawable(Color.RED, new Point(place.getX(), place.getY()), dim);
      jc.addDrawable(rect);
    }
    this.placesFourmi.put(place, value);

  }

  private void enleve(Place place, Map<Place, Integer> liste) {
    if (liste.get(place) == 1) {
      liste.remove(place);
      Dimension dim = new Dimension(3, 3);
      IDrawable rect = new RectangleDrawable(Color.WHITE, new Point(place.getX(), place.getY()),
          dim);
      jc.addDrawable(rect);
    } else {
      liste.put(place, liste.get(place) - 1);
    }

  }

}
