package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.EService;


@WebServlet(description = "/", urlPatterns = { "/delete-employee" })
public class EControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EService materialService = new EService();
		materialService.deleteEmployee(request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);

	}

}
