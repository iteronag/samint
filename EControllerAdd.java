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


@WebServlet(description = "/", urlPatterns = { "/add-employee" })
public class EControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String cnumber = request.getParameter("enumber");
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
		 
		System.out.println(
				  "ename=" + ename
				+ "dob=" + strDob
				+ "gender=" + gender
				+ "addr1=" + addr1
				+ "addr2=" + addr2
				+ "pobox=" + pobox
				+ "city="	+ city
				+ "country=" + country
				+ "per_mail_id=" + per_mail_id
				+ "designation=" +designation
				+ "msalary=" + msalary
				+ "cont_number=" + cont_number
				+ "alt_cont_number=" +alt_cont_number
				+ "status=" + status
		);
		
		EService employeeService = new EService();
		employeeService.addEmployee(
				-1, 	
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
		
		
		HttpSession session = request.getSession();
		session.setAttribute("employeeList", employeeService.getAllEmployees());
		
		response.sendRedirect("home.jsp");

	}	

}
