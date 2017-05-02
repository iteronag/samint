package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.Quotation;

public class QuoService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public QuoService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addQuotation(
			int qnumber,
			int cnumber,
			Date qdate,
			String remarks,
			int totalprice,
			Date ddate	
			) {
		try {
			Quotation quotation = new Quotation(
					 qnumber,
					cnumber,
					qdate,
					remarks,
					totalprice,
					ddate	
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO QUOTATION ("
					+ "qnumber,"
					+ "cnumberf,"		
					+ "qdate,"
					+ "tprice,"
					+ "ddate,"
					+ "remarks"					
					+ ") VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setInt(2, quotation.getCnumber());
			pstmt.setDate(3, quotation.getQdate());
			pstmt.setString(6, quotation.getRemarks());
			pstmt.setInt(4, quotation.getTotalprice());
			pstmt.setDate(5, quotation.getDdate());
			
			System.out.println(quotation);
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

	public Map<Integer, Quotation> getAllQuotations() {
		try {
			Map<Integer, Quotation> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM quotation";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Quotation quotation = new Quotation(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getDate(3), 
						rs.getString(6),
						rs.getInt(3), 
						rs.getDate(5)
						);
				map.put(rs.getInt(1), quotation);
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

	public Map<Integer, Quotation> getQuotationById(String id) {
		
		System.out.println(" mnumber " + id);
		try {
			
			Map<Integer, Quotation> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM quotation WHERE qnumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Quotation material = new Quotation(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getDate(3), 
						rs.getString(6),
						rs.getInt(4), 
						rs.getDate(5)
						);
				mapWithId.put(Integer.parseInt(id), material);
				
				System.out.println(" mnumber " + id);
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
	public void deleteQuotation(String id) {
		try {
			
			System.out.println(" delete mnumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM quotation WHERE qnumber = ?";
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
	public void updateQuotation(
			int qnumber,
			int cnumber,
			Date qdate,
			String remarks,
			int totalprice,
			Date ddate	
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE quotation SET "
					+ "cnumber = ?,"
					+ "qdate = ?,"
					+ "remarks = ?,"
					+ "totalprice = ?,"
					+ "ddate = ?,"
					+ "remarks = ?"					
					+ " where qnumber = ?";
			
			System.out.println( "UPDATE " + query);
			
			pstmt = conn.prepareStatement(query); // create a statement

			pstmt.setInt(1,qnumber);
			pstmt.setInt(2, cnumber);
			pstmt.setDate(3, qdate);
			pstmt.setString(4, remarks);
			pstmt.setInt(5, totalprice);
			pstmt.setDate(6, ddate);
			
			
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
