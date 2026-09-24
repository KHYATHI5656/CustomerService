package com.alpha.CustomerService.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int customerId;
	private int pickupAddressId;
	private int destinationAddressId;
	private int riderId;
	private String paymentType;
	private String vehicleType;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private LocalTime pickupTime;
	private LocalTime dropTime;
	private double fare;
	public booking(int customerId, int pickupAddressId, int destinationAddressId, int riderId, String paymentType,
			String vehicleType, LocalDate bookingDate, LocalTime bookingTime, LocalTime pickupTime, LocalTime dropTime,
			double fare) {
		super();
		this.customerId = customerId;
		this.pickupAddressId = pickupAddressId;
		this.destinationAddressId = destinationAddressId;
		this.riderId = riderId;
		this.paymentType = paymentType;
		this.vehicleType = vehicleType;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.fare = fare;
	}
	public booking() {
		super();
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
	public int getPickupAddressId() {
		return pickupAddressId;
	}
	public void setPickupAddressId(int pickupAddressId) {
		this.pickupAddressId = pickupAddressId;
	}
	public int getDestinationAddressId() {
		return destinationAddressId;
	}
	public void setDestinationAddressId(int destinationAddressId) {
		this.destinationAddressId = destinationAddressId;
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
	@Override
	public String toString() {
		return "booking [id=" + id + ", customerId=" + customerId + ", pickupAddressId=" + pickupAddressId
				+ ", destinationAddressId=" + destinationAddressId + ", riderId=" + riderId + ", paymentType="
				+ paymentType + ", vehicleType=" + vehicleType + ", bookingDate=" + bookingDate + ", bookingTime="
				+ bookingTime + ", pickupTime=" + pickupTime + ", dropTime=" + dropTime + ", fare=" + fare + "]";
	}
	
	
	
	
	

}
