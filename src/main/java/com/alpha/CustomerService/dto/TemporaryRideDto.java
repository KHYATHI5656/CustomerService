package com.alpha.CustomerService.dto;

import java.io.Serializable;

public class TemporaryRideDto implements Serializable{

    private int customerId;

    private double sourceLatitude;
    private double sourceLongitude;

    private double destinationLatitude;
    private double destinationLongitude;

    private String sourceLocation;
    private String destinationLocation;

    private String vehicleType;

    private double fare;

    private String paymentType;

    private Integer riderId;

    public TemporaryRideDto() {
    }

    public TemporaryRideDto(
            int customerId,
            double sourceLatitude,
            double sourceLongitude,
            double destinationLatitude,
            double destinationLongitude,
            String sourceLocation,
            String destinationLocation,
            String vehicleType,
            double fare,
            String paymentType,
            Integer riderId) {

        this.customerId = customerId;
        this.sourceLatitude = sourceLatitude;
        this.sourceLongitude = sourceLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.vehicleType = vehicleType;
        this.fare = fare;
        this.paymentType = paymentType;
        this.riderId = riderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getSourceLatitude() {
        return sourceLatitude;
    }

    public void setSourceLatitude(double sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public double getSourceLongitude() {
        return sourceLongitude;
    }

    public void setSourceLongitude(double sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }

    public double getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public double getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }
}