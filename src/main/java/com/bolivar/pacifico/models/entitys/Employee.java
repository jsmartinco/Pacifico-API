package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.bolivar.pacifico.security.entity.Role;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "NAME", nullable = false, length = 200)
	private String name;
	
	@Column(name = "VIP", nullable = false, length =1)
	private int vip;
	
	@Column(name = "STATE", nullable = false, length = 1)
	private int state;
	
	@Column(name = "EMAIL",nullable = false, length = 50)
	private String email;
	
	@Column(name = "TOWNID",nullable = false, length = 100)
	private int townid;
	
	@Column(name = "PASSWORD",nullable = false, length = 100)
	private String password;
	
	@Column(name = "IDENTIFICATION",nullable = false, length = 100)
	private String identification;
	
	@NonNull
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "EMPLOYEE_ROL", joinColumns = @JoinColumn(name = "EMPLOYEEID"), 
	inverseJoinColumns = @JoinColumn(name = "ROLEID"))
	private Set<Role> roles = new HashSet<>();

	public Employee(String name, int vip, int state, String email, int townid, String password, String identification) {
		this.name = name;
		this.vip = vip;
		this.state = state;
		this.email = email;
		this.password = password;
		this.townid = townid;
		this.identification = identification;
	}

	
		
		

}
