package com.alpha.CustomerService.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.CustomerService.dto.CoordinateDto;
import com.alpha.CustomerService.dto.NearbyRiderDto;
import com.alpha.CustomerService.dto.NearbyRiderResponseDto;
import com.alpha.CustomerService.dto.RideOptionDto;
import com.alpha.CustomerService.dto.SearchDestinationLocationDto;
import com.alpha.CustomerService.dto.SelectRideDto;
import com.alpha.CustomerService.dto.SelectRideResponseDto;
import com.alpha.CustomerService.dto.TemporaryRideDto;
import com.alpha.CustomerService.dto.customerdto;
import com.alpha.CustomerService.entity.booking;
import com.alpha.CustomerService.entity.customer;
import com.alpha.CustomerService.repository.bookingrepo;
import com.alpha.CustomerService.repository.customerrepo;
import java.util.UUID;

@Service
public class customerservice {
	@Autowired
	private customerrepo customerRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private bookingrepo bookingRepo;

	@Autowired
	private redisservice redisService;
	//create customer
	public customer createcustomer(customerdto dto) {
		customer cust=new customer();
		cust.setName(dto.getName());
		cust.setMobile(dto.getMobile());
		cust.setEmail(dto.getEmail());
		cust.setGender(dto.getGender());
		return customerRepo.save(cust);
		
	}
	//find customer
	public customer findcustomer(int id) {
		return customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
	}
	//delete customer
	public void deletecustomer(int id) {
		customerRepo.deleteById(id);
	}
	//search operation
	public List<SearchDestinationLocationDto> searchPlace(String searchKey) {

		String url = "https://us1.locationiq.com/v1/search?key=pk.5c116c763b2f2bc038c444cec968857c&q=" + searchKey
				+ "%20&format=json&";

		ArrayList<Map<String, Object>> response = restTemplate.getForObject(url, ArrayList.class);

		List<SearchDestinationLocationDto> searchDestinationLocationDtolist = new ArrayList<SearchDestinationLocationDto>();

		for (Map<String, Object> object : response) {

			String lat = (String) object.get("lat");
			
			double lati = Double.parseDouble(lat);
			
			String lon = (String) object.get("lon");
			double longi = Double.parseDouble(lon);

			SearchDestinationLocationDto destinationLocationDto = new SearchDestinationLocationDto(
					(String) object.get("display_name"), lati, longi);
			
			searchDestinationLocationDtolist.add(destinationLocationDto);
		}

		return searchDestinationLocationDtolist;
	}
	//selectRide operation
	public SelectRideResponseDto selectRide(SelectRideDto dto) {

	    double sourceLat = dto.getSourceCoord().getLat();
	    double sourceLon = dto.getSourceCoord().getLon();

	    double destLat = dto.getDestCoord().getLat();
	    double destLon = dto.getDestCoord().getLon();

	    // Third-party API to calculate distance
	    String url = "https://router.project-osrm.org/route/v1/driving/"+ sourceLon + "," + sourceLat+ ";" + destLon + "," + destLat + "?overview=false";

	    Map<String, Object> response = restTemplate.getForObject(url, HashMap.class);

	    ArrayList<Map<String, Object>> routes =(ArrayList<Map<String, Object>>) response.get("routes");

	    Map<String, Object> route = routes.get(0);

	    // Distance in meters
	    double distanceInMeters =((Number) route.get("distance")).doubleValue();

	    // Convert meters to KM
	    double distanceInKm = distanceInMeters / 1000;

	    // Calculate cost for each vehicle
	    double bikeCost = 30 + (distanceInKm * 8);

	    double autoCost = 40 + (distanceInKm * 12);

	    double carCost = 60 + (distanceInKm * 18);
	 // Round to 1 decimal place
	    bikeCost = Math.round(bikeCost * 10.0) / 10.0;
	    autoCost = Math.round(autoCost * 10.0) / 10.0;
	    carCost = Math.round(carCost * 10.0) / 10.0;

	    // Create ride options
	    List<RideOptionDto> rides = new ArrayList<>();

	    rides.add(new RideOptionDto("BIKE", bikeCost));
	    rides.add(new RideOptionDto("AUTO", autoCost));
	    rides.add(new RideOptionDto("CAR", carCost));

	    // Return response
	    return new SelectRideResponseDto( distanceInKm, rides);
	}
	
	public booking confirmRide(int customerId) {

	    TemporaryRideDto ride = redisService.getTemporaryRide(customerId);

	    if (ride == null) {
	        throw new RuntimeException("No temporary ride found for customer: " + customerId);
	    }

	    booking book = new booking();
	    book.setIdempotencyId(UUID.randomUUID().toString());

	    book.setCustomerId(customerId);
	    
	    book.setSourceLatitude(ride.getSourceLatitude());
	    book.setSourceLongitude(ride.getSourceLongitude());

	    book.setDestinationLatitude(ride.getDestinationLatitude());
	    book.setDestinationLongitude(ride.getDestinationLongitude());

	    book.setSourceLocation(ride.getSourceLocation());
	    book.setDestinationLocation(ride.getDestinationLocation());

	    book.setRiderId(ride.getRiderId());
	    book.setPaymentType(ride.getPaymentType());
	    book.setVehicleType(ride.getVehicleType());
	    book.setFare(ride.getFare());

	    book.setBookingDate(LocalDate.now());
	    book.setBookingTime(LocalTime.now());
	    String otp = String.valueOf((int)(Math.random() * 9000) + 1000);
	    book.setOtp(otp);

	    book.setStatus("CONFIRMED");
	    book.setRiderStatus("PENDING");
	    book.setPlatformStatus("CONFIRMED");

	    booking savedBooking = bookingRepo.save(book);

	    redisService.deleteTemporaryRide(customerId);

	    return savedBooking;
	}

	public int findNearbyRider(double latitude, double longitude, String vehicleType) {

	    NearbyRiderDto request = new NearbyRiderDto(
	            latitude,
	            longitude,
	            vehicleType,
	            5
	    );

	    String url = "http://localhost:8083/rider/nearby";

	    NearbyRiderResponseDto response =
	            restTemplate.postForObject(
	                    url,
	                    request,
	                    NearbyRiderResponseDto.class
	            );

	    if (response == null ||
	            response.getRiders() == null ||
	            response.getRiders().isEmpty()) {

	        throw new RuntimeException("No nearby rider found");
	    }

	    return Integer.parseInt(response.getRiders().get(0));
	}

	public void saveTemporaryRide(TemporaryRideDto dto) {

	    int riderId = findNearbyRider(
	            dto.getSourceLatitude(),
	            dto.getSourceLongitude(),
	            dto.getVehicleType()
	    );

	    dto.setRiderId(riderId);

	    redisService.saveTemporaryRide(
	            dto.getCustomerId(),
	            dto
	    );
	}

	public booking getBookingById(int bookingId) {

	    return bookingRepo.findById(bookingId)
	            .orElseThrow(() ->
	                new RuntimeException("Booking not found: " + bookingId));
	}
	public String cancelRide(int bookingId) {

	    Optional<booking> optionalBooking = bookingRepo.findById(bookingId);

	    if (optionalBooking.isEmpty()) {
	        return "Booking not found";
	    }

	    booking ride = optionalBooking.get();

	    if (ride.getStatus().equals("CONFIRMED")) {

	        ride.setStatus("CANCELLED");
	        ride.setRiderStatus("CANCELLED");
	        ride.setPlatformStatus("CANCELLED");
	        

	        bookingRepo.save(ride);

	        return "Ride cancelled successfully";
	    }

	    if (ride.getStatus().equals("STARTED")) {
	        return "Ride cannot be cancelled because it has already started";
	    }

	    return "Ride cannot be cancelled in the current status";
	}
	public List<booking> rideHistory(int customerId, String status) {

	    if (status.equalsIgnoreCase("all")) {
	        return bookingRepo.findByCustomerId(customerId);
	    }

	    return bookingRepo.findByCustomerIdAndStatus(customerId, status);

	}
}