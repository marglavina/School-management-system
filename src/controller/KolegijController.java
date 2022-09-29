package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Database;
import model.Kolegij;

public class KolegijController {
	
	public Kolegij kolegij;
	
	public boolean createNewSubject(String subjectName, int yearOfSubject, String uniqueSubjectName)
	{
		kolegij = new Kolegij(subjectName, yearOfSubject, uniqueSubjectName);
		
		String query ="INSERT INTO mglavina.Subjects " + "(subjectName, yearOfSubject, uniqueSubjectName) "
				+ "VALUES('"+subjectName+"', "+yearOfSubject+", '"+uniqueSubjectName+"' )";
						
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
	
	public List<String> getAllSubjects(){
		List<String> subjectList = new ArrayList();
		
		String query = "SELECT * FROM mglavina.Subjects";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					subjectList.add(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return subjectList;
			
		}catch(SQLException e) {
			subjectList = null;
			return subjectList;
		}
	}
	
	public boolean updateSubject(int id, String subjectName, int yearOfSubject, String uniqueSubjectName) {
		
		String query ="UPDATE mglavina.Subjects SET"+
		" subjectName ='"+ subjectName +
		"', yearOfSubject ="+yearOfSubject+
		", uniqueSubjectName ='"+uniqueSubjectName+
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
	public List<String> getSubjectIDandName(){
		List<String> subjectList = new ArrayList();
		
		String query = "SELECT ID, subjectName FROM mglavina.Subjects";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					subjectList.add(rs.getString(1)+" "+rs.getString(2));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return subjectList;
			
		}catch(SQLException e) {
			subjectList = null;
			return subjectList;
		}
	}
	public List<String> getSubjectName(){
		List<String> subjectList = new ArrayList();
		
		String query = "SELECT subjectName FROM mglavina.Subjects";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					subjectList.add(rs.getString(1));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return subjectList;
			
		}catch(SQLException e) {
			subjectList = null;
			return subjectList;
		}
	}
}
