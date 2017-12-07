package population.etat;

/**
 * Regroupe les fonctions n�cessaires � la gestion des �tats des proies.
 * 
 * @author LeGuyader Parlant
 */
public abstract class EtatProieAbstract {

  protected EtatsProies etatLibelle;

  public abstract void changeTemps();

  public EtatsProies getLibelle() {
    return this.etatLibelle;
  }

}
