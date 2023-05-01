import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class P_Profile extends JFrame {

	private JPanel contentPane;
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
	public P_Profile(String user) throws SQLException 
	{
		P_U = user;
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
		output.displayMsg("Connected to Database!");
		
		String sql = "SELECT * FROM Patient";
		
		Statement s = C.createStatement();
		
		String N = dms.getName(P_U, sql, s);
		
		String CNIC = dms.getCNIC(P_U, sql, s);
		
		int Age = dms.getAge(P_U, sql, s);
		
		String Gender = dms.getGender(P_U, sql, s);
		
		JLabel lblWelcomePatient = new JLabel("Welcome " + N);
		lblWelcomePatient.setFont(new Font("Calibri Light", Font.BOLD, 28));
		lblWelcomePatient.setBounds(267, 20, 400, 55);
		contentPane.add(lblWelcomePatient);
		
		JButton btnPrescription = new JButton("View Prescription");
		btnPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String prescription = "Prescription:  " + dms.getPrescription(P_U, sql, s);
				output.Output_GUI(prescription);
			}
		});
		btnPrescription.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnPrescription.setBounds(271, 312, 228, 35);
		contentPane.add(btnPrescription);
		
		JButton btnInvoiceTotal = new JButton("View Invoice Total");
		btnInvoiceTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String InvoiceTotal = "Invoice Total:  " + dms.getInvoiceTotal(P_U, sql, s);
				output.Output_GUI(InvoiceTotal);
			
			}
		});
		btnInvoiceTotal.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnInvoiceTotal.setBounds(271, 358, 228, 35);
		contentPane.add(btnInvoiceTotal);
		
		JButton btnLabReport = new JButton("View Lab Report");
		btnLabReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String labReport = "Lab Report:  " + dms.getLabReport(P_U, sql, s);
				output.Output_GUI(labReport);
			}
		});
		btnLabReport.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnLabReport.setBounds(271, 404, 228, 35);
		contentPane.add(btnLabReport);
		
		JLabel lblName = new JLabel("Name:  "+ N);
		lblName.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblName.setBounds(59, 99, 440, 35);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:  " + CNIC);
		lblCnic.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblCnic.setBounds(59, 132, 417, 35);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:  " + Age);
		lblAge.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblAge.setBounds(59, 164, 130, 35);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:  " + Gender);
		lblGender.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblGender.setBounds(59, 193, 258, 35);
		contentPane.add(lblGender);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 257, 675, 18);
		contentPane.add(separator_2);
		
		JButton btnMedicineCost = new JButton("View Medicine Cost");
		btnMedicineCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String Medcost = "Medicine Cost:  " + dms.getMedCost(P_U, sql, s);
				output.Output_GUI(Medcost);
			}
		});
		btnMedicineCost.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnMedicineCost.setBounds(271, 266, 228, 35);
		contentPane.add(btnMedicineCost);
		
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
		btnSignOut.setBounds(636, 11, 116, 35);
		contentPane.add(btnSignOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 93, 675, 18);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 57, 675, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(283, 63, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblAction = new JLabel("Actions");
		lblAction.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblAction.setBounds(327, 223, 104, 32);
		contentPane.add(lblAction);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(37, 223, 675, 18);
		contentPane.add(separator_2_1);
		
		JButton btnProblem = new JButton("Write Problem");
		btnProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Input_Patient_Problem();
				String problem = input.Input_GUI("Try to describe your problem to your doctor cleary and precisely");
				
				String sql1 = "SELECT * FROM Patient";
				
				String sql2 = "UPDATE Patient SET Problem ='"+problem+"' WHERE Username LIKE '"+P_U+"'";
				
				try {
					dms.insertPatientProblem(P_U, problem, sql1, sql2, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				output.Output_GUI("Sent Successfully!");
			}
		});
		btnProblem.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnProblem.setBounds(271, 450, 228, 35);
		contentPane.add(btnProblem);
		
		JButton btnAppointment = new JButton("Book Appointment");
		btnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Book Appointment
				String n1 = input.Input_GUI("Enter the Name of Doctor you want to Book Appointment with: ");
				String sql1 = "SELECT * FROM Doctor";
				try {
					dms.bookAppointment(n1, sql1, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAppointment.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnAppointment.setBounds(271, 540, 228, 35);
		contentPane.add(btnAppointment);
		
		JButton btnAvailable = new JButton("Available Doctors");
		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String special = input.Input_GUI("Enter the type of Specialist: ");
				String sql1 = "SELECT * FROM Doctor";
				dms.checkAvailableDoctor(special, sql1, s);
			}
		});
		btnAvailable.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnAvailable.setBounds(271, 496, 228, 35);
		contentPane.add(btnAvailable);
	}

}