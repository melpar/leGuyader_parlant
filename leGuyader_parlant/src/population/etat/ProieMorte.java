package population.etat;

/**
 * Lorsqu'une proie est morte.
 * 
 * @author parlanme
 *
 */
public class ProieMorte extends EtatProieAbstract {

  public ProieMorte() {
    this.etatLibelle = EtatsProies.CADAVRE;
  }

  @Override
  public void changeTemps() {
    // TODO Auto-generated method stub
  }

}
