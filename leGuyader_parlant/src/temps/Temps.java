package temps;

import java.util.ArrayList;
import java.util.List;

import population.TempsObserver;
import population.etat.EtatAbstract;

public class Temps implements Runnable {
  private Duree tempsCourant;
  private List<TempsObserver> observeurs;

  public Temps() {
    this.tempsCourant = new Duree();
    this.observeurs = new ArrayList<TempsObserver>();
  }

  public void addObserveur(TempsObserver observeur) {
    this.observeurs.add(observeur);
  }

  public void removeObserveur(TempsObserver observeur) {
    this.observeurs.remove(observeur);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(100);
        this.tempsCourant.addJour(1);
        this.applique();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void applique() {
    for (int i = 0; i < observeurs.size(); i++) {
      observeurs.get(i).agitSur();
    }

  }

  public Duree getTempsCourant() {
    return tempsCourant;
  }

  public void setTempsCourant(Duree tempsCourant) {
    this.tempsCourant = tempsCourant;
  }

  public void removeObserveur(EtatAbstract etat) {
    this.observeurs.remove(etat);
  }

}
