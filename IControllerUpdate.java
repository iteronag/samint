package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.IService;


@WebServlet(description = "/", urlPatterns = { "/update-inquiry" })
public class IControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IService invoiceService = new IService();
		
		String param = request.getParameter("id");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
			
		session.setAttribute("inquiryById", invoiceService.getInquiryById(param));
		response.sendRedirect("cinquiry.jsp?update=true");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int inumber = -1;
		
		if(request.getParameter("id")!=null){
			inumber =  Integer.parseInt(request.getParameter("id"));
		}
		
		String cnumber = request.getParameter("cnumber");
		String idate = request.getParameter("idate");
		String segments = request.getParameter("segments");
		//String organization = request.getParameter("organization");
		String idesc = request.getParameter("idesc");
		String mdesc = request.getParameter("mdesc");
		String mnumber = request.getParameter("mnumber");
		String mname = request.getParameter("mname");
		String mmnumber = request.getParameter("mmnumber");
		String mmname = request.getParameter("mmname");
		String nextvdate = request.getParameter("nextvdate");
		String remarks = request.getParameter("remarks");
		
		Date d = Date.valueOf(nextvdate);
		Date id = Date.valueOf(idate);
		 
		IService inquiryService = new IService();
		inquiryService.updateInquiry(
				inumber,
				Integer.parseInt(cnumber),
				 id,
				  segments,
				  idesc,
				  Integer.parseInt(mnumber),
				  mdesc,
				  Integer.parseInt(mmnumber),
				  mname,
				  Integer.parseInt(mmnumber),
				  mmname,
				  d,
				  remarks			
				);
		//HttpSession session = request.getSession();

		 response.sendRedirect("home");
		//RequestDispatcher rd = request.getRequestDispatcher("search-bankbalance");
		//rd.forward(request,response);
	}
}