package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class FormDrawable implements IMovableDrawable {

  protected Rectangle rect;
  protected Color color;

  /**
   * Permet de créer une fourme dessinable.
   * 
   * @param color
   *          couleur de la fourme.
   * @param pos
   *          position.
   * @param dim
   *          dimension.
   */
  public FormDrawable(Color color, Point pos, Dimension dim) {
    this.color = color;
    this.rect = new Rectangle(dim);
    setPosition(pos);

  }

  public abstract void draw(Graphics g);

  public Rectangle getRectangle() {
    return (Rectangle) rect.clone();
  }

  /**
   * Permet de retourner la position de l'élément.
   */
  public Point getPosition() {
    Point p = rect.getLocation();
    p.x = (p.x + rect.width / 2);
    p.y = (p.y + rect.width / 2);
    return p;
  }

  public void setPosition(Point p) {
    rect.x = (p.x - rect.width / 2);
    rect.y = (p.y - rect.height / 2);
  }
}
