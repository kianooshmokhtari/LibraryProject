package cognixia.jump.model;

import java.util.Date;

public class Book {
	
	private String ISBN;
	private String title;
	private String description;
	private boolean isRented;
	private Date added_To_Library;
	
	public Book(String iSBN, String title, String description, boolean isRented, Date added_To_Library) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.description = description;
		this.isRented = isRented;
		this.added_To_Library = added_To_Library;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public Date getAdded_To_Library() {
		return added_To_Library;
	}

	public void setAdded_To_Library(Date added_To_Library) {
		this.added_To_Library = added_To_Library;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", description=" + description + ", isRented=" + isRented
				+ ", added_To_Library=" + added_To_Library + "]";
	}
	
	
	
	
	

}
