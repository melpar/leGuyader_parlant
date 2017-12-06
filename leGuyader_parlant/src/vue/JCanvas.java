package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JCanvas extends JPanel {

  private List<IDrawable> drawables = new LinkedList<IDrawable>();
  private List<IDrawable> drawablesModifies = new LinkedList<IDrawable>();

  /**
   * Permet de mettre a jour le canvas.
   */
  public void paint(Graphics g) {
    super.paint(g);
    try {
      for (int i = 0; i < drawables.size(); i++) {
        IDrawable d = drawables.get(i);
        d.draw(g);
      }
    } catch (java.lang.NullPointerException | java.lang.IndexOutOfBoundsException exc) {
    }
    // drawables = new LinkedList<IDrawable>();
  }

  public void addDrawable(IDrawable d) {
    drawables.add(d);
    repaint();
  }

  public void removeDrawable(IDrawable d) {
    drawables.remove(d);
    repaint();
  }

  public void clear() {
    drawables.clear();
    repaint();
  }

}