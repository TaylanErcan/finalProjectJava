package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Appointment {
	private int id, doctorId, patientId;
	private String doctorName, patientName, appointmentDate;

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Appointment(int id, int doctorId, int patientId, String doctorName, String patientName,
			String appointmentDate) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.doctorName = doctorName;
		this.patientName = patientName;
		this.appointmentDate = appointmentDate;
	}

	public Appointment() {
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public ArrayList<Appointment> GetPatientAppList(int patient_id) throws SQLException {
		ArrayList<Appointment> list = new ArrayList<>();
		Connection con = conn.conDb();
		Appointment obj;
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE PatientId=" + patient_id);
			while (rs.next()) {
				obj = new Appointment();
				obj.setId(rs.getInt("Id"));
				obj.setDoctorId(rs.getInt("DoctorId"));
				obj.setDoctorName(rs.getString("DoctorName"));
				obj.setPatientId(rs.getInt("PatientId"));
				obj.setPatientName(rs.getString("PatientName"));
				obj.setAppointmentDate(rs.getString("AppDate"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;
	}
	
	public ArrayList<Appointment> GetDoctorAppList(int doctor_id) throws SQLException {
		ArrayList<Appointment> list = new ArrayList<>();
		Connection con = conn.conDb();
		Appointment obj;
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE DoctorId=" + doctor_id);
			while (rs.next()) {
				obj = new Appointment();
				obj.setId(rs.getInt("Id"));
				obj.setDoctorId(rs.getInt("DoctorId"));
				obj.setDoctorName(rs.getString("DoctorName"));
				obj.setPatientId(rs.getInt("PatientId"));
				obj.setPatientName(rs.getString("PatientName"));
				obj.setAppointmentDate(rs.getString("AppDate"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;
	}

}
