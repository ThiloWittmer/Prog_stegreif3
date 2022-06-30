/*
 * Taucher-Klasse
 * 
 *@class Taucher beschreibt die Eigenschaften der Taucher 
 */
public class Taucher implements Leckerbissen {
    private boolean lebendig;
    private final Nahrungstyp TYP = Nahrungstyp.FLEISCH; 
    private int gewicht;

    public Taucher(boolean lebendig, int gewicht){
        this.lebendig=true;
        this.gewicht= gewicht;
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



}
