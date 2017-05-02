package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.Material;

public class MService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public MService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addMaterial(
			int mnumber,
			String mdesc,
			String attr,
			String uom,
			int dprice,
			int stockInHand,
			int price,
			String currency	
			) {
		try {
			Material material = new Material(
						 mnumber,
						 mdesc,
						 attr,
						 uom,
						 dprice,
						 stockInHand,
						 price,
						 currency	
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO MATERIAL ("
					+ "mnumber,"
					+ "mdesc,"
					+ "attr,"
					+ "uom,"
					+ "dprice,"
					+ "stockInHand,"
					+ "price,"
					+ "currency"	
					+ ") VALUES (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setString(2, material.getMdesc());
			pstmt.setString(3, material.getAttr());
			pstmt.setString(4, material.getUom());
			pstmt.setInt(5, material.getDprice());
			pstmt.setInt(6, material.getStockInHand());
			pstmt.setInt(7, material.getPrice());
			pstmt.setString(8, material.getCurrency());

			
			System.out.println(material);
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

	public Map<Integer, Material> getAllMaterials() {
		try {
			Map<Integer, Material> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM material";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Material material = new Material(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getInt(7),
						rs.getString(8)
						);
				map.put(rs.getInt(1), material);
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

	public Map<Integer, Material> getMaterialById(String id) {
		
		System.out.println(" mnumber " + id);
		try {
			
			Map<Integer, Material> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM material WHERE mnumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Material material = new Material(
								rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4),
								rs.getInt(5), 
								rs.getInt(6), 
								rs.getInt(7),
								rs.getString(8)
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
	public void deleteMaterial(String id) {
		try {
			
			System.out.println(" delete mnumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM material WHERE mnumber = ?";
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
	public void updateMaterial(
			int mnumber,
			String mdesc,
			String attr,
			String uom,
			int dprice,
			int stockInHand,
			int price,
			String currency	
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE material SET "
					 + "mdesc = ?," 
					 + "attr = ?,"
					 + "uom = ?," 
					 + "dprice = ?,"
					 + "stockinhand = ?,"
					 + "price = ?,"
					 + "currency = ?"
					+ " where mnumber = ?";
			
			System.out.println( "UPDATE " + query);
			
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(8, mnumber);
			pstmt.setString(1, mdesc);
			pstmt.setString(2, attr);
			pstmt.setString(3, uom);
			pstmt.setInt(4, dprice);
			pstmt.setInt(5, stockInHand);
			pstmt.setInt(6, price);
			pstmt.setString(7, currency);

			
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
