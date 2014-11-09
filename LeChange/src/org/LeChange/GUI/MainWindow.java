package org.LeChange.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainWindow {

	private JFrame frmLechange;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmLechange.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLechange = new JFrame();
		frmLechange.setTitle("Lechange");
		frmLechange.setBounds(100, 100, 620, 400);
		frmLechange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
