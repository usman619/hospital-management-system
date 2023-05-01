import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Guest_Account extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public Guest_Account() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("--------------------- Hospital Timings ---------------------");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(21, 23, 729, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Free Patients: 7:00 am - 1:00 pm");
		lblNewLabel_3_1.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_1.setBounds(21, 60, 532, 43);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Subsidized Patients: 1:00 pm - 5:00 pm");
		lblNewLabel_3_1_1.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_1_1.setBounds(21, 100, 606, 43);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Private Patients (Appointment Required): 5:00 pm - 11:00 pm");
		lblNewLabel_3_1_1_1.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_1_1_1.setBounds(21, 138, 773, 61);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("------------------- Hospital Contact Info ------------------");
		lblNewLabel_3_2.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3_2.setBounds(21, 209, 729, 43);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Phone Number: 0923-534531 \"");
		lblNewLabel_3_2_1.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_2_1.setBounds(21, 262, 729, 43);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Website Link: https://www.hms.gov.pk/");
		lblNewLabel_3_2_2.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_2_2.setBounds(21, 315, 729, 43);
		contentPane.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("--------------------- Hospital Location --------------------");
		lblNewLabel_3_2_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3_2_3.setBounds(21, 368, 729, 43);
		contentPane.add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_3_2_4 = new JLabel("Location: Abdara Road, University Town, Peshawar");
		lblNewLabel_3_2_4.setFont(new Font("Calibri Light", Font.PLAIN, 23));
		lblNewLabel_3_2_4.setBounds(21, 410, 729, 43);
		contentPane.add(lblNewLabel_3_2_4);
		
		JLabel lblNewLabel_3_2_4_1 = new JLabel("------------------------------------------------------------------");
		lblNewLabel_3_2_4_1.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3_2_4_1.setBounds(21, 446, 729, 43);
		contentPane.add(lblNewLabel_3_2_4_1);
		
		JButton btnReset_1_1 = new JButton("<--");
		btnReset_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mainLogin L;
				try {
					setVisible(false);
					L = new mainLogin();
					L.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReset_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset_1_1.setBounds(21, 484, 103, 32);
		contentPane.add(btnReset_1_1);
	}

}
