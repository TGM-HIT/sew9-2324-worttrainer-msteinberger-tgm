package msteinberger.worttrainerreloaded.model;

public class WortEintrag {
	private String wort;
	private String url;
	
	public WortEintrag(String wort, String url) {
		this.wort = wort;
		this.url = url;
	}
	
	public static boolean checkUrl(String url) {
		//TODO call URL checker in network class.
		return false;
	}
	
	public void setWort(String wort) {
		this.wort = wort;
	}
	
	public String getWort() {
		return this.wort;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return this.url;
	}
	
	public String toString() {
		return wort + ": " + url;
	}
}
