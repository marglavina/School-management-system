package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Database;

public class StudentToSubjController {
//	CREATE TABLE  `mglavina`.`StudToSubj` (
//			  `ID` int(11) NOT NULL AUTO_INCREMENT,
//			  `StudentID` int(11) DEFAULT NULL,
//			  `SubjectID` int(11) DEFAULT NULL,
//			  PRIMARY KEY (`ID`),
//			  KEY `FK_Student` (`StudentID`),
//			  KEY `FK_Subjects1` (`SubjectID`),
//			  CONSTRAINT `FK_Student` FOREIGN KEY (`StudentID`) REFERENCES `Student` (`ID`),
//			  CONSTRAINT `FK_Subjects1` FOREIGN KEY (`SubjectID`) REFERENCES `Subjects` (`ID`)
//			)
	
	
	public boolean assignStudToSubj(int idStud, int idSubj) {
		
		String query = "INSERT INTO schoolmenegment.StudToSubj(StudentID, SubjectID) VALUES("+idStud+", "+idSubj+")";
		
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
		List<String> studToSubjList = new ArrayList();
		
		String query = "SELECT Student.studentName, Student.studentSurname, Subjects.subjectName FROM schoolmenegment.StudToSubj "
				+ "LEFT JOIN schoolmenegment.Student on Student.ID = StudToSubj.StudentID "
				+ "LEFT JOIN schoolmenegment.Subjects on Subjects.ID = StudToSubj.SubjectID";
		
		try {
			Connection conn = Database.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			try{
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					studToSubjList.add(rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3));
				}
			
			}catch(SQLException e1) {
				System.out.println(e1);
			}
			
			return studToSubjList ;
			
		}catch(SQLException e) {
			studToSubjList = null;
			return studToSubjList;
		}
	}

}
