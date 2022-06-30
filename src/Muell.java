
public class Muell implements Leckerbissen{
	
	private Nahrungstyp nahrungstyp;
	private int menge;
	
	public Muell(int menge) {
		nahrungstyp = Nahrungstyp.NICHT_ESSBAR;
		this.menge = menge;
	}

	@Override
	public int getGramm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean gefressen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean istLebendig() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nahrungstyp getNahrungstyp() {
		// TODO Auto-generated method stub
		return nahrungstyp;
	}

}
