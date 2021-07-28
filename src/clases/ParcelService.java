package clases;

public class ParcelService {
	private int ParcelServiceId;
	private String Name;

	public ParcelService () {}
	
	public ParcelService(String name) {
		this.Name = name;
	}
	
	public int getId() {
		return ParcelServiceId;
	}
	public void setId(int id) {
		this.ParcelServiceId = id;
	}
	public String getName() {
	      return Name;
	}
	public void setName( String name ) {
	      this.Name = name;
	}
	

}
