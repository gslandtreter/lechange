package org.LeChange.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import org.LeChange.DAO.User;
import org.LeChange.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWindow {

	private JFrame frmCadastro;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirma;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 450, 300);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(173, 38, 140, 20);
		frmCadastro.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 69, 140, 20);
		frmCadastro.getContentPane().add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(117, 41, 46, 14);
		frmCadastro.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(117, 72, 46, 14);
		frmCadastro.getContentPane().add(lblSenha);
		
		passwordFieldConfirma = new JPasswordField();
		passwordFieldConfirma.setBounds(173, 100, 140, 20);
		frmCadastro.getContentPane().add(passwordFieldConfirma);
		
		JLabel lblRepitirASenha = new JLabel("Favor repitir a senha");
		lblRepitirASenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepitirASenha.setBounds(45, 103, 118, 14);
		frmCadastro.getContentPane().add(lblRepitirASenha);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastraUsuario();
			}
		});
		btnCadastro.setBounds(200, 131, 89, 23);
		frmCadastro.getContentPane().add(btnCadastro);
		
		JLabel lblAguardandoDadosDe = new JLabel("Aguardando Dados de Entrada");
		lblAguardandoDadosDe.setBounds(53, 183, 260, 14);
		frmCadastro.getContentPane().add(lblAguardandoDadosDe);
	}
	
	@SuppressWarnings("deprecation")
	private User CadastraUsuario() {
		
		if(textUsername.getText().length() > 4 && passwordField.getText().length() > 4) {
			
			if(!passwordField.getText().equals(passwordFieldConfirma.getText())) {
				System.out.println("Senhas nao batem!");
				return null;
			}
			
			return Database.registerUser(textUsername.getText(), passwordField.getText());
			
		}
		System.out.println("Dados invalidos");
		return null;
	}
}
