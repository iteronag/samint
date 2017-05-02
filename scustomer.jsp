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
				<h2>Search Customer </h2>
				<form method="get" action="update-customer" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="cnumber">Customer Number:</label></div>
				    <div class="col-sm-4">
						<input type="cnumber"
						class="form-control" id="cnumber" name="cnumber"
						placeholder="Enter Customer Number">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-4">
						<input type="cname"
						class="form-control" id="cname" name="cname"
						placeholder="Enter Customer Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="pnumber">Phone Number:</label></div>
				    <div class="col-sm-4">
						<input type="pnumber" 
						class="form-control" id="pnumber" name="pnumber"
						placeholder="Phone Number">				    
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