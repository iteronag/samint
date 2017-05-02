package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.EmpPayment;
import com.service.EPService;


@WebServlet(description = "/", urlPatterns = { "/update-emppayment" })
public class EPControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EPService empPaymentService = new EPService();
		
		String param = request.getParameter("id");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
			
		session.setAttribute("empPaymentById", empPaymentService.getEmpPaymentById(param));
		response.sendRedirect("emppaymentedit.jsp?update=true");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int epnumber = -1;
		
		if(request.getParameter("id")!=null){
			epnumber =  Integer.parseInt(request.getParameter("id"));
		}
		
		int enumber = Integer.parseInt(request.getParameter("empno"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String ename = request.getParameter("ename");
		int advamt = Integer.parseInt(request.getParameter("advamt"));
		int expenses = Integer.parseInt(request.getParameter("expenses"));		
		int balamt = Integer.parseInt(request.getParameter("balamt"));
		String remarks = request.getParameter("remarks");
		
		HttpSession session = request.getSession();
		
		System.out.println(" update for epnumber " + epnumber);
		
		EPService empPaymentService = new EPService();


		if( epnumber<=0){
			
			EmpPayment empPayment = new EmpPayment(
					epnumber, 
					enumber,
					year, 
					month, 
					advamt, 
					expenses, 
					balamt, remarks);
			empPayment.setEname(ename);
			
			session.setAttribute("empPaymentToSave", empPayment);
			
			response.sendRedirect("emppaymentedit.jsp?add=true");
		}else{
			
			empPaymentService.updateEmpPayment(
					epnumber, 
					enumber,
					year, 
					month, 
					advamt, 
					expenses, 
					balamt, remarks);
			
			response.sendRedirect("cepayment.jsp");
		}

	}
}