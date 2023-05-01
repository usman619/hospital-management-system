import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class R_Profile extends JFrame {

	private JPanel contentPane;
	private String R_U;
	private String P_U;
	private DMS dms;
	private Input input;
	private Output output;
	private mainLogin L;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public R_Profile(String user) throws SQLException
	{
		R_U = user;
		dms = new DMS();
		input = new Input();
		output = new Output();
		L = new mainLogin();
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb"; //Connecting to Database
		Connection C = DriverManager.getConnection(dbURL);
		output.displayMsg("Connected to Database!");
		
		String sql = " ";
		
		Statement s = C.createStatement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplayAllDoctors = new JButton("Display All Doctors");
		btnDisplayAllDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sql = "SELECT * FROM Doctor";
				dms.printDoctor(sql, s);
			}
		});
		btnDisplayAllDoctors.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDisplayAllDoctors.setBounds(297, 199, 269, 35);
		contentPane.add(btnDisplayAllDoctors);
		
		JButton btnDisplayAllNurses = new JButton("Display All Nurses");
		btnDisplayAllNurses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sql = "SELECT * FROM Nurse";
				dms.printNurse(sql, s);
			}
		});
		btnDisplayAllNurses.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDisplayAllNurses.setBounds(297, 245, 269, 35);
		contentPane.add(btnDisplayAllNurses);
		
		JButton btnDisplayAllLab = new JButton("Display All Lab Assistants");
		btnDisplayAllLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String sql = "SELECT * FROM LabAssistant";
				dms.printLabAssistant(sql, s);
			}
		});
		btnDisplayAllLab.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDisplayAllLab.setBounds(297, 291, 269, 35);
		contentPane.add(btnDisplayAllLab);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(49, 129, 675, 18);
		contentPane.add(separator_2);
		
		JButton btnDisplayAllPatients = new JButton(" Display All Patients");
		btnDisplayAllPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sql = "SELECT * FROM Patient";
				dms.printPatient(sql, s);
			}
		});
		btnDisplayAllPatients.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDisplayAllPatients.setBounds(297, 153, 269, 35);
		contentPane.add(btnDisplayAllPatients);
		
		JLabel lblActions = new JLabel("ACTIONS");
		lblActions.setFont(new Font("Calibri Light", Font.BOLD, 25));
		lblActions.setBounds(359, 86, 104, 32);
		contentPane.add(lblActions);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(49, 77, 675, 18);
		contentPane.add(separator_2_1);
		
		JButton btnDisplayAllPharmacists = new JButton("Display All Pharmacists");
		btnDisplayAllPharmacists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sql = "SELECT * FROM Pharmacist";
				dms.printPharmacist(sql, s);
			}
		});
		btnDisplayAllPharmacists.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDisplayAllPharmacists.setBounds(297, 337, 269, 35);
		contentPane.add(btnDisplayAllPharmacists);
		
		JButton btnRegisterAPatient = new JButton("Register a Patient");
		btnRegisterAPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Register Patient
				setVisible(false);
				P_Register_R P = new P_Register_R();
				P.setVisible(true);
				
			}
		});
		btnRegisterAPatient.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnRegisterAPatient.setBounds(297, 383, 269, 35);
		contentPane.add(btnRegisterAPatient);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Administrator");
		lblWelcomeAdmin.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblWelcomeAdmin.setBounds(253, 27, 313, 55);
		contentPane.add(lblWelcomeAdmin);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frmLoginSystem = new JFrame("Sign Out");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want Log-out", "Sign-Out", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					mainLogin L;
					setVisible(false);
					try {
						L = new mainLogin();
						L.setVisible(true);
					} catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSignOut.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnSignOut.setBounds(647, 11, 122, 35);
		contentPane.add(btnSignOut);
		
		JButton btnDeletingRecordFrom = new JButton("Deleting Record ");
		btnDeletingRecordFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String dbURL = "jdbc:ucanaccess://HMS_DB.accdb"; //Connecting to Database
				Connection C;
				try {
					C = DriverManager.getConnection(dbURL);
					String table = input.Input_GUI("Enter the name of the database that you want to delete the record from? ");
					P_U = input.Input_GUI("Enter ID of the record: ");
					dms.deleteAccount(P_U, table, C);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
			}
		});
		btnDeletingRecordFrom.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnDeletingRecordFrom.setBounds(297, 428, 269, 35);
		contentPane.add(btnDeletingRecordFrom);
	}
}