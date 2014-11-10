package org.LeChange.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.LeChange.DAO.Livro;
import org.LeChange.DAO.User;
import org.LeChange.Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601195575967191562L;
	private JPanel contentPane;
	private JTextField textField_Titulo;
	private JTextField textField_Autor;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterBook frame = new RegisterBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterBook() {
		setTitle("Cadastrar Livro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtulo.setBounds(62, 61, 82, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setBounds(62, 86, 82, 14);
		contentPane.add(lblAutor);
		
		textField_Titulo = new JTextField();
		textField_Titulo.setBounds(154, 58, 165, 20);
		contentPane.add(textField_Titulo);
		textField_Titulo.setColumns(10);
		
		textField_Autor = new JTextField();
		textField_Autor.setColumns(10);
		textField_Autor.setBounds(154, 83, 165, 20);
		contentPane.add(textField_Autor);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_Autor.getText().length() > 1 && textField_Titulo.getText().length() > 1) {
					
					Livro novoLivro = new Livro();
					novoLivro.setId(0);
					novoLivro.setIdOwner(User.getCurrentUser().getId());
					novoLivro.setTitulo(textField_Titulo.getText());
					novoLivro.setAutor(textField_Autor.getText());
					
					novoLivro = Database.registerBook(novoLivro);
					
					if(novoLivro != null) {
						//Livro cadastrado com sucesso
						
						Popup popup = new Popup("Livro cadastrado com sucesso!");
						popup.main();
						
						Dispose();
						
					}
				}
				else {
					Popup popup = new Popup("Dados invalidos!");
					popup.main();
				}
					
			}
		});
		btnOk.setBounds(110, 158, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(244, 158, 89, 23);
		contentPane.add(btnCancelar);
	}

	protected void Dispose() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
