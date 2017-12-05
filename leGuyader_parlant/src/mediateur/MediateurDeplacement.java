package mediateur;

import population.Fourmi;

public interface MediateurDeplacement {

  public void deplacement();

  public void setFourmi(Fourmi uneFourmi);

  public Fourmi getFourmi();
}
