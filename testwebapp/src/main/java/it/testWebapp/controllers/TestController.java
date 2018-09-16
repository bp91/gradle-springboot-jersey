package it.testWebapp.controllers;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@PostConstruct
	private void init() {
		logger.info("TestController: Application Started");
	}

}
