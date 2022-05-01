package Model;

public class User {
	
	private int Id;
	public int getId() {
		return Id;
	}
	public User(int id, String tc_No, String password, String name, String type) {
		super();
		Id = id;
		Tc_No = tc_No;
		Password = password;
		Name = name;
		Type = type;
	}
	
	public User() {}
	
	
	public void setId(int id) {
		Id = id;
	}
	public String getTc_No() {
		return Tc_No;
	}
	public void setTc_No(String tc_No) {
		Tc_No = tc_No;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	private String Tc_No;
	private String Password;
	private String Name;
	private String Type;
}
