package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.BBService;


@WebServlet(description = "/", urlPatterns = { "/search-bankbalance" })
public class BBControllerSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BBService bankBalanceService = new BBService();
		
		HttpSession session = request.getSession();
		session.setAttribute("bankBalanceAll", bankBalanceService.getBBalances());

		response.sendRedirect("cbankbalance.jsp");

	}
}
