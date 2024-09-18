package com.example.user.JWT;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.user.CustomUserDetailsService;
import com.example.user.model.MyUserDetails;
import com.example.user.model.User;
import com.example.user.repository.userRepository;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthonticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private JwtUtil util;
	
	private  CustomUserDetailsService userDetailsService;
	@Autowired
	private  userRepository userRepo;
	@Override
	protected void doFilterInternal(@Nonnull HttpServletRequest request,@Nonnull HttpServletResponse response,@Nonnull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userName;
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);
		userName = util.extractUsername(jwt);
		if(userName == null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetail = this.userDetailsService.loadUserByUsername(userName);
			if(util.validateToken(jwt, userDetail)) {
				UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken
						(userDetail,null, userDetail.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authtoken);
			}
		
		
		}
		filterChain.doFilter(request, response);
	}
	

}
