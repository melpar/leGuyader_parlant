package vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import population.Fourmi;
import report.CompteurFourmi;

public class PopUpNid extends JFrame {
  private List<Fourmi> listeFourmis;

  public PopUpNid(List<Fourmi> fourmis) {
    super();
    this.setSize(new Dimension(120, 120));
    this.setVisible(true);
    this.listeFourmis = fourmis;
    this.afficherInformationsNid();
  }

  private void afficherInformationsNid() {
    CompteurFourmi cpt = new CompteurFourmi();
    for (Fourmi uneFourmi : this.listeFourmis) {
      cpt.traceFourmi(uneFourmi);
    }
    JPanel panelInfos = new JPanel();
    panelInfos.setLayout(new GridLayout(4, 1));
    panelInfos.add(new JLabel("Oeufs : " + cpt.getCptOeuf()));
    panelInfos.add(new JLabel("Larve : " + cpt.getCptLarve()));
    panelInfos.add(new JLabel("Nymphe : " + cpt.getCptNymphe()));
    panelInfos.add(new JLabel("Adulte : " + cpt.getCptAdulte()));
    this.add(panelInfos);
  }
}
