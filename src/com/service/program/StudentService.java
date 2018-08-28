package com.service.program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.program.StudentDao;

import com.bean.program.StudentRecord;

@Service
public class StudentService {

	@Autowired
	StudentDao studao;

	public void addRecord(StudentRecord stuRecord) {
		
		try {
			studao.insert(stuRecord);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<StudentRecord> retrieveRecords() {
		List<StudentRecord> rows = new ArrayList<StudentRecord>();
		
		try {
			rows = studao.getRecords();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public void deleteRecord(int id) {
		try {
			studao.deleteRecord(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
