package org.LeChange.DAO;

public class Transaction {

	private int id;
	private int userID;
	private int bookID;
	private int targetUserID;
	private int targetBookID;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getTargetUserID() {
		return targetUserID;
	}
	public void setTargetUserID(int targetUserID) {
		this.targetUserID = targetUserID;
	}
	public int getTargetBookID() {
		return targetBookID;
	}
	public void setTargetBookID(int targetBookID) {
		this.targetBookID = targetBookID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
