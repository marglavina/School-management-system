package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.StudentController;
import controller.UserController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {
	//GUI
	private JFrame frame;
	private JTextField username;
	private JTextField password;

	//private
	private int windowH;
	private int windowW;
	
	//public
	public UserController uc;
	public AdminPanel adminP;
	public StudentController sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Studis Web");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(168, 42, 222, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(99, 153, 93, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(99, 187, 93, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 11));
		username.setBounds(202, 154, 190, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(202, 188, 188, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		loginBtn.setBounds(300, 233, 89, 23);
		frame.getContentPane().add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean check = false;
				
				String usernames = username.getText().toString();
				String passwords = password.getText().toString();
				
				if(username.getText().equals("admin")&&password.getText().equals("admin")){
					frame.dispose();
					adminP.main(null);
				}
				else if(!usernames.equals("")&&!passwords.equals("")){
					uc = new UserController();
					check = uc.checkUserAndPass(usernames,passwords);
				}else if(usernames.equals("")||passwords.equals("")){
					JOptionPane.showMessageDialog(frame, "All fiealds must be entered.");
				}
				
				if(check) {
					
					
					StudentPanel sp = new StudentPanel();
					sc = new StudentController();
					sp.UpdateStudentPanel(sc.getStudentInfobyUsername(usernames));
					sp.setVisible(true);
					frame.dispose();
					
					
				}else {
					JOptionPane.showMessageDialog(frame, "Wrong username or password.");
					
				}
					
			}
		});
		
	}
}
