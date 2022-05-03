package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Bashekim extends User {
	

	public Bashekim(int id, String tc_No, String password, String name, String type) {
		super(id, tc_No, password, name, type);
		
	}
	
	public Bashekim() {}
	
	public ArrayList<User> GetDoctorList() throws SQLException{
		ArrayList<User> list= new ArrayList<>();
		Statement st= null;
		ResultSet rs= null;
		Connection con= conn.conDb();
		User obj;
		try {
			st= con.createStatement();
			rs= st.executeQuery(" SELECT * FROM user WHERE Type='Doktor' ");
			while(rs.next()) {
				obj=new User(rs.getInt("Id"),rs.getString("Tc_No"),rs.getString("Password"),rs.getString("Name"),rs.getString("Type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st.close();
			rs.close();
			con.close();
		}
		
		return list;

	}
}
