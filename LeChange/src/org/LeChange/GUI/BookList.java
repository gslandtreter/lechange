package org.LeChange.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import org.LeChange.DAO.Livro;
import org.LeChange.DAO.User;
import org.LeChange.Database.Database;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -47019223451957170L;
	private JPanel contentPane;
	private JList<String> list;
	private DefaultListModel<String> model;
	private List<Livro> livros;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
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
	public BookList() {
		setTitle("Livros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		list = new JList<String>();
		list.setBounds(10, 11, 414, 191);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		list.setVisible(true);
		contentPane.setLayout(null);
		contentPane.add(list);
		
		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.setBounds(43, 228, 128, 23);
		contentPane.add(btnDetalhes);
		
		JButton btnSolicitaTroca = new JButton("Solicita Troca");
		btnSolicitaTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = list.getSelectedIndex();
				
				if(selectedIndex == -1) {
					Popup popup = new Popup("Selecione um livro!");
					popup.main();
					return;
				}
				
				Livro livroSelecionado = livros.get(selectedIndex);
				
				boolean retVal = Database.reservaLivro(livroSelecionado);
				
				if(retVal) {
					Popup popup = new Popup("Livro reservado com sucesso!");
					popup.main();
					Dispose();
				}
				else {
					Popup popup = new Popup("Erro ao reservar livro!");
					popup.main();
				}
			}
		});
		btnSolicitaTroca.setBounds(257, 228, 128, 23);
		contentPane.add(btnSolicitaTroca);
		
		CarregaLivros();
	}

	private void CarregaLivros() {
		
		livros = Database.getBookList(User.getCurrentUser());
		
		model = new DefaultListModel<String>();
		
		for (Livro livro : livros) {
			model.addElement(livro.getTitulo());
		}

		list.setModel(model);
	}
	
	private void Dispose() {
		this.dispose();
	}
}
