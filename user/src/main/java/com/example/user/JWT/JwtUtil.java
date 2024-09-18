package com.example.user.JWT;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

@Component
public class JwtUtil {
	
	private final  String SECRET_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTcwNzA0Mjk3MSwiaWF0IjoxNzA3MDQyOTcxfQ.ce3Ez2jzI934qI4oqf_wkZV8S6cDSyY1YLwAu9peZjQ";
	
	private  long expireTime = 86400000 ; //24 hours
	Date now = new Date();
	Date expiryDate = new Date(now.getTime() + expireTime);

	
	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	    }

	    private Key getSignInKey() {
			// TODO Auto-generated method stub
	    	byte keyByte[] =Decoders.BASE64.decode(SECRET_KEY);
			return Keys.hmacShaKeyFor(keyByte);
			
			
			
		}

		private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(String userName) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, userName);
	    }

	    private String createToken(Map<String, Object> claims, String userName) {

	        return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(expiryDate)
	                .signWith(getSignInKey(),SignatureAlgorithm.HS256).compact();
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
	
	
}
