package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.Bashekim;
import Model.Clinic;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import Helper.*;
import javax.swing.JComboBox;

public class BashekimGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	static Bashekim bashekim = new Bashekim();
	Clinic clinic = new Clinic();
	private JPanel contentPaneBashekim;
	private JTextField txtDNameSurname;
	private JTextField textDTcNo;
	private JPasswordField passwordFieldDoktor;
	private JTextField txtDoktorId;
	private JTable jtableDoktorList;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTable tableClinicList;
	private JTextField txtClinicName;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;
	private JPopupMenu clinicMenu;
	private JTable tableEmployee;

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
	 * 
	 * @throws SQLException
	 */
	public BashekimGUI(Bashekim bashekim) throws SQLException {

		// Doctor model
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "TC No";
		colDoctorName[2] = "�ifre";
		colDoctorName[3] = "Ad Soyad";
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for (int i = 0; i < bashekim.GetDoctorList().size(); i++) {
			doctorData[0] = bashekim.GetDoctorList().get(i).getId();
			doctorData[1] = bashekim.GetDoctorList().get(i).getTc_No();
			doctorData[2] = bashekim.GetDoctorList().get(i).getPassword();
			doctorData[3] = bashekim.GetDoctorList().get(i).getName();
			doctorModel.addRow(doctorData);
		}

		// Clinic model
		clinicModel = new DefaultTableModel();
		Object[] clinicColName = new Object[2];
		clinicColName[0] = "ID";
		clinicColName[1] = "Poliklinik Ad�";
		clinicModel.setColumnIdentifiers(clinicColName);
		clinicData = new Object[2];
		for (int i = 0; i < clinic.GetClinicList().size(); i++) {
			clinicData[0] = clinic.GetClinicList().get(i).getId();
			clinicData[1] = clinic.GetClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}

		// Employee model
		DefaultTableModel employeeModel = new DefaultTableModel();
		Object[] colEmployee = new Object[2];
		colEmployee[0] = "ID";
		colEmployee[1] = "Ad Soyad";
		employeeModel.setColumnIdentifiers(colEmployee);
		Object[] employeeData = new Object[2];

		setResizable(false);
		setTitle("Hospital Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 487);
		contentPaneBashekim = new JPanel();
		contentPaneBashekim.setBackground(Color.WHITE);
		contentPaneBashekim.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneBashekim);
		contentPaneBashekim.setLayout(null);

		JLabel lblBashekimWelcome = new JLabel("Ho\u015F geldiniz, Say\u0131n" + " " + bashekim.getName());
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
		tabbedPane.addTab("Doktor Y�netimi", null, panel, null);
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

		jtableDoktorList = new JTable(doctorModel);
		scrollPaneDoktor.setViewportView(jtableDoktorList);

		jtableDoktorList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					txtDoktorId.setText(jtableDoktorList.getValueAt(jtableDoktorList.getSelectedRow(), 0).toString());
				} catch (Exception ex) {

				}
			}
		});

		jtableDoktorList.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectedRowId = Integer
							.parseInt(jtableDoktorList.getValueAt(jtableDoktorList.getSelectedRow(), 0).toString());
					String selectTC = jtableDoktorList.getValueAt(jtableDoktorList.getSelectedRow(), 1).toString();
					String selectSifre = jtableDoktorList.getValueAt(jtableDoktorList.getSelectedRow(), 2).toString();
					String selectAdSoyad = jtableDoktorList.getValueAt(jtableDoktorList.getSelectedRow(), 3).toString();

					try {
						bashekim.updateDoctor(selectedRowId, selectTC, selectSifre, selectAdSoyad);
						updateDoctorModel();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		btnAddDoktor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDNameSurname.getText().length() == 0 || passwordFieldDoktor.getText().length() == 0
						|| textDTcNo.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						boolean control = bashekim.addDoctor(textDTcNo.getText(), passwordFieldDoktor.getText(),
								txtDNameSurname.getText());
						if (control) {
							Helper.showMessage("success");
							textDTcNo.setText(null);
							passwordFieldDoktor.setText(null);
							txtDNameSurname.setText(null);
							updateDoctorModel();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnDeleteDoktor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoktorId.getText().length() == 0) {
					Helper.showMessage("L�tfen ge�erli bir doktor kayd� se�iniz.");
				} else {
					if (Helper.confirm("sure")) {
						int selectedID = Integer.parseInt(txtDoktorId.getText());
						try {
							boolean control = bashekim.deleteDoctor(selectedID);
							if (control) {
								Helper.showMessage("success");
								txtDoktorId.setText(null);
								updateDoctorModel();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}

			}
		});

		JPanel jPanelClinic = new JPanel();
		jPanelClinic.setBackground(Color.WHITE);
		tabbedPane.addTab("Poliklinikler", null, jPanelClinic, null);
		jPanelClinic.setLayout(null);

		JScrollPane scrollPaneClinic = new JScrollPane();
		scrollPaneClinic.setBounds(10, 11, 194, 304);
		jPanelClinic.add(scrollPaneClinic);

		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("G�ncelle");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);

		/*
		 * updateMenu.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { int selectedClinicID =
		 * Integer
		 * .parseInt(tableClinicList.getValueAt(tableClinicList.getSelectedRow(),
		 * 0).toString()); Clinic SelectedClinic = clinic.getFetch(selectedClinicID);
		 * UpdateClinicGUI updateGUI = new UpdateClinicGUI(SelectedClinic);
		 * updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 * updateGUI.setVisible(true); updateGUI.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosed(WindowEvent e) { try {
		 * updateClinicModel(); } catch (Exception e2) { e2.printStackTrace(); }
		 * 
		 * } }); }
		 * 
		 * });
		 */

		/*
		 * tableClinicList = new JTable(clinicModel);
		 * tableClinicList.setComponentPopupMenu(clinicMenu);
		 * tableClinicList.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mousePressed(MouseEvent e) { super.mousePressed(e);
		 * Point point = e.getPoint(); // gettin click coordinates int selectedRow =
		 * tableClinicList.rowAtPoint(point);
		 * tableClinicList.setRowSelectionInterval(selectedRow, selectedRow); } });
		 */

		scrollPaneClinic.setViewportView(tableClinicList);

		JLabel lblClinicName = new JLabel("Poliklinik Ad\u0131");
		lblClinicName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblClinicName.setBounds(214, 8, 110, 20);
		jPanelClinic.add(lblClinicName);

		txtClinicName = new JTextField();
		txtClinicName.setBounds(214, 30, 110, 20);
		jPanelClinic.add(txtClinicName);
		txtClinicName.setColumns(10);

		JButton btnAddClinic = new JButton("Ekle");

		btnAddClinic.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddClinic.setBounds(214, 61, 110, 31);
		jPanelClinic.add(btnAddClinic);

		JScrollPane scrollPaneEmployee = new JScrollPane();
		scrollPaneEmployee.setBounds(334, 11, 187, 304);
		jPanelClinic.add(scrollPaneEmployee);

		tableEmployee = new JTable();
		scrollPaneEmployee.setViewportView(tableEmployee);

		JComboBox cbxSelectDoctor = new JComboBox();
		cbxSelectDoctor.setBounds(214, 244, 110, 22);
		for (int i = 0; i < bashekim.GetDoctorList().size(); i++) {
			cbxSelectDoctor.addItem(
					new Item(bashekim.GetDoctorList().get(i).getId(), bashekim.GetDoctorList().get(i).getName()));
		}
		cbxSelectDoctor.addActionListener(e -> { // lambda expression
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getKey() + " : " + item.getValue());
		});
		jPanelClinic.add(cbxSelectDoctor);

		JButton btnAddSelectedDoctor = new JButton("Doktor ekle");
		btnAddSelectedDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClinicList.getSelectedRow();
				if (selectedRow >= 0) {
					String selClinic = tableClinicList.getModel().getValueAt(selectedRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					Item doctorItem = (Item) cbxSelectDoctor.getSelectedItem();
					try {
						boolean control = bashekim.addEmployee(doctorItem.getKey(), selClinicID);
						if (control) {
							Helper.showMessage("success");
						} else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					Helper.showMessage("L�tfen bir poliklinik se�iniz.");
				}
			}
		});

		btnAddSelectedDoctor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddSelectedDoctor.setBounds(214, 277, 110, 31);
		jPanelClinic.add(btnAddSelectedDoctor);

		JButton btnChooseClinic = new JButton("Se\u00E7");
		btnChooseClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow= tableClinicList.getSelectedRow();
				if(selectedRow >0 ) {
					String selClinic = tableClinicList.getModel().getValueAt(selectedRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					DefaultTableModel clearModel= (DefaultTableModel) tableEmployee.getModel(); // clear table
					clearModel.setRowCount(0);
					
					try {
						for(int i=0; i< bashekim.getClinicSpecificDoctorlist(selClinicID).size();i++) {
							employeeData[0]=bashekim.getClinicSpecificDoctorlist(selClinicID).get(i).getId();
							employeeData[1]=bashekim.getClinicSpecificDoctorlist(selClinicID).get(i).getName();
							employeeModel.addRow(employeeData);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					tableEmployee.setModel(employeeModel);
					
				}else {
					Helper.showMessage("L�tfen bir poliklinik se�iniz.");
				}
			}
		});
		btnChooseClinic.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnChooseClinic.setBounds(214, 169, 110, 31);
		jPanelClinic.add(btnChooseClinic);

		JLabel lblClinicNameChoose = new JLabel("Poliklinik Ad\u0131");
		lblClinicNameChoose.setFont(new Font("Arial", Font.PLAIN, 14));
		lblClinicNameChoose.setBounds(214, 138, 110, 20);
		jPanelClinic.add(lblClinicNameChoose);

		btnAddClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtClinicName.getText().length() == 0) {
					Helper.showMessage("L�tfen klinik ad�n� bo� b�rakmay�n�z.");
				} else {
					try {
						if (clinic.addClinic(txtClinicName.getText())) {
							Helper.showMessage("success");
							txtClinicName.setText(null);
							updateClinicModel();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}

	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) jtableDoktorList.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < bashekim.GetDoctorList().size(); i++) {
			doctorData[0] = bashekim.GetDoctorList().get(i).getId();
			doctorData[1] = bashekim.GetDoctorList().get(i).getTc_No();
			doctorData[2] = bashekim.GetDoctorList().get(i).getPassword();
			doctorData[3] = bashekim.GetDoctorList().get(i).getName();
			doctorModel.addRow(doctorData);
		}
	}

	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableClinicList.getModel(); // type casting
		clearModel.setRowCount(0);
		for (int i = 0; i < clinic.GetClinicList().size(); i++) {
			clinicData[0] = clinic.GetClinicList().get(i).getId();
			clinicData[1] = clinic.GetClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
	}
}
