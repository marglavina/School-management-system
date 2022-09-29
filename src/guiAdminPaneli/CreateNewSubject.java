package guiAdminPaneli;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CreateNewSubject extends JPanel {
	private JTextField sujbectName;
	private JTextField uniqueSubjectName;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CreateNewSubject() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of Subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(32, 64, 95, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Year of a subject");
		lblNewLabel_1.setBounds(32, 113, 95, 14);
		add(lblNewLabel_1);
		
		sujbectName = new JTextField();
		sujbectName.setBounds(148, 61, 160, 20);
		add(sujbectName);
		sujbectName.setColumns(10);
		
		JButton subjectSubmitNew = new JButton("Submit subject");
		subjectSubmitNew.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectSubmitNew.setBounds(32, 187, 113, 23);
		add(subjectSubmitNew);
		
		JLabel lblNewLabel_32 = new JLabel("Unique name");
		lblNewLabel_32.setBounds(32, 157, 95, 14);
		add(lblNewLabel_32);
		
		uniqueSubjectName = new JTextField();
		uniqueSubjectName.setBounds(149, 154, 159, 20);
		add(uniqueSubjectName);
		uniqueSubjectName.setColumns(10);
		
		JComboBox yearOfSubject = new JComboBox();
		yearOfSubject.setModel(new DefaultComboBoxModel(new String[] {"First year", "Second year", "Third year", "Fourth year", "Fifth year"}));
		yearOfSubject.setBounds(150, 109, 160, 22);
		add(yearOfSubject);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 269, 621, 236);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name of subject", "Year of subject", "Unique Subject Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton subjectBackBtn = new JButton("Back");
		subjectBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		subjectBackBtn.setBounds(552, 32, 89, 23);
		add(subjectBackBtn);
		
		JButton updateSubjectBtn = new JButton("Update subject");
		updateSubjectBtn.setBounds(533, 235, 113, 23);
		add(updateSubjectBtn);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setPreferredWidth(116);
		
		

	}
}
