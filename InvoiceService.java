package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.JDBCConnection;

import com.domain.CInvMaterials;
import com.domain.CInvoice;
import com.domain.Quotation;

public class InvoiceService {
	private JDBCConnection jdbcConnection;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public InvoiceService() {
		jdbcConnection = new JDBCConnection();
	}

	public void addInvoice(
			int cinumber,
			Date idate,
			int cnumber,
			String cname,
			String qref,
			String currency,
			int iamt,
			String pcurrency,
			String bname,
			int erate,
			String baccount
			) {
		try {
			CInvoice invoice = new CInvoice(
					 cinumber,
					 idate,
					 cnumber,
					 cname,
					 qref,
					 currency,
					 iamt,
					 pcurrency,
					 bname,
					 erate,
					 baccount
					);
			conn = jdbcConnection.getConnection();
			String sql = "INSERT INTO INVOICE ("
					+ "inumber,"
					+ "invdate,"
					+ "cname,"
					+ "qref,"
					+ "currency,"
					+ "INVAMOUNT,"
					+ "pcurrency,"
					+ "bname,"
					+ "erate,"
					+ "baccount"
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1,java.sql.Types.INTEGER);
			//pstmt.setInt(2, cnumberf);
			pstmt.setDate(2, idate);
			pstmt.setString(3, cname);
			pstmt.setString(4, qref);
			pstmt.setString(5, currency);
			pstmt.setInt(6, iamt);
			pstmt.setString(7, pcurrency);
			pstmt.setString(8, bname);
			pstmt.setInt(9, erate);
			pstmt.setString(10, baccount);
			
			
			System.out.println(invoice);
			
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

	
	public Map<Integer, CInvoice> getAllInvoicesFromTo(
			String idatefrom,
			String idateTo,
			String inumber,
			String cname,
			String cnumber
			) {
		try {
			Map<Integer, CInvoice> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM invoice  where invdate between ? and ? ";
	
			pstmt = conn.prepareStatement(query); // create a statement
			
			java.util.Date d = null;
			java.sql.Date ds = null;
			
			java.util.Date d1 = null;
			java.sql.Date ds1 = null;
			

			 try{
				 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 

				 d = formatter.parse(idatefrom); 
				 ds = new java.sql.Date(d.getTime());
				 
				 d1 = formatter.parse(idateTo); 
				 ds1 = new java.sql.Date(d1.getTime());			 
			
			 }catch(Exception e){
				 System.out.println(" Date exception ");
				 e.printStackTrace();
			 }
			 
			pstmt.setDate(1, ds);
			pstmt.setDate(2, ds1);
			System.out.println( " query = " + query);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CInvoice invoice = new CInvoice(
						rs.getInt(1),
						rs.getDate(3),
						rs.getInt(2 ),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11)
						);
				map.put(rs.getInt(1), invoice);
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
	
	public Map<Integer, CInvoice> getAllInvoices() {
		try {
			Map<Integer, CInvoice> map = new HashMap<>();
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM invoice";
			pstmt = conn.prepareStatement(query); // create a statement
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInvoice invoice = new CInvoice(
						rs.getInt(1),
						rs.getDate(3),
						rs.getInt(2 ),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11)
						);
				map.put(rs.getInt(1), invoice);
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

	public Map<Integer, CInvoice> getInvoiceById(String id) {
		
		System.out.println(" CInvoice " + id);
		try {
			
			Map<Integer, CInvoice> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = "SELECT * FROM invoice WHERE inumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInvoice invoice = new CInvoice(
						rs.getInt(1),
						rs.getDate(3),
						rs.getInt(2 ),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getString(11)
						);
				mapWithId.put(Integer.parseInt(id), invoice);
				
				System.out.println(" invoice " + id);
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
	public void deleteInvoice(String id) {
		try {
			
			System.out.println(" inumber  " + id );
			
			conn = jdbcConnection.getConnection();
			String query = "DELETE FROM invoice WHERE inumber = ?";
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
	public void updateInvoice(
			int cinumber,
			Date idate,
			int cnumber,
			String cname,
			String qref,
			String currency,
			int iamt,
			String pcurrency,
			String bname,
			int erate,
			String baccount
			) {
		try {
			conn = jdbcConnection.getConnection();
			String query = "UPDATE invoice SET "
					+ "cinumber = ?,"
					+ "invdate = ?,"
					+ "cname = ?,"
					+ "qref = ?,"
					+ "currency = ?,"
					+ "INVAMOUNT = ?,"
					+ "pcurrency = ?,"
					+ "bname = ?,"
					+ "erate = ?,"
					+ "baccount = ?"
					+ " WHERE inumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(11,cinumber);
			pstmt.setInt(1, cnumber);
			pstmt.setDate(2, idate);
			pstmt.setString(3, cname);
			pstmt.setString(4, qref);
			pstmt.setString(5, currency);
			pstmt.setInt(6, iamt);
			pstmt.setString(7, pcurrency);
			pstmt.setString(8, bname);
			pstmt.setInt(9, erate);
			pstmt.setString(10, baccount);
			
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
	
public Map<Integer, CInvMaterials> getMaterialForInvoiceById(String id) {
		
		System.out.println(" qnumber " + id);
		try {
			
			Map<Integer, CInvMaterials> mapWithId = new HashMap<>();
			
			conn = jdbcConnection.getConnection();
			String query = ""
					+ "select "
					+ "M.MDESC, "
					+ "M.UOM, "
					+ "M.DPRICE, "
					+ "QM.QUANTITY, "
					+ "QM.NETPRICE,  "
					+ "QM.REMARKS, "
					+ "QM.qmsnumber "
					+ "from material m "
					+ "join quo_materials qm "
					+ "on m.mnumber=qm.mnumberf and "
					+ "qm.qnumberf=? ";
				
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CInvMaterials invMaterials = new CInvMaterials(
						rs.getString(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getInt(4),
						rs.getInt(5), 
						rs.getString(6)
						);
				mapWithId.put(rs.getInt(7), invMaterials);
				
				System.out.println(" qmsnumber " + rs.getInt(7));
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

}
