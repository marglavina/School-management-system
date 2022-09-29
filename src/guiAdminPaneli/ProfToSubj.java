package guiAdminPaneli;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ProfToSubj extends JPanel {
	private JTable profToSubj;

	/**
	 * Create the panel.
	 */
	public ProfToSubj() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 643, 272);
		add(scrollPane);
		
		profToSubj = new JTable();
		scrollPane.setViewportView(profToSubj);
		profToSubj.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Professor Name", "Subject", "No. Students"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Assign proffesor to subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 33, 263, 32);
		add(lblNewLabel);
		
		JButton profToSubjBackBtn = new JButton("Back");
		profToSubjBackBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		profToSubjBackBtn.setBounds(564, 23, 89, 23);
		add(profToSubjBackBtn);
		
		JComboBox professorBoxMenu = new JComboBox();
		professorBoxMenu.setBounds(148, 89, 130, 23);
		add(professorBoxMenu);
		
		JLabel adsfasd = new JLabel("Professor");
		adsfasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adsfasd.setBounds(23, 93, 115, 14);
		add(adsfasd);
		
		JLabel adasdasdasdasdasd = new JLabel("Subject");
		adasdasdasdasdasd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		adasdasdasdasdasd.setBounds(23, 135, 115, 14);
		add(adasdasdasdasdasd);
		
		JComboBox subjectBoxMenu = new JComboBox();
		subjectBoxMenu.setBounds(148, 132, 130, 21);
		add(subjectBoxMenu);
		
		JButton assignProfToSubj = new JButton("Assign");
		assignProfToSubj.setBounds(191, 175, 89, 23);
		add(assignProfToSubj);
		profToSubj.getColumnModel().getColumn(0).setPreferredWidth(93);

	}
}
