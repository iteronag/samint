<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>International </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<c:choose>
			<c:when test="${param.update == 'true'}">
				<h2>Update Contact Information</h2>
				<form method="post" action="update-contact" class="form-inline">
					<c:forEach items="${contactById}" var="val">
						<input type="hidden" name="id" value="${val.key}">
						<div class="form-group">
							<label for="poductname">Name:</label> <input type="name"
								class="form-control" id="name" name="name"
								value="${val.value.name}">
						</div>
						<div class="form-group">
							<label for="address">Address:</label> <input type="address"
								class="form-control" id="address" name="address"
								value="${val.value.address}">
						</div>
						<div class="form-group">
							<label for="phoneno">Phone no:</label> <input type="phoneno"
								class="form-control" id="phoneno" name="phoneno"
								value="${val.value.phoneno}">
						</div>
						<button type="submit" class="btn btn-default" value="Update">Update</button>
					</c:forEach>
				</form>

			</c:when>
			<c:otherwise>
				<h2>Search Employee</h2>
				<form method="get" action="update-employee" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="enumber">Employee Number:</label></div>
				    <div class="col-sm-4">
						<input type="enumber"
						class="form-control" id="enumber" name="enumber"
						placeholder="Enter Employee Number">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="ename">Employee Name:</label></div>
				    <div class="col-sm-4">
						<input type="ename"
						class="form-control" id="ename" name="ename"
						placeholder="Enter Employee Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="cont_number">Phone Number:</label></div>
				    <div class="col-sm-4">
						<input type="cont_number" 
						class="form-control" id="cont_number" name="cont_number"
						placeholder="Enter Phone number">				    
				    </div>
				  </div>

				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4"></div>
				   </div>			
				   <br>	  
				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4">
					<button type="submit" class="btn btn-default">Search</button>
									  		  
					<button type="submit" class="btn btn-default">Reset</button>
					
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>