package com.bean.program;

import org.springframework.stereotype.Component;

@Component
public class StudentRecord {
	
	private int student_id;
	private String first_name;
	private String last_name;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String toString() {
		return "Student ID: "+ student_id + " First Name: "+ first_name + " Last Name: "+ last_name;
	}

}
