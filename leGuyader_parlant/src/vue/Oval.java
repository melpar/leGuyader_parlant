package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends FormDrawable {

  public Oval(Color color, Point pos, Dimension dim) {
    super(color, pos, dim);

  }

  /**
   * Permet de dessiner un ovale.
   */
  public void draw(Graphics g) {
    Color c = g.getColor();
    g.setColor(color);
    g.fillOval(rect.x, rect.y, rect.height, rect.width);
    g.setColor(c);
  }

}