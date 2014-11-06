package org.LeChange.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

import org.LeChange.DAO.User;
import org.LeChange.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginWindow {

	private JFrame frmLechange;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLechange = new JFrame();
		frmLechange.setTitle("LeChange 0.1");
		frmLechange.setBounds(100, 100, 450, 300);
		frmLechange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmLechange.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(133, 80, 160, 28);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblLechange = new JLabel("LeChange");
		lblLechange.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLechange.setBounds(159, 25, 100, 44);
		panel.add(lblLechange);
		
		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(133, 130, 160, 28);
		panel.add(textPassword);
		
		JButton btnLogin = new JButton("LOGIN!");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Database db = new Database();
				
				User usuario = db.getUser(textUsername.getText(), textPassword.getText());
				
				if(usuario != null)
					System.out.println("Logou como " + usuario.getUserName());
				else
					System.out.println("Usuario Invalido!");
			}
		});
		btnLogin.setBounds(170, 169, 89, 23);
		panel.add(btnLogin);
	}
}
