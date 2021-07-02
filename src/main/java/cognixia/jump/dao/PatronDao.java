package cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cognixia.jump.connection.ConnectionManager;
import cognixia.jump.model.Patron;

public class PatronDao {
	
	private static final Connection connection = ConnectionManager.getConnection();
	
	
	
	private static final String PATRON_BY_USER = "SELECT * FROM patron WHERE username = ?";
	private static final String INSERT_USER = "INSERT INTO patron(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
	
	
	
	
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
	
	
	public boolean createdUserName(String firstName, String lastName, String userName, String password) {
		
		//check if userName exists
		
		Patron p = null;
		
		try(PreparedStatement pstmt = connection.prepareStatement(PATRON_BY_USER);){
			
			pstmt.setString(1, userName);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
			
			PreparedStatement pstmt2 = connection.prepareStatement(INSERT_USER);
			pstmt2.setString(1,firstName );
			pstmt2.setString(2, lastName);
			pstmt2.setString(3, userName);
			pstmt2.setString(4, password);
			
			if(pstmt2.executeUpdate()> 0) {
				
				return true;
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
			}
		
		
		
		return false;
		
	}
	
	
	
	
}
