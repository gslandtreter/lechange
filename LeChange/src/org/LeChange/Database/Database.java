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
	
	 public static Connection getConnection() {
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
	 
	 public static Collection<Livro> getUserBooks(User usuario) {
		 Collection<Livro> livrosUsuario = new ArrayList<Livro>();
		 
		 //TODO: Pegar livros do usuario na DB. Meh...
		 
		 return livrosUsuario;
	 }
	 public static User registerUser(String userName, String password) {
		 if(conn == null)
			 getConnection();
		 
		 if(userExists(userName)) {
			 System.out.println("Usuario ja existe!");
			 //TODO: popup.
			 return null;
		 }
		 
		 PreparedStatement stmt = null;
		 try {
			 stmt = conn.prepareStatement("Insert into usuarios (username, password) VALUES (?,?)");
			 stmt.setString(1, userName);
			 stmt.setString(2, password);

			 stmt.executeUpdate();
			  
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
		 }
		 
		 return getUser(userName, password);
	 }
	 
	 public static Livro registerBook(Livro bookToRegister) {
		 
		 if(conn == null)
			 getConnection(); 
		 
		 if(bookToRegister == null)
			 return null;
		 
		 PreparedStatement stmt = null;
		 try {
			 stmt = conn.prepareStatement("Insert into livros (owner_id, title, author, status) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			 stmt.setInt(1, bookToRegister.getIdOwner());
			 stmt.setString(2, bookToRegister.getTitulo());
			 stmt.setString(3, bookToRegister.getAutor());
			 stmt.setString(4, bookToRegister.getStatus());

			 stmt.executeUpdate();
			 
			 ResultSet rs = stmt.getGeneratedKeys();
			 
			 if(rs.next()) {
				 bookToRegister.setId(rs.getInt(1));
			 }
			  
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
		 }
		 
		 return bookToRegister.getId() != 0 ? bookToRegister : null;
	 }
	 public static boolean userExists(String userName) {
		 if(conn == null)
			 getConnection();
		 
		 boolean userFound = false;
		 
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 try {
			 stmt = conn.prepareStatement("Select * from usuarios WHERE username = ?");
			 
			 stmt.setString(1, userName);
			 
			 rs = stmt.executeQuery();
			 
			 if(rs != null) {
			 
				  if ( rs.next() ) {
					  userFound = true;
				  }
				  
				  rs.close();
				 }
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
	 public static User getUser(String userName, String password) {
		 
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
