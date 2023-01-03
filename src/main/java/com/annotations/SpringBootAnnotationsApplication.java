package com.annotations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mypack.Dog;

//@SpringBootApplication
// @SpringBootApplication Equivalent to @EnableAutoConfiguration, @Configuration and @ComponentScan

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class SpringBootAnnotationsApplication implements CommandLineRunner {

	@Autowired
//	@Qualifier("student1")
	@Qualifier("student2")
	private Student student;

	@Autowired
	private Date date;

	@Autowired
	private Emp emp;

	@Autowired
	private Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studying();
		this.emp.yourName();
		this.dog.eating();
	}
 
}
