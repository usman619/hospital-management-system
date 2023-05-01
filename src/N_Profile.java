import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class N_Profile extends JFrame {

	private JPanel contentPane;
	private DMS dms;
	private Input input;
	private Output output;
	public String N_U;
	private mainLogin L;
	private String P_U;
	private String D_U;
	private int fees;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public N_Profile(String user) throws SQLException 
	{
		N_U = user;
		dms = new DMS();
		input = new Input();
		output = new Output();
		L = new mainLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		Connection C = DriverManager.getConnection(dbURL);
		
		String sql = "SELECT * FROM Nurse";
		
		Statement s = C.createStatement();
		
		String N = dms.getName(N_U, sql, s);
		
		String CNIC = dms.getCNIC(N_U, sql, s);
		
		int Age = dms.getAge(N_U, sql, s);
		
		String Gender = dms.getGender(N_U, sql, s);
		
		JLabel lblWelcomeNurse = new JLabel("Welcome " + N);
		lblWelcomeNurse.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblWelcomeNurse.setBounds(227, 11, 354, 55);
		contentPane.add(lblWelcomeNurse);
		
		JButton btnViewDoctorInfo = new JButton("View Doctor Info");
		btnViewDoctorInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Display Doctor's Info
				D_U = input.Input_GUI("Enter Doctor's ID/Username: ");
				String sql1 = "SELECT * FROM Doctor";
				dms.searchUser(D_U, sql1, s);
			}
		});
		btnViewDoctorInfo.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnViewDoctorInfo.setBounds(282, 341, 220, 45);
		contentPane.add(btnViewDoctorInfo);
		
		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Check Doctor's Availablitiy
				D_U = input.Input_GUI("Enter Doctor's ID/Username: ");
				String sql1 = "SELECT * FROM Doctor";
				String A = dms.checkDoctorAvailability(D_U, sql1, s);
				output.Output_GUI(A);
				
			}
		});
		btnCheckAvailability.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnCheckAvailability.setBounds(282, 396, 220, 45);
		contentPane.add(btnCheckAvailability);
		
		JLabel lblName = new JLabel("Name:  " + N);
		lblName.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblName.setBounds(62, 99, 440, 35);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:  " + CNIC);
		lblCnic.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblCnic.setBounds(62, 132, 417, 35);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:  " + Age);
		lblAge.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblAge.setBounds(62, 164, 130, 35);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:  " + Gender);
		lblGender.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblGender.setBounds(62, 193, 262, 35);
		contentPane.add(lblGender);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(40, 264, 675, 18);
		contentPane.add(separator_2);
		
		JButton btnViewPatientInfo = new JButton("View Patient Info");
		btnViewPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				P_U = JOptionPane.showInputDialog("Enter Patient ID/Username: ");
				String sql1 = "SELECT * FROM Patient";
				dms.searchPatient(P_U, sql1, s);
			}
		});
		btnViewPatientInfo.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnViewPatientInfo.setBounds(282, 284, 220, 47);
		contentPane.add(btnViewPatientInfo);
		
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
		btnSignOut.setBounds(641, 11, 130, 35);
		contentPane.add(btnSignOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 93, 675, 18);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 57, 675, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(286, 63, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblAction = new JLabel("Actions");
		lblAction.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblAction.setBounds(330, 232, 104, 32);
		contentPane.add(lblAction);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(40, 223, 675, 18);
		contentPane.add(separator_2_1);
		
		JButton btnLabReport_1 = new JButton("Pre-Assessment");
		btnLabReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Performing Pre Assessment and updating invoice
				P_U = input.Input_GUI("Enter Patient's Username: ");
				String sql1 = "SELECT * FROM Patient";
				String p = dms.getName(P_U, sql1, s);
				output.Output_GUI("----------PERFORMING PRE ASSESSMENT CHECKUP ON "+p+"----------");
				
				fees = dms.getInvoiceTotal(P_U, sql1, s) + 200;
				String sql3 = "UPDATE Patient SET InvoiceTotal ='"+fees+"' WHERE Username LIKE '"+P_U+"'";
				try {
					dms.insertPatientInvoice(P_U, fees, sql1, sql3, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLabReport_1.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnLabReport_1.setBounds(282, 451, 220, 45);
		contentPane.add(btnLabReport_1);
	}

}