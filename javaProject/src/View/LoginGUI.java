package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.*;
import Model.Bashekim;
import Model.Doctor;
import Model.Patient;

public class LoginGUI extends JFrame {

	private JPanel wrapper_pane;
	private JTextField txtHastaTc;
	private JTextField txtDoktorTc;
	private JPasswordField passwordFieldDoktor;
	private JPasswordField passwordFieldHasta;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 434);
		wrapper_pane = new JPanel();
		wrapper_pane.setBackground(Color.WHITE);
		wrapper_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wrapper_pane);
		wrapper_pane.setLayout(null);

		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("hospitalIcon72x72.png")));
		lbl_logo.setBounds(205, 11, 116, 81);
		wrapper_pane.add(lbl_logo);

		JLabel lblNewLabel = new JLabel("Hastane Y\u00F6netim Sistemine Ho\u015Fgeldiniz");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel.setBounds(89, 93, 349, 28);
		wrapper_pane.add(lblNewLabel);

		JTabbedPane wrapper_TabPane = new JTabbedPane(JTabbedPane.TOP);
		wrapper_TabPane.setBounds(37, 146, 458, 238);
		wrapper_pane.add(wrapper_TabPane);

		JPanel panelDoctor = new JPanel();
		panelDoctor.setBackground(Color.WHITE);
		wrapper_TabPane.addTab("Doktor Giriþi", null, panelDoctor, null);
		panelDoctor.setLayout(null);

		JLabel lblDoktorTc = new JLabel("T.C Numaran\u0131z:");
		lblDoktorTc.setBounds(50, 16, 130, 28);
		lblDoktorTc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		panelDoctor.add(lblDoktorTc);

		JLabel lblDoktorPassword = new JLabel("\u015Eifre:");
		lblDoktorPassword.setBounds(77, 55, 55, 28);
		lblDoktorPassword.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 16));
		panelDoctor.add(lblDoktorPassword);

		txtDoktorTc = new JTextField();
		txtDoktorTc.setBounds(203, 18, 162, 28);
		txtDoktorTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDoktorTc.setColumns(10);
		panelDoctor.add(txtDoktorTc);

		JButton btnDoktorLogin = new JButton("Giri\u015F Yap");

		btnDoktorLogin.setBounds(155, 137, 130, 43);
		panelDoctor.add(btnDoktorLogin);

		passwordFieldDoktor = new JPasswordField();
		passwordFieldDoktor.setBounds(203, 62, 162, 20);
		panelDoctor.add(passwordFieldDoktor);

		JPanel panelHasta = new JPanel();
		panelHasta.setBackground(Color.WHITE);
		wrapper_TabPane.addTab("Hasta Giriþi", null, panelHasta, null);
		panelHasta.setLayout(null);

		JLabel lblHastaTc = new JLabel("T.C Numaran\u0131z:");
		lblHastaTc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblHastaTc.setBounds(50, 16, 130, 28);
		panelHasta.add(lblHastaTc);

		JLabel lblHastaSifre = new JLabel("\u015Eifre:");
		lblHastaSifre.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 16));
		lblHastaSifre.setBounds(79, 55, 55, 28);
		panelHasta.add(lblHastaSifre);

		txtHastaTc = new JTextField();
		txtHastaTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHastaTc.setText("fsdfkshhfsf");
		txtHastaTc.setBounds(203, 18, 162, 28);
		panelHasta.add(txtHastaTc);
		txtHastaTc.setColumns(10);

		JButton btnHastaRegister = new JButton("Kay\u0131t Ol");
		btnHastaRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterGUI rGUI = new RegisterGUI();
				rGUI.setVisible(true);
				dispose();
			}
		});
		btnHastaRegister.setBounds(60, 138, 142, 43);
		panelHasta.add(btnHastaRegister);

		JButton btnHastaLogin = new JButton("Giri\u015F Yap");
		btnHastaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtHastaTc.getText().length() == 0 || passwordFieldHasta.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					boolean key = true;
					try {
						Connection con = conn.conDb();
						Statement st = con.createStatement();
						ResultSet resultSet = st.executeQuery("SELECT * FROM user");
						
						while (resultSet.next()) {
							if (txtHastaTc.getText().equals(resultSet.getString("Tc_No"))
									&& passwordFieldHasta.getText().equals(resultSet.getString("Password"))) {
								if (resultSet.getString("Type").equals("Hasta")) {
									Patient patient = new Patient();
									patient.setId(resultSet.getInt("Id"));
									patient.setTc_No(resultSet.getString("Tc_No"));
									patient.setPassword(resultSet.getString("Password"));
									patient.setName(resultSet.getString("Name"));
									patient.setType(resultSet.getString("Type"));
									PatientGUI pGUI = new PatientGUI(patient);
									pGUI.setVisible(true);
									dispose();
									key = false;
								}
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					if (key) {
						Helper.showMessage("Böyle bir hasta kaydý bulunamadý.\nLütfen kayýt olun.");
					}
				}
			}
		});
		btnHastaLogin.setBounds(249, 138, 142, 43);
		panelHasta.add(btnHastaLogin);

		passwordFieldHasta = new JPasswordField();
		passwordFieldHasta.setBounds(203, 62, 162, 20);
		panelHasta.add(passwordFieldHasta);

		btnDoktorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoktorTc.getText().length() == 0 || passwordFieldDoktor.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						Connection con = conn.conDb();
						Statement st = con.createStatement();
						ResultSet resultSet = st.executeQuery("SELECT * FROM user");
						while (resultSet.next()) {
							if (txtDoktorTc.getText().equals(resultSet.getString("Tc_No"))
									&& passwordFieldDoktor.getText().equals(resultSet.getString("Password"))) {
								if (resultSet.getString("Type").equals("Bashekim")) {
									Bashekim bhekim = new Bashekim();
									bhekim.setId(resultSet.getInt("Id"));
									bhekim.setTc_No(resultSet.getString("Tc_No"));
									bhekim.setPassword(resultSet.getString("Password"));
									bhekim.setName(resultSet.getString("Name"));
									bhekim.setType(resultSet.getString("Type"));
									BashekimGUI bGUI = new BashekimGUI(bhekim);
									bGUI.setVisible(true);
									dispose();
								}

								if (resultSet.getString("Type").equals("Doktor")) {
									Doctor doctor = new Doctor();
									doctor.setId(resultSet.getInt("Id"));
									doctor.setTc_No(resultSet.getString("Tc_No"));
									doctor.setPassword(resultSet.getString("Password"));
									doctor.setName(resultSet.getString("Name"));
									doctor.setType(resultSet.getString("Type"));
									DoctorGUI dGUI = new DoctorGUI(doctor);
									dGUI.setVisible(true);
									dispose();
								}

							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	}
}
