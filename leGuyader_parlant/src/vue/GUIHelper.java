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
import report.CompteurDepot;
import report.CompteurNid;
import report.ReportTemps;
import temps.Temps;

public class GUIHelper implements TempsObserver {
  private Label temps;
  private JFrame frame;
  private ReportTemps reportTemps;
  private Temps tempsCourantGui;
  private List<Fourmi> listeFourmisNid;
  private List<Proie> listeProieNid;
  private List<Fourmi> listeFourmisDepot;
  private List<Proie> listeProieDepot;
  private Terrain terrain;
  private JPanel infosNid;
  private JPanel infosDepot;
  private JLabel[] labelinformationNid;
  private JLabel[] labelinformationDepot;
  private CompteurNid cptNid;
  private CompteurDepot cptDepot;

  public void showOnFrame(JComponent component, String frameName, Temps tempsCourant) {
    this.frame = new JFrame(frameName);
    tempsCourant.addObserveur(this);
    this.labelinformationNid = new JLabel[7];
    for (int indice = 0; indice < this.labelinformationNid.length; indice++) {
      this.labelinformationNid[indice] = new JLabel();
    }

    this.labelinformationDepot = new JLabel[3];
    for (int indice = 0; indice < this.labelinformationDepot.length; indice++) {
      this.labelinformationDepot[indice] = new JLabel();
    }

    this.terrain = Terrain.getInstance();
    this.tempsCourantGui = tempsCourant;

    JPanel infosTemps = new JPanel();
    infosTemps.setLayout(new BorderLayout());

    this.reportTemps = new ReportTemps();
    this.reportTemps.traceTemps(tempsCourant);
    this.temps = new Label();
    this.temps.setText(this.reportTemps.toString());

    this.infosNid = new JPanel();
    this.infosNid.setLayout(new GridLayout(7, 1));
    this.actualiseCompteurNid();
    for (int indice = 0; indice < this.labelinformationNid.length; indice++) {
      this.infosNid.add(this.labelinformationNid[indice]);
    }

    this.infosDepot = new JPanel();
    this.infosDepot.setLayout(new GridLayout(3, 1));
    this.actualiseCompteurDepot();
    for (int indice = 0; indice < this.labelinformationDepot.length; indice++) {
      this.infosDepot.add(this.labelinformationDepot[indice]);
    }

    WindowAdapter winAdpt = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };

    this.frame.addWindowListener(winAdpt);
    this.frame.getContentPane().add(this.temps, BorderLayout.NORTH);
    this.frame.getContentPane().add(this.infosNid, BorderLayout.WEST);
    this.frame.getContentPane().add(component, BorderLayout.CENTER);
    this.frame.getContentPane().add(this.infosDepot, BorderLayout.EAST);
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
    this.actualiseCompteurDepot();
    this.frame.revalidate();
  }

  public void actualiseCompteurNid() {
    this.cptNid = CompteurNid.getInstance();
    cptNid.remiseAZero();
    this.listeFourmisNid = this.terrain.getFourmiliere().getNidFourmiliere().getListeFourmi();
    for (Fourmi uneFourmi : listeFourmisNid) {
      cptNid.traceFourmi(uneFourmi);
    }
    this.listeProieNid = this.terrain.getFourmiliere().getNidFourmiliere().getListeProie();
    for (Proie uneProie : this.listeProieNid) {
      cptNid.traceProie(uneProie);
    }
    this.labelinformationNid[0].setText("Info du nid        ");
    this.labelinformationNid[1].setText("Oeufs : " + cptNid.getCptOeuf());
    this.labelinformationNid[2].setText("Larve : " + cptNid.getCptLarve());
    this.labelinformationNid[3].setText("Nymphe : " + cptNid.getCptNymphe());
    this.labelinformationNid[4].setText("Adulte : " + cptNid.getCptAdulte());
    this.labelinformationNid[5].setText("Proies : " + cptNid.getCptProie());
    this.labelinformationNid[6].setText("Cadavres : " + cptNid.getcptCadavre());

  }

  public void actualiseCompteurDepot() {
    this.cptDepot = CompteurDepot.getInstance();
    cptDepot.remiseAZero();

    this.listeFourmisDepot = this.terrain.getFourmiliere().getDepotFourmiliere()
        .getListeCadavreFourmi();
    for (Fourmi uneFourmi : listeFourmisDepot) {
      cptDepot.traceFourmi(uneFourmi);
    }
    this.listeProieDepot = this.terrain.getFourmiliere().getDepotFourmiliere()
        .getListeCadavreProie();
    for (Proie uneProie : this.listeProieDepot) {
      cptDepot.traceProie(uneProie);
    }
    this.labelinformationDepot[0].setText("Info du Depot     ");
    this.labelinformationDepot[1].setText("Cadavre Fourmis : " + cptDepot.getCptCadavreFourmi());
    this.labelinformationDepot[2].setText("Cadavre Proie : " + cptDepot.getCptCadavreProie());

  }

}
