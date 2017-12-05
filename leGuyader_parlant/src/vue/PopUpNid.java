package vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import population.CompteurObserver;
import population.Fourmi;
import report.CompteurFourmi;
import report.CompteurObservable;
import report.ReportObservable;

public class PopUpNid extends JFrame implements CompteurObserver {
  private List<Fourmi> listeFourmis;

  JPanel panelInfos;

  public PopUpNid(List<Fourmi> fourmis) {
    super();
    this.setSize(new Dimension(120, 120));
    this.setVisible(true);
    this.listeFourmis = fourmis;
    panelInfos = new JPanel();
    this.afficherInformationsNid();
    CompteurFourmi compteurFourmi = CompteurFourmi.getInstance();
    compteurFourmi.ajoutObserver(this);
    this.add(panelInfos);
  }

  private void afficherInformationsNid() {
    CompteurFourmi cpt = CompteurFourmi.getInstance();
    for (Fourmi uneFourmi : this.listeFourmis) {
      cpt.traceFourmi(uneFourmi);
    }
    this.remove(panelInfos);
    panelInfos = new JPanel();
    panelInfos.removeAll();
    panelInfos.setLayout(new GridLayout(4, 1));
    panelInfos.add(new JLabel("Oeufs : " + cpt.getCptOeuf()));
    panelInfos.add(new JLabel("Larve : " + cpt.getCptLarve()));
    panelInfos.add(new JLabel("Nymphe : " + cpt.getCptNymphe()));
    panelInfos.add(new JLabel("Adulte : " + cpt.getCptAdulte()));
    this.add(panelInfos);
    this.repaint();
    this.revalidate();
  }

  @Override
  public void agitSur(CompteurObservable report) {
    System.out.println(" sur");
    this.afficherInformationsNid();

  }
}
