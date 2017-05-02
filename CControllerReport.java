package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.CService;



@WebServlet(description = "/", urlPatterns = { "/report-customer" })
public class CControllerReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CService customerService = new CService();
		
		HttpSession session = request.getSession();

		session.setAttribute("customerAllById", customerService.getAllCustomers());

		response.sendRedirect("creport.jsp");

	}

}
