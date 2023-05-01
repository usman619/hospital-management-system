import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class P_Register_R extends JFrame {

	private JPanel contentPane;
	private JTextField Name_T;
	private JTextField CNIC_T;
	private JTextField Age_T;
	private JTextField Gender_T;
	private JTextField PU_T;
	private DMS dms;
	private JPasswordField PP_T;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_Register_R frame = new P_Register_R();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public P_Register_R() {
		dms = new DMS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Patient Registration Portal");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(209, 25, 374, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Please provide the Details: ");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(243, 68, 302, 32);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 110, 675, 18);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 146, 675, 18);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(286, 116, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName.setBounds(123, 174, 165, 43);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCnic.setBounds(123, 227, 165, 43);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAge.setBounds(123, 280, 165, 43);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGender.setBounds(123, 333, 165, 43);
		contentPane.add(lblGender);
		
		Name_T = new JTextField();
		Name_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Name_T.setColumns(10);
		Name_T.setBounds(299, 171, 278, 38);
		contentPane.add(Name_T);
		
		CNIC_T = new JTextField();
		CNIC_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		CNIC_T.setColumns(10);
		CNIC_T.setBounds(299, 230, 278, 38);
		contentPane.add(CNIC_T);
		
		Age_T = new JTextField();
		Age_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Age_T.setColumns(10);
		Age_T.setBounds(299, 283, 278, 38);
		contentPane.add(Age_T);
		
		Gender_T = new JTextField();
		Gender_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Gender_T.setColumns(10);
		Gender_T.setBounds(299, 336, 278, 38);
		contentPane.add(Gender_T);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 398, 675, 18);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Login Information");
		lblNewLabel_1_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1_1.setBounds(312, 405, 214, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(40, 436, 675, 18);
		contentPane.add(separator_2_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(152, 464, 165, 43);
		contentPane.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Password:");
		lblName_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName_1_1.setBounds(152, 535, 165, 43);
		contentPane.add(lblName_1_1);
		
		PU_T = new JTextField();
		PU_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		PU_T.setColumns(10);
		PU_T.setBounds(299, 464, 278, 38);
		contentPane.add(PU_T);
		
		JButton btnReset_1_1 = new JButton("Back");
		btnReset_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R_Profile R;
				setVisible(false);
				try {
					R = new R_Profile("admin");
					R.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReset_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset_1_1.setBounds(40, 500, 80, 32);
		contentPane.add(btnReset_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient P = new Patient(PU_T.getText(), PP_T.getText());
				String Name = Name_T.getText();
				String cnic = CNIC_T.getText();
				String gender = Gender_T.getText();
				
				int age = Integer.parseInt(Age_T.getText());
				P.registerP(P, Name, cnic, age, gender);
				
				try {
					dms.insertUserPass(PU_T.getText(), PP_T.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Name_T.setText(null);
				CNIC_T.setText(null);
				Gender_T.setText(null);
				Age_T.setText(null);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(613, 513, 115, 32);
		contentPane.add(btnRegister);
		
		PP_T = new JPasswordField();
		PP_T.setBounds(299, 535, 278, 37);
		contentPane.add(PP_T);
	}

}