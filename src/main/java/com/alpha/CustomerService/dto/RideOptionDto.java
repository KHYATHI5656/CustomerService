package com.alpha.CustomerService.dto;

public class RideOptionDto {

    private String vehicleType;
    private double cost;

    public RideOptionDto() {
    }

    public RideOptionDto(String vehicleType, double cost) {
        this.vehicleType = vehicleType;
        this.cost = cost;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}