
public enum Esstyp {
	VEGANER(Nahrungstyp.PFLANZE), VEGETARIER(Nahrungstyp.PFLANZE), FLEXITARIER(Nahrungstyp.PFLANZE, Nahrungstyp.FISCH, Nahrungstyp.FLEISCH),
		FISCHESSER(Nahrungstyp.FISCH), FLEISCHESSER(Nahrungstyp.FLEISCH);
	
	private Nahrungstyp[] akzTypen;
	
	private Esstyp(Nahrungstyp ... typen) {
		akzTypen = typen;
	}
	
	public boolean akzeptiert(Nahrungstyp typ) {
		for(Nahrungstyp aktTyp : akzTypen) {
			if(aktTyp == typ) {
				return true;
			}
		}
		return false;
	}
	
	
}
