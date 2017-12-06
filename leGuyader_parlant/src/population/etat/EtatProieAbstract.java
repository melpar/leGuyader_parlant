package population.etat;

public abstract class EtatProieAbstract {

  protected EtatsProies etatLibelle;

  public abstract void changeTemps();

  public EtatsProies getLibelle() {
    return this.etatLibelle;
  }

}
