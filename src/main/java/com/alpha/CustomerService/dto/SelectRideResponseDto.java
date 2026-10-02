package com.alpha.CustomerService.dto;

import java.util.List;

public class SelectRideResponseDto {

    private double distance;
    private List<RideOptionDto> rides;

    public SelectRideResponseDto() {
    }

    public SelectRideResponseDto(double distance,
                                 List<RideOptionDto> rides) {
        this.distance = distance;
        this.rides = rides;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<RideOptionDto> getRides() {
        return rides;
    }

    public void setRides(List<RideOptionDto> rides) {
        this.rides = rides;
    }
}