package com.bolivar.pacifico.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolivar.pacifico.security.entity.Role;
import com.bolivar.pacifico.security.enums.RoleName;

@Repository
public interface IRolDao extends JpaRepository<Role, Long>{
	Optional<Role> findByRoleName(RoleName roleName);

}
