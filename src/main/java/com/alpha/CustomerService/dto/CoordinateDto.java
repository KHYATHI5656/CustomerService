package com.alpha.CustomerService.dto;


public class CoordinateDto {
	
    private double lat;
    private double lon;
	public CoordinateDto( double lat, double lon) {
		super();
		
		this.lat = lat;
		this.lon = lon;
	}
	public CoordinateDto() {
		super();
		// TODO Auto-generated constructor stub
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