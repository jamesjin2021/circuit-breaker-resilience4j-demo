package com.aummn.circuit.breaker.service;

import com.aummn.circuit.breaker.exception.StaffException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController()
@RequestMapping("/api")
class StaffService {

	@GetMapping("/staff/name")
	public String staffName() {
		log.info("in method staffName() - /api/staff/name");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3);
		if (randomInt < 2) {
			throw new StaffException("Staff service is unavailable");
		}
		return "Michael";
	}
}

