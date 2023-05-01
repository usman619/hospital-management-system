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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class N_Registration2 extends JFrame {

	private JPanel contentPane;
	private JTextField Name_T;
	private JTextField CNIC_T;
	private JTextField Age_T;
	private JTextField Gender_T;
	private JTextField NU_T;
	private JPasswordField NP_T;
	private DMS dms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					N_Registration2 frame = new N_Registration2();
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
	public N_Registration2() {
		dms = new DMS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nurse Registration Portal");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(239, 30, 374, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Please provide the Details: ");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(266, 76, 302, 32);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 118, 675, 18);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(63, 154, 675, 18);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(309, 124, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName.setBounds(146, 182, 165, 43);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCnic.setBounds(146, 235, 165, 43);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAge.setBounds(146, 288, 165, 43);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGender.setBounds(146, 341, 165, 43);
		contentPane.add(lblGender);
		
		Name_T = new JTextField();
		Name_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Name_T.setColumns(10);
		Name_T.setBounds(322, 179, 278, 38);
		contentPane.add(Name_T);
		
		CNIC_T = new JTextField();
		CNIC_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		CNIC_T.setColumns(10);
		CNIC_T.setBounds(322, 238, 278, 38);
		contentPane.add(CNIC_T);
		
		Age_T = new JTextField();
		Age_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Age_T.setColumns(10);
		Age_T.setBounds(322, 291, 278, 38);
		contentPane.add(Age_T);
		
		Gender_T = new JTextField();
		Gender_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Gender_T.setColumns(10);
		Gender_T.setBounds(322, 344, 278, 38);
		contentPane.add(Gender_T);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(76, 406, 675, 18);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Login Information");
		lblNewLabel_1_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1_1.setBounds(335, 413, 214, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(63, 444, 675, 18);
		contentPane.add(separator_2_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(175, 472, 165, 43);
		contentPane.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Password:");
		lblName_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName_1_1.setBounds(175, 543, 165, 43);
		contentPane.add(lblName_1_1);
		
		NU_T = new JTextField();
		NU_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		NU_T.setColumns(10);
		NU_T.setBounds(322, 472, 278, 38);
		contentPane.add(NU_T);
		
		JButton btnReset_1_1 = new JButton("<--");
		btnReset_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration R;
				setVisible(false);
				R = new Registration();
				R.setVisible(true);
			}
		});
		btnReset_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset_1_1.setBounds(63, 508, 80, 32);
		contentPane.add(btnReset_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nurse N = new Nurse(NU_T.getText(), NP_T.getText());
				String Name = Name_T.getText();
				String cnic = CNIC_T.getText();
				String gender = Gender_T.getText();
				
				int age = Integer.parseInt(Age_T.getText());
				N.registerN(N, Name, cnic, age, gender);
				
				try {
					dms.insertUserPass(NU_T.getText(), NP_T.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(636, 521, 115, 32);
		contentPane.add(btnRegister);
		
		NP_T = new JPasswordField();
		NP_T.setBounds(322, 543, 278, 37);
		contentPane.add(NP_T);
	}

}
