package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public Appointment() {};
	
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
	
	
}
