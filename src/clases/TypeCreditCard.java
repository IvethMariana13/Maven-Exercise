package clases;

public class TypeCreditCard {
	private int TypeCardId;
	private String Type;
	
	public TypeCreditCard() {}
	
	public TypeCreditCard(String cctype ) {
		this.Type = cctype;
	}
	public int getTCCId() {
		return TypeCardId;
	}
	public void setTCCId(int TCCId ) {
		this.TypeCardId = TCCId;
	}
	
	public String getType() {
		return Type;
	}
	public void SetType(String type ) {
		this.Type = type;
	}
}
