package com.bolivar.pacifico.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.pacifico.models.entitys.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Long>{
	
	Optional<Employee>findByName(String name);
	boolean existsByName(String idEmployee);
	boolean existsByemail(String email);

}
