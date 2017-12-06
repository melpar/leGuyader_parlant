package population;

import environnement.Place;
import environnement.Terrain;
import mediateur.MediateurCombat;
import mediateur.MediateurCombatAbstract;
import mediateur.MediateurDeplacementChasse;
import mediateur.MediateurDeplacementProie;
import population.etat.EtatProieAbstract;
import population.etat.EtatsProies;
import population.etat.ProieCapturee;
import population.etat.ProieVivante;
import population.role.RoleAbstract;
import report.ReportMouvementChasse;
import report.ReportMouvementProie;
import report.ReportPheromone;

/**
 * Permet de gérer les proies.
 * 
 * @author parlanme
 *
 */
public class Proie implements TempsObserver {
  private EtatProieAbstract etat;
  private double poids;
  private Place placeProie;
  private MediateurDeplacementProie mediateurProie;
  private MediateurCombatAbstract enCombat;
  private int attente;

  public Proie(Place place, double poids) {
    super();
    this.placeProie = place;
    this.poids = poids;
    this.etat = new ProieVivante();
    this.mediateurProie = new MediateurDeplacementProie(Terrain.getInstance());
    this.enCombat = null;
    this.attente = 0;
  }

  public EtatProieAbstract getEtat() {
    return etat;
  }

  public void setEtat(EtatProieAbstract etat) {
    this.etat = etat;
  }

  @Override
  public void agitSur() {

    this.etat.changeTemps();
    if (this.getEtat().getLibelle() == EtatsProies.VIVANTE) {
      this.deplace();
    } else {
      System.out.println("arrêté " + this.getEtat().getLibelle());
    }
  }

  /**
   * Permet de déplacer la fourmi associée.
   */
  public void deplace() {
    Place ancienne = this.placeProie;
    mediateurProie.setProie(this);
    mediateurProie.deplacement();
    ReportMouvementProie report = ReportMouvementProie.getInstance();
    report.traceMouvement(ancienne, this.placeProie);

  }

  public double getPoids() {
    return poids;
  }

  public void setPoids(double poids) {
    this.poids = poids;
  }

  public Place getPlaceProie() {
    return placeProie;
  }

  public void setPlaceProie(Place placeProie) {
    this.placeProie = placeProie;
  }

  public MediateurCombatAbstract isEnCombat() {
    return enCombat;
  }

  public void setEnCombat(MediateurCombatAbstract enCombat) {
    this.enCombat = enCombat;
  }

  public MediateurDeplacementProie getMediateurProie() {
    return mediateurProie;
  }

  public void setMediateurProie(MediateurDeplacementProie mediateurProie) {
    this.mediateurProie = mediateurProie;
  }

  public boolean getTempsAttenteCombat() {
    if (this.attente == 1) {
      this.attente--;
      return false;
    }
    return true;
  }

  public int getAttente() {
    return attente;
  }

  public void setAttente(int attente) {
    this.attente = attente;
  }

}
