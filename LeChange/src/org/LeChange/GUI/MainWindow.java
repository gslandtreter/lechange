package org.LeChange.GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.LeChange.DAO.User;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

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
		btnCadastraLivroDesejado.setBounds(200, 66, 178, 80);
		frmLechange.getContentPane().add(btnCadastraLivroDesejado);
		
		JButton btnBuscarLivros = new JButton("Buscar Livros");
		btnBuscarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookList bookWindow = new BookList(0);
				bookWindow.main(0);
			}
		});
		btnBuscarLivros.setBounds(20, 157, 160, 80);
		frmLechange.getContentPane().add(btnBuscarLivros);
		
		JButton btnExcluirLivros = new JButton("Excluir Livros");
		btnExcluirLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookList bookWindow = new BookList(1);
				bookWindow.main(1);
			}
		});
		btnExcluirLivros.setBounds(200, 157, 178, 80);
		frmLechange.getContentPane().add(btnExcluirLivros);
		
		JButton btnBuscarUsuario = new JButton("Buscar Usuário");
		btnBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserList userWindow = new UserList();
				userWindow.main();
			}
		});
		btnBuscarUsuario.setBounds(20, 248, 160, 80);
		frmLechange.getContentPane().add(btnBuscarUsuario);
		
		/*
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSair.setForeground(new Color(0, 0, 153));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow.this.frmLechange.dispatchEvent(new WindowEvent(frmLechange, WindowEvent.WINDOW_CLOSING));
			}
		});
		lblSair.setBounds(133, 219, 420, 14);
		frmLechange.getContentPane().add(lblSair);
		 */
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
