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

public class BashekimGUI extends JFrame {
	
	static Bashekim bashekim= new Bashekim();
	private JPanel contentPaneBashekim;

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
		lblBashekimWelcome.setBounds(20, 38, 225, 22);
		contentPaneBashekim.add(lblBashekimWelcome);
		
		JButton btnBashekimExit = new JButton("\u00C7\u0131k\u0131\u015F yap");
		btnBashekimExit.setBounds(417, 35, 114, 31);
		contentPaneBashekim.add(btnBashekimExit);
	}
}
