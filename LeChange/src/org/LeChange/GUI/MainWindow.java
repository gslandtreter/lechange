package org.LeChange.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.LeChange.DAO.User;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmLechange;
	private JLabel lblTitle;

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
		lblTitle.setText(lblTitle.getText() + " > Pagina pessoal > " + User.getCurrentUser().getUserName());
		
		JButton btnCadastraLivro = new JButton("Cadastrar Novo Livro");
		btnCadastraLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterBook registerWindow = new RegisterBook(0);
				registerWindow.main();
			}
		});
		btnCadastraLivro.setBounds(20, 66, 160, 80);
		frmLechange.getContentPane().add(btnCadastraLivro);
		
		JButton btnCadastraLivroDesejado = new JButton("Cadastrar Livro Desejado");
		btnCadastraLivroDesejado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterBook registerWindow = new RegisterBook(1);
				registerWindow.main();
			}
		});
		btnCadastraLivroDesejado.setBounds(200, 66, 160, 80);
		frmLechange.getContentPane().add(btnCadastraLivroDesejado);
	}
	
	public boolean isVisible() {
		return frmLechange != null && frmLechange.isVisible();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLechange = new JFrame();
		frmLechange.setTitle("Lechange");
		frmLechange.setBounds(100, 100, 620, 400);
		frmLechange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLechange.getContentPane().setLayout(null);
		
		lblTitle = new JLabel("LeChange");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTitle.setBounds(10, 11, 584, 44);
		frmLechange.getContentPane().add(lblTitle);
	}
}
