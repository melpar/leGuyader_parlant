package population.etat;

/**
 * Lorsqu'une proie est vivante, elle est libre de bouger al�atoirement.
 * 
 * @author LeGuyader Parlant
 */
public class ProieVivante extends EtatProieAbstract {

  public ProieVivante() {
    this.etatLibelle = EtatsProies.VIVANTE;
  }

  @Override
  public void changeTemps() {
    // TODO Auto-generated method stub

  }

}
