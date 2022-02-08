package com.bolivar.pacifico.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.entitys.Employee;
import com.bolivar.pacifico.security.repository.IEmployeeDao;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	IEmployeeDao employeeDao;
	
	public Optional<Employee> getByNameEmployee(String name){
		return employeeDao.findByName(name);
	}
	
	public boolean existByName(String employeeName) {
		return employeeDao.existsByName(employeeName);
	}
	
	public boolean existByEmail(String email) {
		return employeeDao.existsByemail(email);
	}
	
	public void save (Employee employee) {
		employeeDao.save(employee);
	}

}
