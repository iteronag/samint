package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.QuoMaterialService;


@WebServlet(description = "/", urlPatterns = { "/add-mat-quotation" })
public class QuoMControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String cnumber = request.getParameter("qmnumber");
		int qnumber = Integer.parseInt(request.getParameter("qnumber"));
		int mnumber = Integer.parseInt(request.getParameter("mnumber"));
		String mdesc = request.getParameter("mdesc");		
		int nprice = Integer.parseInt(request.getParameter("nprice"));
		String currency = request.getParameter("currency");	
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String remarks = request.getParameter("remarks");
		
		
		System.out.println(mnumber + " =mnumber " + mdesc + "= mdesc  " + nprice + " = nprice" + currency + " = currency" + 
				quantity + " = quantity" + remarks + "=remarks  " );
		
		QuoMaterialService quoMaterialService = new QuoMaterialService();
		
		quoMaterialService.addQuoMaterials(
				-1, 
				qnumber, 
				mnumber, 
				nprice, 
				quantity, 
				remarks
				);
		

		
		
		HttpSession session = request.getSession();
		session.setAttribute("quoMaterialList", quoMaterialService.getAllQuoMaterials());
		
		response.sendRedirect("cquotation.jsp");

	}	

}
