
public class Seetang implements Leckerbissen{
	
	
	private int gewicht;
	private Nahrungstyp nahrungstyp;
	private boolean istLebendig;
	
	/***
	 * Erzeugen Objekt von Typ Seetang
	 * 
	 * @param gewicht
	 */
	public Seetang(int gewicht) {
		this.gewicht = gewicht;
		istLebendig = true;
		nahrungstyp = Nahrungstyp.PFLANZE;
	}


	@Override
	public int getGramm() {
		return gewicht;
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

	@Override
	public String toString() {
		return "Seetang";
	}
}
