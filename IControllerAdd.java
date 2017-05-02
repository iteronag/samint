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

import com.service.IService;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/add-inquiry")
public class IControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cnumber = request.getParameter("cnumber");
		String idate = request.getParameter("idate");
		String segments = request.getParameter("segments");
		String organization = request.getParameter("organization");
		String idesc = request.getParameter("idesc");
		String mdesc = request.getParameter("mdesc");
		String mnumber = request.getParameter("mnumber");
		String mname = request.getParameter("mname");
		String mmnumber = request.getParameter("mmnumber");
		String mmname = request.getParameter("mmname");
		String nextvdate = request.getParameter("nextvdate");
		String remarks = request.getParameter("remarks");
		
		
		System.out.println(" idate " + idate );
		System.out.println(" nextvdate " + nextvdate );
		
		java.util.Date d = null;
		java.util.Date id = null;
		
		java.sql.Date ds = null;
		java.sql.Date ids = null;
		
		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 

			 d = formatter.parse(nextvdate); 
			 ds = new java.sql.Date(d.getTime());
			 
			 id = formatter.parse(idate);
			 ids = new java.sql.Date(id.getTime());
		 }catch(Exception e){
			 System.out.println(" Date exception ");
			 e.printStackTrace();
		 }
		 
		IService inquiryService = new IService();
		inquiryService.addInquiry(
				-1,
				Integer.parseInt(cnumber),
				 ids,
				  segments,
				  idesc,
				  Integer.parseInt("1"),
				  mdesc,
				  Integer.parseInt("1"),
				  mname,
				  Integer.parseInt("1"),
				  mmname,
				  ds,
				  remarks			
				);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("contactList", contactService.getAllContacts());*/
		
		response.sendRedirect("home.jsp");
	}

}
