package model;

import otherStuff.PasswordGenerator;

//create table Profesor( ID int(11) AUTO_INCREMENT PRIMARY KEY, 
//		profesoreName VarcHAR(50) , 
//		profesorSurname VarcHAR(50), 
//		profesorUsername VarcHAR(50), 
//		profesorPassword VarcHAR(50));

public class Profesor {
	
	
	private String profesorName;
	private String profesorSurname;
	private String profesorUsername;
	private String profesorPassword;
	private int ID;	
	
	public Profesor(char[] profesorName, String profesorSurname){
		
		this.profesorName = String.copyValueOf(profesorName);
		this.profesorSurname = profesorSurname;
		this.profesorUsername =  String.copyValueOf(profesorName,0, 1).toLowerCase()+profesorSurname.toLowerCase();
		this.profesorPassword = PasswordGenerator.generateRandomPassword();
		
	}
	
	public String getProfesorUsername() {
		return profesorUsername;
	}
	public String getProfesorPassword() {
		return profesorPassword;
	}
	public void setProfesorUsername(String profesorUsername) {
		this.profesorUsername = profesorUsername;
	}
	public void setProfesorPassword(String profesorPassword) {
		this.profesorPassword = profesorPassword;
	}		

	public String getProfesorSurname() {
		return profesorSurname;
	}
	public int getID() {
		return ID;
	}
	public void setProfesorSurname(String profesorSurname) {
		this.profesorSurname = profesorSurname;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getProfesorName() {
		return profesorName;
	}
	public void setProfesorName(char[] profesorName) {
		this.profesorName = profesorName.toString();
	}
	
	

}
