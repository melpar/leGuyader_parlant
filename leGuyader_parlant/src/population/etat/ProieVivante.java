package population.etat;

import temps.Duree;

/**
 * Lorsqu'une proie est vivante, et pas capturée.
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
