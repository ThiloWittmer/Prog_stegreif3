
public class Fisch implements Leckerbissen {
	
	private String name;
	private int gewicht;
	private int hunger;
	private Esstyp esstyp;
	private Nahrungstyp nahrungstyp;
	private boolean istLebendig;
	
	//Objekt Fisch
	public Fisch(String name, Nahrungstyp nahrungstyp, Esstyp typ, int gewicht, int hunger) {
		this.name = name;
		this.gewicht = gewicht;
		this.hunger = hunger;
		this.esstyp = typ;
		this.nahrungstyp = nahrungstyp;
		this.istLebendig = true;
	}

	/***
	 * Methode wenn Fisch frisst
	 * 
	 * @param beute
	 * @throws FalscherNahrungstypException
	 * @throws KeinenHungerException
	 */
	public void fressen(Leckerbissen beute) throws FalscherNahrungstypException, KeinenHungerException {
		if(beute.getGramm() > (hunger - gewicht)) {
			//Exception: satt
			throw new KeinenHungerException(name + " hat nicht genug Hunger für " + beute.toString());
		}
		
		//beute wird gefressen
		if(esstyp.akzeptiert(beute.getNahrungstyp())) {
			gewicht += beute.getGramm();
			System.out.println(name + " hat " + beute.toString() + " gefressen.");
		} else {
			//Exception: falscher Nahrungstyp
			throw new FalscherNahrungstypException(name + " hat nicht den richtigen Nahrungstyp für " + beute.toString());
		}
	}

	public String getName() {
		return name;
	}


	@Override
	public int getGramm() {
		return gewicht;
	}


	@Override
	public boolean gefressen() {
		if(istLebendig) {
			istLebendig = false;
			return true;
		}
		return false;
	}


	@Override
	public boolean istLebendig() {
		return istLebendig;
	}


	@Override
	public Nahrungstyp getNahrungstyp() {
		return nahrungstyp;
	}

	@Override
	public String toString() {
		return name;
	}
}
