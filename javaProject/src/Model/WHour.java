package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Helper.DBConnection;

public class WHour {
	private int Id, DoctorId;
	private String DoctorName, WDate, Status;
	
	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public WHour(int id, int doctorId, String doctorName, String wDate, String status) {
		this.Id = id;
		this.DoctorId = doctorId;
		this.DoctorName = doctorName;
		this.WDate = wDate;
		this.Status = status;
	}
	
	public WHour() {};

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(int doctorId) {
		DoctorId = doctorId;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public String getWDate() {
		return WDate;
	}

	public void setWDate(String wDate) {
		WDate = wDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
