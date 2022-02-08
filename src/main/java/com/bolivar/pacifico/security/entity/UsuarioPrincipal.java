package com.bolivar.pacifico.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bolivar.pacifico.models.entitys.Employee;

//import lombok.AllArgsConstructor;
//import lombok.Data;


//@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
		
	private int vip;
	
	private int state;
	
	private String email;
		
	private int townid;
	
	private String password;
	
	private String identification;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public static UsuarioPrincipal build(Employee employee) {
		List<GrantedAuthority> authorities = employee.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.
				getRoleName().name())).collect(Collectors.toList());
		return new UsuarioPrincipal(employee.getName(), employee.getVip(),employee.getState(), 
				employee.getEmail(),employee.getTownid(), employee.getPassword(), employee.getIdentification(),authorities);
	}
	
	public UsuarioPrincipal(String name, int vip, int state, String email, int townid, String password,
			String identification, Collection<? extends GrantedAuthority> authorities) {
		this.name = name;
		this.vip = vip;
		this.state = state;
		this.email = email;
		this.townid = townid;
		this.password = password;
		this.identification = identification;
		this.authorities = authorities;
	}
	
		 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTownid() {
		return townid;
	}

	public void setTownid(int townid) {
		this.townid = townid;
	}



	
	
	 
	
	
}
