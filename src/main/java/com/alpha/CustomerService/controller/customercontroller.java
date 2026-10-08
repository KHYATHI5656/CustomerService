package com.alpha.CustomerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alpha.CustomerService.dto.SearchDestinationLocationDto;
import com.alpha.CustomerService.dto.SelectRideDto;
import com.alpha.CustomerService.dto.SelectRideResponseDto;
import com.alpha.CustomerService.dto.TemporaryRideDto;
import com.alpha.CustomerService.dto.customerdto;
import com.alpha.CustomerService.entity.booking;
import com.alpha.CustomerService.entity.customer;
import com.alpha.CustomerService.service.customerservice;

@RestController
public class customercontroller {
	@Autowired
	private customerservice customerService;
	@PostMapping("customer/createAccount")
	public customer createAccount(@RequestBody customerdto dto) {
		return customerService.createcustomer(dto);
		
	}
	@GetMapping("/findcustomer")
	public customer findcustomer(@RequestParam int id) {
		return customerService.findcustomer(id);
	}
	@DeleteMapping("/deleteAccount")
	public String deletecustomer(@RequestParam int id) {
		customerService.deletecustomer(id);
		return "Customer deleted successfully";
	}
	// SEARCH
		@GetMapping("/searchplace")
		public List<SearchDestinationLocationDto> searchPlace(@RequestParam String searchKey) {
			return customerService.searchPlace(searchKey);
		}
		//SelectRide
		@PostMapping("/customer/selectRide")
		public SelectRideResponseDto selectRide(@RequestBody SelectRideDto dto) {
		    return customerService.selectRide(dto);
		}
		 @PostMapping("/customer/confirmRide")
		  public booking confirmRide(@RequestParam int customerId) {
			 return customerService.confirmRide(customerId);
		    }
		 @PostMapping("/customer/saveTemporaryRide")
		 public String saveTemporaryRide(@RequestBody TemporaryRideDto dto) {

		     customerService.saveTemporaryRide(dto);

		     return "Temporary ride saved successfully";
		 }

}
