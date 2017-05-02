package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.BBService;


@WebServlet(description = "/", urlPatterns = { "/update-bankbalance" })
public class BBControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBService bankBalanceService = new BBService();
		
		String param = request.getParameter("id");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
			
		session.setAttribute("bankBalanceById", bankBalanceService.getBBalanceById(param));
		response.sendRedirect("cbankbalance.jsp?update=true");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bbnumber = -1;
		
		if(request.getParameter("id")!=null){
			bbnumber =  Integer.parseInt(request.getParameter("id"));
		}
		
		String bname = request.getParameter("bname");
		String anumber = request.getParameter("anumber");
		String currency = request.getParameter("currency");
		String dateOfEntry = request.getParameter("dateofentry");
		int bbalance = Integer.parseInt(request.getParameter("bbalance"));		
		
		HttpSession session = request.getSession();
		
		System.out.println(" update for epnumber " + bbnumber);
		
		BBService bankBalanceService = new BBService();
			
		bankBalanceService.updateBBalance(
					bbnumber, 
					bname,
					anumber, 
					currency, 
					dateOfEntry, 
					bbalance);
			
		 response.sendRedirect("search-bankbalance");
		//RequestDispatcher rd = request.getRequestDispatcher("search-bankbalance");
		//rd.forward(request,response);

	}
}