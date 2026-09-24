package com.alpha.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.CustomerService.entity.address;

@Repository
public interface addressrepo extends JpaRepository<address, Integer> {

}
