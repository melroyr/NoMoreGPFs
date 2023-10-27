package com.myco.helloworld.backend.controller;

import com.myco.helloworld.backend.model.RemoteGreeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myco.helloworld.backend.model.RemoteGreeting;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/greeting" })
public class GreetingController {

	@GetMapping(produces = "application/json")
	public RemoteGreeting[] getRemoteGreeting() {
		RemoteGreeting[] remoteGreetings = new RemoteGreeting[1];
		remoteGreetings[0] = new RemoteGreeting();
		return remoteGreetings;
	}

}
