package temps;

public class Temps implements Runnable {
  private Duree tempsCourant;

  public Temps() {
    this.tempsCourant = new Duree();
  }

  @Override
  public void run() {
    while (this.tempsCourant.getAnnee() < 3) {
      try {
        Thread.sleep(100);
        this.tempsCourant.addJour(1);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
