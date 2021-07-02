package cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.model.Book;

public class BookDAO {
	private static final Connection connection = ConnectionManager.getConnection();
	
	private static final String SELECT_ALL_BOOKS = "Select * from Book";
	//private static final String INSERT_RENT_BOOK = "I"
	
	
	
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
	
	
	

}
