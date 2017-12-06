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
  private static Label temps;
  private static JFrame frame;
  private static ReportTemps reportTemps;

  public static void showOnFrame(JComponent component, String frameName, Temps tempsCourant) {
    frame = new JFrame(frameName);
    WindowAdapter wa = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    JPanel info = new JPanel();
    info.setLayout(new BorderLayout());
    reportTemps = new ReportTemps();
    reportTemps.traceTemps(tempsCourant);
    temps = new Label();
    temps.setText(reportTemps.toString());
    frame.addWindowListener(wa);
    frame.getContentPane().add(temps, BorderLayout.NORTH);
    frame.getContentPane().add(component, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }

  @Override
  public void agitSur() {
    // TODO Auto-generated method stub
    temps.setText(reportTemps.toString());
    frame.revalidate();
  }

}
