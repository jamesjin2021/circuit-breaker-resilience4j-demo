package com.aummn.circuit.breaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CustomerService {

	private RestTemplate restTemplate = new RestTemplate();


	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
	@Retry(name = "myRetry")
	public String getCustomerName() {
		String serviceUrl = "http://localhost:8080/api2/staff/name";
		System.out.println(" Making a request to " + serviceUrl + " at :" + LocalDateTime.now());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(serviceUrl, String.class);
	}

	public String fallback(Throwable e) {
		log.info("in fallback method");
		return "James";
	}
	
}

