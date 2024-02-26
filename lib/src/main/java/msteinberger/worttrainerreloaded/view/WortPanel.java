package msteinberger.worttrainerreloaded.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import msteinberger.worttrainerreloaded.control.WortController;

/**
 * Das Panel der UI.
 * @author msteinberger
 *
 */
public class WortPanel extends JPanel {
	private JTextField eingabe;
	private JLabel richtig, falsch, anzahl, bild;
	private JButton add, reset;
	
	public WortPanel(WortController wControl) {
		
		this.setLayout(new BorderLayout());
		
		//Header
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));
		top.add(new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?"));
		eingabe = new JTextField();
		eingabe.addActionListener(wControl);
		eingabe.setActionCommand("eingabe");
		top.add(eingabe);
		this.add(top, BorderLayout.PAGE_START);
		
		//Image
		bild = new JLabel("Image not initialized!", JLabel.CENTER);
		this.add(bild, BorderLayout.CENTER);
		
		//Footer
		JPanel bottom = new JPanel(new GridLayout(2, 3));
		bottom.add(new JLabel("Richtige Wörter:"));
		richtig = new JLabel("0");
		bottom.add(richtig);
		reset = new JButton("Zurücksetzten");
		reset.addActionListener(wControl);
		reset.setActionCommand("reset");
		bottom.add(reset);
		bottom.add(new JLabel("Anzahl Wörter:"));
		anzahl = new JLabel("0");
		bottom.add(anzahl);
		add = new JButton("Wort hinzufügen");
		add.addActionListener(wControl);
		add.setActionCommand("neuWort");
		bottom.add(add);
		this.add(bottom, BorderLayout.PAGE_END);
	}
	
	/**
	 * Setzt ein neues Bild.
	 * @param url Der Link zum Bild
	 */
	public void updateImage(String url) {
		try {
			Image image = new ImageIcon(new URL(url)).getImage();
			image = image.getScaledInstance(-1, 400, Image.SCALE_SMOOTH);
			bild.setIcon(new ImageIcon(image));
			bild.setText(null);
		} catch(MalformedURLException e) {
			bild.setIcon(null);
			bild.setText("Failed to load!");
		}
	}
	
	/**
	 * Gibt die Eingabe zurück.
	 * @return Die Eingabe
	 */
	public String getEingabe() {
		String text = eingabe.getText();
		eingabe.setText(null);
		return text;
	}
	
	/**
	 * Aktuallisiert die Statistik.
	 * @param beantwortet Wörter ingesammt
	 * @param korrekt Richtige Wörter
	 */
	public void updateScore(int beantwortet, int korrekt) {
		richtig.setText(String.valueOf(korrekt));
		anzahl.setText(String.valueOf(beantwortet));
	}
}
