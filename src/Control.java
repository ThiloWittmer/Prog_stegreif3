import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.prog2.TextIO;

public class Control {

	public static void main(String[] args) {

		List<String> akteurListe = null;
		String[] akteurDaten = null;
		List<Fisch> fischListe = new ArrayList<Fisch>();
		List<Leckerbissen> leckerbissenListe = new ArrayList<Leckerbissen>();

		//Einlesen Textdatei: Akteure
		try {
			akteurListe = TextIO.read(new File("akteure.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Erzeugen der Objekte
		for (String akteur : akteurListe) {
			//zerlegen
			akteurDaten = akteur.split(",");
			switch (akteurDaten[0]) {
				case "Fisch":
					erzeugeFisch(akteurDaten, fischListe);
					break;

				default:
					erzeugeLeckerbissen(akteurDaten, leckerbissenListe);
			}
		}

		//Einlesen Textdatei Ablauf

		//Durchführung der Abläufe

	}

	private static void erzeugeLeckerbissen(String[] akteurDaten, List<Leckerbissen> leckerbissenListe) {
		int menge = Integer.parseInt(akteurDaten[2]);
		int gewicht = Integer.parseInt(akteurDaten[3]);
		switch (akteurDaten[0]) {
			case "Seetang":
				for (int i = 0; i < menge; i++) {
					leckerbissenListe.add(new Seetang(gewicht));
				}
				break;
			case "Taucher":
				for (int i = 0; i < menge; i++) {
					leckerbissenListe.add(new Taucher(gewicht));
				}
				break;
			case "Muell":
				for (int i = 0; i < menge; i++) {
					leckerbissenListe.add(new Muell());
				}
		}
	}

	private static void erzeugeFisch(String[] akteurDaten, List<Fisch> fischListe) {
		Nahrungstyp nahrungstyp = null;
		switch (akteurDaten[2]) {
			case "FISCH":
				nahrungstyp = Nahrungstyp.FISCH;
				break;
			case "NICHT_ESSBAR":
				nahrungstyp = Nahrungstyp.NICHT_ESSBAR;
		}

		Esstyp esstyp = null;
		switch (akteurDaten[3]) {
			case "VEGANER":
				esstyp = Esstyp.VEGANER;
				break;
			case "VEGETARIER":
				esstyp = Esstyp.VEGETARIER;
				break;
			case "FLEXITARIER":
				esstyp = Esstyp.FLEXITARIER;
				break;
			case "FISCHESSER":
				esstyp = Esstyp.FISCHESSER;
				break;
			case "FLEISCHESSER":
				esstyp = Esstyp.FLEISCHESSER;
		}
		int gewicht = Integer.parseInt(akteurDaten[4]);
		int hunger = Integer.parseInt(akteurDaten[5]);
		fischListe.add(new Fisch(akteurDaten[1], nahrungstyp, esstyp, gewicht, hunger));
	}

}
