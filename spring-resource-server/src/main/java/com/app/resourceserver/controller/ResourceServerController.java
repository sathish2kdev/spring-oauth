package com.app.resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {

	@GetMapping("/test")
	public String printHelloWorld() {
		return "Hello World";
	}
	
}
