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
				<h2>Create Bank Balance</h2>
				<form method="post" action="add-bankbalance" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-2"><label for="bname">Bank Name</label></div>
				    <div class="col-sm-2">
						<input type="bname" 
						class="form-control" id="bname" name="bname"
						placeholder="Enter Bank Name">				    
				    </div>
				  		
				
				    <div class="col-sm-2"><label for="anumber">Account Number</label></div>
				    <div class="col-sm-2">
						<input type="anumber" 
						class="form-control" id="anumber" name="anumber"
						placeholder="Enter Account Number">				    
				    </div>
				  

				  
				    <div class="col-sm-2"><label for="currency">Currency</label></div>
				    <div class="col-sm-2">
						<input type="currency" 
						class="form-control" id="currency" name="currency"
						placeholder="Enter Currency">				    
				    </div>
				 

				 
				    <div class="col-sm-2"><label for="dateofentry">Date of Entry</label></div>
				    <div class="col-sm-2">
						<input type="dateofentry" 
						class="form-control" id="dateofentry" name="dateofentry"
						placeholder="Enter Date Of Entry">				    
				    </div>
				 				  				  
				  	
				  
				    <div class="col-sm-2"><label for="bbalance">Bank Balance</label></div>
				    <div class="col-sm-2">
						<input type="bbalance" 
						class="form-control" id="bbalance" name="bbalance"
						placeholder="Enter Bank Balance">				    
				    </div>
				  </div>
				  	
				  	<br/>
				  	<br/>			  				  				  		
				   <br/>	  
				   <div class="row">
				   <div class="col-sm-9"></div>
				   <div class="col-sm-3">
					<button type="submit" class="btn btn-default">Save</button>
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					</div>					
					</div>
				 										
				</form>			
			</c:otherwise>
		</c:choose>
		
<h2>Bank Balance Information</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Bank Name</th>
					<th>Account Number</th>					
					<th>Currency</th>
					<th>Date Of Entry</th>
					<th>Bank Balance</th>					
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${bankBalanceAll}" var="val">
					<tr><form method="post" action="update-bankbalance">
						<td>
						<input type="bname"
						class="form-control" id="bname" name="bname"
						value="${val.value.bname}">						
						</td>
						<td>
						<input type="anumber"
						class="form-control" id="anumber" name="anumber"
						value="${val.value.anumber}">	
						</td>
						<td>
						<input type="currency"
						class="form-control" id="currency" name="currency"
						value="${val.value.currency}">	
						</td>
						<td>
						<input type="dateofentry"
						class="form-control" id="dateofentry" name="dateofentry"
						value="${val.value.dateOfEntry}">	
						</td>
						<td>
						<input type="bbalance"
						class="form-control" id="bbalance" name="bbalance"
						value="${val.value.bbalance}">	
						</td>
						<td><button class="btn btn-info" >Update</button></td>
						<input type="hidden" name="id" value="${val.key}">
						</form>
						<td><a href="delete-bankbalance?id=${val.key}"
							class="btn btn-info" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
</body>
</html>