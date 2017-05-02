package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.CInquiry;

public class IService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public IService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addInquiry(
			int inumber,
			int customerid,
			 Date inqdate,
			 String segments,
			 String inqdesc,
			 int mid,
			 String mdesc,
			 int marketersid,
			 String mname,
			 int marketersmid,
			 String mmname,
			 Date nextVDate,
			 String remarks
			) {
		try {
			CInquiry inquiry = new CInquiry(
					  inumber,
					  customerid,
					  mid,
					  mdesc,	
					  marketersid,
					  mname,
					  mmname,
					  marketersmid,
					  nextVDate,
					  remarks,
					  inqdesc,
					  segments,
					  inqdate
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO inquiry("
					 + "inumber,"
					 + "cnumberf,"
					 + "idate,"
					 + "segments,"
					 + "idesc,"
					 + "MA_NUMBERF,"
					 + "MA_DESC,"
					 + "MNUMBERF,"
					 + "mname,"
					 + "MMNUMBERF,"
					 + "mmname,"
					 + "NEXTVDATE,"
					 + "remarks"
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setInt(2, inquiry.getCustomerid());
			pstmt.setDate(3, inquiry.getInqdate());
			pstmt.setString(4, inquiry.getSegments());
			pstmt.setString(5, inquiry.getInqdesc());
			pstmt.setInt(6, inquiry.getMid());
			pstmt.setString(7, inquiry.getMdesc());
			
			pstmt.setInt(8, inquiry.getMarketersid());
			pstmt.setString(9, inquiry.getMname());
			
			pstmt.setInt(10, inquiry.getMarketersmid());
			pstmt.setString(11, inquiry.getMmname());			
			pstmt.setDate(12, inquiry.getNextVDate());
			pstmt.setString(13, inquiry.getRemarks());
			
			System.out.println(inquiry);
			
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

	public Map<Integer, CInquiry> getAllInquiries() {
		try {
			Map<Integer, CInquiry> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM INQUIRY";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInquiry inquiry = new CInquiry(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getDate(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getDate(13)
						);
				map.put(rs.getInt(1), inquiry);
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

	public Map<Integer, CInquiry> getInquiryAll() {
		try {
			Map<Integer, CInquiry> mapWithId = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM inquiry ";
			pstmt = conn.prepareStatement(query); // create a statement
			//pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInquiry inquiry = new CInquiry(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getDate(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getDate(13)
						);
				mapWithId.put(rs.getInt(1), inquiry);
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
	
	public Map<Integer, CInquiry> getInquiryById(String id) {
		try {
			Map<Integer, CInquiry> mapWithId = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM inquiry WHERE inumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInquiry inquiry = new CInquiry(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getDate(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getDate(13)
						);
				mapWithId.put(Integer.parseInt(id), inquiry);
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
	public void deleteInquiry(String id) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM inquiry WHERE id = ?";
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
	public void updateInquiry(
			int inumber,
			int customerid,
			 Date inqdate,
			 String segments,
			 String inqdesc,
			 int mid,
			 String mdesc,
			 int marketersid,
			 String mname,
			 int marketersmid,
			 String mmname,
			 Date nextVDate,
			 String remarks
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE inquiry SET "
					+ " customerid = ?,"
					+ " inqdate = ?,"
					+ " segments = ?,"
					+ " inqdesc = ?,"
					+ " mid = ?,"
					+ " mdesc = ?,"
					+ " marketersid = ?,"
					+ " mname = ?,"
					+ " marketersmid = ?,"
					+ " mmname = ?,"
					+ " nextVDate = ?,"
					+ " remarks = ?"  
					+ " WHERE inumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement

			pstmt.setInt(13,inumber);
			pstmt.setInt(1, customerid);
			pstmt.setDate(2, inqdate);
			pstmt.setString(3, segments);
			pstmt.setString(4, inqdesc);
			pstmt.setInt(5, mid);
			pstmt.setString(6, mdesc);
			
			pstmt.setInt(7, marketersid);
			pstmt.setString(8, mname);
			
			pstmt.setInt(9, marketersmid);
			pstmt.setString(10, mmname);			
			pstmt.setDate(11, nextVDate);
			pstmt.setString(12, remarks);
			
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
