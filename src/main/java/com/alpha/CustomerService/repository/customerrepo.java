package com.alpha.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.CustomerService.entity.customer;

@Repository
public interface customerrepo extends JpaRepository<customer,Integer>{
	
}
