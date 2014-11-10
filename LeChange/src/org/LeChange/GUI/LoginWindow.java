package org.LeChange.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.LeChange.DAO.User;
import org.LeChange.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class LoginWindow {

	private JFrame frmLechange;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
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
		frmLechange.setBounds(100, 100, 440, 300);
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
							
				User usuario = Database.getUser(textUsername.getText(), textPassword.getText());
				
				if(usuario != null){
					User.setCurrentUser(usuario);
					LoginOK();
				}
				else {
					//System.out.println("Usuario Invalido!");
					Popup popup = new Popup("Usuario Invalido!");
					popup.main();
				}
			}
		});
		btnLogin.setBounds(170, 169, 89, 23);
		panel.add(btnLogin);
		
		JLabel lblUsurio = new JLabel("ID");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(79, 87, 44, 14);
		panel.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(69, 137, 54, 14);
		panel.add(lblSenha);
		
		JLabel lblCadastrarNovaConta = new JLabel("Cadastrar nova conta");
		lblCadastrarNovaConta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastrarNovaConta.setForeground(new Color(0, 0, 153));
		lblCadastrarNovaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RegisterWindow registerWindow = new RegisterWindow();
				registerWindow.main(null);
			}
		});
		lblCadastrarNovaConta.setBounds(133, 219, 160, 14);
		panel.add(lblCadastrarNovaConta);
	}
	
	private void LoginOK() {
		frmLechange.setVisible(false);
		MainWindow mainWindow = new MainWindow();
		mainWindow.main();
	}
}
