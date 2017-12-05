package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JCanvas extends JPanel {

  private List<IDrawable> drawables = new LinkedList<IDrawable>();
  Graphics g;
  // private List<IDrawable> drawablesModifies = new LinkedList<IDrawable>();

  public void paint(Graphics g) {
    super.paint(g);
    // for (Iterator<IDrawable> iter = drawables.iterator(); iter.hasNext();) {
    for (int i = 0; i < drawables.size(); i++) {
      IDrawable d = drawables.get(i);
      d.draw(g);
    }
    this.g = g;
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