package clases;
import java.util.HashSet;
import java.util.Set;
import java. util.Date;

public class DeliveryPackage {
	private Integer PackageId; 
	private Date Date;
	private Set POrderId = new HashSet(0);
	private Set ParcelServiceId = new HashSet(0);
	
	public DeliveryPackage () {
		
	}
	public DeliveryPackage (Integer PackageId) {
		this.PackageId = PackageId;
	}
	
	public DeliveryPackage (Date Date) {
		this.Date = Date;
	}
	
	public DeliveryPackage (Date Date, Set POrderId, Set ParcelServiceId) {
		this.Date = Date;
		this.POrderId = POrderId;
		this.ParcelServiceId = ParcelServiceId;
	}
	
	public Integer getPackageId () {
		return this.PackageId;
	}
	public void setPackageId (Integer PackageId) {
		this.PackageId = PackageId;
	}
	
	public Date getDate() {
		return this.Date;
	}
	public void setDate(Date Date) {
		this.Date = Date;
	}
	public Set getPOrderId() {
		return this.POrderId;
	}
	public void setPOrderId (Set POrderId) {
		this.POrderId = POrderId;
	}
	
	public Set getParcelServiceId() {
		return this.ParcelServiceId;
	}
	public void ParcelServiceId (Set ParcelServiceId) {
		this.ParcelServiceId = ParcelServiceId;
	}
	
	
		
	
	
	
		
}
