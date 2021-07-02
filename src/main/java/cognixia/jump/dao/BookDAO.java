package cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.model.Book;

public class BookDAO {
	private static final Connection connection = ConnectionManager.getConnection();
	
	private static final String SELECT_ALL_BOOKS = "Select * from Book";
	private static final String INSERT_RENT_BOOK = "insert into book_checkout(patron_id, isbn, checkedout, due_date, returned) values(?, ?, ?, ?, ?)";
	private static final String UPDATE_RENT_BOOK = "UPDATE book Set rented = ? where isbn = ?";
	
	
	
	
	
	public List <Book> getAllBooks(){
		
		ArrayList<Book> allBooks = new ArrayList<Book>();
		
		try(PreparedStatement pstm = connection.prepareStatement(SELECT_ALL_BOOKS)){
			
			ResultSet results = pstm.executeQuery();
			
			while(results.next()) {
				
				String isbn = results.getString("isbn");
				String title = results.getString("title");
				String description = results.getString("descr");
				boolean isRented = results.getBoolean("rented");
				
				Book book = new Book(isbn, title, description, isRented, null);
				
				allBooks.add(book);
				System.out.println(book.toString());
				
				
				
				
			}
			
			return allBooks;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	
	public boolean rentABook(String id, String isbn) {
		
		
		try(PreparedStatement pstmt = connection.prepareStatement(INSERT_RENT_BOOK);){
			
			pstmt.setString(1, id);
			pstmt.setString(2, isbn);
			
			
			
			Date date = getCurrentDateTime();
			
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DATE, 10);
			Date returnDate = c.getTime();
			
			
			
			
			pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setDate(4, (java.sql.Date) returnDate);
			pstmt.setDate(5, null);
			
			
			if(pstmt.executeUpdate() < 1 )
				return false;
			
			
			PreparedStatement pstmt2 = connection.prepareStatement(UPDATE_RENT_BOOK);
			
			pstmt2.setBoolean(1, true);
			pstmt2.setString(2, isbn);
			
			
			if(pstmt2.executeUpdate() > 0) {
				return true;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public Date getCurrentDateTime(){
		Date today = new Date();
		return new Date(today.getTime());
	}
	
	
	

}
