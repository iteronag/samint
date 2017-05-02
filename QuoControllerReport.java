package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.QuoMaterialService;
import com.service.QuoService;


@WebServlet(description = "/", urlPatterns = { "/report-quotation" })
public class QuoControllerReport extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuoService quoService = new QuoService();
		//QuoMaterialService quoMaterialService = new QuoMaterialService();
		
		HttpSession session = request.getSession();
		session.setAttribute("quotationAllById", quoService.getAllQuotations());
		//session.setAttribute("quoMaterialList", quoMaterialService.getQuoMaterialById(qnumber));
		

		response.sendRedirect("qreport.jsp");

	}
}
