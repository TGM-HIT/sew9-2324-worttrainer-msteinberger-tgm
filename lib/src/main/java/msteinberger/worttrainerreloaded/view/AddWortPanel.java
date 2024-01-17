package msteinberger.worttrainerreloaded.view;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import msteinberger.worttrainerreloaded.control.WortController;

public class AddWortPanel extends JPanel {
	private JTextField wort, url;
	private JButton add, close;
	
	public AddWortPanel(WortController wControl) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setAlignmentY(LEFT_ALIGNMENT);
		JLabel wortTxt = new JLabel("Wort", JLabel.LEFT);
		this.add(wortTxt);
		wort = new JTextField();
		this.add(wort);
		JLabel urlTxt = new JLabel("URL", JLabel.LEFT);
		this.add(urlTxt);
		url = new JTextField();
		this.add(url);
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add = new JButton("Hinzufügen");
		add.addActionListener(wControl);
		add.setActionCommand("wortAdd");
		panel1.add(add);
		close = new JButton("Schließen");
		close.addActionListener(wControl);
		close.setActionCommand("close");
		panel1.add(close);
		this.add(panel1);
	}
	
	public String[] getEingabe() {
		String[] eingabe = {wort.getText(), url.getText()};
		wort.setText(null);
		url.setText(null);
		return eingabe;
	}
}
