package com.alpha.CustomerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String buildingName;
	private String street;
	private String landmark;
	private String city;
	private int pincode;
	private String state;
	private String country;
	public address(String buildingName, String street, String landmark, String city, int pincode, String state,
			String country) {
		super();
		this.buildingName = buildingName;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	public address() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "address [id=" + id + ", buildingName=" + buildingName + ", street=" + street + ", landmark=" + landmark
				+ ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}
	
	

}
