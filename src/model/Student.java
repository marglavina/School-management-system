package Model;

import otherStuff.PasswordGenerator;

//
//
//create table Student( ID int(11) AUTO_INCREMENT PRIMARY KEY, studentName VarcHAR(50) , studentSurname VarcHAR(50), studentUsername VarcHAR(50), studentPassword VarcHAR(50))
//
//
public class Student {
	
	private int ID;
	private String studentName;
	private String studentSurname;
	private String studentUsername;
	private String studentPassword;
	
	public Student(char[] studentName, String studentSurname) {
		
		this.studentName = String.copyValueOf(studentName);
		this.studentSurname = studentSurname;
		this.studentUsername = String.copyValueOf(studentName,0, 1).toLowerCase()+studentSurname.toLowerCase();
		this.studentPassword = PasswordGenerator.generateRandomPassword();		
	}

	public int getID() {
		return ID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public String getStudentUsername() {
		return studentUsername;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	
	
	
	
	
	
	
	
	

}
