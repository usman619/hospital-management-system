import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class D_Profile extends JFrame {

	private JPanel contentPane;
	private DMS dms;
	private Input input;
	private Output output;
	public String D_U;
	private mainLogin L;
	private String P_U;
	private int fees;
	public String Availaibility;
	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public D_Profile(String user) throws SQLException {
		D_U = user;
		dms = new DMS();
		input = new Input();
		output = new Output();
		L = new mainLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 625);;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		Connection C = DriverManager.getConnection(dbURL);
		output.displayMsg("Connected to Database!");
		
		String sql = "SELECT * FROM Doctor";
		
		Statement s = C.createStatement();
		
		String N = dms.getName(D_U, sql, s);
		
		String CNIC = dms.getCNIC(D_U, sql, s);
		
		int Age = dms.getAge(D_U, sql, s);
		
		String Gender = dms.getGender(D_U, sql, s);
		
		JLabel lblNewLabel = new JLabel("Welcome Dr."+N);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 25));
		lblNewLabel.setBounds(222, 11, 323, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Insert Diagnose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				P_U = JOptionPane.showInputDialog("Enter Patient's ID/Username: ");
				String diagnoses = JOptionPane.showInputDialog("Enter Patient's Dignoses: ");
				String sql1 = "SELECT * FROM Patient";
				String sql2 = "UPDATE Patient SET Diagnosis ='"+diagnoses+"' WHERE Username LIKE '"+P_U+"'";
				try {
					dms.insertDiagnoses(P_U, diagnoses, sql1, sql2, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnNewButton.setBounds(280, 326, 197, 35);
		contentPane.add(btnNewButton);
		
		JButton btnPrescription = new JButton("Insert Prescription");
		btnPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				P_U = JOptionPane.showInputDialog("Enter Patient's ID/Username: ");
				String prescription = JOptionPane.showInputDialog("Enter Patient's Prescription: ");
				String sql1 = "SELECT * FROM Patient";
				
				String sql2 = "UPDATE Patient SET Prescription ='"+prescription+"' WHERE Username LIKE '"+P_U+"'";
				
				try {
					dms.insertPatientPrescription(P_U, prescription, sql1, sql2, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrescription.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnPrescription.setBounds(280, 371, 197, 35);
		contentPane.add(btnPrescription);
		
		JButton btnLabReport = new JButton("Check Lab Report");
		btnLabReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sql1 = "SELECT * FROM Patient";
				P_U = JOptionPane.showInputDialog("Enter Patient's ID/Username: ");
				String L = "Lab Report: " + dms.getLabReport(P_U, sql1, s);
				output.Output_GUI(L);
			}
		});
		btnLabReport.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnLabReport.setBounds(280, 416, 197, 35);
		contentPane.add(btnLabReport);
		
		
		JLabel lblName = new JLabel("Name:  " + N);
		lblName.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblName.setBounds(50, 99, 390, 35);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:  " + CNIC);
		lblCnic.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblCnic.setBounds(50, 132, 390, 35);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:  " + Age);
		lblAge.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblAge.setBounds(50, 166, 214, 35);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:  " + Gender);
		lblGender.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblGender.setBounds(50, 203, 214, 35);
		contentPane.add(lblGender);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 265, 675, 18);
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
		btnViewPatientInfo.setBounds(280, 281, 197, 35);
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
		btnSignOut.setBounds(628, 11, 130, 36);
		contentPane.add(btnSignOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 93, 675, 18);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 57, 675, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(274, 63, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblAction = new JLabel("Actions");
		lblAction.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblAction.setBounds(336, 238, 104, 32);
		contentPane.add(lblAction);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(28, 238, 675, 18);
		contentPane.add(separator_2_1);
		
		JButton btnLabReport_1 = new JButton("Perform Opertion");
		btnLabReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				P_U = JOptionPane.showInputDialog("Enter Patient ID/Username: ");
				String sql1 = "SELECT * FROM Patient";
				String p = dms.getName(P_U, sql1, s);
				output.Output_GUI("--------------------PERFORMING OPERATION ON "+p+"--------------------");
				
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
		btnLabReport_1.setBounds(280, 461, 197, 35);
		contentPane.add(btnLabReport_1);
		
		JButton btnLabReport_1_1 = new JButton("Update Availaibility Status");
		btnLabReport_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Doctors_Availaibility_Status frame = new Doctors_Availaibility_Status(D_U);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnLabReport_1_1.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnLabReport_1_1.setBounds(252, 506, 276, 40);
		contentPane.add(btnLabReport_1_1);	
	}
}