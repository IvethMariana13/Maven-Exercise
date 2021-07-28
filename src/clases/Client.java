package clases;

public class Client {
	private int ClientId;
	private String Name;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	
	public Client () {}
	
	public Client (String name, String lname, String usname, String pwd, String email) {
		this.Name = name;
		this.LastName = lname;
		this.UserName = usname;
		this.Password = pwd;
		this.Email = email;
	}
	
	public int getClientId() {
		return ClientId;
	}
	public void setClientId(int idclient) {
		this.ClientId = idclient;
	}
	
	public String getName() {
	      return Name;
	}
	public void setName (String name) {
		this.Name = name;
	}
	
	public String getLastName() {
	      return LastName;
	}
	public void setLastName (String last_name) {
		this.LastName = last_name;
	}
	
	public String getUserName() {
	      return UserName;
	}
	public void setUserName (String username) {
		this.UserName = username;
	}
	
	public String getPassword() {
	      return Password;
	}
	public void setPassword (String password) {
		this.Password = password;
	}
	
	public String getEmail() {
	      return Email;
	}
	public void setEmail (String email) {
		this.Email = email;
	}
	
}
