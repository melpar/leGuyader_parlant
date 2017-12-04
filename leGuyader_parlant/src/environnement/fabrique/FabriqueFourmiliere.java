package environnement.fabrique;

import environnement.Fourmiliere;
import environnement.Place;

public class FabriqueFourmiliere {

  public Fourmiliere creeFourmiliere(Place place) {
    Fourmiliere nouvelleFourmilere = new Fourmiliere(place);
    return nouvelleFourmilere;

  }
}
