package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppController {

	@Autowired
	private Environment envObject;

	// to access it - http://localhost:9091/app/appProperty?key=name - O/P - No value present
	// http://localhost:9091/app/appProperty?key=app.name - O/P - springboot Annotations
	// http://localhost:9091/app/appProperty?key=app.description - O/p - Learning spring boot Annotations in details
	
	// 1. Reading properties of application.properties using getProperty() method of Environment interface 
	@GetMapping("/appProperty")
	public String getPropertyValue(@RequestParam String key) {

		String returnVal = "No value present";
		if (envObject.getProperty(key) != null && !envObject.getProperty(key).isEmpty()) {
			return envObject.getProperty(key);
		}
		return returnVal;
	}
	
	// 2. Reading properties of application.properties using @Value
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.description}")
	private String appDescription;
	
	// to access it - http://localhost:9091/app/getAppProperties?key=app.name
	@RequestMapping(value = "/getAppProperties" , method = RequestMethod.GET)
	public String getAppName(@RequestParam("key") String key) {
		
		return (key.equalsIgnoreCase("app.name")? appName : appDescription);
	}
	
	// 3.Reading properties of application.properties using @ConfigurationProperties("app") - prefix(app)
	@Autowired
	private AppProperties appProperties;
	
	// To access it - http://localhost:9091/app/getAppName
	@GetMapping(path = "/getAppName")
	private String appName() {
		return appProperties.getName();
	}
	
	//To access it - http://localhost:9091/app/getAppDesc
	@GetMapping(value = "/getAppDesc")
	private String getAppDesciption() {
		return appProperties.getDescription();
	}

}
