package com.annotations;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"com.mypack"})
public class MyConfig {

	@Bean("student1")
	@Lazy
	public Student getStudent() {
		System.out.println("getting 1st Student Object");
		return new Student("Praveen");
	}
	
	@Bean("student2")
	@Lazy
	public Student createStudent() {
		System.out.println("Creating 2nd Student Object");
		return new Student("Vinod");
	}
	
	@Bean
	public Date getDate() {
		System.out.println("Creating new Date");
		return new Date();
	}

}
