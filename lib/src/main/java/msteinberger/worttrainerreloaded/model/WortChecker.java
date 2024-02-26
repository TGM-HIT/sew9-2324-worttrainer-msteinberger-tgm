package msteinberger.worttrainerreloaded.model;

/**
 * Die Klasse speichert und überprüft die Wörter des Worttrainers.
 * @author msteinberger
 *
 */
public class WortChecker {
	private WortListe wliste;
	private WortEintrag current;
	private int abgefragt;
	private int richtig;
	
	public WortChecker() {
		WortListe wListe = new WortListe();
		wListe.add(new WortEintrag("tgm", "https://upload.wikimedia.org/wikipedia/commons/b/ba/TGM_Logo.png"));
		this.wliste = wListe;
		this.abgefragt = 0;
		this.richtig = 0;
	}
	
	public WortChecker(WortListe wliste) {
		this.wliste = wliste;
		this.abgefragt = 0;
		this.richtig = 0;
	}
	
	/**
	 * Checkt ob ein Wort richtig geschrieben wurde.
	 * @param wort Das eingegebene Wort
	 * @return Ist das Wort richtig
	 */
	public boolean checkWort(String wort) {
		abgefragt++;
		if(current.getWort().equals(wort)) {
			richtig++;
			return true;
		}
		return false;
	}
	
	/**
	 * Checkt ob ein Wort richtig geschrieben wurde ohne auf Groß/kleinschreibung zu achten.
	 * @param wort Das eingegebene Wort
	 * @return Ist das Wort richtig
	 */
	public boolean checkWortIgnoreCase(String wort) {
		abgefragt++;
		if(current.getWort().toLowerCase().equals(wort.toLowerCase())) {
			richtig++;
			return true;
		}
		return false;
	}
	
	/**
	 * Wählt ein zufälliges Wort.
	 * @return Das Wort
	 */
	public WortEintrag getRandomWort() {
		current = wliste.getRandomWortEintrag();
		return current;
	}
	
	/**
	 * Fügt ein Wort zur Liste hinzu.
	 * @param wort Das Wort
	 * @param url Der URL für das Bild
	 */
	public void addWortEintrag(String wort, String url) {
		wliste.add(new WortEintrag(wort, url));
	}
	
	/**
	 * Gibt die Statistik zum Spiel zurück.
	 * @return Die Statistik
	 */
	public int[] getStatistik() {
		int[] statistik = {abgefragt, richtig};
		return statistik;
	}
	
	/**
	 * Setzt die Statistik zurück.
	 */
	public void reset() {
		abgefragt = 0;
		richtig = 0;
	}
}
