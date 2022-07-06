
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
	 * @throws SelbstGefressenException 
	 * @throws LeckerbissenSchonTotException 
	 */
	public void fressen(Leckerbissen beute) throws FalscherNahrungstypException, KeinenHungerException, SelbstGefressenException, LeckerbissenSchonTotException {
		if(beute.getGramm() > (hunger - gewicht)) {
			//Exception: satt
			throw new KeinenHungerException(name + " hat nicht genug Hunger für " + beute.toString());
		}
		
		//beute wird gefressen
		if(esstyp.akzeptiert(beute.getNahrungstyp())) {
			if (this == beute) {
				throw new SelbstGefressenException(name + " hat versucht sich selber zu fressen.");
			} else if(beute.getGramm() == 0) {
				throw new LeckerbissenSchonTotException(beute.toString() + " ist schon tot.");
			} else {
				gewicht += beute.getGramm();
				System.out.println(name + " hat " + beute.toString() + " gefressen.");
				beute.setGewicht(0);
			}
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
	
	@Override
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
}
