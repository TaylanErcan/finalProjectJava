package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Patient;
import Model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame {

	private JPanel w_contentPane;
	private JTextField txtHastaAdSoyad;
	private JTextField txtTcNo;
	private JPasswordField pswFieldHastaSifre;
	private Patient patient = new Patient();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setResizable(false);
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 318);
		w_contentPane = new JPanel();
		w_contentPane.setBackground(Color.WHITE);
		w_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_contentPane);
		w_contentPane.setLayout(null);

		JLabel lblHastaName = new JLabel("Ad Soyad");
		lblHastaName.setBounds(47, 11, 76, 14);
		w_contentPane.add(lblHastaName);

		txtHastaAdSoyad = new JTextField();
		txtHastaAdSoyad.setBounds(47, 36, 190, 20);
		w_contentPane.add(txtHastaAdSoyad);
		txtHastaAdSoyad.setColumns(10);

		JLabel lblTcNo = new JLabel("T.C. Numaras\u0131");
		lblTcNo.setBounds(47, 71, 95, 14);
		w_contentPane.add(lblTcNo);

		txtTcNo = new JTextField();
		txtTcNo.setBounds(47, 96, 190, 20);
		w_contentPane.add(txtTcNo);
		txtTcNo.setColumns(10);

		JLabel lblHastaSifre = new JLabel("\u015Eifre:");
		lblHastaSifre.setBounds(47, 127, 76, 14);
		w_contentPane.add(lblHastaSifre);

		pswFieldHastaSifre = new JPasswordField();
		pswFieldHastaSifre.setBounds(47, 154, 190, 20);
		w_contentPane.add(pswFieldHastaSifre);

		JButton btnGoBack = new JButton("Geri D\u00F6n");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(85, 232, 110, 35);
		w_contentPane.add(btnGoBack);

		JButton btnHastaRegister = new JButton("Kay\u0131t Ol");
		btnHastaRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTcNo.getText().length() == 0 || txtHastaAdSoyad.getText().length() == 0
						|| pswFieldHastaSifre.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						boolean control = patient.Register(txtTcNo.getText(), pswFieldHastaSifre.getText(),
								txtHastaAdSoyad.getText());
						if (control) {
							Helper.showMessage("success");
							LoginGUI loginGUI = new LoginGUI();
							loginGUI.setVisible(true);
							dispose();
						} else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnHastaRegister.setBounds(85, 185, 110, 36);
		w_contentPane.add(btnHastaRegister);
	}
}
