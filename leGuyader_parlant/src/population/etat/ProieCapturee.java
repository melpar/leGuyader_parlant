package population.etat;

import environnement.Terrain;
import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import mediateur.MediateurDeplacementProie;
import population.Proie;
import temps.Duree;
import temps.Temps;

/**
 * Lorsqu'une proie est capturée par une fourmi. La fourmi la ramène au nid.
 * 
 * @author parlanme
 *
 */
public class ProieCapturee extends EtatProieAbstract {

  private Duree dateMort;
  private final int DELAIS_MORT = 10;
  private Proie maProie;
  private Temps tempsCourant;

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
