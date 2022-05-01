package Helper;
import java.sql.*;

public class DBConnection {
	Connection con= null;
	
	public DBConnection(){
		
	}
	
	public Connection conDb() {
		try {
			this.con= DriverManager.getConnection("jdbc:mariadb://localhost:3306/Hospital?user=root&password=bidahaunutma94");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
