package com.controller.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.program.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService depSer;
}

