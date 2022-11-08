package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Database;
import Model.Student;

public class StudentController {
public boolean addNewStudent(char[]studentName, String studentSurname) {
		
		Student student = new Student( studentName, studentSurname);
		
		String query ="INSERT INTO schoolmenegment.Student"+
				"(studentName, studentSurname, studentUsername, studentPassword)"
				+"VALUES('"
				+ student.getStudentName() +"','"
				+ student.getStudentSurname()+"','"
				+ student.getStudentUsername()+"','"
				+ student.getStudentPassword()+"')";
		
		try {
			Connection conn = Database.getConnection();
			
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
			
		} catch (SQLException e) {
			
			System.out.println(e);
			return false;		
		}
		
	}
	
	public List<String> getAllStudents(){
		List<String> studentList = new ArrayList();
		
		String query = "SELECT * FROM schoolmenegment.Student";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					studentList.add(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return studentList ;
			
		}catch(SQLException e) {
			studentList = null;
			return studentList;
		}
	}
	
	public boolean updateStudent(int id, String studentName, String studentSurname) {
		
		char [] pName = studentName.toCharArray();
		
		String query ="UPDATE schoolmenegment.Student SET"+
		" studentName ='"+ studentName +
		"', studentSurname = '" + studentSurname+
		"', studentUsername ='"+ String.copyValueOf(pName,0, 1).toLowerCase()+studentSurname.toLowerCase()+
		"' WHERE ID ="+ id +"";
		
		try {
			Connection conn = Database.getConnection();
			
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
			
		} catch (SQLException e) {
			
			System.out.println(e);
			return false;
			
		}
		
	}
	public List<String> getStudentsIDNameAndSurname(){
		List<String> studentList = new ArrayList();
		
		String query = "SELECT ID, studentName, studentSurname FROM schoolmenegment.Student";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					studentList.add(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return studentList ;
			
		}catch(SQLException e) {
			studentList = null;
			return studentList;
		}
	}

	public List<String> getStudentsNameAndSurname(){
		List<String> studentList = new ArrayList();
		
		String query = "SELECT studentName, studentSurname FROM schoolmenegment.Student";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					studentList.add(rs.getString(1)+" "+rs.getString(2));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return studentList ;
			
		}catch(SQLException e) {
			studentList = null;
			return studentList;
		}
	}
	
	public List<String> getStudentInfobyUsername(String username){
		
		List<String> studentInfo = new ArrayList();
		
		
				
		String query = "SELECT studentName, studentSurname, studentUsername, studentPassword  FROM schoolmenegment.Student WHERE studentUsername ='"+username+"'";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					studentInfo.add(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return studentInfo ;
			
		}catch(SQLException e) {
			studentInfo = null;
			return studentInfo;
		}
		
		
	}
}
