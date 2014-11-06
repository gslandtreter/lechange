package org.LeChange.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import org.LeChange.DAO.Livro;
import org.LeChange.DAO.User;

public class Database {

	private static Connection conn = null;
	
	public Database() {
		getConnection();
	}
	
	 public Connection getConnection() {
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection("jdbc:sqlite:lechange.db");
	      
	      if(conn != null)
	    	  conn.setAutoCommit(true);
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    return conn;
	  }
	 
	 public Collection<Livro> getUserBooks(User usuario) {
		 Collection<Livro> livrosUsuario = new ArrayList<Livro>();
		 
		 //TODO: Pegar livros do usuario na DB. Meh...
		 
		 return livrosUsuario;
	 }
	 public User getUser(String userName, String password) {
		 
		 if(conn == null)
			 getConnection();
		 
		 User userFound = null;
		 
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 try {
			 stmt = conn.prepareStatement("Select * from usuarios WHERE username = ? and password = ?");
			 
			 stmt.setString(1, userName);
			 stmt.setString(2, password);
			 
			 rs = stmt.executeQuery();
			 
			  if ( rs.next() ) {
			     int id = rs.getInt("id");
			     
			     userFound = new User();
			     userFound.setId(id);
			     userFound.setUserName(userName);
			  }
			  
			  rs.close();
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	      
		 finally {
			 if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
			 if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			 }
		 }
		 
		 return userFound;
	 }
	 
}
