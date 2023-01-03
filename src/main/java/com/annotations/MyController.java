package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class MyController {
	
	@Autowired
	@Qualifier("student1")
	private Student studuent;

	@ResponseBody
	@GetMapping("/home")
	public String home() {
		return "My Home";
	}
	
	
	//JSON Returned - {"name":"Praveen Tavare"}
	@ResponseBody
	@GetMapping("/getData")
	public Student getData() {
		
		System.out.println("This is my student data");
		this.studuent.setName("Praveen Tavare");
		return this.studuent;
	}
	// To invoke this - http://localhost:9091/user/20
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public String user(@PathVariable("userId") Integer userId) {
		return String.valueOf(userId);
	}
	
	// To invoke this -http://localhost:9091/emp?empId=20
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@ResponseBody
	public String emp(@RequestParam("empId") Integer userId) {
		return String.valueOf(userId);
	}
}
