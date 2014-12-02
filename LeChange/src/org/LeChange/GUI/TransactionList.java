package org.LeChange.GUI;

import java.awt.BorderLayout;
import org.LeChange.Database.Database;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.LeChange.DAO.Livro;
import org.LeChange.DAO.Transaction;
import org.LeChange.DAO.User;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

public class TransactionList extends JFrame {
	
	/**
	 * 
	 */
	private JFrame frmUser;
	private JPanel contentPanel;
	private JList<String> list;
	private DefaultListModel<String> model;
	private List<Transaction> transactions;
	
	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionList frame = new TransactionList();
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
	public TransactionList(){
		
		setTitle("Trocas Pendentes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(0,20,20,20));
		setContentPane(contentPanel);
		
		model = new DefaultListModel<String>();
		list = new JList(model);
		
		//list = new JList<String>();
		list.setBounds(10, 11, 412, 190);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		list.setVisible(true);
		contentPanel.setLayout(null);
		contentPanel.add(list);

		JButton btnRecusarTroca = new JButton("Recusar Troca");
		btnRecusarTroca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = list.getSelectedIndex();
				
				if(selectedIndex == -1) {
					Popup popup = new Popup("Selecione uma troca pendente!");
					popup.main();
					return;
				}
				
				Transaction transacaoSelecionada = transactions.get(selectedIndex);
				boolean retVal = Database.rejectTransaction(transacaoSelecionada);
				
				if(retVal) {
					Popup popup = new Popup("Troca rejeitada com sucesso!");
					popup.main();
				}
				else {
					Popup popup = new Popup("Erro ao rejeitar troca!");
					popup.main();
				}
				
				Dispose();
			}
		});
		btnRecusarTroca.setBounds(255, 212, 167, 22);
		contentPanel.add(btnRecusarTroca);
		
		JButton btnAceitarTroca = new JButton("Aceitar Troca");
		btnAceitarTroca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = list.getSelectedIndex();
				
				if(selectedIndex == -1) {
					Popup popup = new Popup("Selecione uma troca pendente!");
					popup.main();
					return;
				}
				
				Transaction transacaoSelecionada = transactions.get(selectedIndex);
				boolean retVal = Database.acceptTransaction(transacaoSelecionada);
				
				if(retVal) {
					Popup popup = new Popup("Troca efetuada com sucesso!");
					popup.main();
				}
				else {
					Popup popup = new Popup("Erro ao efetuar troca!");
					popup.main();
				}

				Dispose();
			}
		});
		btnAceitarTroca.setBounds(20, 212, 167, 22);
		contentPanel.add(btnAceitarTroca);
		
		CarregaTransacoes();
	}
	
	private void CarregaTransacoes() {
		
		transactions = Database.getTransaction(User.getCurrentUser());
		
		model = new DefaultListModel<String>();
		
		for (Transaction trans : transactions) {
			model.addElement(Database.getBook(trans.getBookID()).getTitulo() + " - " + Database.getBook(trans.getTargetBookID()).getTitulo());
		}
		
		list.setModel(model);
		
	}
	
	void Dispose() {
		this.dispose();
	}
	
}
