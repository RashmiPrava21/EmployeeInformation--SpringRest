package com.controller.program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.program.StudentRecord;
import com.service.program.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService stuserv;
	
	@GetMapping("/students")
	public List<StudentRecord> fetchRecords(){
		List<StudentRecord> data = new ArrayList<StudentRecord>();
		data = stuserv.retrieveRecords();
		return data;
	}
	
	
	@PostMapping("/students")
	public void insertRecord(StudentRecord stuRecord) {
		stuserv.addRecord(stuRecord);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteRecord(@PathVariable int id) {
		stuserv.deleteRecord(id);
	}
}
