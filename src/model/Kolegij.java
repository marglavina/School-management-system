package Model;

//CREATE TABLE  `mglavina`.`Subjects` (
//		  `ID` int(11) NOT NULL AUTO_INCREMENT,
//		  `subjectName` varchar(50) DEFAULT NULL,
//		  `yearOfSubject` int(1) DEFAULT NULL,
//		  `uniqueSubjectName` varchar(5) DEFAULT NULL,
//		  PRIMARY KEY (`ID`),
//		  UNIQUE KEY `uniqueSubjectNameConstraint` (`uniqueSubjectName`)
//		);

public class Kolegij {
	
	private int ID;
	private String subjectName;
	private int year;
	private String uniqueSubjectName;
	Profesor profesor;
	
	public Kolegij(String subjectName, int year, String uniqueSubjectName){
		
		this.subjectName = subjectName;
		this.year = year;
		this.uniqueSubjectName = uniqueSubjectName;
	}

	public String getUniqueSubjectName() {
		return uniqueSubjectName;
	}

	public void setUniqueSubjectName(String uniqueSubjectName) {
		this.uniqueSubjectName = uniqueSubjectName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public int getYear() {
		return year;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getID() {
		return ID;
	}
	
}
