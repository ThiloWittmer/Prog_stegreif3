/*
 * Muell-Klasse
 * 
 *@class Muell beschreibt die Eigenschaften des Muells
 */
public class Muell implements Leckerbissen {
    private boolean lebendig;
    private final Nahrungstyp TYP= Nahrungstyp.NICHT_ESSBAR;
    private int gewicht;
    
    public Muell(boolean lebendig, int gewicht){
        this.lebendig= true;
        this.gewicht= gewicht;
    }

    @Override
    public int getGramm() {
    
        return gewicht;
    }

    @Override
    public boolean gefressen() {
        lebendig = false;
		return true;
    }

    @Override
    public boolean istLebendig() {
        lebendig = false;
		return lebendig;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return TYP;
    }

}
