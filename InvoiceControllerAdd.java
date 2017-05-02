package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.InvoiceService;


@WebServlet(description = "/", urlPatterns = { "/add-invoice" })
public class InvoiceControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String cnumber = request.getParameter("cinumber");
		String idate = request.getParameter("idate");
		String cnumber = request.getParameter("cnumber");		
		String cname = request.getParameter("cname");
		String qref = request.getParameter("qref");	
		String currency = request.getParameter("currency");
		int iamount = Integer.parseInt(request.getParameter("iamount"));
		String pcurrency = request.getParameter("pcurrency");
		String bname = request.getParameter("bname");
		int erate = Integer.parseInt(request.getParameter("erate"));
		String baccount = request.getParameter("baccount");
		

		java.util.Date d = null;
		java.sql.Date ds = null;
		

		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 

			 d = formatter.parse(idate); 
			 ds = new java.sql.Date(d.getTime());		 
		
		 }catch(Exception e){
			 System.out.println(" Date exception ");
			 e.printStackTrace();
		 }
		 
				
		System.out.println( "" 
				+ "inumber,"  
				+ "cinumber," 
				+ "invdate," + idate
				+ "cname," + cname
				+ "qref," + qref
				+ "currency," + currency
				+ "INVAMOUNT," + iamount
				+ "pcurrency," + pcurrency
				+ "bname," + bname
				+ "erate," + erate
				+ "baccount" + baccount
							);
		
		InvoiceService invoicelService = new InvoiceService();
		invoicelService.addInvoice(
				-1, 
				ds,
				 Integer.parseInt(cnumber),
				 cname,
				 qref,
				 currency,
				 iamount,
				 pcurrency,
				 bname,
				 erate,
				 baccount	
				);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("invoiceList", invoicelService.getAllInvoices());
		
		response.sendRedirect("home.jsp");

	}	

}
