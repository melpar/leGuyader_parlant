package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JCanvas extends JPanel {

  private List drawables = new LinkedList();

  public void paint(Graphics g) {
    super.paint(g);
    for (Iterator iter = drawables.iterator(); iter.hasNext();) {
      IDrawable d = (IDrawable) iter.next();
      d.draw(g);
    }
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