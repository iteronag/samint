package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.BBalance;

public class BBService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public BBService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addBBalance(
			int bbnumber,		
			 String bname,
			 String anumber,
			 String currency,
			 Date dateofentry,
			 int bbalance
			) {
		 
		try {
			
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO BANK_BALANCE ("
					+ "bbnumber," 
					+ "bname,"
					+ "anumber,"
					+ "currency,"
					+ "dateofentry,"
					+ "balance"
					+ ") VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setString(2, bname);
			pstmt.setString(3, anumber);
			pstmt.setString(4, currency);
			pstmt.setDate(5,dateofentry);
			pstmt.setInt(6, bbalance);

			
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

	public Map<Integer, BBalance> getAllBBalances() {
		try {
			Map<Integer, BBalance> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM BANK_BALANCE";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BBalance bankBalance = new BBalance(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getDate(5), 
						rs.getInt(6)
						);
				map.put(rs.getInt(1), bankBalance);
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
	
	public Map<Integer, BBalance> getBBalances(){
		
		try {
			
			Map<Integer, BBalance> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = 	"SELECT * from BANK_BALANCE ";
			
			pstmt = conn.prepareStatement(query); // create a statement
			//pstmt.setInt(1, Integer.parseInt(id));

			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BBalance bankBalance = new BBalance(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getDate(5), 
						rs.getInt(6)
						);
				mapWithId.put(rs.getInt(1), bankBalance);
				
				System.out.println(" bankBalance " + rs.getInt(1));
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
	public Map<Integer, BBalance> getBBalanceById(
			String id
			) {
		
		System.out.println(" bbnumber " + id);
		try {
			
			Map<Integer, BBalance> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = 	"SELECT * from BANK_BALANCE WHERE  BBNUMBER = ? ";
			
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));

			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BBalance bankBalance = new BBalance(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getDate(5), 
						rs.getInt(6)
						);
				mapWithId.put(rs.getInt(1), bankBalance);
				
				System.out.println(" bankBalance " + rs.getInt(1));
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
	public void deleteBBalance(String id) {
		try {
			
			System.out.println(" delete bbnumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM BANK_BALANCE WHERE BBNUMBER = ?";
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
	public void updateBBalance(
			int bbnumber,		
			 String bname,
			 String anumber,
			 String currency,
			 String dateofentry,
			 int bbalance			
			) {
		
		 Date dateOfEntry = null;
		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
			 dateOfEntry = (Date)formatter.parse(dateofentry); 
		 }catch(Exception e){
			 System.out.println(" Date exception ");
		 }
		 
			try {
				conn = jdbcConnection.getConnection();
				String query = "UPDATE BANK_BALANCE SET "
						+ "BNAME = ?,"
						+ "ANUMBER = ?,"
						+ "CURRENCY = ?,"
						+ "DATEOFENTRY = ?,"
						+ "BALANCE = ?"
						+ " where BBNUMBER = ? ";
				
				System.out.println( "UPDATE SQL " + query);
				
				pstmt = conn.prepareStatement(query); // create a statement
				//pstmt.setInt(5, epnumber);
				//pstmt.setString(1, year);
				pstmt.setString(1, bname);
				pstmt.setString(2, anumber);
				pstmt.setString(3, currency);
				pstmt.setDate(4, dateOfEntry);
				pstmt.setInt(5, bbalance);
				pstmt.setInt(6, bbnumber);

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