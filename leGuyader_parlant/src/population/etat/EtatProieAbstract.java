package population.etat;

/**
 * Regroupe les fonctions nécessaires à la gestion des états des proies.
 * 
 * @author parlanme
 *
 */
public abstract class EtatProieAbstract {

  protected EtatsProies etatLibelle;

  public abstract void changeTemps();

  public EtatsProies getLibelle() {
    return this.etatLibelle;
  }

}
