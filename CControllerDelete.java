package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.CService;


@WebServlet(description = "/", urlPatterns = { "/delete-customer" })
public class CControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CService customerService = new CService();
		customerService.deleteCustomer(request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);

	}

}
