package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.JDBCConnection;
import com.domain.Customer;

public class CService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public CService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addCustomer(
			int cnumber,
			String cname, 
			String oname,
			String addr1, 
			String addr2,
			String pobox,
			String city,
			String country,
			String currency,
			String cont_per_name,			
			String phoneno,
			String mail_id
			) {
		try {
			Customer customer = new Customer(
					 cnumber,
					 cname, 
					 oname,
					 addr1, 
					 addr2,
					 pobox,
					 city,
					 country,
					 currency,
					 cont_per_name,			
					 phoneno,
					 mail_id
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO CUSTOMER ("
					 + "cnumber,"
					 + "cname," 
					 + "oname,"
					 + "addr1," 
					 + "addr2,"
					 + "pobox,"
					 + "city,"
					 + "country,"
					 + "currency,"
					 + "cont_per_name,"			
					 + "phone_number,"
					 + "mail_id"
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			pstmt.setString(2, customer.getCName());
			pstmt.setString(3, customer.getOname());
			pstmt.setString(4, customer.getAddr1());
			pstmt.setString(5, customer.getAddr2());
			pstmt.setString(6, customer.getPobox());
			pstmt.setString(7, customer.getCity());
			pstmt.setString(8, customer.getCountry());
			pstmt.setString(9, customer.getCurrency());
			pstmt.setString(10, customer.getCont_per_name());
			pstmt.setString(11, customer.getPhoneno());
			pstmt.setString(12, customer.getMail_id());
			
			System.out.println(customer);
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

	public Map<Integer, Customer> getAllCustomers() {
		try {
			Map<Integer, Customer> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM customer";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10),
						rs.getString(11), 
						rs.getString(12)
						);
				map.put(rs.getInt(1), customer);
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

	public Map<Integer, Customer> getCustomerById(String id) {
		
		System.out.println(" cnumber " + id);
		try {
			
			Map<Integer, Customer> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM customer WHERE cnumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer(
								rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4),
								rs.getString(5), 
								rs.getString(6), 
								rs.getString(7),
								rs.getString(8), 
								rs.getString(9), 
								rs.getString(10),
								rs.getString(11), 
								rs.getString(12)
						);
				mapWithId.put(Integer.parseInt(id), customer);
				
				System.out.println(" cnumber " + id);
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
	public void deleteCustomer(String id) {
		try {
			
			System.out.println(" delete cnumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM customer WHERE cnumber = ?";
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
	public void updateCustomer(
			int cnumber,
			String cname, 
			String oname,
			String addr1, 
			String addr2,
			String pobox,
			String city,
			String country,
			String currency,
			String cont_per_name,			
			String phoneno,
			String mail_id
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE customer SET "
					 + "cname = ?," 
					 + "oname = ?,"
					 + "addr1 = ?," 
					 + "addr2 = ?,"
					 + "pobox = ?,"
					 + "city = ?,"
					 + "country = ?,"
					 + "currency = ?,"
					 + "cont_per_name = ?,"			
					 + "phone_number = ?,"
					 + "mail_id = ?"
					+ " WHERE cnumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(12, cnumber);
			pstmt.setString(1, cname);
			pstmt.setString(2, oname);
			pstmt.setString(3, addr1);
			pstmt.setString(4, addr2);
			pstmt.setString(5, pobox);
			pstmt.setString(6, city);
			pstmt.setString(7, country);
			pstmt.setString(8, currency);
			pstmt.setString(9, cont_per_name);
			pstmt.setString(10, phoneno);
			pstmt.setString(11, mail_id);
			
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
