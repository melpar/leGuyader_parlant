package population.etat;

import temps.Duree;

/**
 * Lorsqu'une proie est vivante, elle est libre de bouger aléatoirement.
 * 
 * @author parlanme
 *
 */
public class ProieVivante extends EtatProieAbstract {
  private Duree tempsAvantPartir;

  public ProieVivante() {
    this.etatLibelle = EtatsProies.VIVANTE;
  }

  @Override
  public void changeTemps() {
    // TODO Auto-generated method stub

  }

}
