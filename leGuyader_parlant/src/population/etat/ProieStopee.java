package population.etat;

import java.util.List;

import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import population.Fourmi;
import population.Proie;
import temps.Duree;
import temps.Temps;

/**
 * Lorsqu'une proie est stopp�e par une ou plusieurs fourmi(s). Dans cet �tat,
 * le combat est en cours.
 * 
 * @author LeGuyader Parlant
 */
public class ProieStopee extends EtatProieAbstract {

  private final int nombeHeures = 10;
  private Duree dateFin;
  private Proie laProie;
  private Temps tempsCourant;

  /**
   * Permet de passer l'état de proie à stopper (combat commencé mais la fourmi
   * n'a pas prit le dessus).
   * 
   * @param tempsCourant
   *          temps permettant l'évolution
   * @param uneProie
   *          proie associée
   */
  public ProieStopee(Temps tempsCourant, Proie uneProie) {
    this.dateFin = new Duree(tempsCourant.getTempsCourant());
    dateFin.addHeure(nombeHeures);
    this.laProie = uneProie;
    this.tempsCourant = tempsCourant;
    this.etatLibelle = EtatsProies.STOPEE;
  }

  @Override
  public void changeTemps() {
    if (this.laProie.isEnCombat() instanceof MediateurCombat
        && this.tempsCourant.getTempsCourant().estSuperieur(dateFin)) {
      this.laProie.setEtat(new ProieVivante());

      MediateurCombatAbstract med = this.laProie.isEnCombat();
      med.setProie(null);

      List<Fourmi> fourmis = ((MediateurCombat) this.laProie.isEnCombat()).getFourmis();
      for (Fourmi cetteFourmi : fourmis) {
        cetteFourmi.setEnCombat(false);
      }
      this.tempsCourant.removeObserveur((MediateurCombat) this.laProie.isEnCombat());
      this.laProie.setEnCombat(null);
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
