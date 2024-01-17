package msteinberger.worttrainerreloaded.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import msteinberger.worttrainerreloaded.model.*;
import msteinberger.worttrainerreloaded.view.*;

public class WortController implements ActionListener {
	private WortPanel wPanel;
	private WortFrame wFrame;
	private WortChecker wChecker;
	
	private AddWortPanel nwPanel;
	private AddWortFrame nwFrame;
	
	private WortPersistence wPersist;
	
	public static void main(String[] args) {
		new WortController();
	}
	
	public WortController() {
		wPersist = new WortPersistenceJSON();
		
		//Initiate UI
		wPanel = new WortPanel(this);
		wFrame = new WortFrame(wPanel);
		wFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		        exit();
		    }
		});
		if((wChecker = wPersist.load()) == null)
			wChecker = new WortChecker();
		
		nwPanel = new AddWortPanel(this);
		nwFrame = new AddWortFrame(nwPanel);
		
		wPanel.updateImage(wChecker.getRandomWort().getURL());
		int[] stats = wChecker.getStatistik();
		wPanel.updateScore(stats[0], stats[1]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "eingabe":
				String eingabe = wPanel.getEingabe();
				wChecker.checkWort(eingabe);
				
				int[] stats = wChecker.getStatistik();
				wPanel.updateScore(stats[0], stats[1]);
				wPanel.updateImage(wChecker.getRandomWort().getURL());
				break;
			case "reset":
				wChecker.reset();
				wPanel.updateScore(0, 0);
				break;
			case "neuWort":
				nwFrame.setVisible(true);
				break;
			case "wortAdd":
				String[] neuWort = nwPanel.getEingabe();
				wChecker.addWortEintrag(neuWort[0], neuWort[1]);
				break;
			case "close":
				nwFrame.setVisible(false);
				break;
		}
	}
	
	public void exit() {
		wPersist.save(wChecker);
	}
}
