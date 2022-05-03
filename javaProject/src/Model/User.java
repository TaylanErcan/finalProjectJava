package Model;

import Helper.DBConnection;

public class User {
	
	private int Id;
	private String tcno,name,password,type;
	DBConnection conn= new DBConnection();
	
	public User(int id, String Tc_No, String password, String name, String type) {
		this.Id = id;
		this.tcno = Tc_No;
		this.password = password;
		this.name = name;
		this.type = type;
	}
	
	public User() {}
	
	public int getId() {
		return this.Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getTc_No() {
		return this.tcno;
	}
	public void setTc_No(String Tc_No) {
		this.tcno = Tc_No;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
