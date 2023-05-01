import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Doctors_Availaibility_Status extends JFrame {

	private JPanel contentPane;
	private String Availability;
	private DMS dms;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Doctors_Availaibility_Status(String D_U) throws SQLException 
	{
		dms = new DMS();
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		Connection C = DriverManager.getConnection(dbURL);
		Availability = " ";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkbox_YES = new JCheckBox("Yes");
		checkbox_YES.setFont(new Font("Calibri", Font.PLAIN, 20));
		checkbox_YES.setBounds(197, 96, 72, 50);
		contentPane.add(checkbox_YES);
		
		JLabel lblSelectAvailaibilityStatus = new JLabel("Select Availaibility Status");
		lblSelectAvailaibilityStatus.setFont(new Font("Calibri Light", Font.BOLD, 25));
		lblSelectAvailaibilityStatus.setBounds(149, 22, 285, 35);
		contentPane.add(lblSelectAvailaibilityStatus);
		
		JCheckBox checkbox_NO = new JCheckBox("No");
		checkbox_NO.setFont(new Font("Calibri", Font.PLAIN, 20));
		checkbox_NO.setBounds(312, 96, 72, 50);
		contentPane.add(checkbox_NO);
		
		
		JButton btnSelectChoice = new JButton("Update Availaibility Status");
		btnSelectChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(checkbox_YES.isSelected())
				{
					Availability = "YES";
				}
				else if (checkbox_NO.isSelected())
				{
					Availability = "NO";
				}
					
				String sql1 = "SELECT * FROM Doctor";
				String sql2 = "UPDATE Doctor SET Availability ='"+Availability+"' WHERE Username LIKE '"+D_U+"'";
				try {
					dms.insertDiagnoses(D_U, Availability, sql1, sql2, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectChoice.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnSelectChoice.setBounds(149, 169, 285, 35);
		contentPane.add(btnSelectChoice);
		
		JButton btnReset_1_1 = new JButton("<--");
		btnReset_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				D_Profile D;
				setVisible(false);
				try {
					D = new D_Profile(D_U);
					D.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnReset_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset_1_1.setBounds(10, 220, 80, 32);
		contentPane.add(btnReset_1_1);
	}

}
