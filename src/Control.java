import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.prog2.TextIO;

public class Control {

	public static void main(String[] args) {

		List<String> akteurListe = null;
		List<String> ablaufListe = null;
		String[] akteurDaten = null;
		String[] anweisungen = null;
		List<Fisch> fischListe = new ArrayList<Fisch>();
		List<Leckerbissen> leckerbissenListe = new ArrayList<Leckerbissen>();
		int count[] = {0, 0};

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
		try {
			ablaufListe = TextIO.read(new File("szene.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Durchführung der Abläufe
		for (String anweisung : ablaufListe) {
			Fisch fisch = null;
			anweisungen = anweisung.split(" ");
			for (Fisch aktFisch : fischListe) {
				if (aktFisch.getName().equals(anweisungen[0])) {
					fisch = aktFisch;
					break;
				}
			}

			switch (anweisungen[2]) {
				case "Seetang":
					searchnEatLeckerbissen(leckerbissenListe, fisch, Seetang.class, count);
					break;
				case "Muell":
					searchnEatLeckerbissen(leckerbissenListe, fisch, Muell.class, count);
					break;
				case "Taucher":
					searchnEatLeckerbissen(leckerbissenListe, fisch, Taucher.class, count);
					break;
				default:
					boolean gefressen = false;
					for (Fisch aktFisch : fischListe) {
						if (aktFisch.getName().equals(anweisungen[2])) {
							try {
								fisch.fressen(aktFisch);
								fischListe.remove(aktFisch);
								count[0]++;
							} catch (FalscherNahrungstypException e) {
								e.printStackTrace();
								count[1]++;
							} catch (KeinenHungerException e) {
								e.printStackTrace();
								count[1]++;
							}
							gefressen = true;
						}
						if(gefressen) break;
					}
					break;
			}
		}

		System.out.println("Es wurde " + count[0] + " mal erfolgreich etwas gefressen.");
		System.out.println("Es wurde " + count[1] + " mal nicht erfolgreich etwas gefressen.");
		
	}

	private static void searchnEatLeckerbissen(List<Leckerbissen> leckerbissenListe, Fisch fisch, Class<?> klasse, int[] count) {
		boolean gefressen = false;
		for (Leckerbissen aktLeckerbissen : leckerbissenListe) {
			if (aktLeckerbissen.getClass() == klasse) {
				try {
					fisch.fressen(aktLeckerbissen);
					leckerbissenListe.remove(aktLeckerbissen);
					count[0]++;
				} catch (FalscherNahrungstypException e) {
					e.printStackTrace();
					count[1]++;
				} catch (KeinenHungerException e) {
					e.printStackTrace();
					count[1]++;
				}
				gefressen = true;
			}
			if (gefressen) break;
		}
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
