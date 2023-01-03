package com.annotations.corejava;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaDateCreations {

	public static void main(String[] args) {
		
		// Creating current Date and Time in different ways
		// 1. Using java.util.Date class. 2.Using java.sql.Date class 3. Using java.time.Clock class
		// 4. Using java.time.LocalDate 5.Using java.time.LocalDateTime 6. Using java.time.LocalTime
		// 7. For Format use SimpleDateFormat Class, For Date in milli sec - use - System.currentTimeMillis();
		
		Long milliSecDate = System.currentTimeMillis();
		
		//1. Using java.util.Date class
		java.util.Date utilDate = new  java.util.Date();
		System.out.println(utilDate);
		System.out.println(new java.util.Date());
		
		// Using SimpleDateFormat
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(format.format(new java.util.Date()));
		
		
		// 2.Using java.sql.Date class
		java.sql.Date sqlDate = new java.sql.Date(milliSecDate);
		System.out.println(sqlDate);
		System.out.println(new java.sql.Date(System.currentTimeMillis()));
		
		System.out.println();
		
		// Using LocalDate.now() method
		System.out.println(LocalDate.now());
		
		//Using LocalDateTime.now() method
		System.out.println(LocalDateTime.now());
		
		//Using LocalTime.now() method
		System.out.println(LocalTime.now());

		// Using java.time/Clock class - systemUTC() method
		System.out.println(Clock.systemUTC().instant());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
