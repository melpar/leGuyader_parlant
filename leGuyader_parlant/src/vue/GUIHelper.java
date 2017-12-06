package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environnement.Terrain;
import population.Fourmi;
import population.Proie;
import population.TempsObserver;
import report.CompteurFourmi;
import report.ReportTemps;
import temps.Temps;

public class GUIHelper implements TempsObserver {
  private Label temps;
  private JFrame frame;
  private ReportTemps reportTemps;
  private Temps tempsCourantGui;
  private List<Fourmi> listeFourmis;
  private List<Proie> listeProie;
  private Terrain terrain;
  private JPanel InfosNid;
  private JLabel[] labelinformation;
  private CompteurFourmi cpt;

  public void showOnFrame(JComponent component, String frameName, Temps tempsCourant) {
    this.frame = new JFrame(frameName);
    tempsCourant.addObserveur(this);
    this.labelinformation = new JLabel[7];
    for (int indice = 0; indice < this.labelinformation.length; indice++) {
      this.labelinformation[indice] = new JLabel();
    }
    this.terrain = Terrain.getInstance();
    WindowAdapter wa = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    this.tempsCourantGui = tempsCourant;
    JPanel infosTemps = new JPanel();
    infosTemps.setLayout(new BorderLayout());
    this.InfosNid = new JPanel();

    this.reportTemps = new ReportTemps();
    this.reportTemps.traceTemps(tempsCourant);
    this.temps = new Label();
    this.temps.setText(this.reportTemps.toString());

    this.InfosNid.setLayout(new GridLayout(7, 1));
    this.actualiseCompteurNid();
    for (int indice = 0; indice < this.labelinformation.length; indice++) {
      this.InfosNid.add(this.labelinformation[indice]);
    }

    this.frame.addWindowListener(wa);
    this.frame.getContentPane().add(this.temps, BorderLayout.NORTH);
    this.frame.getContentPane().add(this.InfosNid, BorderLayout.WEST);
    this.frame.getContentPane().add(component, BorderLayout.CENTER);
    this.frame.pack();
    this.frame.setVisible(true);
    this.frame.setResizable(false);
  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub
    this.reportTemps.traceTemps(this.tempsCourantGui);
    this.temps.setText(this.reportTemps.toString());
    this.actualiseCompteurNid();
    this.frame.revalidate();
  }

  public void actualiseCompteurNid() {
    this.cpt = CompteurFourmi.getInstance();
    cpt.remiseAZero();
    this.listeFourmis = this.terrain.getFourmiliere().getNidFourmiliere().getListeFourmi();
    for (Fourmi uneFourmi : listeFourmis) {
      cpt.traceFourmi(uneFourmi);
    }
    this.listeProie = this.terrain.getFourmiliere().getNidFourmiliere().getListeProie();
    for (Proie uneProie : this.listeProie) {
      cpt.traceProie(uneProie);
    }
    this.labelinformation[0].setText("Info du nid        ");
    this.labelinformation[1].setText("Oeufs : " + cpt.getCptOeuf());
    this.labelinformation[2].setText("Larve : " + cpt.getCptLarve());
    this.labelinformation[3].setText("Nymphe : " + cpt.getCptNymphe());
    this.labelinformation[4].setText("Adulte : " + cpt.getCptAdulte());
    this.labelinformation[5].setText("Proies : " + cpt.getCptProie());
    this.labelinformation[6].setText("Cadavres : " + cpt.getcptCadavre());

  }

}
