package com.jm3200104.springboot.customer;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerRestController {

	private final CustomerRepository customerRepository;

	public CustomerRestController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomers() {
		return ResponseEntity.ok(customerRepository.findAll());
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		return ResponseEntity.ok(customerRepository.findById(id).orElse(null));
	}

	@PostMapping
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(customerRepository.findByName(name));
	}
	
	@GetMapping(value = "/search2", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> getCustomerByNameAndAge(@RequestParam("name") String name,
			@RequestParam("age") int age) {
		return ResponseEntity.ok(customerRepository.findByNameAndAge(name, age));
	}
}
