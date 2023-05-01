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

public class LA_Profile extends JFrame {

	private JPanel contentPane;
	private String L_U;
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
	public LA_Profile(String user) throws SQLException {
		L_U = user;
		dms = new DMS();
		input = new Input();
		output = new Output();
		L = new mainLogin();
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		Connection C = DriverManager.getConnection(dbURL);
		output.displayMsg("Connected to Database!");
		
		String sql = "SELECT * FROM LabAssistant";
		
		Statement s = C.createStatement();
		
		String N = dms.getName(L_U, sql, s);
		
		String CNIC = dms.getCNIC(L_U, sql, s);
		
		int Age = dms.getAge(L_U, sql, s);
		
		String Gender = dms.getGender(L_U, sql, s);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeLabAssistant = new JLabel("Welcome " + N);
		lblWelcomeLabAssistant.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblWelcomeLabAssistant.setBounds(226, 11, 315, 55);
		contentPane.add(lblWelcomeLabAssistant);
		
		JButton btnNewButton = new JButton("Perform Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Enter test result in a specific Patient
				P_U = input.Input_GUI("Enter Patient's ID/Username ");
				String report = input.Input_GUI("Enter Patient's Labtest: ");
				
				String sql1 = "SELECT * FROM Patient";
				
				String p = dms.getName(P_U, sql1, s);
				output.Output_GUI("--------------------PERFORMING "+report+" ON "+p+"--------------------");
				
				int fees = dms.getInvoiceTotal(P_U, sql1, s) + 300;
				
				try {
					dms.insertPatientReport(P_U, report, C);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String sql3 = "UPDATE Patient SET InvoiceTotal ='"+fees+"' WHERE Username LIKE '"+P_U+"'";
				try {
					dms.insertPatientInvoice(P_U, fees, sql1, sql3, C);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri Light", Font.BOLD, 20));
		btnNewButton.setBounds(272, 353, 197, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name:  "+ N);
		lblName.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblName.setBounds(52, 99, 440, 35);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:  " + CNIC);
		lblCnic.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblCnic.setBounds(52, 132, 417, 35);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:  " + Age);
		lblAge.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblAge.setBounds(52, 164, 130, 35);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:  " + Gender);
		lblGender.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblGender.setBounds(52, 193, 184, 35);
		contentPane.add(lblGender);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 264, 675, 18);
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
		btnViewPatientInfo.setBounds(272, 295, 197, 35);
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
		btnSignOut.setBounds(615, 11, 130, 35);
		contentPane.add(btnSignOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 93, 675, 18);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 57, 675, 18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(276, 63, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblAction = new JLabel("Actions");
		lblAction.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblAction.setBounds(320, 232, 104, 32);
		contentPane.add(lblAction);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(30, 223, 675, 18);
		contentPane.add(separator_2_1);
	}
}