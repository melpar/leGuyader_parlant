package population.etat;

/**
 * Lorsqu'une proie est morte, elle va être transférée du nid au dépot.
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
