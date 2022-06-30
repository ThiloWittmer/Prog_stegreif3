
public class Seetang implements Leckerbissen{
	
	private int nahrungsmenge;
	private Nahrungstyp nahrungstyp;
	private boolean istLebendig;
	
	public Seetang(int nahrungsmenge) {
		this.nahrungsmenge = nahrungsmenge;
		istLebendig = true;
		nahrungstyp = Nahrungstyp.PFLANZE;
	}


	@Override
	public int getGramm() {
		return nahrungsmenge;
	}

	@Override
	public boolean gefressen() {
		if(istLebendig()) {
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
}
