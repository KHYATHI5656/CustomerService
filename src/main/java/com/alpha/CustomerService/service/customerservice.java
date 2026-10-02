package com.alpha.CustomerService.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.CustomerService.dto.CoordinateDto;
import com.alpha.CustomerService.dto.RideOptionDto;
import com.alpha.CustomerService.dto.SearchDestinationLocationDto;
import com.alpha.CustomerService.dto.SelectRideDto;
import com.alpha.CustomerService.dto.SelectRideResponseDto;
import com.alpha.CustomerService.dto.customerdto;
import com.alpha.CustomerService.entity.customer;
import com.alpha.CustomerService.repository.customerrepo;

@Service
public class customerservice {
	@Autowired
	private customerrepo customerRepo;
	@Autowired
	private RestTemplate restTemplate;
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
}
