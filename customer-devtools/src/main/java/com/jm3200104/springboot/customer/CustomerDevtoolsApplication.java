package com.jm3200104.springboot.customer;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CustomerDevtoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDevtoolsApplication.class, args);
	}

	@Scheduled(fixedRate = 10000)
	public void printDate() {
		System.out.println(new Date());
	}

}
