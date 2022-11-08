package Controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Database;


//Create table ProfessorTeaches (
//	    ID int(11) auto_increment primary key,
//	    ProfessorID int(11) ,
//	    SubjectID int(11),
//	    constraint FK_Professor foreign key (ProfessorID)references Profesor(ID),
//	    constraint FK_Subjects foreign key (SubjectID)references Subjects(ID)
//	)



public class ProfToSubjController {
	
	public boolean assignProfToSubj(int idProf, int idSubj) {
		
		String query = "INSERT INTO schoolmenegment.ProfToSubj(ProfessorID, SubjectID) VALUES("+idProf+", "+idSubj+")";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.execute();
			return true;
			
		}catch(SQLException e) {
			return false;
		}
	}

	public List<String> getAll(){
		List<String> profToSubjList = new ArrayList();
		
		String query = "SELECT Profesor.profesoreName, Profesor.profesorSurname, Subjects.subjectName, ProfToSubj.SubjectID FROM schoolmenegment.ProfToSubj "
				+ "LEFT JOIN schoolmenegment.Profesor on Profesor.ID = ProfToSubj.ProfessorID "
				+ "LEFT JOIN schoolmenegment.Subjects on Subjects.ID = ProfToSubj.SubjectID ";
		String subjectID="";
		String numOfStudents="";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					subjectID = rs.getString(4);
					try {
						
						String querySubject = "Select COUNT(StudToSubj.StudentID) From schoolmenegment.StudToSubj where SubjectID = "+subjectID;
						Connection connn = Database.getConnection();
						PreparedStatement stmt1 = connn.prepareStatement(querySubject);
						
						ResultSet rs1 = stmt1.executeQuery();
						rs1.next();
						numOfStudents = rs1.getString(1);
						
						rs1.close();
						
					}catch(SQLException e3) {
						System.out.println(e3);
					}
									
					
					profToSubjList.add(rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3)+", "+numOfStudents);
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return profToSubjList ;
			
		}catch(SQLException e) {
			profToSubjList = null;
			return profToSubjList;
		}
	}

}
