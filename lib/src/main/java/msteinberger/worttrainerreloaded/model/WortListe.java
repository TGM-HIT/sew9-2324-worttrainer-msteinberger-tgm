package msteinberger.worttrainerreloaded.model;

import java.util.ArrayList;
import java.util.List;

public class WortListe {
	private List<WortEintrag> woerter;
	
	public WortListe() {
		this.woerter = new ArrayList<WortEintrag>();
	}
	
	public WortListe(List<WortEintrag> woerter) {
		this.woerter = woerter;
	}
	
	public void add(WortEintrag wort) {
		this.woerter.add(wort);
	}
	
	public boolean delete(String wort) {
		for(int i = 0; i < length(); i++) {
			if(woerter.get(i).getWort().equals(wort)) {
				woerter.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public WortEintrag getWortEintrag(int index) {
		return this.woerter.get(index);
	}
	
	public WortEintrag getRandomWortEintrag() {
		int index = (int) (Math.random() * length());
		return getWortEintrag(index);
	}
	
	public int length() {
		return this.woerter.size();
	}
	
	public String toString() {
		String text = "";
		for(WortEintrag w : woerter) {
			text += w + "\n";
		}
		return text;
	}
}
