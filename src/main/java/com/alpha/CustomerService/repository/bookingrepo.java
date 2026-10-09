package com.alpha.CustomerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.CustomerService.entity.booking;

@Repository
public interface bookingrepo extends JpaRepository<booking, Integer>{
	List<booking> findByCustomerId(int customerId);

    List<booking> findByCustomerIdAndStatus(int customerId, String status);
}
