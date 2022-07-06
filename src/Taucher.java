/*
 * Taucher-Klasse
 * 
 *@class Taucher beschreibt die Eigenschaften der Taucher 
 */
public class Taucher implements Leckerbissen {
    private boolean lebendig;
    private final Nahrungstyp TYP = Nahrungstyp.FLEISCH; 
    private int gewicht;
    private String name;

    public Taucher(String name, int gewicht){
    	this.name = name;
        this.lebendig=true;
        this.gewicht= gewicht;
    }

    @Override
    public String getName() {
    	return name;
    }
    
    @Override
    public int getGramm() {
    
        return gewicht;
    }

    @Override
    public boolean gefressen() {
        if(lebendig){
            lebendig = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean istLebendig() {
        
        return lebendig;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
    
        return TYP;
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
