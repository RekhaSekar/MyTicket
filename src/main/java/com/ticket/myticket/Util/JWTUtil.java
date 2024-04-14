package com.ticket.myticket.Util;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.ticket.myticket.Exception.TicketException;
import com.ticket.myticket.model.User;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.experimental.UtilityClass;

@UtilityClass
@Component
public class JWTUtil {
	
	private String secretKey = "Rekha";
	
	public String createToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("issuedBy" , "Ticket Server");
        claims.put("roles" , user.getRoles());
        claims.put("username", user.getEmail());
//        claims.put("iat", new Date().getTime());
        long milliSecondsTime = new Date().getTime() + (30*60*1000);
		return Jwts.builder().addClaims(claims).signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes())).setIssuedAt(new Date(new Date().getTime())).setExpiration(new Date(milliSecondsTime)).compact();	
	}
	 public Claims claimToken(String token) {
		try {
			return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secretKey.getBytes())).parseClaimsJws(token).getBody();
		}catch (SignatureException e) {
	        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT signature", e);
	    } catch (MalformedJwtException e) {
	        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT token", e);
	    } catch (ExpiredJwtException e) {
	        throw new TicketException(HttpStatus.UNAUTHORIZED,"Invalid JWT token", e);
	    } catch (ClaimJwtException e) {
	        throw new TicketException(HttpStatus.UNAUTHORIZED,"Claiming JWT token", e);
	    }
	 }
	 
	public boolean isTokenExpired(String token) {
//		System.out.println("first");
		return  new Date().before(claimToken(token).getExpiration());
	}
}
