package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.MService;


@WebServlet(description = "/", urlPatterns = { "/add-material" })
public class MControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String cnumber = request.getParameter("cnumber");
		String mdesc = request.getParameter("mdesc");
		String attr = request.getParameter("attr");		
		String uom = request.getParameter("uom");
		int dprice = Integer.parseInt(request.getParameter("dprice"));	
		int stockInHand = Integer.parseInt(request.getParameter("stockInHand"));
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");
		
		System.out.println(mdesc + " " + attr + " " + uom + " " + dprice + " " + 
		stockInHand + " " + price + " " + currency + " "  );
		
		MService materialService = new MService();
		materialService.addMaterial(
				-1, 
				mdesc,
				attr,
				uom,
				dprice,
				stockInHand,
				price,
				currency	
				);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("materialList", materialService.getAllMaterials());
		
		response.sendRedirect("home.jsp");

	}	

}
