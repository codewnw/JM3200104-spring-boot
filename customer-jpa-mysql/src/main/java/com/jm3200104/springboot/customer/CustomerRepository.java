package com.jm3200104.springboot.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByName(String name);
	List<Customer> findByNameAndAge(String name, int age);
}
