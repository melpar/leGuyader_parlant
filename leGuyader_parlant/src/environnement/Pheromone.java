package environnement;

import temps.Duree;

public enum Pheromone {
  PHEROMONE_DEPOT("depot"), PHEROMONE_CHASSE("chasse");

  private static final int TEMPS_PHEROMONE_CHASSE = 5;
  private static final int TEMPS_PHEROMONE_DEPOT = 2;
  private Duree duree;

  private Pheromone(String type) {
    this.duree = new Duree();
    switch (type) {
      case "depot":
        this.duree.setHeure(TEMPS_PHEROMONE_DEPOT);
        break;
      case "chasse":
        this.duree.setHeure(TEMPS_PHEROMONE_CHASSE);
        break;
      default:
        System.out.println("Erreur");
        break;
    }
  }

}
