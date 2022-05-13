package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.Item;
import Model.Clinic;
import Model.Patient;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class PatientGUI extends JFrame {

	private JPanel contentPane;
	private static Patient patient = new Patient();
	private Clinic clinic = new Clinic();
	private JTable tableDoctor;
	private DefaultTableModel doctorModel;
	private Object[] doctorData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGUI frame = new PatientGUI(patient);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public PatientGUI(Patient patient) throws SQLException {
		
		doctorModel = new DefaultTableModel();
		Object[] colDoctor = new Object[2];
		colDoctor[0] = "ID";;
		colDoctor[1] = "Ad Soyad";
		doctorModel.setColumnIdentifiers(colDoctor);
		doctorData = new Object[2];

		setResizable(false);
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pLabel = new JLabel("Hosgeldiniz, Say\u0131n " + patient.getName());
		pLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		pLabel.setBounds(27, 22, 225, 22);
		contentPane.add(pLabel);

		JButton btnPExit = new JButton("\u00C7\u0131k\u0131\u015F yap");
		btnPExit.setBounds(448, 19, 114, 31);
		contentPane.add(btnPExit);

		JTabbedPane p_tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		p_tabbedPane.setBounds(10, 65, 574, 317);
		contentPane.add(p_tabbedPane);

		JPanel p_appointmentPanel = new JPanel();
		p_appointmentPanel.setBackground(Color.WHITE);
		p_tabbedPane.addTab("Randevu Sistemi", null, p_appointmentPanel, null);
		p_appointmentPanel.setLayout(null);

		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 25, 214, 253);
		p_appointmentPanel.add(w_scrollDoctor);

		tableDoctor = new JTable();
		w_scrollDoctor.setViewportView(tableDoctor);

		JLabel lblDocList = new JLabel("Doktor Listesi");
		lblDocList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocList.setBounds(10, 0, 80, 22);
		p_appointmentPanel.add(lblDocList);

		JLabel lblClinicName = new JLabel("Klinik Ad\u0131");
		lblClinicName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClinicName.setBounds(234, 5, 87, 17);
		p_appointmentPanel.add(lblClinicName);

		JComboBox cbxSelectClinic = new JComboBox();
		cbxSelectClinic.addItem("Polikinik Seçiniz");
		for (int i = 0; i < clinic.GetClinicList().size(); i++) {
			cbxSelectClinic
					.addItem(new Item(clinic.GetClinicList().get(i).getId(), clinic.GetClinicList().get(i).getName()));
		}

		cbxSelectClinic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbxSelectClinic.getSelectedIndex() != 0) {
					JComboBox jCombo = (JComboBox) e.getSource();
					Item item = (Item) jCombo.getSelectedItem();
					DefaultTableModel clearModel= (DefaultTableModel) tableDoctor.getModel();
					clearModel.setRowCount(0);
					
					
				}
			}
		});

		cbxSelectClinic.setBounds(234, 25, 131, 28);
		p_appointmentPanel.add(cbxSelectClinic);
	}
}
