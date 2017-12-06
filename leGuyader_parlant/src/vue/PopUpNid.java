package vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import population.CompteurObserver;
import population.Fourmi;
import population.Proie;
import report.CompteurFourmi;
import report.CompteurObservable;
import report.ReportObservable;

public class PopUpNid extends JFrame implements CompteurObserver {
  private List<Fourmi> listeFourmis;
  private List<Proie> listeProie;

  JPanel panelInfos;

  public PopUpNid(List<Fourmi> fourmis, List<Proie> proies) {
    super();
    this.setSize(new Dimension(200, 200));
    this.setVisible(true);
    this.listeFourmis = fourmis;
    this.listeProie = proies;
    panelInfos = new JPanel();
    this.afficherInformationsNid();
    CompteurFourmi compteurFourmi = CompteurFourmi.getInstance();
    compteurFourmi.ajoutObserver(this);
    this.add(panelInfos);
  }

  private void afficherInformationsNid() {
    CompteurFourmi cpt = CompteurFourmi.getInstance();
    cpt.remiseAZero();
    for (Fourmi uneFourmi : this.listeFourmis) {
      cpt.traceFourmi(uneFourmi);
    }

    for (Proie uneProie : this.listeProie) {
      cpt.traceProie(uneProie);
    }

    this.remove(panelInfos);
    panelInfos = new JPanel();
    panelInfos.removeAll();
    panelInfos.setLayout(new GridLayout(5, 1));
    panelInfos.add(new JLabel("Oeufs : " + cpt.getCptOeuf()));
    panelInfos.add(new JLabel("Larve : " + cpt.getCptLarve()));
    panelInfos.add(new JLabel("Nymphe : " + cpt.getCptNymphe()));
    panelInfos.add(new JLabel("Adulte : " + cpt.getCptAdulte()));
    panelInfos.add(new JLabel("Cadavres de proies : " + cpt.getCptProieCadavre()));
    this.add(panelInfos);
    this.repaint();
    this.revalidate();
  }

  @Override
  public void agitSur(CompteurObservable report) {
    this.afficherInformationsNid();

  }

  public void setListeProie(List<Proie> listeProie) {
    this.listeProie = listeProie;
  }
}
