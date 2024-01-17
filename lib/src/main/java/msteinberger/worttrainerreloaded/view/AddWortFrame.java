package msteinberger.worttrainerreloaded.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddWortFrame extends JFrame{
	public AddWortFrame(JPanel layout) {
		super("Neues Wort hinzufügen");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.add(layout);
		this.pack();
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}
}
