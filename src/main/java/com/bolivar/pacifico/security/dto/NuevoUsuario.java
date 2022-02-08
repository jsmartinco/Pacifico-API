package com.bolivar.pacifico.security.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;


@Data
public class NuevoUsuario {
	
	
	private String name; 
	
	private int vip;
		
	private int state;
	
	private String email;
	
	private int townid;
	
	private String password;	
	
	private String identification;
	
	private Set<String> roles = new HashSet<>();

}
