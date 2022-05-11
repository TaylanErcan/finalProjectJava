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

import Helper.Helper;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DoctorGUI extends JFrame {

	private JPanel doctorReservationPane;
	private static Doctor doctor = new Doctor();
	private JTable tableWHour;

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

		JDateChooser doctorSelectDate = new JDateChooser();
		doctorSelectDate.setBounds(10, 11, 125, 26);
		workingHoursPanel.add(doctorSelectDate);

		JComboBox cbxSelectTime = new JComboBox();
		cbxSelectTime.setFont(new Font("SansSerif", Font.PLAIN, 13));
		cbxSelectTime.setModel(new DefaultComboBoxModel(
				new String[] { "10:00", "11:00", "11:30", "12:30", "14:00", "14:45", "15:40" }));
		cbxSelectTime.setBounds(145, 11, 70, 26);
		workingHoursPanel.add(cbxSelectTime);

		JButton btnAddWHour = new JButton("Ekle");
		btnAddWHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(doctorSelectDate.getDate());
				} catch (Exception e2) {

				}
				if (date.length() == 0) {
					Helper.showMessage("Lütfen geçerli bir tarih seçiniz.");
				} else {
					String time = " " + cbxSelectTime.getSelectedItem().toString() + ":00";
					String selectedDateTime = date + time;
					try {
						boolean control = doctor.addWorkHour(doctor.getId(), doctor.getName(), selectedDateTime);
						if (control) {
							Helper.showMessage("success");
						} else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnAddWHour.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnAddWHour.setBounds(419, 11, 104, 26);
		workingHoursPanel.add(btnAddWHour);

		JScrollPane scrollPaneWHour = new JScrollPane();
		scrollPaneWHour.setBounds(10, 48, 513, 223);
		workingHoursPanel.add(scrollPaneWHour);

		tableWHour = new JTable();
		scrollPaneWHour.setViewportView(tableWHour);
	}
}
