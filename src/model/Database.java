package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//
//Create table ProfessorTeaches (
//	    ID int(11) auto_increment primary key,
//	    ProfessorID int(11) ,
//	    SubjectID int(11),
//	    constraint FK_Professor foreign key (ProfessorID)references Profesor(ID),
//	    constraint FK_Subjects foreign key (SubjectID)references Subjects(ID)
//	);



public class Database {
	
	public final static String url = "jdbc:mysql://localhost:3306";
	public final static String username ="root";
	public final static String password = "";
	
	public static Connection getConnection() {
		
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return conn;
	}
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	
}
