package com.pedrofernandes.apirestpedidos.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pedrofernandes.apirestpedidos.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
	}
}
