import java.io.File;
import java.util.List;

import de.hsrm.mi.prog2.TextIO;

public class Control {

	public static void main(String[] args) {

		List<String> akteurListe = null;

		//Einlesen Textdatei: Akteure
		try {
			akteurListe = TextIO.read(new File("akteure.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Erzeugen der Objekte
		

		//Einlesen Textdatei Ablauf

		//Durchführung der Abläufe

	}

}
