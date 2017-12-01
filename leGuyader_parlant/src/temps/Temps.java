package temps;

import java.util.List;

import population.TempsObserver;

public class Temps implements Runnable {
  private Duree tempsCourant;
  private List<TempsObserver> observeurs;

  public Temps() {
    this.tempsCourant = new Duree();
  }

  @Override
  public void run() {
    while (this.tempsCourant.getAnnee() < 3) {
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
    for (TempsObserver observeur : observeurs) {
      observeur.agitSur();
    }

  }

}
