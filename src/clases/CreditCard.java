package clases;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class CreditCard implements java.io.Serializable{
	private Integer CreditCardId;
	private Integer CardNumber; 
	private String CardHolder; 
	private Set ClientId = new HashSet(0); 
	private Set TypeCardId = new HashSet(0);
	
	public CreditCard() {
		
	}
	
	public CreditCard (Integer CreditCardId) {
		this.CreditCardId = CreditCardId;
	}
	public CreditCard (Integer CardNumber, String CardHolder) {
		this.CardNumber = CardNumber;
		this.CardHolder = CardHolder;
		
	}
	
	public CreditCard (Integer CardNumber, String CardHolder, Set ClientId, Set TypeCardId) {
		this.CardNumber = CardNumber;
		this.CardHolder = CardHolder;
		this.ClientId = ClientId;
		this.TypeCardId = TypeCardId;
	}
	
	public Integer getCreditCardId() {
		return this.CreditCardId;
	}
	public void setDate_Order(Integer CreditCardId) {
		this.CreditCardId = CreditCardId;
	}
	public Integer getCardNumber() {
		return this.CardNumber;
	}
	public void setCardNumber(Integer CardNumber) {
		this.CardNumber = CardNumber;
	}
	
	public String getCardHolder() {
		return this.CardHolder;
	}
	public void setCardHolder(String CardHolder) {
		this.CardHolder = CardHolder;
	}
	
	public Set getClientId() {
		return this.ClientId;
	}
	public void setClientId (Set ClientId) {
		this.ClientId = ClientId;
	}
	
	public Set getTypeCardId() {
		return this.TypeCardId;
	}
	public void setTypeCardId (Set TypeCardId) {
		this.TypeCardId = TypeCardId;
	}
}

