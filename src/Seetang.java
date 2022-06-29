
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
		// TODO Auto-generated method stub
		return nahrungsmenge;
	}

	@Override
	public boolean gefressen() {
		// TODO Auto-generated method stub 
		if(istLebendig()) {
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
	
	

}
