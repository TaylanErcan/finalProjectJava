package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Bashekim extends User {

	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.conDb();
	PreparedStatement preparedStatement = null;

	public Bashekim(int id, String tc_No, String password, String name, String type) {
		super(id, tc_No, password, name, type);

	}

	public Bashekim() {
	}

	public ArrayList<User> GetDoctorList() throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery(" SELECT * FROM user WHERE Type='Doktor' ");
			while (rs.next()) {
				obj = new User(rs.getInt("Id"), rs.getString("Tc_No"), rs.getString("Password"), rs.getString("Name"),
						rs.getString("Type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addDoctor(String tcno, String password, String name) throws SQLException {

		String query = "INSERT INTO user" + "(Tc_No,Password,Name,Type) VALUES" + "(?,?,?,?)";
		boolean trueFalseFlag = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "Doktor");
			preparedStatement.executeUpdate();
			trueFalseFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (trueFalseFlag)
			return true;
		else
			return false;

	}

	public boolean deleteDoctor(int id) throws SQLException {

		String query = "DELETE FROM user WHERE Id = ?";
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

	public boolean updateDoctor(int id, String tcno, String password, String name) throws SQLException {

		String query = "UPDATE user SET Tc_No=?, Password=?, Name=? WHERE Id=?";
		boolean successOrFailFlag = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, id);
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

	public boolean addEmployee(int userId, int clinicId) throws SQLException {

		String query = "INSERT INTO employee" + "(clinic_id,user_id) VALUES" + "(?,?)";
		boolean trueFalseFlag = false;
		int count = 0; // to prevent adding same employee to same clinic twice or more
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM employee where clinic_id=" + clinicId + " AND user_id=" + userId);
			while (rs.next()) {
				count++;
			}
			if (count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, clinicId);
				preparedStatement.setInt(2, userId);
				preparedStatement.executeUpdate();
				trueFalseFlag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (trueFalseFlag)
			return true;
		else
			return false;

	}

	public ArrayList<User> getClinicSpecificDoctorlist(int clinicId) throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery(
					" SELECT u.Id, u.Tc_No, u.Password, u.Name, u.Type FROM employee e LEFT JOIN user u ON e.user_id=u.Id WHERE clinic_id="
					+ clinicId); // left join
																																
			while (rs.next()) {
				obj = new User(rs.getInt("u.Id"), rs.getString("u.Tc_No"), rs.getString("u.Password"), rs.getString("u.Name"),
						rs.getString("Type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
