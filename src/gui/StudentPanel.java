package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StudentController;
import javax.swing.JTextField;

public class StudentPanel extends JFrame {

	private JPanel contentPane;
	
	public StudentController sc;
	private JTextField name;
	private JTextField surname;
	private JTextField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPanel frame = new StudentPanel();
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
	public StudentPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(41, 44, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(41, 87, 86, 20);
		contentPane.add(surname);
		surname.setColumns(10);
		
		password = new JTextField();
		password.setBounds(41, 171, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		username = new JTextField();
		username.setBounds(41, 129, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		
		
	}
	public void UpdateStudentPanel(List<String> studentInfo) {
		
		String[] splitStudentInfo = new String[4];
		
		for(String info : studentInfo) {
			splitStudentInfo = info.split(", ");			
		}
		
		name.setText(splitStudentInfo[0]);
		surname.setText(splitStudentInfo[1]);
		username.setText(splitStudentInfo[2]);
		password.setText(splitStudentInfo[3]);
		
		
		
	}
}
