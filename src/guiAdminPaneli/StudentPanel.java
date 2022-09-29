package guiAdminPaneli;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class StudentPanel extends JPanel {
	private JTextField studentName;
	private JTextField studentSurname;
	private JTable studentTable;
	private JScrollPane scrollPane;
	private JButton updateStudentBtn;
	private JButton backStudentBtn;

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(28, 43, 95, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(28, 82, 95, 25);
		add(lblNewLabel_1);
		
		studentName = new JTextField();
		studentName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentName.setBounds(133, 45, 132, 20);
		add(studentName);
		studentName.setColumns(10);
		
		studentSurname = new JTextField();
		studentSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		studentSurname.setBounds(133, 84, 132, 20);
		add(studentSurname);
		studentSurname.setColumns(10);
		
		JButton addStudentBtn = new JButton("Submit");
		addStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addStudentBtn.setBounds(176, 123, 89, 23);
		add(addStudentBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 284, 545, 242);
		add(scrollPane);
		
		studentTable = new JTable();
		scrollPane.setViewportView(studentTable);
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Surname", "Username", "Password"
			}
		));
		
		updateStudentBtn = new JButton("Update");
		updateStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		updateStudentBtn.setBounds(466, 251, 89, 23);
		add(updateStudentBtn);
		
		backStudentBtn = new JButton("Back");
		backStudentBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backStudentBtn.setBounds(480, 25, 63, 23);
		add(backStudentBtn);

	}
}
