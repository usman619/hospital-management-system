import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class mainLogin extends JFrame {

	private JPanel contentPane;
	private JTextField U_T;
	private JPasswordField P_T;
	private Input input;
	private Output output;
	private Login L;
	private int check;
	public String user;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainLogin frame = new mainLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public mainLogin() throws SQLException {
		setBackground(new Color(204, 204, 204));
		setForeground(new Color(204, 204, 204));
		setTitle("HMS");
		input = new Input();
		output = new Output();
		L = new Login();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 148, 165, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPassword.setBounds(59, 221, 165, 43);
		contentPane.add(lblPassword);
		
		U_T = new JTextField();
		U_T.setFont(new Font("Calibri", Font.PLAIN, 15));
		U_T.setColumns(10);
		U_T.setBounds(234, 151, 151, 38);
		contentPane.add(U_T);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				user = U_T.getText();
				@SuppressWarnings("deprecation")
				String password = P_T.getText();

				int A = L.Authorization(user, password);
				try {
					check = L.front_page(user);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(A == 1)
				{
					if(check == 0)
					{
						output.Output_GUI("Invalid Username/Password");
					}
					else if (check == 1)
					{
						//Patient
						setVisible(false);
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									P_Profile frame = new P_Profile(user);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					else if (check == 2)
					{
						//Doctor
						setVisible(false);
						
						EventQueue.invokeLater(new Runnable() {
							public void run() 
							{
								try {
									
									D_Profile frame = new D_Profile(user);
									frame.setVisible(true);
								} 
								catch (Exception e) 
								{
									e.printStackTrace();
								}
							}
						});
						
					}
					else if (check == 3)
					{
						//Lab Assistant
						setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									LA_Profile frame = new LA_Profile(user);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					else if (check == 4)
					{
						//Pharmacist
						setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									PH_Profile frame = new PH_Profile(user);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					else if (check == 5)
					{
						//Nurse
						setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									N_Profile frame = new N_Profile(user);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else if (check == 6)
					{
						//Admin OR Receptionist
							setVisible(false);
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										R_Profile frame = new R_Profile(user);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						
					}
				}
				else 
				{
					output.Output_GUI("Incorrect Username/Password, Try Again.");
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignIn.setBounds(494, 218, 144, 43);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel_1 = new JLabel("Dont Have an Account?");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1.setBounds(30, 370, 206, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Registration R1 = new Registration();
				R1.setVisible(true);
			
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(311, 367, 218, 32);
		contentPane.add(btnRegister);
		
		JButton btnGuestAccount = new JButton("Guest Account");
		btnGuestAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Guest_Account frame = new Guest_Account();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnGuestAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuestAccount.setBounds(311, 409, 218, 32);
		contentPane.add(btnGuestAccount);
		
		JLabel lblNewLabel_2 = new JLabel("Unregistered Account?");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_2.setBounds(30, 412, 206, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\HMS logo.jpeg"));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(-37, -12, 564, 138);
		contentPane.add(lblNewLabel_3);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					U_T.setText(null);
					P_T.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(494, 145, 144, 43);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
					System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(353, 461, 129, 27);
		contentPane.add(btnExit);
		
		P_T = new JPasswordField();
		P_T.setBounds(234, 222, 151, 40);
		contentPane.add(P_T);
	}
}
