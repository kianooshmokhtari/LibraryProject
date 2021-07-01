package cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.model.Patron;

public class PatronDao {
	
	private static final Connection connection = ConnectionManager.getConnection();
	
	
	//private static final String ALL_PRODUCTS = "SELECT * FROM patron";
	private static final String PATRON_BY_USER = "SELECT * FROM patron WHERE username = ?";
	//private static final String INSERT_PRODUCT = "INSERT INTO product(item, qty, description) VALUES (?, ?, ?)";
	//private static final String UPDATE_PRODUCT = "UPDATE product SET item = ?, qty = ?, description = ? WHERE id = ?";
	//private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
	
	
	
	public Patron getPatronByUserName(String usr, String pass) {
		
		Patron user = null;
		
		try(PreparedStatement pstmt = connection.prepareStatement(PATRON_BY_USER)){
			
			pstmt.setString(1, usr);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("patron_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				
				if(password.equals(pass)) {
					user = new Patron(String.valueOf(id), firstName, lastName, userName, password);
				
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return user;
		}
		return user;
		
	}
	
	
}
