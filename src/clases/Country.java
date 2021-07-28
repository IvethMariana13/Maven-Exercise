package clases;

public class Country {
	private int id;
	private String Name;
	
	public Country() {}
	
	public Country(String Name) {
		this.Name = Name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName (String Name) {
		this.Name = Name;
	}
}
