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
				<h2>Create Employee Payment</h2>
				<form method="get" action="search-emppayment" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-2" align="right"><label for="year">Year</label></div>
				    <div class="col-sm-2">
						<input type="year"
						class="form-control" id="year" name="year"
						placeholder="Year">				    
				    </div>
				    <div class="col-sm-2" align="right"><label for="month">Month</label></div>
				    <div class="col-sm-2">
						<input type="month"
						class="form-control" id="month" name="month"
						placeholder="Enter Month">				    
				    </div>	
				    <div class="col-sm-2" align="right"><label for="empno">Emp No</label></div>
				    <div class="col-sm-2">
						<input type="empno"
						class="form-control" id="empno" name="empno"
						placeholder="Enter Month">				    
				    </div>	
				  </div>

				   <div class="row">
				   <div class="col-sm-2"></div>
				   <div class="col-sm-2"></div>
				   <div class="col-sm-2"></div>
				   <div class="col-sm-2"></div>				   
				   <div class="col-sm-2"></div>
				   </div>			
				   <br>	  
				   
				   <div class="row">
				   <div class="col-sm-2"></div>
				   <div class="col-sm-2">
					</div>	
					<div class="col-sm-2"></div>
					<div class="col-sm-2">
					</div>
					<div class="col-sm-2" align="right">
						
							<button type="submit" class="btn btn-default">Search</button>
												
					</div>
					<div class="col-sm-2" align="right">
						<button type="submit" class="btn btn-default">Save</button>
							<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					</div>				
					</div>
					 										
				</form>
				
			</c:otherwise>
		</c:choose>
		
<h2>Payment Information</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Year</th>
					<th>Month</th>					
					<th>Emp No</th>
					<th>Emp Name</th>
					<th>Role</th>
					<th>Salary</th>
					<th>Advance Amount</th>
					<th>Expenses</th>
					<th>Balance Amount</th>
					<th>Phone Number</th>
					<th>Remarks</th>					
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${empPaymentList}" var="val">
					<tr><form method="post" action="update-emppayment">
						<td>
						<input type="year"
						class="form-control" id="year" name="year"
						value="${val.value.year}">						
						</td>
						<td>
						<input type="month"
						class="form-control" id="month" name="month"
						value="${val.value.month}">	
						</td>
						<td>
						<input type="empno"
						class="form-control" id="empno" name="empno"
						value="${val.value.empno}">	
						</td>
						<td>
						<input type="ename"
						class="form-control" id="ename" name="ename"
						value="${val.value.ename}">	
						</td>
						<td><c:out value=" role" /></td>
						<td>
						<input type="msalary"
						class="form-control" id="msalary" name="msalary"
						value="${val.value.msalary}">	
						</td>
						<td>
						<input type="advamt"
						class="form-control" id="advamt" name="advamt"
						value="${val.value.advamt}">	
						</td>
						<td>
						<input type="expenses"
						class="form-control" id="expenses" name="expenses"
						value="${val.value.expenses}">	
						</td>
						<td>
						<input type="balamt"
						class="form-control" id="balamt" name="balamt"
						value="${val.value.balamt}">
						</td>
						<td>
						<input type="remarks"
						class="form-control" id="remarks" name="remarks"
						value="${val.value.remarks}">
						</td>
						<td/>
						<td><button class="btn btn-info" >Update</button></td>
						</form>
						<td><a href="delete-emppayment?id=${val.key}"
							class="btn btn-info" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>				
</body>
</html>