package test.report;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import environnement.Place;
import population.Fourmi;
import population.etat.Adulte;
import population.etat.Cadavre;
import population.etat.EtatAbstract;
import population.etat.Larve;
import population.etat.Nymphe;
import population.etat.Oeuf;
import report.CompteurFourmi;
import report.EtatsFourmi;
import report.ReportFourmi;
import temps.Temps;

public class ReportTest {
  @Test
  public void testCompteur() {
    List<Fourmi> listeFourmis = new ArrayList<Fourmi>();
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    for (int i = 0; i < 100; i++) {
      Fourmi uneFourmi = new Fourmi(false, place, tempsCourant);
      switch (i % 5) {
        case 0:
          uneFourmi.setEtat(new Oeuf(tempsCourant.getTempsCourant(), uneFourmi));
          break;
        case 1:
          uneFourmi.setEtat(new Larve(uneFourmi, tempsCourant.getTempsCourant()));
          break;
        case 2:
          uneFourmi.setEtat(new Nymphe(uneFourmi, tempsCourant.getTempsCourant()));
          break;
        case 3:
          uneFourmi.setEtat(new Adulte(uneFourmi, tempsCourant.getTempsCourant()));
          break;
        default:
          uneFourmi.setEtat(new Cadavre(uneFourmi, tempsCourant.getTempsCourant()));
          break;
      }

      listeFourmis.add(uneFourmi);
    }
    CompteurFourmi compteur = CompteurFourmi.getInstance();
    for (Fourmi uneFourmi : listeFourmis) {
      compteur.traceFourmi(uneFourmi);
    }
    System.out.println("Résultat : ");
    System.out.println(compteur.toString());
  }

  @Test
  public void testEtatsFourmi() {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    Fourmi uneFourmi = new Fourmi(false, place, tempsCourant);
    EtatsFourmi compteur = new EtatsFourmi();
    compteur.traceEtat(uneFourmi.getEtat());
    System.out.println(compteur.toString());

    uneFourmi.setEtat(new Larve(uneFourmi, tempsCourant.getTempsCourant()));
    compteur.traceEtat(uneFourmi.getEtat());
    System.out.println(compteur.toString());

    uneFourmi.setEtat(new Nymphe(uneFourmi, tempsCourant.getTempsCourant()));
    compteur.traceEtat(uneFourmi.getEtat());
    System.out.println(compteur.toString());

    uneFourmi.setEtat(new Adulte(uneFourmi, tempsCourant.getTempsCourant()));
    compteur.traceEtat(uneFourmi.getEtat());
    System.out.println(compteur.toString());

    uneFourmi.setEtat(new Cadavre(uneFourmi, tempsCourant.getTempsCourant()));
    compteur.traceEtat(uneFourmi.getEtat());
    System.out.println(compteur.toString());
  }

  @Test
  public void testReportFourmi() {
    Place place = new Place(0, 0);
    Temps tempsCourant = new Temps();
    Fourmi uneFourmi = new Fourmi(false, place, tempsCourant);

    ReportFourmi compteur = new ReportFourmi();
    compteur.traceFourmi(uneFourmi);
    System.out.println(compteur.toString());
  }
}
