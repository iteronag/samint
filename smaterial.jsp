<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SAM International - Material </title>
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
				<h2>Edit Material </h2>
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
						<button type="submit" class="btn btn-default" value="Edit">Edit</button>
					</c:forEach>
				</form>

			</c:when>
			<c:otherwise>
				<h2>Search Material</h2>
				<form method="get" action="update-material" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="mnumber">Material Number:</label></div>
				    <div class="col-sm-4">
						<input type="mnumber"
						class="form-control" id="mnumber" name="mnumber"
						placeholder="Enter Material Number">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="mdesc">Material Desc:</label></div>
				    <div class="col-sm-4">
						<input type="mdesc"
						class="form-control" id="mdesc" name="mdesc"
						placeholder="Enter Material Desc">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="pnumber">Price:</label></div>
				    <div class="col-sm-4">
						<input type="price" 
						class="form-control" id="price" name="price"
						placeholder="Pricer">				    
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