package vue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIHelper {

  public static void showOnFrame(JComponent component, String frameName) {
    JFrame frame = new JFrame(frameName);
    WindowAdapter wa = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };

    JPanel info = new JPanel();
    frame.addWindowListener(wa);
    frame.getContentPane().add(component);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }

}
