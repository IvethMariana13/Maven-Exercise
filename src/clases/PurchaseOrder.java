package clases;
import java.util.HashSet;
import java.util.Set;
import java. util.Date;
public class PurchaseOrder implements java.io.Serializable{
	private Integer POrderId;
	private Date Date_Order;
	private Set DeliveryAdId = new HashSet(0);
	
	
	public PurchaseOrder () {
		
	}
	public PurchaseOrder (Integer POrderId) {
		this.POrderId = POrderId;
	}
	public PurchaseOrder (Date Date_Order) {
		this.Date_Order = Date_Order;
	}
	
	public PurchaseOrder (Date Date_Order, Set DeliveryAdId) {
		this.Date_Order = Date_Order;
		this.DeliveryAdId = DeliveryAdId;
		
	}
	public Integer getPOrderId () {
		return this.POrderId;
	}
	public void setPOrderId (Integer POrderId) {
		this.POrderId = POrderId;
	}
	
	public Date getDate_Order() {
		return this.Date_Order;
	}
	public void setDate_Order(Date Date_Order) {
		this.Date_Order = Date_Order;
	}
	public Set getDeliveryAdId() {
		return this.DeliveryAdId;
	}
	public void setDeliveryAdId (Set DeliveryAdId) {
		this.DeliveryAdId = DeliveryAdId;
	}
	
	
	

}
