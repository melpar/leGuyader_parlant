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
    if ((this.placeNid.getX() * VuePrincipale.COEFFICIENT + 5) > e.getX()
        && (this.placeNid.getX() * VuePrincipale.COEFFICIENT - 5) < e.getX()) {
      if ((this.placeNid.getY() * VuePrincipale.COEFFICIENT + 5) > e.getY()
          && (this.placeNid.getY() * VuePrincipale.COEFFICIENT - 5) < e.getY()) {
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
