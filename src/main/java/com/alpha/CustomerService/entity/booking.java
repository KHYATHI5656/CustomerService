package com.alpha.CustomerService.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String idempotencyId;
    private int customerId;

    private double sourceLatitude;
    private double sourceLongitude;

    private double destinationLatitude;
    private double destinationLongitude;

    private String sourceLocation;
    private String destinationLocation;

    private int riderId;

    private String paymentType;

    private String vehicleType;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private LocalTime pickupTime;

    private LocalTime dropTime;

    private double fare;
    private String otp;

    private String status;
    private String riderStatus;
    private String platformStatus;

    public booking() {
        super();
    }
    public booking(String idempotencyId, int customerId, double sourceLatitude, double sourceLongitude,
			double destinationLatitude, double destinationLongitude, String sourceLocation, String destinationLocation,
			int riderId, String paymentType, String vehicleType, LocalDate bookingDate, LocalTime bookingTime,
			LocalTime pickupTime, LocalTime dropTime, double fare, String status, String riderStatus,
			String platformStatus,String otp) {
		super();
		this.idempotencyId = idempotencyId;
		this.customerId = customerId;
		this.sourceLatitude = sourceLatitude;
		this.sourceLongitude = sourceLongitude;
		this.destinationLatitude = destinationLatitude;
		this.destinationLongitude = destinationLongitude;
		this.sourceLocation = sourceLocation;
		this.destinationLocation = destinationLocation;
		this.riderId = riderId;
		this.paymentType = paymentType;
		this.vehicleType = vehicleType;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.fare = fare;
		this.status = status;
		this.riderStatus = riderStatus;
		this.platformStatus = platformStatus;
		this.otp=otp;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalTime getDropTime() {
        return dropTime;
    }

    public void setDropTime(LocalTime dropTime) {
        this.dropTime = dropTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getIdempotencyId() {
        return idempotencyId;
    }

    public void setIdempotencyId(String idempotencyId) {
        this.idempotencyId = idempotencyId;
    }
    public String getRiderStatus() {
        return riderStatus;
    }

    public void setRiderStatus(String riderStatus) {
        this.riderStatus = riderStatus;
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus;
    }
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}