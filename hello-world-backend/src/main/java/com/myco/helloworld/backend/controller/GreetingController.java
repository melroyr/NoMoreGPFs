package com.myco.helloworld.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/greeting" })
public class GreetingController {

	@GetMapping(produces = "application/json")
	public String getGeneralGreeting() {
		return "Hello Everybody";
	}

}
