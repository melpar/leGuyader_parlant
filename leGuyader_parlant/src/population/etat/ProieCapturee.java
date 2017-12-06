package population.etat;

import environnement.Terrain;
import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import mediateur.MediateurDeplacementProie;
import population.Proie;
import temps.Duree;
import temps.Temps;

/**
 * Lorsqu'une proie est capturée par une fourmi.
 * 
 * @author parlanme
 *
 */
public class ProieCapturee extends EtatProieAbstract {
  private final int nombeHeures = 3;
  private Duree dateFin;
  private Proie laProie;
  private Temps tempsCourant;

  public ProieCapturee(Temps tempsCourant, Proie uneProie) {
    this.dateFin = new Duree(tempsCourant.getTempsCourant());
    dateFin.addHeure(nombeHeures);
    this.laProie = uneProie;
    this.tempsCourant = tempsCourant;
    this.etatLibelle = EtatsProies.CAPTURE;
  }

  @Override
  public void changeTemps() {
    if (this.tempsCourant.getTempsCourant().estSuperieur(dateFin)) {
      System.out.println("je rebouge");
      this.laProie.setEtat(new ProieVivante());
      // this.laProie.setMediateurProie(new
      // MediateurDeplacementProie(Terrain.getInstance()));

      MediateurCombatAbstract med = this.laProie.isEnCombat();
      med.setProie(null);

      this.tempsCourant.removeObserveur((MediateurCombat) this.laProie.isEnCombat());
      this.laProie.setEnCombat(null);
      // this.laProie.setMediateurProie(new
      // MediateurDeplacementProie(Terrain.getInstance()));
      this.laProie.setAttente(1);
    }
  }

  public Duree getDateFin() {
    return dateFin;
  }

  public void setDateFin(Duree dateFin) {
    this.dateFin = dateFin;
  }
}
