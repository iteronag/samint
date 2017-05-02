package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.InvoiceService;


@WebServlet(description = "/", urlPatterns = { "/search-invoice" })
public class InvoiceControllerSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idatefrom = request.getParameter("idate");
		String idateto = request.getParameter("idateto");
		String inumber = request.getParameter("inumber");
		
		String cname = request.getParameter("cname");
		String cnumber = request.getParameter("cnumber");
		
		System.out.println(
				" idatefrom " + idatefrom
				+ "idateto "  + idateto
				+ " inumber " + inumber
				+ "cnmae " + cname
				+ "cnumber " + cnumber
				);
		
		InvoiceService invMaterialService = new InvoiceService();
		
		HttpSession session = request.getSession();
		session.setAttribute("invoiceById", 
				invMaterialService.getAllInvoicesFromTo(idatefrom, idateto, inumber, cname, cnumber));

		response.sendRedirect("sinvoice.jsp");

	}

}
