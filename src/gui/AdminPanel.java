package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.KolegijController;
import controller.ProfToSubjController;
import controller.ProfesorController;
import controller.StudentController;
import controller.StudentToSubjController;
import model.Profesor;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Button;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class AdminPanel {

	private JFrame frame;
	private JTextField profesorName;
	private JTextField profesorSurname;
	
	ProfesorController pc = new ProfesorController();
	KolegijController kc = new KolegijController();
	StudentController sc = new StudentController();
	ProfToSubjController pts= new ProfToSubjController();
	StudentToSubjController sts = new StudentToSubjController();
	
	private JTextField yearOfSubject;
	private JTextField subjectName;
	private JTextField uniqueSubjectName;
	private JTable tableSubject;
	private JTable profesorTable;
	private JTable profToSubj;
	private JTable profToSubjTable;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPageAdmin = new JPanel();
		mainPageAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(mainPageAdmin);
		mainPageAdmin.setLayout(null);
		
		JPanel profesorAdmin = new JPanel();
		profesorAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(profesorAdmin);
		profesorAdmin.setLayout(null);
		profesorAdmin.setVisible(false);
		
		JPanel subjectAdmin = new JPanel();
		subjectAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(subjectAdmin);
		subjectAdmin.setVisible(false);
		
		JPanel studentAdmin = new JPanel();
		studentAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(studentAdmin);
		studentAdmin.setVisible(false);
		
		JPanel profToSubjAdmin = new JPanel();
		profToSubjAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(profToSubjAdmin);
		profToSubjAdmin.setLayout(null);
		profToSubjAdmin.setVisible(false);
		
		JPanel studToSubjAdmin = new JPanel();
		studToSubjAdmin.setBounds(0, 0, 646, 533);
		frame.getContentPane().add(studToSubjAdmin);
		studToSubjAdmin.setLayout(null);
		studToSubjAdmin.setVisible(false);
		
		JButton subjectBtn = new JButton("Subjects");
		subjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBtn.setBounds(10, 60, 200, 55);
		mainPageAdmin.add(subjectBtn);
		
		JButton professorsBtn = new JButton("Professors");
		professorsBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		professorsBtn.setBounds(10, 136, 200, 60);
		mainPageAdmin.add(professorsBtn);
		
		JButton studentBtn = new JButton("Students");
		studentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentBtn.setBounds(10, 219, 200, 60);
		mainPageAdmin.add(studentBtn);
		
		JButton profToSubjBtn = new JButton("Assign professor to subject");		
		profToSubjBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profToSubjBtn.setBounds(10, 303, 200, 60);
		mainPageAdmin.add(profToSubjBtn);
		
		JButton studToSubjBtn = new JButton("Assign student to subject");		
		studToSubjBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studToSubjBtn.setBounds(10, 385, 200, 60);
		mainPageAdmin.add(studToSubjBtn);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(51, 40, 88, 28);
		profesorAdmin.add(lblNewLabel);
		
		profesorName = new JTextField();
		profesorName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorName.setBounds(149, 40, 204, 28);
		profesorAdmin.add(profesorName);
		profesorName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(51, 100, 88, 28);
		profesorAdmin.add(lblNewLabel_1);
		
		profesorSurname = new JTextField();
		profesorSurname.setBounds(149, 100, 204, 28);
		profesorAdmin.add(profesorSurname);
		profesorSurname.setColumns(10);
		
		JButton newProfesorsubmitBtn = new JButton("Submit");
		newProfesorsubmitBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		newProfesorsubmitBtn.setBounds(264, 150, 89, 23);
		profesorAdmin.add(newProfesorsubmitBtn);
		
		JButton professorBackBtn = new JButton("Back");
		professorBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		professorBackBtn.setBounds(550, 30, 89, 23);
		profesorAdmin.add(professorBackBtn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 269, 572, 236);
		profesorAdmin.add(scrollPane_1);
		
		profesorTable = new JTable();
		scrollPane_1.setViewportView(profesorTable);
		profesorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "profesorName", "profesorSurname", "professorUsername", "professorPassword"
			}
		));
		profesorTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton updateProfesor = new JButton("Update");
		updateProfesor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateProfesor.setBounds(500, 230, 89, 23);
		profesorAdmin.add(updateProfesor);
		subjectAdmin.setLayout(null);
		
		JLabel lblNewLabel3 = new JLabel("Name of Subject");
		lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel3.setBounds(32, 64, 95, 14);
		subjectAdmin.add(lblNewLabel3);
		
		JLabel lblNewLabel_13 = new JLabel("Year of a subject");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13.setBounds(32, 113, 95, 14);
		subjectAdmin.add(lblNewLabel_13);
		
		subjectName = new JTextField();
		subjectName.setBounds(148, 61, 160, 20);
		subjectAdmin.add(subjectName);
		subjectName.setColumns(10);
		
		JComboBox yearOfSubject = new JComboBox();
		yearOfSubject.setFont(new Font("Tahoma", Font.PLAIN, 11));
		yearOfSubject.setModel(new DefaultComboBoxModel(new String[] {"First year", "Second year", "Third year", "Fourth year", "Fifth year"}));
		yearOfSubject.setBounds(150, 109, 160, 22);
		subjectAdmin.add(yearOfSubject);
		
		JButton subjectSubmitNew = new JButton("Submit subject");
		subjectSubmitNew.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectSubmitNew.setBounds(32, 187, 113, 23);
		subjectAdmin.add(subjectSubmitNew);
		
		JButton updateSubjectBtn = new JButton("Update subject");
		updateSubjectBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateSubjectBtn.setBounds(533, 235, 113, 23);
		subjectAdmin.add(updateSubjectBtn);
		
		JLabel lblNewLabel_32 = new JLabel("Unique name");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_32.setBounds(32, 157, 95, 14);
		subjectAdmin.add(lblNewLabel_32);
		
		uniqueSubjectName = new JTextField();
		uniqueSubjectName.setBounds(149, 154, 159, 20);
		subjectAdmin.add(uniqueSubjectName);
		uniqueSubjectName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 269, 621, 236);
		subjectAdmin.add(scrollPane);
				
		tableSubject = new JTable();
		scrollPane.setBounds(25, 269, 572, 236);
		scrollPane.setViewportView(tableSubject);
		tableSubject.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name of subject", "Year of subject", "Unique Subject Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSubject.getColumnModel().getColumn(1).setPreferredWidth(103);
		tableSubject.getColumnModel().getColumn(2).setPreferredWidth(91);
		tableSubject.getColumnModel().getColumn(3).setPreferredWidth(116);

		JButton subjectBackBtn = new JButton("Back");
		subjectBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBackBtn.setBounds(552, 32, 89, 23);
		subjectAdmin.add(subjectBackBtn);
		
		JLabel lblNewLabel123 = new JLabel("Student name");
		lblNewLabel123.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel123.setBounds(28, 43, 95, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(28, 43, 95, 25);
		studentAdmin.setLayout(null);
		studentAdmin.add(lblNewLabel123);
		
		JLabel lblNewLabel_12 = new JLabel("Student surname");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(28, 82, 95, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(28, 82, 95, 25);
		studentAdmin.add(lblNewLabel_12);
		
		JTextField studentName = new JTextField();
		studentName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentName.setBounds(133, 45, 132, 20);
		studentAdmin.add(studentName);
		studentName.setColumns(10);
		
		JTextField studentSurname = new JTextField();
		studentSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentSurname.setBounds(133, 84, 132, 20);
		studentAdmin.add(studentSurname);
		studentSurname.setColumns(10);
		
		JButton addStudentBtn = new JButton("Submit");
		addStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addStudentBtn.setBounds(176, 123, 89, 23);
		studentAdmin.add(addStudentBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 284, 610, 242);
		studentAdmin.add(scrollPane);
		
		JTable studentTable = new JTable();
		scrollPane.setViewportView(studentTable);
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Surname", "Username", "Password"
			}
		));
		
		JButton updateStudentBtn = new JButton("Update");
		updateStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateStudentBtn.setBounds(466, 251, 89, 23);
		studentAdmin.add(updateStudentBtn);
		
		JButton backStudentBtn = new JButton("Back");
		backStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backStudentBtn.setBounds(480, 25, 63, 23);
		studentAdmin.add(backStudentBtn);
		
		JLabel lblNewLabel1213 = new JLabel("Assign proffesor to subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 33, 263, 32);
		profToSubjAdmin.add(lblNewLabel1213);
		
		JButton profToSubjBackBtn = new JButton("Back");
		profToSubjBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profToSubjBackBtn.setBounds(564, 23, 89, 23);
		profToSubjAdmin.add(profToSubjBackBtn);
		
		JComboBox professorBoxMenu = new JComboBox();
		professorBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		professorBoxMenu.setBounds(148, 89, 250, 23);
		profToSubjAdmin.add(professorBoxMenu);
		
		JLabel adsfasd = new JLabel("Professor");
		adsfasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adsfasd.setBounds(23, 93, 115, 14);
		profToSubjAdmin.add(adsfasd);
		
		JLabel adasdasdasdasdasd = new JLabel("Subject");
		adasdasdasdasdasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adasdasdasdasdasd.setBounds(23, 135, 115, 14);
		profToSubjAdmin.add(adasdasdasdasdasd);
		
		JComboBox subjectBoxMenu = new JComboBox();
		subjectBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBoxMenu.setBounds(148, 132, 250, 21);
		profToSubjAdmin.add(subjectBoxMenu);
		
		JButton assignProfToSubj = new JButton("Assign");
		assignProfToSubj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		assignProfToSubj.setBounds(191, 175, 89, 23);
		profToSubjAdmin.add(assignProfToSubj);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 284, 610, 242);
		profToSubjAdmin.add(scrollPane_2);
		
		JTable profToSubjTable = new JTable();
		scrollPane_2.setViewportView(profToSubjTable);
		profToSubjTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Professor Name", "Subject", "No. Students"
				}
			));
		
		JLabel lblNewLabel121323 = new JLabel("Assign student to subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 33, 263, 32);
		studToSubjAdmin.add(lblNewLabel121323);
		
		JButton studToSubjBackBtn = new JButton("Back");
		profToSubjBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profToSubjBackBtn.setBounds(564, 23, 89, 23);
		profToSubjAdmin.add(profToSubjBackBtn);
		
		JComboBox studentBoxMenu = new JComboBox();
		studentBoxMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentBoxMenu.setBounds(148, 89, 250, 23);
		studToSubjAdmin.add(studentBoxMenu);
		
		JLabel adsfasd1 = new JLabel("Student");
		adsfasd1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adsfasd1.setBounds(23, 93, 115, 14);
		studToSubjAdmin.add(adsfasd1);
		
		JLabel adasdasdasdasdasd1 = new JLabel("Subject");
		adasdasdasdasdasd1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adasdasdasdasdasd1.setBounds(23, 135, 115, 14);
		studToSubjAdmin.add(adasdasdasdasdasd1);
		
		JComboBox subjectBoxMenu1 = new JComboBox();
		subjectBoxMenu1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBoxMenu1.setBounds(148, 132, 250, 21);
		studToSubjAdmin.add(subjectBoxMenu1);
		
		JButton assignStudToSubj = new JButton("Assign");
		assignStudToSubj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		assignStudToSubj.setBounds(191, 175, 89, 23);
		studToSubjAdmin.add(assignStudToSubj);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 284, 610, 242);
		studToSubjAdmin.add(scrollPane_3);
		
		JTable studToSubjTable = new JTable();
		scrollPane_3.setViewportView(studToSubjTable);
		studToSubjTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Student Name", "Subject"
				}
			));
		
		JButton sTsBackBtn = new JButton("Back");
		sTsBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sTsBackBtn.setBounds(564, 23, 89, 23);
		studToSubjAdmin.add(sTsBackBtn);
//		
//		
//		
//		Subject Admin
//		
//		
//
		subjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPageAdmin.setVisible(false);
				profesorAdmin.setVisible(false);
				subjectAdmin.setVisible(true);
				
				String[] subjectSplit;
				List<String> subjectList = kc.getAllSubjects();
				DefaultTableModel tables = (DefaultTableModel)tableSubject.getModel();
				
				if(subjectList != null) {
					tables.setRowCount(0);
					for (String subject : subjectList) {
						subjectSplit = subject.split(", ");
						
						tables.addRow(subjectSplit);
					}
				}
				else JOptionPane.showMessageDialog(frame, "There is no subject or has been error.");
				
			}
		});
		
		//Button event for creating new subject
		subjectSubmitNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int yearOfSubjectindex = yearOfSubject.getSelectedIndex()+1;
				String subjectNames = subjectName.getText();
				String uniqueSubjectNames = uniqueSubjectName.getText();
				boolean inserted = false;
				
				if(uniqueSubjectName.getText().length()>5)
				{
					JOptionPane.showMessageDialog(frame, "Unique subject name must be max 5 characters.");	
					
				}
				else {
					if((!subjectName.getText().equals("")) && 
						((yearOfSubjectindex>=1) && (yearOfSubjectindex<=5)) && 
						(!uniqueSubjectName.getText().equals("")) &&
						(uniqueSubjectName.getText().length()<=5))				
					{			
					 inserted = kc.createNewSubject(subjectNames, yearOfSubjectindex, uniqueSubjectNames);
					 
					 if(inserted) {
							JOptionPane.showMessageDialog(frame, "Subject has been added.");
						
							String[] subjectSplit;
							List<String> subjectList = kc.getAllSubjects();
							DefaultTableModel tables = (DefaultTableModel)tableSubject.getModel();
						
							if(subjectList != null) {
								tables.setRowCount(0);
								for (String subject : subjectList) {
									subjectSplit = subject.split(", ");
								
									tables.addRow(subjectSplit);
								}
							}
							else JOptionPane.showMessageDialog(frame, "There is no subject or has been error.");
						
							subjectName.setText("");
							uniqueSubjectName.setText("");
							inserted = false;
							yearOfSubject.setSelectedIndex(0);
						
						}else JOptionPane.showMessageDialog(frame, "Subject has not been added.");
					 
					}
					else{
						JOptionPane.showMessageDialog(frame, "All fields are requered.");
					}
				
									
				}
			}
		});
		
		//Updating Subject with table edit
		updateSubjectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean updated = false;
				
				int redBr = tableSubject.getSelectedRow();
				
						
						
				if (redBr < 1) {
					JOptionPane.showMessageDialog(null, "You must select a row!");
				}else	
				{
					int id = Integer.parseInt((String)tableSubject.getModel().getValueAt(tableSubject.getSelectedRow(), 0));
					String subjectName = (String)tableSubject.getModel().getValueAt(tableSubject.getSelectedRow(), 1);
					int yearOfSubject = Integer.parseInt((String)tableSubject.getModel().getValueAt(tableSubject.getSelectedRow(), 2));
					String uniqueSubjectName = (String)tableSubject.getModel().getValueAt(tableSubject.getSelectedRow(), 3);
					updated = kc.updateSubject(id, subjectName, yearOfSubject, uniqueSubjectName);
							
				}
		
				
				if(updated) {
					JOptionPane.showMessageDialog(null, "Subject has been updated.");
					
					
					String[] subjectSplit;
					List<String> subjectList = kc.getAllSubjects();
					DefaultTableModel tables = (DefaultTableModel)tableSubject.getModel();
				
					if(subjectList != null) {
						tables.setRowCount(0);
						for (String subject : subjectList) {
							subjectSplit = subject.split(", ");
						
							tables.addRow(subjectSplit);
						}
					}
					else JOptionPane.showMessageDialog(frame, "There is no subject or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Subject has not been updated.");
				}
				
			}
		});
		
		subjectBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectName.setText("");
				uniqueSubjectName.setText("");
				yearOfSubject.setSelectedIndex(0);
				
				subjectAdmin.setVisible(false);
				mainPageAdmin.setVisible(true);
				
				
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
				
				mainPageAdmin.setVisible(false);
				profesorAdmin.setVisible(true);
				
				String[] professorSplit;
				List<String> professorList = pc.getAllProfessors();
				DefaultTableModel tables = (DefaultTableModel)profesorTable.getModel();
			
				if(professorList != null) {
					tables.setRowCount(0);
					for (String subject : professorList) {
						professorSplit = subject.split(", ");
					
						tables.addRow(professorSplit);
					}
				}
				else JOptionPane.showMessageDialog(frame, "There is no professors.");
								
			}
		});
		
		newProfesorsubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[]profesorNames = profesorName.getText().toCharArray();
				String profesorSurnames = profesorSurname.getText();
				boolean profesorAdded= false;
				
				
				if(profesorName.getText().equals("")|| profesorSurname.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "All fields must be entered.");
				}else {
					
					profesorAdded =pc.addNewProfesor(profesorNames, profesorSurnames);
					
					if(profesorAdded) {
						String[] professorSplit;
						List<String> professorList = pc.getAllProfessors();
						DefaultTableModel tables = (DefaultTableModel)profesorTable.getModel();
					
						if(professorList != null) {
							tables.setRowCount(0);
							for (String subject : professorList) {
								professorSplit = subject.split(", ");
							
								tables.addRow(professorSplit);
							}
						}
						else JOptionPane.showMessageDialog(frame, "There is no professors.");
						
						JOptionPane.showMessageDialog(frame, "Professor was added.");
						profesorName.setText("");
						profesorSurname.setText("");
					}else JOptionPane.showMessageDialog(frame, "Professor was NOT added.");
				
				}
			}
		});
		
		professorBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				profesorName.setText("");
				profesorSurname.setText("");
				
				profesorAdmin.setVisible(false);
				mainPageAdmin.setVisible(true);
				
			}
		});
		
		updateProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean updated = false;
				int redBr = profesorTable.getSelectedRow();
				
				if (redBr == -1) {
					JOptionPane.showMessageDialog(frame, "You must select a row!");
				}
				else{
					String profesorName = (String)profesorTable.getModel().getValueAt(profesorTable.getSelectedRow(), 1);
					String profesorSurname = (String)profesorTable.getModel().getValueAt(profesorTable.getSelectedRow(), 2);
					int id = Integer.parseInt((String)profesorTable.getModel().getValueAt(profesorTable.getSelectedRow(), 0));
					updated = pc.updateProfesor(id, profesorName, profesorSurname);			
				}
				
				try {
				
		
				
				if(updated) {
					JOptionPane.showMessageDialog(null, "Profesor has been updated.");
					
					
					String[] profesorSplit;
					List<String> profesorList = pc.getAllProfessors();
					DefaultTableModel tables = (DefaultTableModel)profesorTable.getModel();
				
					if(profesorList != null) {
						tables.setRowCount(0);
						for (String profesor : profesorList) {
							profesorSplit = profesor.split(", ");
						
							tables.addRow(profesorSplit);
						}
					}
					else JOptionPane.showMessageDialog(frame, "There is no professors or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Professor has not been updated.");
				}
			}catch (Exception e4) {
				JOptionPane.showMessageDialog(frame, "Something went wrong try again !");
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
				
				mainPageAdmin.setVisible(false);
				studentAdmin.setVisible(true);
				
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
				else JOptionPane.showMessageDialog(frame, "There is no students.");
			}
		});
		backStudentBtn.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				mainPageAdmin.setVisible(true);
				studentAdmin.setVisible(false);
				studentName.setText("");
				studentSurname.setText("");
				DefaultTableModel tables = (DefaultTableModel)studentTable.getModel();
				tables.setRowCount(0);
			}

			
		});
		
		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[]studentNames = studentName.getText().toCharArray();
				String studentSurnames = studentSurname.getText();
				boolean studentAdded= false;
				
				
				if(studentName.getText().equals("")|| studentSurname.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "All fields must be entered.");
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
						else JOptionPane.showMessageDialog(frame, "There is no students.");
						
						JOptionPane.showMessageDialog(frame, "Student was added.");
						studentName.setText("");
						studentSurname.setText("");
					}else JOptionPane.showMessageDialog(frame, "Student was NOT added.");
				
				}
							
			}
		});
		updateStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean updated = false;
				int redBr = studentTable.getSelectedRow();
				
				if (redBr == -1) {
					JOptionPane.showMessageDialog(frame, "You must select a row!");
				}
				else{
					String studentName = (String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 1);
					String studentSurname = (String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 2);
					int id = Integer.parseInt((String)studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 0));
					updated = sc.updateStudent(id, studentName, studentSurname);			
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
					else JOptionPane.showMessageDialog(frame, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}catch (Exception e4) {
				JOptionPane.showMessageDialog(frame, "Something went wrong try again !");
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
	
				mainPageAdmin.setVisible(false);
				profToSubjAdmin.setVisible(true);
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
				else JOptionPane.showMessageDialog(frame, "There is no students or has been error.");
				
			}
		});
	
		assignProfToSubj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String [] professor = professorBoxMenu.getSelectedItem().toString().split(" ");
				String [] subject = subjectBoxMenu.getSelectedItem().toString().split(" ");
			
				boolean assigned = pts.assignProfToSubj(Integer.parseInt(professor[0]), Integer.parseInt(subject[0]));
				
				if(assigned) {
					
					JOptionPane.showMessageDialog(frame, "Professor assinged to subject.");
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
					else JOptionPane.showMessageDialog(frame, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}
		});
		
		profToSubjBackBtn.addActionListener(new ActionListener() { 
			public void actionPerformed (ActionEvent e) {
				DefaultTableModel tables = (DefaultTableModel)profToSubjTable.getModel();
				tables.setRowCount(0);
				mainPageAdmin.setVisible(true);
				profToSubjAdmin.setVisible(false);				
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
	
				mainPageAdmin.setVisible(false);
				studToSubjAdmin.setVisible(true);
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
				else JOptionPane.showMessageDialog(frame, "There is no students or has been error.");
				
			}
		});
	
		assignStudToSubj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String [] student = studentBoxMenu.getSelectedItem().toString().split(" ");
				String [] subject = subjectBoxMenu1.getSelectedItem().toString().split(" ");
			
				boolean assigned = sts.assignStudToSubj(Integer.parseInt(student[0]), Integer.parseInt(subject[0]));
				
				if(assigned) {
					
					JOptionPane.showMessageDialog(frame, "Student assinged to subject.");
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
					else JOptionPane.showMessageDialog(frame, "There is no students or has been error.");
					
				}else {
					JOptionPane.showMessageDialog(null, "Student has not been updated.");
				}
			}
		});
		
		sTsBackBtn.addActionListener(new ActionListener() { 
			public void actionPerformed (ActionEvent e) {
				DefaultTableModel tables = (DefaultTableModel)studToSubjTable.getModel();
				tables.setRowCount(0);
				mainPageAdmin.setVisible(true);
				studToSubjAdmin.setVisible(false);				
			}
		});
		
		
		profToSubjBackBtn.addActionListener(new ActionListener() { 
			public void actionPerformed (ActionEvent e) {
				DefaultTableModel tables = (DefaultTableModel)profToSubjTable.getModel();
				tables.setRowCount(0);
				mainPageAdmin.setVisible(true);
				profToSubjAdmin.setVisible(false);				
			}
		});
	}
}
