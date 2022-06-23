package com.retailer.rewards.service;

import com.retailer.rewards.model.Customer;
import com.retailer.rewards.model.RewardsResponse;
import com.retailer.rewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardsServiceImpl implements RewardsService {
    @Autowired
    private CustomerRepository customerRepository;

    public RewardsResponse getCustomerAll() {
        RewardsResponse response = new RewardsResponse();
        response.setCustomers(customerRepository.findAll());
        return response;
    }

    public RewardsResponse getCustomerById(Integer customerId) {
        RewardsResponse response = new RewardsResponse();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent())
            response.addCustomer(customer.get());
        return response;
    }

}
