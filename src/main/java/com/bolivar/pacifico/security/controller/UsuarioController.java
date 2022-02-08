package com.bolivar.pacifico.security.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.pacifico.models.dto.Mensaje;
import com.bolivar.pacifico.models.entitys.Employee;
import com.bolivar.pacifico.security.dto.JwtDto;
import com.bolivar.pacifico.security.dto.LoginUsuario;
import com.bolivar.pacifico.security.dto.NuevoUsuario;
import com.bolivar.pacifico.security.entity.Role;
import com.bolivar.pacifico.security.enums.RoleName;
import com.bolivar.pacifico.security.jwt.JwtProvider;
import com.bolivar.pacifico.security.service.EmployeeService;
import com.bolivar.pacifico.security.service.RolService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/nuevo")
	//ACA ERA VALID PERO TOCO VALIDATED, VERIFICAR CUALQUEIR ERROR.
	public ResponseEntity<?> nuevo(@Validated @RequestBody NuevoUsuario nuevousuario, BindingResult bindingResult){
		if(bindingResult.hasErrors())
				return new ResponseEntity<>(new Mensaje("Campos Mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
		if(employeeService.existByName(nuevousuario.getName()))
				return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
		if(employeeService.existByEmail(nuevousuario.getEmail()))
			return new ResponseEntity<>(new Mensaje("Ese email ya existe"),HttpStatus.BAD_REQUEST);
		Employee employee = new Employee (nuevousuario.getName(), nuevousuario.getVip(), nuevousuario.getState(), nuevousuario.getEmail(),
				nuevousuario.getTownid(), passwordEncoder.encode(nuevousuario.getPassword()),nuevousuario.getIdentification());
		Set<Role> roles = new HashSet<>();
		roles.add(rolService.getByRolName(RoleName.ROLE_USER).get());
		if(nuevousuario.getRoles().contains("gestor"))
			roles.add(rolService.getByRolName(RoleName.ROLE_GESTOR).get());
		employee.setRoles(roles);
		employeeService.save(employee);
		return new ResponseEntity<>(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
		if(bindingResult.hasErrors()) 
			return new ResponseEntity<JwtDto>(HttpStatus.BAD_REQUEST);
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getName(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwdDto = new JwtDto(jwt,userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<>(jwdDto, HttpStatus.OK);
	}

	
}
