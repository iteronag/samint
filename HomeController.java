package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.CService;
import com.service.ContactService;

@WebServlet(description = "/", urlPatterns = { "/home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ContactService contactService = new ContactService();
		//CService customerService = new CService();
		//HttpSession session = request.getSession();
		//session.setAttribute("customerList", customerService.getAllCustomers());
		//session.setAttribute("contactList", contactService.getAllContacts());
		response.sendRedirect("home.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
