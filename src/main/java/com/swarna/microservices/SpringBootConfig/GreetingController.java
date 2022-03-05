package com.swarna.microservices.SpringBootConfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	// @Value("${my.greeting}") is telling Spring to fetch the value from config
	// file.
//	@Value("${my.greeting}")
//	private String greetingMessage;

	// default value will be print if it dont find my.greeting in property file
	@Value("${my.greeting: default value}")
	private String greetingMessage;

	// Printing Static message
	@Value(" static message ")
	private String staticMessage;

	// Taking List of values using property file
	@Value("${my.list.values}")
	private List<String> listValues;

	// #{} will evaluate anything between braces and assign to variables.
//	@Value("#{${dbValues}}")
//	private Map<String,String> dbValues;

	@Autowired
	private DbSettings dbSettings;

	@Autowired
	private Environment env;

	@GetMapping("/greeting")
	public String greeting() {
		// return greetingMessage + staticMessage + listValues + dbValues;
		return greetingMessage + dbSettings.getConnection() + dbSettings.getHost();
	}

	@GetMapping("/envdetails")
	public String envDetails() {
		return env.toString() ;
	}
}
