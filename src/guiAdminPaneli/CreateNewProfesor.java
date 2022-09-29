package guiAdminPaneli;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateNewProfesor extends JPanel {
	private JTextField profesorName;
	private JTextField profesorSurname;

	/**
	 * Create the panel.
	 */
	public CreateNewProfesor() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(51, 60, 88, 28);
		add(lblNewLabel);
		
		profesorName = new JTextField();
		profesorName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profesorName.setBounds(149, 60, 204, 28);
		add(profesorName);
		profesorName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(51, 124, 88, 28);
		add(lblNewLabel_1);
		
		profesorSurname = new JTextField();
		profesorSurname.setBounds(149, 124, 204, 28);
		add(profesorSurname);
		profesorSurname.setColumns(10);
		
		JButton newProfesorBtn = new JButton("Submit");
		newProfesorBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		newProfesorBtn.setBounds(264, 163, 89, 23);
		add(newProfesorBtn);

	}
}
