package msteinberger.worttrainerreloaded.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Der Frame der GUI von dem Worttrainer.
 * @author msteinberger
 *
 */
public class WortFrame extends JFrame {
	public WortFrame(JPanel layout) {
		super("WortTrainer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(layout);
		this.pack();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
