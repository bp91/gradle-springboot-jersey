package it.testWebapp.controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	
	@PostConstruct
	private void init() {
		System.out.println("TestController: Application Started");
	}

}
