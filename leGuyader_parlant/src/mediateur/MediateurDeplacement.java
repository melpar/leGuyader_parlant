package mediateur;

import population.Fourmi;

/**
 * Fonctions nécessaires au déplacement d'une fourmi.
 * 
 * @author parlanme
 *
 */
public interface MediateurDeplacement {

  public void deplacement();

  public void setFourmi(Fourmi uneFourmi);

  public Fourmi getFourmi();
}
