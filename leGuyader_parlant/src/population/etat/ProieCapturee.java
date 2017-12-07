package population.etat;

import environnement.Terrain;
import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import mediateur.MediateurDeplacementProie;
import population.Proie;
import temps.Duree;
import temps.Temps;

/**
 * Lorsqu'une proie est captur�e par une fourmi. La fourmi la ram�ne au nid.
 * 
 * @author LeGuyader Parlant
 */
public class ProieCapturee extends EtatProieAbstract {

  private Duree dateMort;
  private final int DELAIS_MORT = 10;
  private Proie maProie;
  private Temps tempsCourant;

  /**
   * Permet de changer le type d'une proie en proie capturée (combat terminée,
   * ramenée au dépot).
   * 
   * @param tempsCourant
   *          temps permettant l'évolution à l'état mort
   * @param maProie
   *          proie associée
   */
  public ProieCapturee(Temps tempsCourant, Proie maProie) {
    this.etatLibelle = EtatsProies.CAPTURE;
    this.dateMort = new Duree(tempsCourant.getTempsCourant());
    this.dateMort.addJour(DELAIS_MORT);
    this.maProie = maProie;
    this.tempsCourant = tempsCourant;
  }

  @Override
  public void changeTemps() {
    if (this.tempsCourant.getTempsCourant().estSuperieur(this.dateMort)) {
      this.maProie.setEtat(new ProieMorte());
    }
  }

}
