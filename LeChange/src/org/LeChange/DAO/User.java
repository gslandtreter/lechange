package org.LeChange.DAO;

import java.util.Collection;

public class User {

	private int id;
	private int isAdmin;
	
	private String userName;
	private Collection<Livro> livrosCadastrados;
	private Collection<Livro> livrosDesejados;
	
	private static User currentUser = null;
	
	public static User getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(User currentUser) {
		User.currentUser = currentUser;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Livro> getLivrosCadastrados() {
		return livrosCadastrados;
	}
	public void setLivrosCadastrados(Collection<Livro> livrosCadastrados) {
		this.livrosCadastrados = livrosCadastrados;
	}
	public Collection<Livro> getLivrosDesejados() {
		return livrosDesejados;
	}
	public void setLivrosDesejados(Collection<Livro> livrosDesejados) {
		this.livrosDesejados = livrosDesejados;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
