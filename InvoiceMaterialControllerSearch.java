package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.InvoiceService;


@WebServlet(description = "/", urlPatterns = { "/search-invoice_material" })
public class InvoiceMaterialControllerSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qnumber = request.getParameter("qref");
		
		System.out.println(" qnumber " + qnumber);
		
		InvoiceService invMaterialService = new InvoiceService();
		
		HttpSession session = request.getSession();
		session.setAttribute("quoMaterialListForInvoice", invMaterialService.getMaterialForInvoiceById(qnumber));
		
		

		response.sendRedirect("ccinvoice.jsp");

	}
}
