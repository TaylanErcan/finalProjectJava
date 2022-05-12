package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String query = "INSERT INTO user" + "(Tc_No,Password,Name) VALUES" + "(?,?,?)";
		boolean duplicate = false;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE Tc_No='" + tcno + "'");

			while (rs.next()) {
				duplicate = true;
				break;
			}
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, tcno);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, name);
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

}
