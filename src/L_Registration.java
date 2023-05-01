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

public class L_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField Name_T;
	private JTextField CNIC_T;
	private JTextField Age_T;
	private JTextField Gender_T;
	private JTextField LU_T;
	private JPasswordField LP_T;
	private DMS dms;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L_Registration frame = new L_Registration();
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
	public L_Registration() {
		dms = new DMS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(30, 0, 781, 588);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("Lab-Assistant Registration Portal");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(174, 25, 479, 43);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Please provide the Details: ");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(243, 68, 302, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 110, 675, 18);
		contentPane_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 146, 675, 18);
		contentPane_1.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(286, 116, 214, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName.setBounds(123, 174, 165, 43);
		contentPane_1.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCnic.setBounds(123, 227, 165, 43);
		contentPane_1.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAge.setBounds(123, 280, 165, 43);
		contentPane_1.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGender.setBounds(123, 333, 165, 43);
		contentPane_1.add(lblGender);
		
		Name_T = new JTextField();
		Name_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Name_T.setColumns(10);
		Name_T.setBounds(299, 171, 278, 38);
		contentPane_1.add(Name_T);
		
		CNIC_T = new JTextField();
		CNIC_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		CNIC_T.setColumns(10);
		CNIC_T.setBounds(299, 230, 278, 38);
		contentPane_1.add(CNIC_T);
		
		Age_T = new JTextField();
		Age_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Age_T.setColumns(10);
		Age_T.setBounds(299, 283, 278, 38);
		contentPane_1.add(Age_T);
		
		Gender_T = new JTextField();
		Gender_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Gender_T.setColumns(10);
		Gender_T.setBounds(299, 336, 278, 38);
		contentPane_1.add(Gender_T);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 398, 675, 18);
		contentPane_1.add(separator_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Login Information");
		lblNewLabel_1_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1_1.setBounds(312, 405, 214, 32);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(40, 436, 675, 18);
		contentPane_1.add(separator_2_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(152, 464, 165, 43);
		contentPane_1.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Password:");
		lblName_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName_1_1.setBounds(152, 535, 165, 43);
		contentPane_1.add(lblName_1_1);
		
		LU_T = new JTextField();
		LU_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		LU_T.setColumns(10);
		LU_T.setBounds(299, 464, 278, 38);
		contentPane_1.add(LU_T);
		
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
		btnReset_1_1.setBounds(40, 500, 80, 32);
		contentPane_1.add(btnReset_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lab_Assistant L = new Lab_Assistant(LU_T.getText(), LP_T.getText());
				String Name = Name_T.getText();
				String cnic = CNIC_T.getText();
				String gender = Gender_T.getText();
				
				int age = Integer.parseInt(Age_T.getText());
				L.registerL(L, Name, cnic, age, gender);
				
				try {
					dms.insertUserPass(LU_T.getText(), LP_T.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(613, 513, 115, 32);
		contentPane_1.add(btnRegister);
		
		LP_T = new JPasswordField();
		LP_T.setBounds(299, 535, 278, 37);
		contentPane_1.add(LP_T);
	}
}
