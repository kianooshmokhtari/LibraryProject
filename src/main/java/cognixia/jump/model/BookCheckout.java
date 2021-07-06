package cognixia.jump.model;

import java.sql.Date;

public class BookCheckout {
	
	private String patrondID;
	private Book book;
	private java.sql.Date checkout_date;
	private java.sql.Date due_date;
	private java.sql.Date returned_date;
	
	
	public BookCheckout(String patrondID, Book book, Date checkout_date, Date due_date, Date returned_date) {
		super();
		this.patrondID = patrondID;
		this.book = book;
		this.checkout_date = checkout_date;
		this.due_date = due_date;
		this.returned_date = returned_date;
	}


	public String getPatrondID() {
		return patrondID;
	}


	public void setPatrondID(String patrondID) {
		this.patrondID = patrondID;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public java.sql.Date getCheckout_date() {
		return checkout_date;
	}


	public void setCheckout_date(java.sql.Date checkout_date) {
		this.checkout_date = checkout_date;
	}


	public java.sql.Date getDue_date() {
		return due_date;
	}


	public void setDue_date(java.sql.Date due_date) {
		this.due_date = due_date;
	}


	public java.sql.Date getReturned_date() {
		return returned_date;
	}


	public void setReturned_date(java.sql.Date returned_date) {
		this.returned_date = returned_date;
	}
	
	
	
	
	

}
