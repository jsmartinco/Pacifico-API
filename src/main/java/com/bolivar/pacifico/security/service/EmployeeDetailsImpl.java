package com.bolivar.pacifico.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bolivar.pacifico.models.entitys.Employee;
import com.bolivar.pacifico.security.entity.UsuarioPrincipal;


@Service
public class EmployeeDetailsImpl implements UserDetailsService{
	
	//private final static Logger logger = LoggerFactory.getLogger(EmployeeDetailsImpl.class);
	
	@Autowired
	EmployeeService employeeService;

	//@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Employee employee = employeeService.getByNameEmployee(name).get();
		//System.out.println(employee);
		return UsuarioPrincipal.build(employee);
				
	}
}
