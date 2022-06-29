import java.util.ArrayList;
import java.util.List;

public class Fisch implements Typisiert<Esstyp>, Leckerbissen {
	
	private String name;
	private int gewicht;
	private int hunger;
	private Esstyp typ;
	
	
	public Fisch(String name, int gewicht, int hunger, Esstyp typ) {
		this.name = name;
		this.gewicht = gewicht;
		this.hunger = hunger;
		this.typ = typ;
	}

	public void fressen(Leckerbissen beute) {
		if(beute.getGramm() > (hunger - gewicht)) {
			//Exception: satt
		}
		
		//beute wird gefressen
		if(typ.akzeptiert(beute.getNahrungstyp())) {
			
		} else {
			//Exception: Nicht genug Hunger
		}
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
		return null;
	}

	@Override
	public Esstyp getTyp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
