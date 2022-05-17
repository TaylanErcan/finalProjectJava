package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.Helper;

public class Patient extends User {

	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.conDb();
	PreparedStatement preparedStatement = null;

	public Patient() {
	}

	public Patient(int id, String Tc_No, String password, String name, String type) {
		super(id, Tc_No, password, name, type);
	}

	public boolean Register(String tcno, String password, String name) throws SQLException {
		int key = 0;
		String query = "INSERT INTO user" + "(Tc_No,Password,Name,Type) VALUES" + "(?,?,?,?)";
		boolean duplicate = false;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE Tc_No='" + tcno + "'");

			while (rs.next()) {
				duplicate = true;
				Helper.showMessage("Bu TC numarasýna kayýtlý bir hasta zaten var!");
				break;
			}
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, tcno);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, name);
				preparedStatement.setString(4, "Hasta");
				preparedStatement.executeUpdate();
				key = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (key == 1)
			return true;
		else
			return false;
	}

	public boolean AddAppointment(int doctor_id, int patient_id, String doctor_name, String patient_name,
			String app_date) throws SQLException {
		int key = 0;
		String query = "INSERT INTO appointment" + "(DoctorId,PatientId,DoctorName,PatientName,AppDate) VALUES"
				+ "(?,?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, doctor_id);
			preparedStatement.setInt(2, patient_id);
			preparedStatement.setString(3, doctor_name);
			preparedStatement.setString(4, patient_name);
			preparedStatement.setString(5, app_date);
			preparedStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (key == 1)
			return true;
		else
			return false;
	}

	public boolean updateWHourStatus(int doctor_id, String wHour) throws SQLException {
		int key = 0;
		String query = "UPDATE whour SET Status=? WHERE DoctorId=? AND wDate=?";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, "Pasif");
			preparedStatement.setInt(2, doctor_id);
			preparedStatement.setString(3, wHour);
			preparedStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (key == 1)
			return true;
		else
			return false;
	}

}
