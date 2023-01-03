package com.annotations;

public class Student {
	
	private String name;
	
	public Student() {
		
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public void studying() {
		System.out.println(this.name +  " is Studying!!!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
