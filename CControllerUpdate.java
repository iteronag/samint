package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.CService;


@WebServlet(description = "/", urlPatterns = { "/update-customer" })
public class CControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CService customerService = new CService();
		
		String param = request.getParameter("cnumber");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("customerById", customerService.getCustomerById(param));

		response.sendRedirect("ccustomer.jsp?update=true");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cnumber = request.getParameter("id");
		String cname = request.getParameter("cname");
		String oname = request.getParameter("oname");		
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");	
		String pobox = request.getParameter("pobox");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String currency = request.getParameter("currency");
		String cont_per_name = request.getParameter("cont_per_name");
		String phoneno = request.getParameter("phoneno");
		String mail_id = request.getParameter("mail_id");
		
		System.out.println(" update " + cnumber);
		
		CService customerService = new CService();
		customerService.updateCustomer(
				Integer.parseInt(cnumber), 
				cname, 
				oname, 
				addr1, 
				addr2, 
				pobox, 
				city, 
				country, 
				currency, 
				cont_per_name, 
				phoneno, mail_id);
		
			response.sendRedirect("scustomer.jsp");
	}

}
