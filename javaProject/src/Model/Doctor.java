package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Doctor extends User {
	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.conDb();
	PreparedStatement preparedStatement = null;

	public Doctor() {
		super();
	}

	public Doctor(int id, String Tc_No, String password, String name, String type) {
		super(id, Tc_No, password, name, type);
	}

	public boolean addWorkHour(int doctor_id, String doctor_name, String wdate) throws SQLException {
		int key = 0;
		String query = "INSERT INTO whour" + "(DoctorId,DoctorName,wDate) VALUES" + "(?,?,?)";
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM whour WHERE Status='Aktif' AND DoctorId=" + doctor_id + " AND wDate='"
					+ wdate + "'");

			while (rs.next()) {
				count++;
				break;
			}
			if (count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, doctor_id);
				preparedStatement.setString(2, doctor_name);
				preparedStatement.setString(3, wdate);
				preparedStatement.executeUpdate();
			}

			key = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (key == 1)
			return true;
		else
			return false;
	}

	public ArrayList<WHour> getWHourList(int doctor_id) throws SQLException {
		ArrayList<WHour> list = new ArrayList<>();
		WHour obj;
		try {
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

	public boolean deleteWHour(int id) throws SQLException {

		String query = "DELETE FROM whour WHERE Id = ?";
		boolean successOrFailFlag = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			successOrFailFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (successOrFailFlag)
			return true;
		else
			return false;
	}

}
