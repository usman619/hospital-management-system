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

public class PH_Profile extends JFrame {

	private JPanel contentPane;
	private String H_U;
	private String P_U;
	private DMS dms;
	private Input input;
	private Output output;
	private mainLogin L;
	private int M_Cost;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PH_Profile(String user) throws SQLException
	{
		H_U = user;
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
		
		String sql = "SELECT * FROM Pharmacist";
		
		Statement s = C.createStatement();
		
		String N = dms.getName(H_U, sql, s);
		
		String CNIC = dms.getCNIC(H_U, sql, s);
		
		int Age = dms.getAge(H_U, sql, s);
		
		String Gender = dms.getGender(H_U, sql, s);
		
		JLabel lblWelcomePharmacist = new JLabel("Welcome " + N);
		lblWelcomePharmacist.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblWelcomePharmacist.setBounds(200, 11, 379, 55);
		contentPane.add(lblWelcomePharmacist);
		
		JButton btnAddMedicineCost = new JButton("Add Medicine Cost");
		btnAddMedicineCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Add medicine cost in patient and updating total amount
				String sql1 = "SELECT * FROM Patient";
				Statement s1;
				
				P_U = input.Input_GUI("Enter Patient's Username: ");
		
				Receptionist R = new Receptionist();
				int no = input.Input_INT_GUI("Input the number of medicines: ");
				for(int i=0; i<no; i++)
				{
					int X = input.Input_INT_GUI("Enter Patient's Medicine Cost: ");
					try {
						s1 = C.createStatement();
						M_Cost = dms.getMedCost(P_U, sql1, s1);
						X += M_Cost;
						R.TotalAmount = X;
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					
					String sql2 = "UPDATE Patient SET MedCost ='"+X+"' WHERE Username LIKE '"+P_U+"'";
					
					try {
						dms.insertPatientMedCost(P_U, X, sql1, sql2, C);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					String sql3 = "UPDATE Patient SET InvoiceTotal ='"+R.TotalAmount+"' WHERE Username LIKE '"+P_U+"'";
					try {
						dms.insertPatientInvoice(P_U, i, sql1, sql3, C);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAddMedicineCost.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnAddMedicineCost.setBounds(278, 341, 218, 35);
		contentPane.add(btnAddMedicineCost);
		
		JButton btnPrescriptionDetails = new JButton("Prescription Details");
		btnPrescriptionDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Check Prescription Details of a Specific Patient
				String sql2 = "SELECT * FROM Patient";
				Statement s2;
				try {
					s2 = C.createStatement();
					P_U = input.Input_GUI("Enter Patient's ID/Username ");
					String P = "Prescription: " + dms.getPrescription(P_U, sql2, s2);
					output.Output_GUI(P);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrescriptionDetails.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnPrescriptionDetails.setBounds(278, 396, 218, 35);
		contentPane.add(btnPrescriptionDetails);
		
		JLabel lblName = new JLabel("Name:  "+ N);
		lblName.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblName.setBounds(58, 99, 440, 35);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:  "+ CNIC);
		lblCnic.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblCnic.setBounds(58, 132, 417, 35);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:  "+ Age);
		lblAge.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblAge.setBounds(58, 164, 130, 35);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:  "+ Gender);
		lblGender.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblGender.setBounds(58, 193, 201, 35);
		contentPane.add(lblGender);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(36, 264, 675, 18);
		contentPane.add(separator_2);
		
		JButton btnPrepareMedicine = new JButton("Prepare Medicine");
		btnPrepareMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				output.Output_GUI("--------------Preparing Medicine--------------");
			}
		});
		btnPrepareMedicine.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnPrepareMedicine.setBounds(278, 293, 218, 35);
		contentPane.add(btnPrepareMedicine);
		
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
		btnSignOut.setBounds(647, 11, 112, 35);
		contentPane.add(btnSignOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 93, 675, 18);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 57, 675, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(282, 63, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblAction = new JLabel("Actions");
		lblAction.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblAction.setBounds(326, 232, 104, 32);
		contentPane.add(lblAction);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(36, 223, 675, 18);
		contentPane.add(separator_2_1);
	}

}