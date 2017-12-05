package vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import environnement.Place;
import environnement.Terrain;

public class ListenerNid implements MouseListener {
  Place placeNid;
  Terrain terrain;

  public ListenerNid(Terrain terrain) {
    this.terrain = terrain;
  }

  public void setPlaceNid(Place nid) {
    this.placeNid = nid;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (((this.placeNid.getX() + 5) * VuePrincipale.COEFFICIENT) > e.getX()
        && ((this.placeNid.getX() - 5) * VuePrincipale.COEFFICIENT) < e.getX()) {
      if (((this.placeNid.getY() + 5) * VuePrincipale.COEFFICIENT) > e.getY()
          && ((this.placeNid.getY() - 5) * VuePrincipale.COEFFICIENT) < e.getY()) {
        PopUpNid popup = new PopUpNid(terrain.getFourmiliere().getNidFourmiliere().getListeFourmi(),
            this.terrain.getFourmiliere().getNidFourmiliere().getListeProie());
      }
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}
