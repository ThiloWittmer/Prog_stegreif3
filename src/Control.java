import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author Thilo Wittmer, Aaron Stier, Muhanad Khatib
 */

import de.hsrm.mi.prog2.TextIO;

public class Control {

	public static void main(String[] args) throws LeckerbissenSchonTotException, ExistiertNichtException {

		List<String> akteurListe = null;
		List<String> ablaufListe = null;
		String[] akteurDaten = null;
		String[] anweisungen = null;
		List<Fisch> fischListe = new ArrayList<Fisch>();
		List<Leckerbissen> leckerbissenListe = new ArrayList<Leckerbissen>();
		int count[] = {0, 0};

		/***
		 * Einlesen Textdatei: Akteure
		 */
		try {
			akteurListe = TextIO.read(new File("akteure.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/***
		 * Erzeugen der Objekte
		 */
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

		/***
		 * Einlesen Textdatei Ablauf
		 */
		try {
			ablaufListe = TextIO.read(new File("szene.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/***
		 * Durchführung der Abläufe
		 */
		for (String anweisung : ablaufListe) {
			Fisch fisch = null;
			Class<?> aktKlasse;
			Leckerbissen leckerbissen;
			anweisungen = anweisung.split(" ");
			for (Fisch aktFisch : fischListe) {
				if (aktFisch.getName().equals(anweisungen[0])) {
					fisch = aktFisch;
					break;
				}
			}
			
			try {
				if (fisch == null) {
					throw new ExistiertNichtException(anweisungen[0] + " wurde schon gefressen oder existiert nicht.");
				}
				aktKlasse = select(anweisungen[2]);
				try {
					leckerbissen = search(fischListe, leckerbissenListe, aktKlasse, anweisungen[2]);
					try {
						fisch.fressen(leckerbissen);
						if (leckerbissen.getClass() == Fisch.class) {
							fischListe.remove(leckerbissen);
						} else {
							leckerbissenListe.remove(leckerbissen);
						}
						count[0]++;
					} catch (FalscherNahrungstypException e) {
						e.printStackTrace();
						count[1]++;
					} catch (KeinenHungerException e) {
						e.printStackTrace();
						count[1]++;
					} catch (SelbstGefressenException e) {
						e.printStackTrace();
						count[1]++;
					}
				} catch(ExistiertNichtException e) {
					e.printStackTrace();
				}
			} catch(ExistiertNichtException e) {
				e.printStackTrace();
			}

			
						
		}

		System.out.println("Es wurde " + count[0] + " mal erfolgreich etwas gefressen.");
		System.out.println("Es wurde " + count[1] + " mal nicht erfolgreich etwas gefressen.");
		
	}

	
	/***
	 * Gibt die passende Klasse zurück
	 * @param anweisung
	 * @return
	 */
	private static Class<?> select(String anweisung) {
		switch(anweisung) {
			case "Seetang": return Seetang.class;
			case "Muell": return Muell.class;
			default: return Fisch.class;
		}
	}
	
	/***
	 * Suche des jeweiligen Leckerbissens
	 * 
	 * @param leckerbissenListe
	 * @param fisch
	 * @param klasse
	 * @param count
	 * @throws IOException 
	 * @throws ExistiertNichtException 
	 */
	private static Leckerbissen search(List<Fisch> fischListe, List<Leckerbissen> leckerbissenListe, Class<?> klasse, String name) throws ExistiertNichtException {
		if(klasse == Fisch.class) {
			for (Fisch aktFisch : fischListe) {
				if (aktFisch.getName().equals(name)) {
					return aktFisch;
				}
			}
			for (Leckerbissen aktLeckerbissen : leckerbissenListe) {
				if (aktLeckerbissen.getClass() == Taucher.class) {
					if ((aktLeckerbissen).getName().equals(name)) {
						return aktLeckerbissen;
					}
				}
			}
			throw new ExistiertNichtException(name + " ist nicht im Meer zu finden.");
		} else {
			for (Leckerbissen aktLeckerbissen : leckerbissenListe) {
				if(aktLeckerbissen.getClass() == klasse) {
					return aktLeckerbissen;
				}
			}
			throw new ExistiertNichtException(name + " ist nicht im Meer zu finden.");
		}
	}
	
	/***
	 * Erzeugen des Objekts des jeweilgen Leckerbissens
	 * 
	 * @param akteurDaten
	 * @param leckerbissenListe
	 */
	private static void erzeugeLeckerbissen(String[] akteurDaten, List<Leckerbissen> leckerbissenListe) {
		String name = null;
		int menge;
		int gewicht = Integer.parseInt(akteurDaten[2]);
		switch(akteurDaten[0]) {
			case "Seetang", "Muell":
				menge = Integer.parseInt(akteurDaten[1]);
			break;
			default:
				menge = 0;
				name = akteurDaten[1];
		}
		switch (akteurDaten[0]) {
			case "Seetang":
				for (int i = 0; i < menge; i++) {
					leckerbissenListe.add(new Seetang(gewicht));
				}
				break;
			case "Taucher":
				leckerbissenListe.add(new Taucher(name, gewicht));
				break;
			case "Muell":
				for (int i = 0; i < menge; i++) {
					leckerbissenListe.add(new Muell());
				}
		}
	}

	/***
	 * Erzeugen des Objekttypes Fisch
	 * 
	 * @param akteurDaten
	 * @param fischListe
	 */
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
