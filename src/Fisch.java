
public class Fisch implements Typisiert<Esstyp>, Leckerbissen {
	
	private String name;
	private int gewicht;
	private int hunger;
	private Esstyp esstyp;
	private Nahrungstyp nahrungstyp;
	private boolean istLebendig;
	
	
	public Fisch(String name, int gewicht, int hunger, Esstyp typ) {
		this.name = name;
		this.gewicht = gewicht;
		this.hunger = hunger;
		this.esstyp = typ;
	}

	public void fressen(Leckerbissen beute) throws FalscherNahrungstypException, KeinenHungerException {
		if(beute.getGramm() > (hunger - gewicht)) {
			//Exception: satt
			throw new KeinenHungerException(name + " hat nicht genug Hunger für " + beute);
		}
		
		//beute wird gefressen
		if(esstyp.akzeptiert(beute.getNahrungstyp())) {
			
		} else {
			//Exception: falscher Nahrungstyp
			throw new FalscherNahrungstypException(name + " akzeptiert kein: " + beute.getNahrungstyp());
		}
	}


	@Override
	public int getGramm() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return istLebendig;
	}


	@Override
	public Nahrungstyp getNahrungstyp() {
		// TODO Auto-generated method stub
		return nahrungstyp;
	}

	@Override
	public Esstyp getTyp() {
		// TODO Auto-generated method stub
		return esstyp;
	}
	
	
}
