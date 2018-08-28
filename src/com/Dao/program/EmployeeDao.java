package com.Dao.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.bean.program.EmployeeRecord;

@Repository
public class EmployeeDao {
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String urnm;
	
	@Value("${db.password}")
	private String pwd;
	
	public List<EmployeeRecord> getbyID(int id) throws SQLException{
		
		EmployeeRecord emprecd_row = new EmployeeRecord();
		List<EmployeeRecord> list_row = new ArrayList<EmployeeRecord>();
		Connection con = getConnect();
		System.out.println("Connection Established Successfully - fetch record by id");
		
		PreparedStatement pstmt = con.prepareStatement("Select * from employees where employee_id = ?");
		
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			emprecd_row.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			emprecd_row.setFirst_name(rs.getString("FIRST_NAME"));
			emprecd_row.setLast_name(rs.getString("LAST_NAME"));
			emprecd_row.setEmail(rs.getString("EMAIL"));
			emprecd_row.setPhone_number(rs.getString("PHONE_NUMBER"));
			emprecd_row.setHire_date(rs.getDate("HIRE_DATE"));
			emprecd_row.setJob_id(rs.getString("JOB_ID"));
			emprecd_row.setSalary(rs.getInt("SALARY"));
			emprecd_row.setCommission_pct(rs.getLong("COMMISSION_PCT"));
			emprecd_row.setManager_id(rs.getInt("MANAGER_ID"));
			emprecd_row.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			list_row.add(emprecd_row);
			emprecd_row = new EmployeeRecord();
		}
		
		return list_row;
	}
	
	public List<EmployeeRecord> getRecords() throws SQLException{
		
		EmployeeRecord emprecd = new EmployeeRecord();
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		Connection con = getConnect();
		System.out.println("Connection Established Successfully - fetch all records");
		
		Statement stmt = null;
		String query = "Select * from employees";
		stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			emprecd.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			emprecd.setFirst_name(rs.getString("FIRST_NAME"));
			emprecd.setLast_name(rs.getString("LAST_NAME"));
			emprecd.setEmail(rs.getString("EMAIL"));
			emprecd.setPhone_number(rs.getString("PHONE_NUMBER"));
			emprecd.setHire_date(rs.getDate("HIRE_DATE"));
			emprecd.setJob_id(rs.getString("JOB_ID"));
			emprecd.setSalary(rs.getInt("SALARY"));
			emprecd.setCommission_pct(rs.getLong("COMMISSION_PCT"));
			emprecd.setManager_id(rs.getInt("MANAGER_ID"));
			emprecd.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			list.add(emprecd);
			emprecd = new EmployeeRecord();
		}
		
		return list;
	}
	

	
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

	public void insertRecord(EmployeeRecord emprcd) throws SQLException {
		Connection con = getConnect();
		System.out.println("Connection Established Successfully - insert record");
		
		PreparedStatement pstmt = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?,?");
		
		pstmt.setInt(1, emprcd.getEmployee_id());
		pstmt.setString(2, emprcd.getFirst_name());
		pstmt.setString(3, emprcd.getLast_name());
		pstmt.setString(4, emprcd.getEmail());
		pstmt.setString(5, emprcd.getPhone_number());
		pstmt.setDate(6, emprcd.getHire_date());
		pstmt.setString(7, emprcd.getJob_id());
		pstmt.setInt(8, emprcd.getSalary());
		pstmt.setLong(9, emprcd.getCommission_pct());
		pstmt.setInt(10, emprcd.getManager_id());
		pstmt.setInt(11, emprcd.getDepartment_id());
		
		pstmt.executeUpdate();
		
		System.out.println("Inserted successfully!!");
		
	}

	public void updateRecord(int id) throws SQLException{
//		EmployeeRecord emp_update = new EmployeeRecord();
		Connection con = getConnect();
		System.out.println("Connection established for updating records!!");
		
		PreparedStatement pstmt = con.prepareStatement("update employees set first_name = 'Rashmi' where employee_id = ?");
		
		pstmt.setInt(1, id);
		
		pstmt.executeUpdate();
		
		System.out.println("Updated Successfully!!");
		
		
	}

	/*public void deleteRecord(int id) {
		
		Connection con = getConnect();
		System.out.println("Connection established for deleting records!!");
		
		PreparedStatement pstmt = 
		
	}*/

	
}
