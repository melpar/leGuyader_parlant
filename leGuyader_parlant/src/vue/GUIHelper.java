package vue;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import population.TempsObserver;
import report.ReportTemps;
import temps.Temps;

public class GUIHelper implements TempsObserver {
  private Label temps;
  private JFrame frame;
  private ReportTemps reportTemps;
  private Temps tempsCourantGUI;

  public void showOnFrame(JComponent component, String frameName, Temps tempsCourant) {
    this.frame = new JFrame(frameName);
    tempsCourant.addObserveur(this);
    WindowAdapter wa = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    this.tempsCourantGUI = tempsCourant;
    JPanel info = new JPanel();
    info.setLayout(new BorderLayout());
    this.reportTemps = new ReportTemps();
    this.reportTemps.traceTemps(tempsCourant);
    this.temps = new Label();
    this.temps.setText(this.reportTemps.toString());
    this.frame.addWindowListener(wa);
    this.frame.getContentPane().add(this.temps, BorderLayout.NORTH);
    this.frame.getContentPane().add(component, BorderLayout.CENTER);
    this.frame.pack();
    this.frame.setVisible(true);
    this.frame.setResizable(false);
  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub
    this.reportTemps.traceTemps(this.tempsCourantGUI);
    this.temps.setText(this.reportTemps.toString());
    this.frame.revalidate();
  }

}
