/*
 * Leckerbissen-Interface
 * 
 * in diesem Interface werden die Methoden der Leckerbissen deklariert
 */
public interface Leckerbissen {
	public int getGramm();  	//Gewicht von Objekt zurückliefern
	public boolean gefressen(); 	//Wenn Leckerbissen gefressen wurde
	public boolean istLebendig();	//Abfrage ob Objekt noch da ist
	public Nahrungstyp getNahrungstyp(); 	//Return Nahrungstyp vom Objekt
	public String toString(); //Name von Objekt als String
	public void setGewicht(int gewicht);
	public String getName();
}
