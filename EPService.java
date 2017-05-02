package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.EmpPayment;

public class EPService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public EPService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addEmpPayment(
			int epnumber,
			int empno,	
			String ename,
			String year,
			String month,
			int advamt,
			int expenses,
			int balamt,
			String remarks
			) {
		try {
			EmpPayment empPayment = new EmpPayment(
					epnumber,
					empno,
					year,
					month,
					advamt,
					expenses,
					balamt,
					remarks
					);
			empPayment.setEname(ename);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO EMPPAYMENT ("
					+ "epnumber," 
					+ "enumberf,"
					+ "year,"
					+ "month,"
					+ "adv_amt,"
					+ "expenses,"
					+ "bal_amt,"
					+ "remarks"	
					+ ") VALUES (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setInt(2, empPayment.getEmpno());
			pstmt.setString(3, empPayment.getYear());
			pstmt.setString(4, empPayment.getMonth());
			pstmt.setInt(5, empPayment.getAdvamt());
			pstmt.setInt(6, empPayment.getExpenses());
			pstmt.setInt(7, empPayment.getBalamt());
			pstmt.setString(8, empPayment.getRemarks());
			
			System.out.println(empPayment);
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

	public Map<Integer, EmpPayment> getAllEmpPayments() {
		try {
			Map<Integer, EmpPayment> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM EMPPAYMENT";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpPayment empPayment = new EmpPayment(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getInt(7),
						rs.getString(8)
						);
				map.put(rs.getInt(1), empPayment);
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
	
	public Map<Integer, EmpPayment> getEmpPaymentById(
			String id
			) {
		
		System.out.println(" epnumber " + id);
		try {
			
			Map<Integer, EmpPayment> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = 	"SELECT * from EMPPAYMENT WHERE  EPNUMBER = ? ";
			
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));

			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpPayment empPayment = new EmpPayment(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getInt(7),
						rs.getString(8)
						);
				mapWithId.put(rs.getInt(1), empPayment);
				
				System.out.println(" empPayNumber " + rs.getInt(1));
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
	

	public Map<Integer, EmpPayment> getEmpPaymentByIds(
			String year,
			String month,
			String id
			) {
		
		System.out.println(" epnumber " + id + "month " + month + "year " + year);
		try {
			
			Map<Integer, EmpPayment> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = 		
"SELECT EP.epnumber,EP.YEAR,EP.MONTH,E.ENUMBER,E.ENAME,E.MSALARY,EP.ADV_AMT,EP.EXPENSES,EP.BAL_AMT,EP.REMARKS FROM EMPLOYEE E"
+ " LEFT JOIN EMPPAYMENT EP ON EP.ENUMBERF=E.ENUMBER " 
+ " WHERE  E.ENUMBER = ? OR  (EP.YEAR = ? AND EP.MONTH = ? )";
			
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpPayment empPayment = new EmpPayment(
						rs.getInt(1), 
						rs.getInt(4), 
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(7), 
						rs.getInt(8), 
						rs.getInt(9),
						rs.getString(10)
						);
				empPayment.setEname(rs.getString(5));
				empPayment.setMsalary(rs.getInt(6));
				mapWithId.put(rs.getInt(1), empPayment);
				
				System.out.println(" empPayNumber " + rs.getInt(1));
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
	public void deleteEmpPayment(String id) {
		try {
			
			System.out.println(" delete epnumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM EMPPAYMENT WHERE ePnumber = ?";
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
	public void updateEmpPayment(
			int epnumber,
			 int empno,			
			 String year,
			 String month,
			 int advamt,
			 int expenses,
			 int balamt,
			 String remarks			
			) {
		
			try {
				conn = jdbcConnection.getConnection();
				String query = "UPDATE EMPPAYMENT SET "
						+ "ADV_AMT = ?,"
						+ "EXPENSES = ?,"
						+ "BAL_AMT = ?,"
						+ "REMARKS = ?"
						+ " where epnumber = ? ";
				
				System.out.println( "UPDATE SQL " + query);
				
				pstmt = conn.prepareStatement(query); // create a statement
				pstmt.setInt(5, epnumber);
				//pstmt.setInt(8, empno);			
				//pstmt.setString(1, year);
				//pstmt.setString(2, month);
				pstmt.setInt(3, advamt);
				pstmt.setInt(4, expenses);
				pstmt.setInt(5, balamt);
				pstmt.setString(6, remarks);

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