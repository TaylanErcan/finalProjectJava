package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Bashekim;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BashekimGUI extends JFrame {
	
	static Bashekim bashekim= new Bashekim();
	private JPanel contentPaneBashekim;
	private JTextField txtDNameSurname;
	private JTextField textDTcNo;
	private JPasswordField passwordFieldDoktor;
	private JTextField txtDoktorId;
	private JTable jtableDoktorList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BashekimGUI frame = new BashekimGUI(bashekim);
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
	public BashekimGUI(Bashekim bashekim) {
		setResizable(false);
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 487);
		contentPaneBashekim = new JPanel();
		contentPaneBashekim.setBackground(Color.WHITE);
		contentPaneBashekim.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneBashekim);
		contentPaneBashekim.setLayout(null);
		
		JLabel lblBashekimWelcome = new JLabel("Ho\u015F geldiniz, Say\u0131n"+" "+ bashekim.getName());
		lblBashekimWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblBashekimWelcome.setBounds(10, 11, 225, 22);
		contentPaneBashekim.add(lblBashekimWelcome);
		
		JButton btnBashekimExit = new JButton("\u00C7\u0131k\u0131\u015F yap");
		btnBashekimExit.setBounds(432, 11, 114, 31);
		contentPaneBashekim.add(btnBashekimExit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 72, 536, 354);
		contentPaneBashekim.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Doktor Yönetimi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblDTcNo = new JLabel("T.C. No");
		lblDTcNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDTcNo.setBounds(381, 64, 79, 14);
		panel.add(lblDTcNo);
		
		JLabel lblDNameSurname = new JLabel("Ad Soyad");
		lblDNameSurname.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDNameSurname.setBounds(381, 8, 79, 14);
		panel.add(lblDNameSurname);
		
		JLabel lblDoktorPassword = new JLabel("\u015Eifre");
		lblDoktorPassword.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDoktorPassword.setBounds(381, 120, 79, 15);
		panel.add(lblDoktorPassword);
		
		txtDNameSurname = new JTextField();
		txtDNameSurname.setBounds(381, 33, 140, 20);
		panel.add(txtDNameSurname);
		txtDNameSurname.setColumns(10);
		
		textDTcNo = new JTextField();
		textDTcNo.setBounds(381, 89, 140, 20);
		panel.add(textDTcNo);
		textDTcNo.setColumns(10);
		
		passwordFieldDoktor = new JPasswordField();
		passwordFieldDoktor.setBounds(381, 146, 140, 20);
		panel.add(passwordFieldDoktor);
		
		JButton btnAddDoktor = new JButton("Ekle");
		btnAddDoktor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAddDoktor.setBounds(381, 177, 140, 32);
		panel.add(btnAddDoktor);
		
		JLabel lblDoktorId = new JLabel("Kullan\u0131c\u0131 ID");
		lblDoktorId.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblDoktorId.setBounds(381, 227, 79, 14);
		panel.add(lblDoktorId);
		
		txtDoktorId = new JTextField();
		txtDoktorId.setBackground(Color.LIGHT_GRAY);
		txtDoktorId.setBounds(381, 252, 140, 20);
		panel.add(txtDoktorId);
		txtDoktorId.setColumns(10);
		
		JButton btnDeleteDoktor = new JButton("Sil");
		btnDeleteDoktor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnDeleteDoktor.setBounds(381, 283, 140, 32);
		panel.add(btnDeleteDoktor);
		
		JScrollPane scrollPaneDoktor = new JScrollPane();
		scrollPaneDoktor.setBounds(10, 8, 361, 307);
		panel.add(scrollPaneDoktor);
		
		jtableDoktorList = new JTable();
		scrollPaneDoktor.setViewportView(jtableDoktorList);
	}
}
