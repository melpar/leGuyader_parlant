package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class JCanvas extends JPanel {

  private List<IDrawable> drawables = new LinkedList<IDrawable>();
  private IDrawable rectNid;
  private IDrawable rectDepot;

  public void setRectNid(IDrawable rectNid) {
    this.rectNid = rectNid;
  }

  public void setRectDepot(IDrawable rectDep) {
    this.rectDepot = rectDep;
  }

  /**
   * Permet de mettre a jour le canvas.
   */
  public void paint(Graphics g) {
    super.paint(g);
    try {
      for (int i = 0; i < drawables.size(); i++) {
        IDrawable d = drawables.get(i);
        boolean afficher = true;
        if (this.rectNid != null && this.rectDepot != null && this.rectNid != d
            && this.rectDepot != d) {
          int ecart = (VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT)
              - (VuePrincipale.TAILLE_CARRE_PROIE_FOURMI * VuePrincipale.COEFFICIENT);
          for (int positionX = -ecart; positionX < ecart; positionX++) {
            for (int positionY = -ecart; positionY < ecart; positionY++) {
              Point p = new Point((int) d.getRectangle().getCenterX(),
                  (int) d.getRectangle().getCenterY());
              p.setLocation(p.getX() + positionX, p.getY() + positionY);
              if (this.rectNid.getRectangle().contains(p)
                  || this.rectDepot.getRectangle().contains(p)) {
                afficher = false;
                break;
              }
            }
          }

          // double xMin = this.rectNid.getRectangle().getLocation().getX()
          // - (VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT);
          // double xMax = this.rectNid.getRectangle().getLocation().getX()
          // + (VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT);
          // double yMin = this.rectNid.getRectangle().getLocation().getX()
          // - (VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT);
          // double yMax = this.rectNid.getRectangle().getLocation().getX()
          // + (VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT);
          // if
          // (d.getRectangle().contains(this.rectNid.getRectangle().getLocation().getX(),
          // this.rectNid.getRectangle().getLocation().getY(),
          // VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT,
          // VuePrincipale.TAILLE_CARRE_NID_DEPOT / 2 * VuePrincipale.COEFFICIENT)) {
          // afficher = false;
          // }
        }
        if (afficher) {
          d.draw(g);
        }
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