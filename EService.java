package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.Employee;

public class EService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public EService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addEmployee(
			int enumber,	
			String ename,
			Date dob,
			String gender,
			String addr1,
			String addr2,
			String pobox,
			String city,
			String country,
			String per_mail_id,
			String designation,
			int msalary,
			int cont_number,
			int alt_cont_number,
			String status
			) {
		try {
			Employee employee = new Employee(
					 enumber,	
					 ename,
					 dob,
					 gender,
					 addr1,
					 addr2,
					 pobox,
					 city,
					 country,
					 per_mail_id,
					 designation,
					 msalary,
					 cont_number,
					 alt_cont_number,
					 status	
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO EMPLOYEE ("
					+ "enumber," 
					+ "ename,"
					+ "dob,"
					+ "gender,"
					+ "addr1,"
					+ "addr2,"
					+ "pobox,"
					+ "city,"
					+ "country," 
					+ "per_mail_id," 
					+ "designation," 
					+ "msalary,"
					+ "cont_number,"
					+ "alt_cont_number,"
					+ "status"	
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setString(2, employee.getEname());
			pstmt.setDate(3, employee.getDob());
			pstmt.setString(4, employee.getGender());
			pstmt.setString(5, employee.getAddr1());
			pstmt.setString(6, employee.getAddr2());
			pstmt.setString(7, employee.getPobox());
			pstmt.setString(8, employee.getCity());
			pstmt.setString(9, employee.getCountry());
			pstmt.setString(10, employee.getPer_mail_id());
			pstmt.setString(11, employee.getDesignation());
			pstmt.setInt(12, employee.getMsalary());
			pstmt.setInt(13, employee.getCont_number());
			pstmt.setInt(14, employee.getAlt_cont_number());
			pstmt.setString(15, employee.getStatus());

			
			System.out.println(employee);
			System.out.println("sql =" + sql);
			pstmt.executeUpdate();
			System.out.println("Inserted records into the table...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public Map<Integer, Employee> getAllEmployees() {
		try {
			Map<Integer, Employee> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM employee";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getDate(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getInt(13),
						rs.getInt(14),
						rs.getString(15)
						);
				map.put(rs.getInt(1), employee);
			}
			System.out.println(map);
			return map;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return null;
	}

	public Map<Integer, Employee> getEmployeeById(String id) {
		
		System.out.println(" enumber " + id);
		try {
			
			Map<Integer, Employee> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM employee WHERE enumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getDate(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getInt(13),
						rs.getInt(14),
						rs.getString(15)
						);
				mapWithId.put(Integer.parseInt(id), employee);
				
				System.out.println(" enumber " + id);
			}
			return mapWithId;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return null;
	}

	// delete records based on id
	public void deleteEmployee(String id) {
		try {
			
			System.out.println(" delete enumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM employee WHERE enumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			// execute delete SQL stetement
			pstmt.executeUpdate();
			System.out.println("Record is deleted!");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	// delete records based on id
	public void updateEmployee(
			int enumber,	
			String ename,
			Date dob,
			String gender,
			String addr1,
			String addr2,
			String pobox,
			String city,
			String country,
			String per_mail_id,
			String designation,
			int msalary,
			int cont_number,
			int alt_cont_number,
			String status
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE EMPLOYEE SET "
					+ "ename = ?,"
					+ "dob = ?,"
					+ "gender = ?,"
					+ "addr1 = ?,"
					+ "addr2 = ?,"
					+ "pobox = ?,"
					+ "city = ?,"
					+ "country = ?," 
					+ "per_mail_id = ?," 
					+ "designation = ?," 
					+ "msalary = ?,"
					+ "cont_number = ?,"
					+ "alt_cont_number = ?,"
					+ "status = ?"
					+ " where enumber = ?";
			
			System.out.println( "UPDATE SQL " + query);
			
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(15, enumber);
			pstmt.setString(1, ename);
			pstmt.setDate(2, dob);
			pstmt.setString(3, gender);
			pstmt.setString(4, addr1);
			pstmt.setString(5, addr2);
			pstmt.setString(6, pobox);
			pstmt.setString(7, city);
			pstmt.setString(8, country);
			pstmt.setString(9, per_mail_id);
			pstmt.setString(10, designation);
			pstmt.setInt(11, msalary);
			pstmt.setInt(12, cont_number);
			pstmt.setInt(13, alt_cont_number);
			pstmt.setString(14, status);

			
			// execute update SQL stetement
			pstmt.executeUpdate();
			System.out.println("Record is Updated!");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}
}
