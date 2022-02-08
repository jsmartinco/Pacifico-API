package com.bolivar.pacifico.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.dao.ICustomerDao;
import com.bolivar.pacifico.models.entitys.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDao iCustomerDao;
		
	@Override
	public Customer save(Customer customer) {
		return iCustomerDao.save(customer);
	}

}
