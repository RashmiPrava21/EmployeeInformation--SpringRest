package com.controller.program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.program.EmployeeRecord;
import com.service.program.EmployeeService;


@RestController
//@RequestMapping("/test")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	
//	@RequestMapping("/greet")
	@GetMapping("/greet")
	public String getHello() {
		return "greet";
	}
	
//	@RequestMapping("/employees")
	@GetMapping("/employees")
	public List<EmployeeRecord> fetchRecords(){
		List<EmployeeRecord> data = new ArrayList<EmployeeRecord>();
		data = empservice.retrieveRecords();
		return data;
	}
	
	@GetMapping("/employees/{id}")
	public List<EmployeeRecord> fetchRecordbyId(@PathVariable int id){
		List<EmployeeRecord> data_row = new ArrayList<EmployeeRecord>();
		data_row = empservice.retrievebyID(id);
		return data_row;
	}
	
	@PostMapping("/employees")
	public void addRecord(@RequestBody EmployeeRecord emprcd) {
		empservice.insertRecord(emprcd);
	}
	
	@PutMapping("/employees/{id}")
	public void updateRecord(@PathVariable int id) {
		empservice.updateRecord(id);
	}
	
//	@DeleteMapping("/employees/{id}")
//	public void deleteRecord(@PathVariable int id) {
//		empservice.deteleRecord(id);
//	}
	
}

