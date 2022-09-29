package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Database;
import model.Profesor;

public class ProfesorController {
	
	public boolean addNewProfesor(char[]profesorName, String profesorSurname) {
		
		Profesor profesor = new Profesor( profesorName, profesorSurname);
		
		String query ="INSERT INTO mglavina.Profesor"+
				"(profesoreName, profesorSurname, profesorUsername, profesorPassword)"
				+"VALUES('"
				+ profesor.getProfesorName() +"','"
				+ profesor.getProfesorSurname()+"','"
				+ profesor.getProfesorUsername()+"','"
				+ profesor.getProfesorPassword()+"')";
		
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
	
	public List<String> getAllProfessors(){
		List<String> professorList = new ArrayList();
		
		String query = "SELECT * FROM mglavina.Profesor";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					professorList.add(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return professorList ;
			
		}catch(SQLException e) {
			professorList = null;
			return professorList;
		}
	}
	
	public boolean updateProfesor(int id, String profesorName, String profesorSurname) {
		
		char [] pName = profesorName.toCharArray();
		
		String query ="UPDATE mglavina.Profesor SET"+
		" profesoreName ='"+ profesorName +
		"', profesorSurname = '" + profesorSurname+
		"', profesorUsername ='"+ String.copyValueOf(pName,0, 1).toLowerCase()+profesorSurname.toLowerCase()+
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
	
	public List<String> getProfessorsIDNameAndSurname(){
		List<String> professorList = new ArrayList();
		
		String query = "SELECT ID, profesoreName, profesorSurname FROM mglavina.Profesor";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					professorList.add(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return professorList ;
			
		}catch(SQLException e) {
			professorList = null;
			return professorList;
		}
	}

	public List<String> getProfessorsNameAndSurname(){
		List<String> professorList = new ArrayList();
		
		String query = "SELECT profesoreName, profesorSurname FROM mglavina.Profesor";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					professorList.add(rs.getString(1)+" "+rs.getString(2));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return professorList ;
			
		}catch(SQLException e) {
			professorList = null;
			return professorList;
		}
	}
	
}
