package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactService;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/add-contact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneno = request.getParameter("phoneno");
		ContactService contactService = new ContactService();
		contactService.addContact(name, address, phoneno);
		HttpSession session = request.getSession();
		session.setAttribute("contactList", contactService.getAllContacts());*/
		
		response.sendRedirect("home.jsp");

	}

}
