package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EPService;


@WebServlet(description = "/", urlPatterns = { "/search-emppayment" })
public class EPControllerSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EPService empPaymentService = new EPService();
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String empno = request.getParameter("empno");
		
		System.out.println(" Year " + year + " month " + month + " empno " + empno);
		
		HttpSession session = request.getSession();
		session.setAttribute("empPaymentList", empPaymentService.getEmpPaymentByIds(year,month,empno));

		response.sendRedirect("cepayment.jsp");

	}
}
