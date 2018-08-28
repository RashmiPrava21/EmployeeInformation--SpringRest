package com.service.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.program.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao depDao;
	
	
}
