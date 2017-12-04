package environnement.fabrique;

import environnement.Fourmiliere;
import environnement.Place;

public class FabriqueFourmiliere {

  /**
   * lethode qui fabrique une fourmiliere
   * 
   * @param place
   *          Place de la nouvelle Fourmiliere.
   * @return la nouvelle fourmiliere.
   */
  public Fourmiliere creeFourmiliere(Place place) {
    Fourmiliere nouvelleFourmilere = new Fourmiliere(place);
    return nouvelleFourmilere;
  }
}
