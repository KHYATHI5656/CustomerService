package com.alpha.CustomerService.dto;

public class SearchDestinationLocationDto {
	private String address;
	private double lat;
	private double lon;

	public SearchDestinationLocationDto(String address, double lat, double lon) {
		super();
		this.address = address;
		this.lat = lat;
		this.lon = lon;
	}

	public SearchDestinationLocationDto() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

}