package msteinberger.worttrainerreloaded.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Die WortlListe speichert die Wörter welche im Worttrainer verwendet werden.
 * @author msteinberger
 *
 */
public class WortListe {
	private List<WortEintrag> woerter;
	
	public WortListe() {
		this.woerter = new ArrayList<WortEintrag>();
	}
	
	public WortListe(List<WortEintrag> woerter) {
		this.woerter = woerter;
	}
	
	/**
	 * Fügt ein Wort zur Liste hinzu.
	 * @param wort Das neue Wort
	 */
	public void add(WortEintrag wort) {
		this.woerter.add(wort);
	}
	
	/**
	 * Löscht ein Wort aus der Liste.
	 * @param wort Das zu löschende Wort
	 * @return Ob das Wort gelöscht wurde
	 */
	public boolean delete(String wort) {
		for(int i = 0; i < length(); i++) {
			if(woerter.get(i).getWort().equals(wort)) {
				woerter.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gibt ein bestimmtes Wort zurück.
	 * @param index Der Index in der Liste
	 * @return Das Wort mit dem bestimmten Index
	 */
	public WortEintrag getWortEintrag(int index) {
		return this.woerter.get(index);
	}
	
	/**
	 * Gibt ein zufälliges Wort zurück.
	 * @return Das zufällige Wort
	 */
	public WortEintrag getRandomWortEintrag() {
		int index = (int) (Math.random() * length());
		return getWortEintrag(index);
	}
	
	/**
	 * Gibt die Länge der Liste zurück.
	 * @return Die Länge der Liste
	 */
	public int length() {
		return this.woerter.size();
	}
	
	/**
	 * Stellt die Liste als ein String dar.
	 * @return Der String
	 */
	public String toString() {
		String text = "";
		for(WortEintrag w : woerter) {
			text += w + "\n";
		}
		return text;
	}
}
