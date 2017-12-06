package mediateur;

import population.Fourmi;

/**
 * Fonctions n�cessaires au d�placement d'une fourmi.
 * 
 * @author parlanme
 *
 */
public interface MediateurDeplacement {

  public void deplacement();

  public void setFourmi(Fourmi uneFourmi);

  public Fourmi getFourmi();
}
