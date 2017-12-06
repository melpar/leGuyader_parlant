package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import environnement.Pheromone;
import environnement.Place;
import environnement.Terrain;
import population.ReportObserver;
import population.TempsObserver;
import report.ReportMouvementChasse;
import report.ReportMouvementDepot;
import report.ReportMouvementProie;
import report.ReportObservable;
import report.ReportPheromone;
import temps.Temps;

public class VuePrincipale implements ReportObserver {

  public static final int TAILLE_CARRE_NID_DEPOT = 10;
  public static final int TAILLE_CARRE_PROIE_FOURMI = 3;
  public static final int COEFFICIENT = 4;
  public static final int TAILLE_INFORMATION = 20;
  private Terrain terrain;
  private JCanvas jc;
  private ListenerNid listenerNid;

  private Map<Place, IDrawable> casesFourmis;
  private Map<Place, IDrawable> casesProies;
  private Map<Place, IDrawable> casesPheromone;
  private Map<Place, Integer> placesFourmi;
  private Map<Place, Integer> placesProie;
  private Map<Place, Pheromone> placesPheromone;
  private Temps tempsCourant;

  public VuePrincipale(Terrain terrain, Temps tempscourant) {
    this.terrain = terrain;
    this.tempsCourant = tempscourant;
    listenerNid = new ListenerNid(this.terrain);
    this.placesPheromone = new HashMap<Place, Pheromone>();
    this.placesFourmi = new HashMap<Place, Integer>();
    this.placesProie = new HashMap<Place, Integer>();
    this.casesFourmis = new HashMap<Place, IDrawable>();
    this.casesProies = new HashMap<Place, IDrawable>();
    this.casesPheromone = new HashMap<Place, IDrawable>();
    ReportMouvementChasse report = ReportMouvementChasse.getInstance();
    report.addObserver(this);
    ReportMouvementDepot reportDepot = ReportMouvementDepot.getInstance();
    reportDepot.addObserver(this);
    ReportMouvementProie reportProie = ReportMouvementProie.getInstance();
    reportProie.addObserver(this);
    ReportPheromone reportPheromone = ReportPheromone.getInstance();
    reportPheromone.addObserver(this);
  }

  public void affichage() {
    jc = new JCanvas();
    jc.setBackground(Color.WHITE);
    jc.setPreferredSize(new Dimension((terrain.getLargeurTerrain() * COEFFICIENT),
        terrain.getLongueurTerrain() * COEFFICIENT));
    jc.addMouseListener(listenerNid);
    GUIHelper vue = new GUIHelper();
    vue.showOnFrame(jc, "Fourmilière", this.tempsCourant);

    this.initialisation();
  }

  public void initialisation() {
    List<Place> placesAdultes = terrain.getPlacesAdultes();
    List<Place> placesProies = terrain.getPlaceProies();

    Place placeNid = terrain.getPlaceNid();
    this.listenerNid.setPlaceNid(placeNid);
    Dimension dim = new Dimension(TAILLE_CARRE_NID_DEPOT * COEFFICIENT,
        TAILLE_CARRE_NID_DEPOT * COEFFICIENT);

    IDrawable rect = new RectangleDrawable(Color.BLACK,
        new Point(placeNid.getX() * COEFFICIENT, placeNid.getY() * COEFFICIENT), dim);
    jc.addDrawable(rect);
    jc.setRectNid(rect);

    Place placeDepot = terrain.getPlaceDepot();
    IDrawable rectDepot = new RectangleDrawable(Color.ORANGE,
        new Point(placeDepot.getX() * COEFFICIENT, placeDepot.getY() * COEFFICIENT), dim);
    jc.addDrawable(rectDepot);
    jc.setRectDepot(rectDepot);

    for (Place place : placesProies) {
      Dimension dimP = new Dimension(TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT,
          TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT);
      IDrawable rectP = new RectangleDrawable(Color.BLUE,
          new Point(place.getX() * COEFFICIENT, place.getY() * COEFFICIENT), dimP);
      jc.addDrawable(rectP);
      casesProies.put(place, rectP);
      ajoutePlace(this.placesProie, place);
    }
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
    this.miseAJour(report);

  }

  private void miseAJour(ReportObservable report) {
    if (report instanceof ReportMouvementChasse) {
      miseAJourChasse(report);
    } else if (report instanceof ReportMouvementDepot) {
      miseAJourDepot(report);
    } else if (report instanceof ReportMouvementProie) {
      miseAJourProie(report);
    } else if (report instanceof ReportPheromone) {

      miseAJourPheromone(report);
    }

  }

  /**
   * Permet de mettre à jour la vue.
   * 
   * @param place
   *          place à modifier
   */
  private void miseAJour(Place place) {
    if (!this.placesPheromone.containsKey(place)) {
      Pheromone value = place.getListePheromone().get(place.getListePheromone().size() - 1);
      Dimension dim = new Dimension(TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT,
          TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT);
      IDrawable rect = new RectangleDrawable(Color.GREEN,
          new Point(place.getX() * COEFFICIENT, place.getY() * COEFFICIENT), dim);
      jc.addDrawable(rect);
      casesPheromone.put(place, rect);

      this.placesPheromone.put(place, value);
    }
  }

  private void miseAJourProie(ReportObservable rep) {
    ReportMouvementProie report = (ReportMouvementProie) rep;
    Place ancienne = report.getAnciennePlace();
    Place nouvelle = report.getNouvellePlace();

    enleveProie(ancienne);
    ajouteProie(nouvelle);
  }

  private void miseAJourChasse(ReportObservable rep) {
    ReportMouvementChasse report = (ReportMouvementChasse) rep;
    Place ancienne = report.getAnciennePlace();
    Place nouvelle = report.getNouvellePlace();

    enleveFourmi(ancienne, true);
    ajouteFourmi(nouvelle, true);
  }

  private void miseAJourDepot(ReportObservable rep) {
    ReportMouvementDepot report = (ReportMouvementDepot) rep;
    Place ancienne = report.getAnciennePlace();
    Place nouvelle = report.getNouvellePlace();

    enleveFourmi(ancienne, false);
    ajouteFourmi(nouvelle, false);
  }

  private void miseAJourPheromone(ReportObservable rep) {
    ReportPheromone report = (ReportPheromone) rep;
    Place place = report.getPlace();

    if (place.getListePheromone().size() == 0) {
      this.enleverPheromone(place);
    } else {
      this.miseAJour(place);
    }
  }

  private void enleverPheromone(Place place) {
    if (this.placesPheromone.get(place) != null) {

      this.placesPheromone.remove(place);
      jc.removeDrawable(casesPheromone.get(place));
    }
  }

  private void ajouteFourmi(Place place, boolean isChasse) {
    int value = 1;
    if (this.placesFourmi.containsKey(place)) {
      value = this.placesFourmi.get(place);
      value++;
      System.out.println("sur la cas : " + value);
    } else {
      Dimension dim = new Dimension(TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT,
          TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT);
      Color color = Color.RED;
      if (!isChasse) {
        color = Color.PINK;
      }
      IDrawable rect = new RectangleDrawable(color,
          new Point(place.getX() * COEFFICIENT, place.getY() * COEFFICIENT), dim);
      jc.addDrawable(rect);
      casesFourmis.put(place, rect);
    }
    this.placesFourmi.put(place, value);

  }

  private void enleveFourmi(Place place, boolean isChasse) {
    if (this.placesFourmi.get(place) != null) {
      if (this.placesFourmi.get(place) == 1) {
        this.placesFourmi.remove(place);
        jc.removeDrawable(casesFourmis.get(place));
      } else {
        this.placesFourmi.put(place, this.placesFourmi.get(place) - 1);
      }
    }

  }

  private void ajouteProie(Place place) {
    int value = 1;
    if (this.placesProie.containsKey(place)) {
      value = this.placesProie.get(place);
      value++;
    } else {

      Dimension dim = new Dimension(TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT,
          TAILLE_CARRE_PROIE_FOURMI * COEFFICIENT);
      IDrawable rect = new RectangleDrawable(Color.BLUE,
          new Point(place.getX() * COEFFICIENT, place.getY() * COEFFICIENT), dim);
      jc.addDrawable(rect);
      casesProies.put(place, rect);
    }
    this.placesProie.put(place, value);

  }

  private void enleveProie(Place place) {
    if (this.placesProie.get(place) != null) {
      if (placesProie.get(place) == 1) {
        placesProie.remove(place);
        jc.removeDrawable(casesProies.get(place));
      } else {
        placesProie.put(place, placesProie.get(place) - 1);
      }
    }

  }

}
