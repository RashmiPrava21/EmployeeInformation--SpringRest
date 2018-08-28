package com.service.program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.program.EmployeeDao;
import com.bean.program.EmployeeRecord;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao empdao;
	
	public List<EmployeeRecord> retrieveRecords(){
	
		List<EmployeeRecord> rows = new ArrayList<EmployeeRecord>();
		
		try {
			rows = empdao.getRecords();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public List<EmployeeRecord> retrievebyID(int id){
		List<EmployeeRecord> rows = new ArrayList<EmployeeRecord>();
		
		try {
			rows = empdao.getbyID(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public void insertRecord(EmployeeRecord emprcd) {
		try {
			empdao.insertRecord(emprcd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void updateRecord(int id) {
		try {
			empdao.updateRecord(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/*public void deteleRecord(int id) {
		try {
			empdao.deleteRecord(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/

	

	
}
