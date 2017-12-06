package population.etat;

import java.util.List;

import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import population.Fourmi;
import population.Proie;
import temps.Duree;
import temps.Temps;

public class ProieStopee extends EtatProieAbstract {

  private final int nombeHeures = 10;
  private Duree dateFin;
  private Proie laProie;
  private Temps tempsCourant;

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
      // this.laProie.setMediateurProie(new
      // MediateurDeplacementProie(Terrain.getInstance()));

      MediateurCombatAbstract med = this.laProie.isEnCombat();
      med.setProie(null);

      List<Fourmi> fourmis = ((MediateurCombat) this.laProie.isEnCombat()).getFourmis();
      for (Fourmi cetteFourmi : fourmis) {
        cetteFourmi.setEnCombat(false);
      }
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
