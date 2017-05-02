package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.QuoMaterial;

public class QuoMaterialService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public QuoMaterialService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addQuoMaterials(
			int qmsnumber,
			int qnumber,
			int mnumber,
			int netprice,
			int quantity,
			String remarks
			) {
		try {
			QuoMaterial quoMaterials = new QuoMaterial(
					 qmsnumber,
					 qnumber,
					 mnumber,
					 netprice,
					 quantity,
					 remarks
					);
			
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO QUO_MATERIALS("
					+ "qmsnumber,"
					+ "qnumberf,"
					+ "mnumberf,"
					+ "netprice,"
					+ "quantity,"
					+ "remarks"
					+ ") VALUES (?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setInt(2,quoMaterials.getQnumber());
			pstmt.setInt(3,quoMaterials.getMnumber());
			pstmt.setInt(4,quoMaterials.getNetprice());
			pstmt.setInt(5,quoMaterials.getQuantity());
			pstmt.setString(6, quoMaterials.getRemarks());
			
			System.out.println(quoMaterials
					);
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

	public Map<Integer, QuoMaterial> getAllQuoMaterials() {
		try {
			Map<Integer, QuoMaterial> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM QUO_MATERIALS";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				QuoMaterial quoMaterial = new QuoMaterial(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6)
						);
				map.put(rs.getInt(1), quoMaterial);
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

	public Map<Integer, QuoMaterial> getQuoMaterialById(String id) {
		try {
			Map<Integer, QuoMaterial> mapWithId = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM QUO_MATERIALS WHERE QNUMBERF = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				QuoMaterial quoMaterial = new QuoMaterial(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6)
						);
				mapWithId.put(rs.getInt(2), quoMaterial);
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
	public void deleteQuoMaterial(String id) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM QUO_MATERIALS WHERE QNUMBERF = ?";
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
	public void updateQuoMaterials(
			int qmsnumber,
			int qnumber,
			int mnumber,
			int netprice,
			int quantity,
			String remarks
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE QUO_MATERIALS SET "
					+ "netprice = ?,"
					+ "quantity = ?,"
					+ "remarks = ?"
					+ " WHERE QMSNUMBER = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, netprice);
			pstmt.setInt(2, quantity);
			pstmt.setString(3, remarks);
			pstmt.setInt(4, qmsnumber);
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
