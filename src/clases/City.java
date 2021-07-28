package clases;

public class City {
	private int CityId;
	private String Name;
	
	public City () {}
	
	public City(String Name) {
		this.Name = Name;
	}
	public int getId() {
		return CityId;
	}
	public void setId(int id) {
		this.CityId = id;
	}
	public String getName() {
		return Name;
	}
	public void setName (String Name) {
		this.Name = Name;
	}
}

