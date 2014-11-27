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

import org.LeChange.DAO.User;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserList extends JFrame {
	
	/**
	 * 
	 */
	private JFrame frmUser;
	private JPanel contentPanel;
	private JList<String> list;
	private DefaultListModel<String> models;
	private JTextField textUserName;
	private List<User> users;
	
	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList frame = new UserList();
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
	public UserList(){
		
		setTitle("Buscar Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(0,20,20,20));
		setContentPane(contentPanel);
		
		models = new DefaultListModel<String>();
		JList list = new JList(models);
		//list = new JList<String>();
		list.setBounds(10, 60, 412, 190);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		list.setVisible(true);
		contentPanel.setLayout(null);
		contentPanel.add(list);
		
		JLabel lblNome = new JLabel("Digite o nome do usuário:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(1, 20, 150, 24);
		contentPanel.add(lblNome);
		
		textUserName = new JTextField();
		textUserName.setBounds(155, 20, 180, 23);
		textUserName.setColumns(13);
		contentPanel.add(textUserName);
		
		/**
		 * A ideia aqui é mostrar todos os usuários buscados na JList
		 */
		
		JButton btnBuscarUsuarios = new JButton("Buscar");
		btnBuscarUsuarios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//models.addElement("Lourenço");
				if(Database.userExists(textUserName.getText())){
					// ESCREVER TRECHO QUE TRAZ SÓ NOME DO USUÁRIO DA DATABASE
						
				}
			}
		});
		btnBuscarUsuarios.setBounds(340, 20, 85, 22);
		contentPanel.add(btnBuscarUsuarios);
		
		
		
		
	}
	
}
