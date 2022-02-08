package com.bolivar.pacifico.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bolivar.pacifico.security.service.EmployeeDetailsImpl;

public class jwtTokenFilter extends OncePerRequestFilter{

	private final static Logger logger = LoggerFactory.getLogger(jwtTokenFilter.class);
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	EmployeeDetailsImpl employeeDetailsImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String employeeName = "";
		
		try {
			
			String token = getToken(request);
			if (token != null && jwtProvider.validateToken(token)) {
				employeeName = jwtProvider.getEmployeeNameFromToken(token);
				UserDetails userDetails = employeeDetailsImpl.loadUserByUsername(employeeName);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
			
		} catch (Exception e) {
			logger.error("fail en el metodo doFilter " + e.getMessage());
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer"))
				return header.replace("Bearer " , "");
		return null; 
	}

}
