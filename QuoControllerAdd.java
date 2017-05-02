package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Quotation;
import com.service.QuoService;


@WebServlet(description = "/", urlPatterns = { "/add-quotation" })
public class QuoControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String qnumber = request.getParameter("qnumber");
		int cnumber = Integer.parseInt(request.getParameter("cnumber"));
		String qdate = request.getParameter("qdate");
		String remarks = request.getParameter("remarks");
		int tprice = Integer.parseInt(request.getParameter("tprice"));
		String ddate = request.getParameter("ddate");	

		
		
		System.out.println(cnumber + " =cnumber " + qdate + "= qdate  " + remarks + " = remarks" + tprice + " = tprice" + 
				ddate + " = ddate"  );
		
		QuoService quoService = new QuoService();
		
		java.util.Date d = null;
		java.sql.Date ds = null;
		
		java.util.Date d1 = null;
		java.sql.Date ds1 = null;
		

		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 

			 d = formatter.parse(qdate); 
			 ds = new java.sql.Date(d.getTime());
			 
			 d1 = formatter.parse(ddate); 
			 ds1 = new java.sql.Date(d1.getTime());			 
		
		 }catch(Exception e){
			 System.out.println(" Date exception ");
			 e.printStackTrace();
		 }
		 
		
		quoService.addQuotation(
				-1, 
				cnumber,
				ds,
				remarks,
				tprice,
				ds1
				);
		
		
		HttpSession session = request.getSession();
		
		Map<Integer, Quotation> quoMaterial = (Map<Integer, Quotation>)session.getAttribute("quoMaterialList");
		System.out.println(" quoMaterial " + quoMaterial.size());
		//session.setAttribute("quoList", quoService.getAllQuotations());
		
		response.sendRedirect("home.jsp");
	}	
}
