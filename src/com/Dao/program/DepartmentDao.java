package com.Dao.program;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.bean.program.EmployeeRecord;

@Repository
public class DepartmentDao {

	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String urnm;
	
	@Value("${db.password}")
	private String pwd;
	
	
	
	public Connection getConnect() {
		
		Connection con = null;
		try {
			System.out.println("Connection Details: ");
			System.out.println(url + " "+ urnm + " " +pwd);
			Class.forName(url);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", urnm, pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
