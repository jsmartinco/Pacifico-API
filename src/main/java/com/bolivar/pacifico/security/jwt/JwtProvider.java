package com.bolivar.pacifico.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.bolivar.pacifico.security.entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public String getEmployeeNameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {			
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;			
		} catch (MalformedJwtException e) {
			logger.error("Token mal formado" + e.getMessage());
		}
		catch (UnsupportedJwtException e) {
			logger.error("Token no soportado");
		}
		catch (ExpiredJwtException e) {
			logger.error("Token expirrado");
		}
		catch (IllegalArgumentException  e) {
			logger.error("Token vacio");
		}
		catch (SignatureException e) {
			logger.error("fallo con la firma");
		}
		return false;
		
	}

}
