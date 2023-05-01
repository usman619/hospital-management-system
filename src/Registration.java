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

public class Registration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Registration Portal");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 30));
		lblNewLabel_3.setBounds(271, 43, 255, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Who are you ?");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(318, 139, 206, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDoctor = new JButton("Doctor");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				D_Registration2 DR = new D_Registration2();
				DR.setVisible(true);
			}
		});
		btnDoctor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoctor.setBounds(95, 234, 144, 43);
		contentPane.add(btnDoctor);
		
		JButton btnNurse = new JButton("Nurse");
		btnNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				N_Registration2 N = new N_Registration2();
				N.setVisible(true);
			}
		});
		btnNurse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNurse.setBounds(95, 413, 144, 43);
		contentPane.add(btnNurse);
		
		JButton btnLabAssistant = new JButton("Lab Assistant");
		btnLabAssistant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				L_Registration L = new L_Registration();
				L.setVisible(true);
			}
		});
		btnLabAssistant.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLabAssistant.setBounds(537, 234, 144, 43);
		contentPane.add(btnLabAssistant);
		
		JButton btnPharmacist = new JButton("Pharmacist");
		btnPharmacist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				H_Registration H = new H_Registration();
				H.setVisible(true);
			}
		});
		btnPharmacist.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPharmacist.setBounds(537, 413, 144, 43);
		contentPane.add(btnPharmacist);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				P_Registration2 P = new P_Registration2();
				P.setVisible(true);
			}
		});
		btnPatient.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPatient.setBounds(312, 326, 144, 43);
		contentPane.add(btnPatient);
		
		JButton btnReset_1_1 = new JButton("<--");
		btnReset_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnReset_1_1.setBounds(45, 517, 103, 32);
		contentPane.add(btnReset_1_1);
	}

}
