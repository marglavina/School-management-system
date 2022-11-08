package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.KolegijController;
import Controller.ProfToSubjController;
import Controller.ProfesorController;
import Controller.StudentController;
import Controller.StudentToSubjController;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class schoolManagement extends JFrame {

	private JPanel contentPane;
	private JTextField subjectName;
	private JTextField uniqueSubjectName;
	private JTable subjectTable;
	private JTextField profesorName;
	private JTextField profesorSurname;
	private JTable professorTable;
	private JTextField studentName;
	private JTextField studentSurname;
	private JTable studentTable;
	private JTable profToSubjTable;
	private JTable studToSubjTable;
	
	ProfesorController pc = new ProfesorController();
	KolegijController kc = new KolegijController();
	StudentController sc = new StudentController();
	ProfToSubjController pts= new ProfToSubjController();
	StudentToSubjController sts = new StudentToSubjController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schoolManagement frame = new schoolManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public schoolManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel subjectPanel = new JPanel();
		subjectPanel.setBounds(227, 0, 757, 523);
		contentPane.add(subjectPanel);
		subjectPanel.setLayout(null);
		
		JLabel lblNewLabel3 = new JLabel("Name of Subject");
		lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel3.setBounds(27, 14, 95, 50);
		subjectPanel.add(lblNewLabel3);
		
		JLabel lblNewLabel_13 = new JLabel("Year of a subject");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(27, 93, 95, 14);
		subjectPanel.add(lblNewLabel_13);
		
		subjectName = new JTextField();
		subjectName.setColumns(10);
		subjectName.setBounds(143, 11, 230, 50);
		subjectPanel.add(subjectName);
		
		JComboBox yearOfSubject_1 = new JComboBox();
		yearOfSubject_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		yearOfSubject_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		yearOfSubject_1.setBounds(145, 89, 228, 22);
		subjectPanel.add(yearOfSubject_1);
		
		JButton subjectSubmitNew = new JButton("Submit subject");
		subjectSubmitNew.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectSubmitNew.setBounds(401, 139, 130, 50);
		subjectPanel.add(subjectSubmitNew);
		
		JButton updateSubjectBtn = new JButton("Update subject");
		updateSubjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateSubjectBtn.setBounds(401, 75, 130, 50);
		subjectPanel.add(updateSubjectBtn);
		
		JLabel lblNewLabel_32 = new JLabel("Unique name");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_32.setBounds(27, 139, 95, 50);
		subjectPanel.add(lblNewLabel_32);
		
		uniqueSubjectName = new JTextField();
		uniqueSubjectName.setColumns(10);
		uniqueSubjectName.setBounds(144, 139, 230, 50);
		subjectPanel.add(uniqueSubjectName);
		
		JButton deleteSubjectBtn_1 = new JButton("Delete subject");
		deleteSubjectBtn_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteSubjectBtn_1.setBounds(401, 11, 130, 50);
		subjectPanel.add(deleteSubjectBtn_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 239, 737, 273);
		subjectPanel.add(scrollPane);
		
		subjectTable = new JTable();
		subjectTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name of subject", "Year of subject", "Unique subject name"
			}
		));
		subjectTable.getColumnModel().getColumn(0).setResizable(false);
		subjectTable.getColumnModel().getColumn(1).setPreferredWidth(89);
		scrollPane.setViewportView(subjectTable);
		subjectPanel.setVisible(false);
		

		
		JPanel studToSubjPanel = new JPanel();
		studToSubjPanel.setBounds(227, 0, 757, 523);
		contentPane.add(studToSubjPanel);
		studToSubjPanel.setLayout(null);
		
		JLabel lblNewLabel121323 = new JLabel("Assign student to subject");
		lblNewLabel121323.setBounds(0, -70, 0, 0);
		studToSubjPanel.add(lblNewLabel121323);
		
		JComboBox studentBoxMenu = new JComboBox();
		studentBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentBoxMenu.setBounds(148, 19, 250, 23);
		studToSubjPanel.add(studentBoxMenu);
		
		JLabel adsfasd1 = new JLabel("Student");
		adsfasd1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adsfasd1.setBounds(23, 23, 115, 14);
		studToSubjPanel.add(adsfasd1);
		
		JLabel adasdasdasdasdasd1 = new JLabel("Subject");
		adasdasdasdasdasd1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adasdasdasdasdasd1.setBounds(23, 65, 115, 14);
		studToSubjPanel.add(adasdasdasdasdasd1);
		
		JComboBox subjectBoxMenu1 = new JComboBox();
		subjectBoxMenu1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBoxMenu1.setBounds(148, 62, 250, 21);
		studToSubjPanel.add(subjectBoxMenu1);
		
		JButton assignStudToSubj = new JButton("Assign");
		assignStudToSubj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		assignStudToSubj.setBounds(408, 19, 120, 64);
		studToSubjPanel.add(assignStudToSubj);
		
		JScrollPane studToSubjPane = new JScrollPane();
		studToSubjPane.setBounds(10, 147, 737, 365);
		studToSubjPanel.add(studToSubjPane);
		
		studToSubjTable = new JTable();
		studToSubjTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Name", "Subject"
			}
		));
		studToSubjTable.getColumnModel().getColumn(0).setPreferredWidth(103);
		studToSubjPane.setViewportView(studToSubjTable);
		
		JPanel profToSubjPanel = new JPanel();
		profToSubjPanel.setBounds(227, 0, 757, 523);
		contentPane.add(profToSubjPanel);
		profToSubjPanel.setLayout(null);
		
		JLabel lblNewLabel1213 = new JLabel("Assign proffesor to subject");
		lblNewLabel1213.setBounds(10, 11, 0, 0);
		profToSubjPanel.add(lblNewLabel1213);
		
		JComboBox professorBoxMenu = new JComboBox();
		professorBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		professorBoxMenu.setBounds(148, 24, 250, 23);
		profToSubjPanel.add(professorBoxMenu);
		
		JLabel adsfasd = new JLabel("Professor");
		adsfasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adsfasd.setBounds(23, 28, 115, 14);
		profToSubjPanel.add(adsfasd);
		
		JLabel adasdasdasdasdasd = new JLabel("Subject");
		adasdasdasdasdasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adasdasdasdasdasd.setBounds(23, 70, 115, 14);
		profToSubjPanel.add(adasdasdasdasdasd);
		
		JComboBox subjectBoxMenu = new JComboBox();
		subjectBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBoxMenu.setBounds(148, 67, 250, 21);
		profToSubjPanel.add(subjectBoxMenu);
		
		JButton assignProfToSubj = new JButton("Assign");
		assignProfToSubj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		assignProfToSubj.setBounds(408, 24, 120, 64);
		profToSubjPanel.add(assignProfToSubj);
		
		JScrollPane profToSubjPane = new JScrollPane();
		profToSubjPane.setBounds(10, 133, 737, 379);
		profToSubjPanel.add(profToSubjPane);
		
		profToSubjTable = new JTable();
		profToSubjTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Professor Name", "Subject", "No. Students"
			}
		));
		profToSubjTable.getColumnModel().getColumn(0).setPreferredWidth(104);
		profToSubjPane.setViewportView(profToSubjTable);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.GRAY);
		menu.setForeground(Color.WHITE);
		menu.setBounds(0, 0, 228, 523);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JButton subjectBtn = new JButton("Subjects");
		subjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBtn.setBounds(10, 59, 200, 55);
		menu.add(subjectBtn);
		
		JButton professorsBtn = new JButton("Professors");
		professorsBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		professorsBtn.setBounds(10, 135, 200, 60);
		menu.add(professorsBtn);
		
		JButton studentBtn = new JButton("Students");
		studentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentBtn.setBounds(10, 218, 200, 60);
		menu.add(studentBtn);
		
		JButton profToSubjBtn = new JButton("Assign professor to subject");
		profToSubjBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profToSubjBtn.setBounds(10, 302, 200, 60);
		menu.add(profToSubjBtn);
		
		JButton studToSubjBtn = new JButton("Assign student to subject");
		studToSubjBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studToSubjBtn.setBounds(10, 384, 200, 60);
		menu.add(studToSubjBtn);
		
		JPanel studentPanel = new JPanel();
		studentPanel.setBounds(227, 0, 757, 523);
		contentPane.add(studentPanel);
		studentPanel.setLayout(null);
		
		JLabel lblNewLabel123 = new JLabel("Student name");
		lblNewLabel123.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel123.setBounds(10, 26, 95, 25);
		studentPanel.add(lblNewLabel123);
		
		JLabel lblNewLabel_12 = new JLabel("Student surname");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(10, 95, 95, 25);
		studentPanel.add(lblNewLabel_12);
		
		studentName = new JTextField();
		studentName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentName.setColumns(10);
		studentName.setBounds(115, 13, 206, 50);
		studentPanel.add(studentName);
		
		studentSurname = new JTextField();
		studentSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentSurname.setColumns(10);
		studentSurname.setBounds(115, 82, 206, 50);
		studentPanel.add(studentSurname);
		
		JButton addStudentBtn = new JButton("Submit");
		addStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addStudentBtn.setBounds(331, 82, 120, 50);
		studentPanel.add(addStudentBtn);
		
		JButton updateStudentBtn = new JButton("Update");
		updateStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateStudentBtn.setBounds(461, 13, 120, 50);
		studentPanel.add(updateStudentBtn);
		
		JButton deleteStudentBtn = new JButton("Delete");
		deleteStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteStudentBtn.setBounds(461, 82, 120, 50);
		studentPanel.add(deleteStudentBtn);
		
		JScrollPane studentPane = new JScrollPane();
		studentPane.setBounds(10, 198, 737, 314);
		studentPanel.add(studentPane);
		
		studentTable = new JTable();
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Surname", "Username", "Password"
			}
		));
		studentPane.setViewportView(studentTable);
		
		JPanel profesorPanel = new JPanel();
		profesorPanel.setBounds(227, 0, 757, 523);
		contentPane.add(profesorPanel);
		profesorPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(30, 41, 27, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorPanel.add(lblNewLabel);
		
		profesorName = new JTextField();
		profesorName.setBounds(97, 23, 246, 50);
		profesorName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorName.setColumns(10);
		profesorPanel.add(profesorName);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setBounds(30, 117, 42, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorPanel.add(lblNewLabel_1);
		
		profesorSurname = new JTextField();
		profesorSurname.setBounds(97, 99, 246, 50);
		profesorSurname.setColumns(10);
		profesorPanel.add(profesorSurname);
		
		JButton newProfesorsubmitBtn = new JButton("Submit");
		newProfesorsubmitBtn.setBounds(353, 99, 120, 50);
		newProfesorsubmitBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorPanel.add(newProfesorsubmitBtn);
		
		JButton updateProfesor = new JButton("Update");
		updateProfesor.setBounds(483, 23, 120, 50);
		updateProfesor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorPanel.add(updateProfesor);
		
		JButton deleteProfesor = new JButton("Delete");
		deleteProfesor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteProfesor.setBounds(483, 99, 120, 50);
		profesorPanel.add(deleteProfesor);
		
		JScrollPane profesorPane = new JScrollPane();
		profesorPane.setBounds(10, 223, 737, 289);
		profesorPanel.add(profesorPane);
		
		professorTable = new JTable();
		professorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Surname", "Username", "Password"
			}
		));
		profesorPane.setViewportView(professorTable);
		
		profesorPanel.setVisible(false);
		studentPanel.setVisible(false);
		studToSubjPanel.setVisible(false);
		profToSubjPanel.setVisible(false);
		
		subjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profesorPanel.setVisible(false);
				studentPanel.setVisible(false);
				studToSubjPanel.setVisible(false);
				profToSubjPanel.setVisible(false);
				subjectPanel.setVisible(true);
				
				String[] subjectSplit;
				List<String> subjectList = kc.getAllSubjects();
				DefaultTableModel tables = (DefaultTableModel)subjectTable.getModel();
				
				if(subjectList != null) {
					tables.setRowCount(0);
					for (String subject : subjectList) {
						subjectSplit = subject.split(", ");
						
						tables.addRow(subjectSplit);
					}
				}
				else JOptionPane.showMessageDialog(null, "There is no subject or has been error.");
				
			}
		});
		//Button event for creating new subject
		subjectSubmitNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int yearOfSubjectindex = yearOfSubject_1.getSelectedIndex()+1;
				String subjectNames = subjectName.getText();
				String uniqueSubjectNames = uniqueSubjectName.getText();
				boolean inserted = false;
				
				if(uniqueSubjectName.getText().length()>5)
				{
					JOptionPane.showMessageDialog(null, "Unique subject name must be max 5 characters.");	
					
				}
				else {
					if((!subjectName.getText().equals("")) && 
						((yearOfSubjectindex>=1) && (yearOfSubjectindex<=5)) && 
						(!uniqueSubjectName.getText().equals("")) &&
						(uniqueSubjectName.getText().length()<=5))				
					{			
					 inserted = kc.createNewSubject(subjectNames, yearOfSubjectindex, uniqueSubjectNames);
					 
					 if(inserted) {
							JOptionPane.showMessageDialog(null, "Subject has been added.");
						
							String[] subjectSplit;
							List<String> subjectList = kc.getAllSubjects();
							DefaultTableModel tables = (DefaultTableModel)subjectTable.getModel();
						
							
							if(subjectList != null) {
								tables.setRowCount(0);
								for (String subject : subjectList) {
									subjectSplit = subject.split(", ");
								
									tables.addRow(subjectSplit);
								}
							}
							else JOptionPane.showMessageDialog(null, "There is no subject or has been error.");
						
							subjectName.setText("");
							uniqueSubjectName.setText("");
							inserted = false;
							yearOfSubject_1.setSelectedIndex(0);
						
						}else JOptionPane.showMessageDialog(null, "Subject has not been added.");
					 
					}
					else{
						JOptionPane.showMessageDialog(null, "All fields are requered.");
					}
				
									
				}
			}
		});
		
		//Updating Subject with table edit
		updateSubjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean updated = false;
				
				int redBr = subjectTable.getSelectedRow();
				
						
						
				if (redBr < 1) {
					JOptionPane.showMessageDialog(null, "You must select a row!");
				}else	
				{
					int id = Integer.parseInt((String)subjectTable.getModel().getValueAt(subjectTable.getSelectedRow(), 0));
					String subjectNames = (String)subjectTable.getModel().getValueAt(subjectTable.getSelectedRow(), 1);
					int yearOfSubject = Integer.parseInt((String)subjectTable.getModel().getValueAt(subjectTable.getSelectedRow(), 2));
					String uniqueSubjectNames = (String)subjectTable.getModel().getValueAt(subjectTable.getSelectedRow(), 3);
					updated = kc.updateSubject(id, subjectNames, yearOfSubject, uniqueSubjectNames);
							
				}
		
				
				if(updated) {
					JOptionPane.showMessageDialog(null, "Subject has been updated.");
					
					
					String[] subjectSplit;
					List<String> subjectList = kc.getAllSubjects();
					DefaultTableModel tables = (DefaultTableModel)subjectTable.getModel();
				
					if(subjectList != null) {
						tables.setRowCount(0);
						for (String subject : subjectList) {
							subjectSplit = subject.split(", ");
						
							tables.addRow(subjectSplit);
						}
					}
					else JOptionPane.showMessageDialog(null, "There is no subject or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Subject has not been updated.");
				}
				
			}
		});
	
//		
//		
//		
//		Professor Admin
//		
//		
//
		professorsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				profesorPanel.setVisible(true);
				studentPanel.setVisible(false);
				studToSubjPanel.setVisible(false);
				profToSubjPanel.setVisible(false);
				subjectPanel.setVisible(false);
				
				String[] professorSplit;
				List<String> professorList = pc.getAllProfessors();
				DefaultTableModel tables = (DefaultTableModel)professorTable.getModel();
			
				if(professorList != null) {
					tables.setRowCount(0);
					for (String subject : professorList) {
						professorSplit = subject.split(", ");
					
						tables.addRow(professorSplit);
					}
				}
				else JOptionPane.showMessageDialog(null, "There is no professors.");
								
			}
		});
		
		newProfesorsubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[]profesorNames = profesorName.getText().toCharArray();
				String profesorSurnames = profesorSurname.getText();
				boolean profesorAdded= false;
				
				
				if(profesorName.getText().equals("")|| profesorSurname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All fields must be entered.");
				}else {
					
					profesorAdded =pc.addNewProfesor(profesorNames, profesorSurnames);
					
					if(profesorAdded) {
						String[] professorSplit;
						List<String> professorList = pc.getAllProfessors();
						DefaultTableModel tables = (DefaultTableModel)professorTable.getModel();
					
						if(professorList != null) {
							tables.setRowCount(0);
							for (String subject : professorList) {
								professorSplit = subject.split(", ");
							
								tables.addRow(professorSplit);
							}
						}
						else JOptionPane.showMessageDialog(null, "There is no professors.");
						
						JOptionPane.showMessageDialog(null, "Professor was added.");
						profesorName.setText("");
						profesorSurname.setText("");
					}else JOptionPane.showMessageDialog(null, "Professor was NOT added.");
				
				}
			}
		});
		

		updateProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean updated = false;
				int redBr = professorTable.getSelectedRow();
				
				if (redBr == -1) {
					JOptionPane.showMessageDialog(null, "You must select a row!");
				}
				else{
					String profesorNames = (String)professorTable.getModel().getValueAt(professorTable.getSelectedRow(), 1);
					String profesorSurnames = (String)professorTable.getModel().getValueAt(professorTable.getSelectedRow(), 2);
					int id = Integer.parseInt((String)professorTable.getModel().getValueAt(professorTable.getSelectedRow(), 0));
					updated = pc.updateProfesor(id, profesorNames, profesorSurnames);			
				}
				
				try {
				
		
				
				if(updated) {
					JOptionPane.showMessageDialog(null, "Profesor has been updated.");
					
					
					String[] profesorSplit;
					List<String> profesorList = pc.getAllProfessors();
					DefaultTableModel tables = (DefaultTableModel)professorTable.getModel();
				
					if(profesorList != null) {
						tables.setRowCount(0);
						for (String profesor : profesorList) {
							profesorSplit = profesor.split(", ");
						
							tables.addRow(profesorSplit);
						}
					}
					else JOptionPane.showMessageDialog(null, "There is no professors or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Professor has not been updated.");
				}
			}catch (Exception e4) {
				JOptionPane.showMessageDialog(null, "Something went wrong try again !");
			}
		}
		});
//		
//		
//		
//		Student Admin
//		
//		
//
		studentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				profesorPanel.setVisible(false);
				studentPanel.setVisible(true);
				studToSubjPanel.setVisible(false);
				profToSubjPanel.setVisible(false);
				subjectPanel.setVisible(false);
				
				String[] studentSplit;
				List<String> studentList = sc.getAllStudents();
				DefaultTableModel tables = (DefaultTableModel)studentTable.getModel();
			
				if(studentList != null) {
					tables.setRowCount(0);
					for (String subject : studentList) {
						studentSplit = subject.split(", ");
					
						tables.addRow(studentSplit);
					}
				}
				else JOptionPane.showMessageDialog(null, "There is no students.");
			}
		});
		
		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[]studentNames = studentName.getText().toCharArray();
				String studentSurnames = studentSurname.getText();
				boolean studentAdded= false;
				
				
				if(studentName.getText().equals("")|| studentSurname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All fields must be entered.");
				}else {
					
					studentAdded =sc.addNewStudent(studentNames, studentSurnames);
					
					if(studentAdded) {
						String[] studentSplit;
						List<String> studentList = sc.getAllStudents();
						DefaultTableModel tables = (DefaultTableModel)studentTable.getModel();
					
						if(studentList != null) {
							tables.setRowCount(0);
							for (String subject : studentList) {
								studentSplit = subject.split(", ");
							
								tables.addRow(studentSplit);
							}
						}
						else JOptionPane.showMessageDialog(null, "There is no students.");
						
						JOptionPane.showMessageDialog(null, "Student was added.");
						studentName.setText("");
						studentSurname.setText("");
					}else JOptionPane.showMessageDialog(null, "Student was NOT added.");
				
				}
							
			}
		});
		updateStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean updated = false;
				int redBr = studentTable.getSelectedRow();
				
				if (redBr == -1) {
					JOptionPane.showMessageDialog(null, "You must select a row!");
				}
				else{
					String studentNames = (String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 1);
					String studentSurnames = (String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 2);
					int id = Integer.parseInt((String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 0));
					updated = sc.updateStudent(id, studentNames, studentSurnames);			
				}
				
				try {
				
		
				
				if(updated) {
					JOptionPane.showMessageDialog(null, "Student has been updated.");
					
					
					String[] studentSplit;
					List<String> studentList = sc.getAllStudents();
					DefaultTableModel tables = (DefaultTableModel)studentTable.getModel();
				
					if(studentList != null) {
						tables.setRowCount(0);
						for (String student : studentList) {
							studentSplit = student.split(", ");
						
							tables.addRow(studentSplit);
						}
					}
					else JOptionPane.showMessageDialog(null, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}catch (Exception e4) {
				JOptionPane.showMessageDialog(null, "Something went wrong try again !");
			}
		
			
			}
		});
//		
//		
//		
//		Professor to Subject Admin
//		
//		
//		
		profToSubjBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
	
				profesorPanel.setVisible(false);
				studentPanel.setVisible(false);
				studToSubjPanel.setVisible(false);
				profToSubjPanel.setVisible(true);
				subjectPanel.setVisible(false);
				
				StringBuilder sb = new StringBuilder();
				pc.getProfessorsIDNameAndSurname().forEach(t -> sb.append(t+","));
				String prof = sb.toString();
				String [] professors = prof.split(",");
				professorBoxMenu.setModel(new DefaultComboBoxModel(professors));
				
				StringBuilder sb2 = new StringBuilder();
				kc.getSubjectIDandName().forEach(t -> sb2.append(t +","));
				String subj = sb2.toString();
				String[] subjects = subj.split(",");
				subjectBoxMenu.setModel(new DefaultComboBoxModel(subjects));
				
				String[] profToSubjSplit;
				List<String> profToSubjList = pts.getAll();		
				DefaultTableModel tables = (DefaultTableModel)profToSubjTable.getModel();
				
				
			
				if(profToSubjList != null) {
					tables.setRowCount(0);
					for (String ss : profToSubjList) {
						profToSubjSplit = ss.split(", ");
						
						tables.addRow(profToSubjSplit);
					}
				}
				else JOptionPane.showMessageDialog(null, "There is no students or has been error.");
				
			}
		});
	
		assignProfToSubj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String [] professor = professorBoxMenu.getSelectedItem().toString().split(" ");
				String [] subject = subjectBoxMenu.getSelectedItem().toString().split(" ");
			
				boolean assigned = pts.assignProfToSubj(Integer.parseInt(professor[0]), Integer.parseInt(subject[0]));
				
				if(assigned) {
					
					JOptionPane.showMessageDialog(null, "Professor assinged to subject.");
					String[] profToSubjSplit;
					List<String> profToSubjList = pts.getAll();		
					DefaultTableModel tables = (DefaultTableModel)profToSubjTable.getModel();
				
					if(profToSubjList != null) {
						tables.setRowCount(0);
						for (String ss : profToSubjList) {
							profToSubjSplit = ss.split(", ");
						
							tables.addRow(profToSubjSplit);
						}
					}
					else JOptionPane.showMessageDialog(null, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}
		});
		
//		
//		
//		
//		Student to Subject Admin
//		
//		
//		
		studToSubjBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
	
				profesorPanel.setVisible(false);
				studentPanel.setVisible(false);
				studToSubjPanel.setVisible(true);
				profToSubjPanel.setVisible(false);
				subjectPanel.setVisible(false);
				
				StringBuilder sb = new StringBuilder();
				sc.getStudentsIDNameAndSurname().forEach(t -> sb.append(t+","));
				String stud = sb.toString();
				String [] students = stud.split(",");
				studentBoxMenu.setModel(new DefaultComboBoxModel(students));
				
				StringBuilder sb2 = new StringBuilder();
				kc.getSubjectIDandName().forEach(t -> sb2.append(t +","));
				String subj = sb2.toString();
				String[] subjects = subj.split(",");
				subjectBoxMenu1.setModel(new DefaultComboBoxModel(subjects));
				
				String[] studToSubjSplit;
				List<String> studToSubjList = sts.getAll();		
				DefaultTableModel tables = (DefaultTableModel)studToSubjTable.getModel();
			
				if(studToSubjList != null) {
					tables.setRowCount(0);
					for (String ss : studToSubjList) {
						studToSubjSplit = ss.split(", ");
					
						tables.addRow(studToSubjSplit);
					}
				}
				else JOptionPane.showMessageDialog(null, "There is no students or has been error.");
				
			}
		});
	
		assignStudToSubj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String [] student = studentBoxMenu.getSelectedItem().toString().split(" ");
				String [] subject = subjectBoxMenu1.getSelectedItem().toString().split(" ");
			
				boolean assigned = sts.assignStudToSubj(Integer.parseInt(student[0]), Integer.parseInt(subject[0]));
				
				if(assigned) {
					
					JOptionPane.showMessageDialog(null, "Student assinged to subject.");
					String[] studToSubjSplit;
					List<String> studToSubjList = sts.getAll();		
					DefaultTableModel tables = (DefaultTableModel)studToSubjTable.getModel();
				
					if(studToSubjList != null) {
						tables.setRowCount(0);
						for (String ss : studToSubjList) {
							studToSubjSplit = ss.split(", ");
						
							tables.addRow(studToSubjSplit);
						}
					}
					else JOptionPane.showMessageDialog(null, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}
		});
		

	}
}
