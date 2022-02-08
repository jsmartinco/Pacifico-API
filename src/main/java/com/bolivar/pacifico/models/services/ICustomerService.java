package com.bolivar.pacifico.models.services;

import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.entitys.Customer;

@Service
public interface ICustomerService {
	
	public Customer save (Customer customer);

}
