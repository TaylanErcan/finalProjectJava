package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public ArrayList<WHour> getWHourList(int doctor_id) throws SQLException {
		ArrayList<WHour> list = new ArrayList<>();
		WHour obj;
		try {
			Connection con = conn.conDb();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM whour WHERE Status='Aktif' AND DoctorId=" + doctor_id);
			while (rs.next()) {
				obj = new WHour();
				obj.setId(rs.getInt("Id"));
				obj.setDoctorId(rs.getInt("DoctorId"));
				obj.setDoctorName(rs.getString("DoctorName"));
				obj.setStatus(rs.getString("Status"));
				obj.setWDate(rs.getString("wDate"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
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
