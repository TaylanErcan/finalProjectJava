package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

	private JPanel wrapper_pane;
	private JTextField txtHastaTc;
	private JTextField txtHastaSifre;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblTcNo_1 = new JLabel("T.C Numaran\u0131z:");
		lblTcNo_1.setBounds(50, 16, 130, 28);
		lblTcNo_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		panelDoctor.add(lblTcNo_1);
		
		JLabel lblSifre_1 = new JLabel("\u015Eifre:");
		lblSifre_1.setBounds(77, 55, 55, 28);
		lblSifre_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 16));
		panelDoctor.add(lblSifre_1);
		
		textField = new JTextField();
		textField.setBounds(203, 57, 162, 28);
		textField.setText("fsdfkshhfsf");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		panelDoctor.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 18, 162, 28);
		textField_1.setText("fsdfkshhfsf");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		panelDoctor.add(textField_1);
		
		JButton btnDoktorLogin = new JButton("Giri\u015F Yap");
		btnDoktorLogin.setBounds(50, 138, 341, 43);
		panelDoctor.add(btnDoktorLogin);
		
		JPanel panelHasta = new JPanel();
		panelHasta.setBackground(Color.WHITE);
		wrapper_TabPane.addTab("Hasta Giriþi", null, panelHasta, null);
		panelHasta.setLayout(null);
		
		JLabel lblTcNo = new JLabel("T.C Numaran\u0131z:");
		lblTcNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblTcNo.setBounds(50, 16, 130, 28);
		panelHasta.add(lblTcNo);
		
		JLabel lblSifre = new JLabel("\u015Eifre:");
		lblSifre.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 16));
		lblSifre.setBounds(77, 55, 55, 28);
		panelHasta.add(lblSifre);
		
		txtHastaTc = new JTextField();
		txtHastaTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHastaTc.setText("fsdfkshhfsf");
		txtHastaTc.setBounds(203, 18, 162, 28);
		panelHasta.add(txtHastaTc);
		txtHastaTc.setColumns(10);
		
		txtHastaSifre = new JTextField();
		txtHastaSifre.setText("fsdfkshhfsf");
		txtHastaSifre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHastaSifre.setColumns(10);
		txtHastaSifre.setBounds(203, 57, 162, 28);
		panelHasta.add(txtHastaSifre);
		
		JButton btnHastaRegister = new JButton("Kay\u0131t Ol");
		btnHastaRegister.setBounds(60, 138, 142, 43);
		panelHasta.add(btnHastaRegister);
		
		JButton btnHastaLogin = new JButton("Giri\u015F Yap");
		btnHastaLogin.setBounds(249, 138, 142, 43);
		panelHasta.add(btnHastaLogin);
	}
}
