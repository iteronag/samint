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

import com.service.EService;


@WebServlet(description = "/", urlPatterns = { "/update-employee" })
public class EControllerUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EService employeeService = new EService();
		
		String param = request.getParameter("enumber");
		if(param.trim().equals("")){
			param="-1";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("employeeById", employeeService.getEmployeeById(param));

		response.sendRedirect("cemployee.jsp?update=true");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String enumber = request.getParameter("id");
		 String ename = request.getParameter("ename");
		 String strDob = request.getParameter("dob");
		 String gender = request.getParameter("gender");
		 String addr1 = request.getParameter("addr1");
		 String addr2 = request.getParameter("addr2");
		 String pobox = request.getParameter("pobox");
		 String city = request.getParameter("city");
		 String country = request.getParameter("country");
		 String per_mail_id = request.getParameter("per_mail_id");
		 String designation = request.getParameter("designation");
		 String msalary = request.getParameter("msalary");
		 String cont_number = request.getParameter("cont_number");
		 String alt_cont_number = request.getParameter("alt_cont_number");
		 String status = request.getParameter("status");

		 Date dob = null;
		 try{
			 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
			 dob = (Date)formatter.parse(strDob); 
		 }catch(Exception e){
			 System.out.println(" Date exception ");
		 }
		
		System.out.println(" update " + enumber);
		
		EService employeeService = new EService();
		employeeService.updateEmployee(
				 Integer.parseInt(enumber), 	
				 ename,
				 dob,
				 gender,
				 addr1,
				 addr2,
				 pobox,
				 city,
				 country,
				 per_mail_id,
				 designation,
				 Integer.parseInt(msalary),
				 Integer.parseInt(cont_number),
				 Integer.parseInt(alt_cont_number),
				 status
				);
		
			response.sendRedirect("semployee.jsp");
	}

}
