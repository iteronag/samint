package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.BBService;


@WebServlet(description = "/", urlPatterns = { "/add-bankbalance" })
public class BBControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String cnumber = request.getParameter("bbnumber");
		String bname = request.getParameter("bname");
		String anumber = request.getParameter("anumber");
		String currency = request.getParameter("currency");
		String strDate = request.getParameter("dateofentry");
		int bbalance = Integer.parseInt(request.getParameter("bbalance"));		
		 

		 Date dob = null;
		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
			 dob = (Date)formatter.parse(strDate); 
		 }catch(Exception e){
			 System.out.println(" Date exception ");
		 }
		 
		System.out.println(" update for bbnumber " );
		
		System.out.println(
				  bname + " " +
				  anumber + " " +
				  currency + " " +
				  dob + " " +
				  bbalance
		);
		
		BBService bankBalanceService = new BBService();
		bankBalanceService.addBBalance(
				-1,		
				 bname,
				 anumber,
				 currency,
				 dob,
				 bbalance
				);		
		//HttpSession session = request.getSession();
		//session.setAttribute("bankBalanceList", bankBalanceService.getAllBBalances());

		response.sendRedirect("home.jsp");
	}	
}