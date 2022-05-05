package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Clinic;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUpdateClinic;
	private static Clinic clinic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
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
	public UpdateClinicGUI(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUpdateClinic = new JTextField();
		txtUpdateClinic.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUpdateClinic.setBounds(23, 31, 143, 31);
		txtUpdateClinic.setText(clinic.getName());
		contentPane.add(txtUpdateClinic);
		txtUpdateClinic.setColumns(10);
		
		JLabel lblUpdateClinic = new JLabel("Yeni Poliklinik Ad\u0131");
		lblUpdateClinic.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblUpdateClinic.setBounds(23, 11, 143, 18);
		contentPane.add(lblUpdateClinic);
		
		JButton btnUpdateClinic = new JButton("G\u00FCncelle");
		btnUpdateClinic.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUpdateClinic.setBounds(23, 73, 94, 28);
		contentPane.add(btnUpdateClinic);
		
		btnUpdateClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					try {
						clinic.updateClinic(clinic.getId(), txtUpdateClinic.getText());
						Helper.showMessage("success");
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
	}

}
