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


import com.bean.program.StudentRecord;

@Repository
public class StudentDao {

	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String urnm;
	
	@Value("${db.password}")
	private String pwd;
	
	
	public List<StudentRecord> getRecords() throws SQLException {
		StudentRecord sturecd = new StudentRecord();
		List<StudentRecord> list = new ArrayList<StudentRecord>();
		Connection con = getConnect();
		System.out.println("Connection Established Successfully - fetch all records for students");
		
		Statement stmt = null;
		String query = "Select * from students";
		stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			sturecd.setStudent_id(rs.getInt("STUDENT_ID"));
			sturecd.setFirst_name(rs.getString("FIRST_NAME"));
			sturecd.setLast_name(rs.getString("LAST_NAME"));
			
			list.add(sturecd);
			sturecd = new StudentRecord();
		}
		
		return list;
	}

	public void insert(StudentRecord stuRecord) throws SQLException{
		
		Connection con = getConnect();
		System.out.println("Connection established - Inside Students Dao");
		
		PreparedStatement pstmt = con.prepareStatement("Insert into students values(?,?,?)");
		
		pstmt.setInt(1, stuRecord.getStudent_id());
		pstmt.setString(2, stuRecord.getFirst_name());
		pstmt.setString(3, stuRecord.getLast_name());
		
		pstmt.executeUpdate();
		System.out.println("Successfully inserted");
		
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

	public void deleteRecord(int id) throws SQLException{
		
		Connection con = getConnect();
		System.out.println("Connection established for deleting records from student table");
		
		PreparedStatement pstmt = con.prepareStatement("delete from students where student_id = ?");
		
		pstmt.setInt(1, id);
		
		System.out.println("Deleted successfully");
		
	}

	

}
