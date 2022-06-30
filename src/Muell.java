
public class Muell implements Leckerbissen{
	
	private Nahrungstyp nahrungstyp;
	
	public Muell() {
		nahrungstyp = Nahrungstyp.NICHT_ESSBAR;
	}

	@Override
	public int getGramm() {
		return 0;
	}

	@Override
	public boolean gefressen() {
		return false;
	}

	@Override
	public boolean istLebendig() {
		return false;
	}

	@Override
	public Nahrungstyp getNahrungstyp() {
		return nahrungstyp;
	}

}
