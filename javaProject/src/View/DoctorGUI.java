package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Doctor;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;


public class DoctorGUI extends JFrame {

	private JPanel doctorReservationPane;
	private static Doctor doctor = new Doctor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorGUI frame = new DoctorGUI(doctor);
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
	public DoctorGUI(Doctor doctor) {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		doctorReservationPane = new JPanel();
		doctorReservationPane.setBackground(Color.WHITE);
		doctorReservationPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(doctorReservationPane);
		doctorReservationPane.setLayout(null);

		JButton btnDoctorExit = new JButton("\u00C7\u0131k\u0131\u015F yap");
		btnDoctorExit.setBounds(446, 22, 114, 31);
		doctorReservationPane.add(btnDoctorExit);

		JLabel lblDoctorWelcome = new JLabel("Hosgeldiniz, Sayýn " + doctor.getName());
		lblDoctorWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDoctorWelcome.setBounds(10, 11, 225, 22);
		doctorReservationPane.add(lblDoctorWelcome);
		
		JTabbedPane workingTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		workingTabbedPane.setBounds(22, 90, 538, 310);
		doctorReservationPane.add(workingTabbedPane);
		
		JPanel workingHoursPanel = new JPanel();
		workingHoursPanel.setBackground(Color.WHITE);
		workingTabbedPane.addTab("Çalýþma Saatleri", null, workingHoursPanel, null);
		workingHoursPanel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 11, 102, 26);
		workingHoursPanel.add(dateChooser);
		
		JComboBox cbxSelectTime = new JComboBox();
		cbxSelectTime.setBounds(145, 11, 79, 26);
		workingHoursPanel.add(cbxSelectTime);
	}
}
