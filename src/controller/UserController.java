package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Database;

public class UserController {

	
	public boolean checkUserAndPass(String username, String password) {
		boolean status = false;

		String query = "SELECT count(ID)  FROM schoolmenegment.Student WHERE studentUsername ='"+username+"' AND studentPassword ='" +password+"'";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if(rs.getString(1).equals("0")) {
				status = false;
			}else status = true;
						
			
			return status ;
			
		}catch(SQLException e) {
			status = false;
			return status;
		}
		
		
		
	}
	
	
}
