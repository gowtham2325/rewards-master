package com.retailer.rewards.controller;

import com.retailer.rewards.model.RewardsResponse;
import com.retailer.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardsController {
	
	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/customers")
	public RewardsResponse findCustomerAll() {
		return rewardsService.getCustomerAll();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<RewardsResponse> getCustomer(@PathVariable Integer id) {
		RewardsResponse response = rewardsService.getCustomerById(id);
		if (response == null || response.getCustomers().isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
