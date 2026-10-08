package com.alpha.CustomerService.dto;

public class NearbyRiderDto {

    private double latitude;
    private double longitude;
    private String vehicleType;
    private double radiusInKm;

    public NearbyRiderDto() {
    }

    public NearbyRiderDto(double latitude, double longitude, String vehicleType, double radiusInKm) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleType = vehicleType;
        this.radiusInKm = radiusInKm;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getRadiusInKm() {
        return radiusInKm;
    }

    public void setRadiusInKm(double radiusInKm) {
        this.radiusInKm = radiusInKm;
    }
}