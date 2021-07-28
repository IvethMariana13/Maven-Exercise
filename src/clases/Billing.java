package clases;
import java.util.HashSet;
import java.util.Set;
import java. util.Date;

public class Billing implements java.io.Serializable{
	private Integer InvoceId;
	private short Amount;
	private Date Date_Billing;
	private Set POrderId = new HashSet(0);
	
	public Billing () {
		
	}
	public Billing (Integer InvoceId) {
		this.InvoceId = InvoceId;
	}
	public Billing (short Amount, Date Date_Billing) {
		this.Amount = Amount;
		this.Date_Billing = Date_Billing;
	}
	public Billing (short Amount, Date Date_Billing, Set POrderId) {
		this.Amount = Amount;
		this.Date_Billing = Date_Billing;
		this.POrderId = POrderId;
	}
	
	public Integer getInvoceId () {
		return this.InvoceId;
	}
	public void setInvoceId (Integer InvoceId) {
		this.InvoceId = InvoceId;
	}
	public short getAmount () {
		return this.Amount;
	}
	public void setAmount (short Amount) {
		this.Amount = Amount;
	}
	public Date getDate_Billing() {
		return this.Date_Billing;
	}
	public void setDate(Date Date_Billing) {
		this.Date_Billing = Date_Billing;
	}
	public Set getPOrderId () {
		return this.POrderId;
	}
	public void setPOrderId (Set POrderId) {
		this.POrderId = POrderId;
	}
	
}
