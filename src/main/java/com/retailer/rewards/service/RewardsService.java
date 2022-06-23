package com.retailer.rewards.service;

import com.retailer.rewards.model.RewardsResponse;

public interface RewardsService {
	RewardsResponse getCustomerAll();
	RewardsResponse getCustomerById(Integer customerId);

}
