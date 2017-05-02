package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.MService;


@WebServlet(description = "/", urlPatterns = { "/delete-mat-quotation" })
public class QuoMControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MService materialService = new MService();
		materialService.deleteMaterial(request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);

	}

}
