package com.bolivar.pacifico.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class JwtDto {
	
	private String token;
	private String bearer = "Bearer";
	private String name;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token, String name, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.name = name;
		this.authorities = authorities;
	}
	
	
	
	
}

