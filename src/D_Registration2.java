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

public class D_Registration2 extends JFrame {

	private JPanel contentPane;
	private JTextField Name_T;
	private JTextField CNIC_T;
	private JTextField Age_T;
	private JTextField Gender_T;
	private JTextField Specialization_T;
	private JTextField DU_T;
	private DMS dms;
	private JPasswordField DP_T;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					D_Registration2 frame = new D_Registration2();
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
	public D_Registration2() {
		dms = new DMS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor Registration Portal");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(191, 10, 374, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Please provide the Details: ");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(225, 53, 302, 32);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 95, 675, 18);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 131, 675, 18);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal Information");
		lblNewLabel_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1.setBounds(268, 101, 214, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName.setBounds(105, 159, 165, 43);
		contentPane.add(lblName);
		
		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCnic.setBounds(105, 212, 165, 43);
		contentPane.add(lblCnic);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAge.setBounds(105, 265, 165, 43);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGender.setBounds(105, 318, 165, 43);
		contentPane.add(lblGender);
		
		Name_T = new JTextField();
		Name_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Name_T.setColumns(10);
		Name_T.setBounds(281, 156, 278, 38);
		contentPane.add(Name_T);
		
		CNIC_T = new JTextField();
		CNIC_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		CNIC_T.setColumns(10);
		CNIC_T.setBounds(281, 215, 278, 38);
		contentPane.add(CNIC_T);
		
		Age_T = new JTextField();
		Age_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Age_T.setColumns(10);
		Age_T.setBounds(281, 268, 278, 38);
		contentPane.add(Age_T);
		
		Gender_T = new JTextField();
		Gender_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Gender_T.setColumns(10);
		Gender_T.setBounds(281, 321, 278, 38);
		contentPane.add(Gender_T);
		
		JLabel lblSpecializationIn = new JLabel("Specialization In:");
		lblSpecializationIn.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSpecializationIn.setBounds(105, 384, 165, 43);
		contentPane.add(lblSpecializationIn);
		
		Specialization_T = new JTextField();
		Specialization_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		Specialization_T.setColumns(10);
		Specialization_T.setBounds(281, 377, 278, 38);
		contentPane.add(Specialization_T);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(22, 425, 675, 18);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Login Information");
		lblNewLabel_1_1_1.setFont(new Font("Calibri Light", Font.ITALIC, 23));
		lblNewLabel_1_1_1.setBounds(281, 432, 214, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(22, 463, 675, 18);
		contentPane.add(separator_2_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setBounds(134, 467, 165, 43);
		contentPane.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Password:");
		lblName_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblName_1_1.setBounds(134, 520, 165, 43);
		contentPane.add(lblName_1_1);
		
		DU_T = new JTextField();
		DU_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		DU_T.setColumns(10);
		DU_T.setBounds(281, 474, 278, 38);
		contentPane.add(DU_T);
		
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
		btnReset_1_1.setBounds(22, 498, 80, 32);
		contentPane.add(btnReset_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor D = new Doctor(DU_T.getText(), DP_T.getText());
				String Name = Name_T.getText();
				String cnic = CNIC_T.getText();
				String gender = Gender_T.getText();
				String Specialist = Specialization_T.getText();
				int age = Integer.parseInt(Age_T.getText());
				D.registerD(D, Name, cnic, age, gender, Specialist);
				
				try {
					dms.insertUserPass(DU_T.getText(), DP_T.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(595, 498, 115, 32);
		contentPane.add(btnRegister);
		
		DP_T = new JPasswordField();
		DP_T.setBounds(281, 520, 278, 37);
		contentPane.add(DP_T);
	}
}
