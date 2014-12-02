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
	private List<User> users;
	
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
		final JList list = new JList(model);
		
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
					Popup popup = new Popup("Selecione uma transacao!");
					popup.main();
					return;
				}
				
				//Livro livroSelecionado = livros.get(selectedIndex);s
			}
		});
		btnRecusarTroca.setBounds(255, 212, 167, 22);
		contentPanel.add(btnRecusarTroca);
		
		JButton btnAceitarTroca = new JButton("Aceitar Troca");
		btnAceitarTroca.setBounds(20, 212, 167, 22);
		contentPanel.add(btnAceitarTroca);
		
	}
	
}
