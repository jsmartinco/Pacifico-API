package com.bolivar.pacifico.security.entity;

import javax.persistence.*;

import com.bolivar.pacifico.security.enums.RoleName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ROLES")
@Data
@NoArgsConstructor
public class Role {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	
	@Column(name = "rolename", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public Role(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
	

}
