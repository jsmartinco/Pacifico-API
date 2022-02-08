package com.bolivar.pacifico.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.pacifico.models.entitys.Customer;

@Repository
public interface ICustomerDao extends CrudRepository<Customer, Long>{
	
}
