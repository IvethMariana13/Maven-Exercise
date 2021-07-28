package clases;

public class State {
	private int StateId;
	private String Name;
	
	public State () {}
	
	public State(String Name) {
		this.Name = Name;
	}
	public int getId() {
		return StateId;
	}
	public void setId(int id) {
		this.StateId = id;
	}
	public String getName() {
		return Name;
	}
	public void setName (String Name) {
		this.Name = Name;
	}
}
