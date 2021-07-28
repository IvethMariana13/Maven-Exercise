package clases;
import java.util.HashSet;
import java.util.Set;


public class DeliveryAddress implements java.io.Serializable {
	private Integer DeliveryAdId; 
	private String Street; 
	private String Number;
	private Set CityId = new HashSet(0);
	private Set StateId = new HashSet(0);
	private Set CountryId = new HashSet(0);
	private Set ClientId = new HashSet(0);
	
	public DeliveryAddress() {
		
	}
	
	public DeliveryAddress(Integer DeliveryAddress) {
		this.DeliveryAdId = DeliveryAddress;
	}
	
	public DeliveryAddress(String Street, String Number) {
		this.Street = Street;
		this.Number = Number;
	}
	
	public DeliveryAddress(String Street, String Number, Set IdCity, Set IdState, Set IdCountry, Set IdClient) {
		this.Street = Street;
		this.Number = Number;
		this.CityId = IdCity;
		this.StateId = IdState;
		this.ClientId = IdClient;
	}
	
	public Integer getDeliveryAdId() {
		return this.DeliveryAdId;
	}
	public void setDeliveryAdId(Integer DeliveryAdId) {
		this.DeliveryAdId = DeliveryAdId;
	}
	
	public String getStreet() {
		return this.Street;
	}
	public void setStreet(String Street) {
		this.Street = Street;
	}
	
	public String getNumber() {
		return this.Number;
	}
	public void setNumber (String Number) {
		this.Number = Number;
	}
	
	public Set getCityId() {
		return this.CityId;
	}
	public void setCityId (Set CityId) {
		this.CityId = CityId;
	}
	
	public Set getStateId () {
		return this.StateId;
	}
	public void setStateId (Set StateId) {
		this.StateId = StateId;
	}
	
	public Set getCountryId () {
		return this.CountryId;
	}
	public void setCountryId (Set CountryId) {
		this.CountryId = CountryId;
	}
	
	public Set getClientId () {
		return this.ClientId;
	}
	public void setClientId (Set ClientId) {
		this.ClientId = ClientId;
	}
	
	
	
	

}
