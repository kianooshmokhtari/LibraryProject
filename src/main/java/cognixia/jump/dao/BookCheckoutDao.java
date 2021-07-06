package cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.model.Book;
import cognixia.jump.model.BookCheckout;

public class BookCheckoutDao {
	
	private static final Connection connection = ConnectionManager.getConnection();
	
	
	
	private static final String SELECT_BOOKCHECKOUT_BY_ID = "SELECT b.isbn, b.title ,b.descr , bc.checkedout, bc.due_date, bc.returned from book b join book_checkout bc on b.isbn = bc.isbn where bc.patron_id= ?";

	
	
	public ArrayList <BookCheckout> getBooksRentedByUser(String id){
		
		ArrayList<BookCheckout> userBooks = new ArrayList<BookCheckout>();
		
		try(PreparedStatement pstmt = connection.prepareStatement(SELECT_BOOKCHECKOUT_BY_ID);){
			
			pstmt.setInt(1, Integer.valueOf(id));
			
			ResultSet results = pstmt.executeQuery();
			
			
			while(results.next()) {
				
				String isbn = results.getString("isbn");
				String title = results.getString("title");
				String description = results.getString("descr");
				
				Book book = new Book(isbn, title, description, false, null);
				
				java.sql.Date checkOutDate = results.getDate("checkedout");
				java.sql.Date dueDate = results.getDate("due_date");
				java.sql.Date returnedDate = results.getDate("returned");
				
				BookCheckout row = new BookCheckout(id, book, checkOutDate, dueDate, returnedDate);
				
				userBooks.add(row);
				
				
			}
			
			return userBooks;
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userBooks;
		
	}
}
