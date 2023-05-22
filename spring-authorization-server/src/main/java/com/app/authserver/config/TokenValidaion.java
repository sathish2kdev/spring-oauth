package com.app.authserver.config;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class TokenValidaion {

	@GetMapping("/validateUser")
	public Principal returnUser(Principal user) {
		return user;
	}


}
