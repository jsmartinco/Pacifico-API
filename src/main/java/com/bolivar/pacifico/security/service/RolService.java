package com.bolivar.pacifico.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.security.entity.Role;
import com.bolivar.pacifico.security.enums.RoleName;
import com.bolivar.pacifico.security.repository.IRolDao;

@Service
@Transactional
public class RolService {
	
	@Autowired
	IRolDao rolDao;
	
	public Optional<Role> getByRolName(RoleName rolName){
		return rolDao.findByRoleName(rolName);
	}

}
