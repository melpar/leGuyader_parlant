package population.etat;

/**
 * Lorsqu'une proie est morte, elle va �tre transf�r�e du nid au d�pot.
 * 
 * @author LeGuyader Parlant
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
