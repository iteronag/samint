package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.MService;


@WebServlet(description = "/", urlPatterns = { "/update-material" })
public class MControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MService materialService = new MService();
		
		String param = request.getParameter("mnumber");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("materialById", materialService.getMaterialById(param));

		response.sendRedirect("cmaterial.jsp?update=true");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mnumber = request.getParameter("id");
		String mdesc = request.getParameter("mdesc");
		String attr = request.getParameter("attr");		
		String uom = request.getParameter("uom");
		int dprice = Integer.parseInt(request.getParameter("dprice"));	
		int stockInHand = Integer.parseInt(request.getParameter("stockInHand"));
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");

		
		System.out.println(" update " + mnumber);
		
		MService materialService = new MService();
		materialService.updateMaterial(
				Integer.parseInt(mnumber), 
				mdesc, 
				attr, 
				uom, 
				dprice, 
				stockInHand, 
				price, 
				currency);
		
			response.sendRedirect("smaterial.jsp");
	}

}
