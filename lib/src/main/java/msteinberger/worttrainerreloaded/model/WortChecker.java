package msteinberger.worttrainerreloaded.model;

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
	
	public boolean checkWort(String wort) {
		abgefragt++;
		if(current.getWort().equals(wort)) {
			richtig++;
			return true;
		}
		return false;
	}
	
	public boolean checkWortIgnoreCase(String wort) {
		abgefragt++;
		if(current.getWort().toLowerCase().equals(wort.toLowerCase())) {
			richtig++;
			return true;
		}
		return false;
	}
	
	public WortEintrag getRandomWort() {
		current = wliste.getRandomWortEintrag();
		return current;
	}
	
	public void addWortEintrag(String wort, String url) {
		wliste.add(new WortEintrag(wort, url));
	}
	
	public int[] getStatistik() {
		int[] statistik = {abgefragt, richtig};
		return statistik;
	}
	
	public void reset() {
		abgefragt = 0;
		richtig = 0;
	}
}
