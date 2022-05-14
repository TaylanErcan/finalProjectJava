package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Clinic {

	private int Id;
	private String Name;

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Clinic(int id, String name) {
		super();
		Id = id;
		Name = name;
	}

	public Clinic() {
	}

	public ArrayList<Clinic> GetClinicList() throws SQLException {
		ArrayList<Clinic> list = new ArrayList<>();
		Connection con = conn.conDb();
		Clinic obj;
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");
			while (rs.next()) {
				obj = new Clinic();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
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

	public boolean addClinic(String name) throws SQLException {

		String query = "INSERT INTO clinic" + "(Name) VALUES" + "(?)";
		Connection con = conn.conDb();
		boolean trueFalseFlag = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
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

	public boolean deleteClinic(int id) throws SQLException {

		String query = "DELETE FROM clinic WHERE Id = ?";
		boolean successOrFailFlag = false;
		Connection con = conn.conDb();
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

	public boolean updateClinic(int id, String name) throws SQLException {

		String query = "UPDATE clinic SET name=? WHERE Id=?";
		boolean successOrFailFlag = false;
		Connection con = conn.conDb();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
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
	
	public Clinic getFetch(int id) {
		Connection con = conn.conDb();
		Clinic c= new Clinic();
		try {
			st= con.createStatement();
			rs=st.executeQuery("SELECT * FROM clinic WHERE Id=?");
			while(rs.next()) {
				c.setId(rs.getInt("Id"));
				c.setName(rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;	
		
	}
	
	public ArrayList<User> getClinicSpecificDoctorlist(int clinicId) throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		
		try {
			Connection con = conn.conDb();
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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

}
