package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EPService;


@WebServlet(description = "/", urlPatterns = { "/add-emppayment" })
public class EPControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String cnumber = request.getParameter("epnumber");
		int enumber = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		int advamt = Integer.parseInt(request.getParameter("advamt"));
		int expenses = Integer.parseInt(request.getParameter("expenses"));		
		int balamt = Integer.parseInt(request.getParameter("balamt"));
		String remarks = request.getParameter("remarks");
		
		System.out.println(" update for empno " + enumber);
		
		System.out.println(
				enumber + " " +
				year+ " " + 
				month + " " + 
				advamt + " " + 
				expenses + " " + 
				balamt + " " + 
				remarks
		);
		
		EPService empPaymentService = new EPService();
		empPaymentService.addEmpPayment(
				-1, 
				enumber,
				ename,
				year, 
				month, 
				advamt, 
				expenses, 
				balamt, 
				remarks
				);
		
		HttpSession session = request.getSession();
		session.setAttribute("empPaymentList", empPaymentService.getAllEmpPayments());
		
		response.sendRedirect("home.jsp");
	}	
}