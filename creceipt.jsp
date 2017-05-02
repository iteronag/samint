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
				<h2>Create Receipts</h2>
				<form method="post" action="add-contact" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-3"><label for="inumber">Invoice Number:</label></div>
				    <div class="col-sm-3">
						<input type="inumber"
						class="form-control" id="inumber" name="inumber"
						placeholder="Enter Invoice Number">				    
				    </div>
			    
				  </div>

					<div class="row">
				    <div class="col-sm-3"><label for="idate">Invoice Date:</label></div>
				    <div class="col-sm-3">
						<input type="idate"
						class="form-control" id="idate" name="idate"
						placeholder="Enter Invoice Date">				    
				    </div>	
				    
				    <div class="col-sm-3"><label for="iamount">Invoice Amount:</label></div>
				    <div class="col-sm-3">
						<input type="iamount"
						class="form-control" id="iamount" name="iamount"
						placeholder="Enter Invoice Amount">				    
				    </div>	
				  </div>
				    				    		
				  <div class="row">
				    <div class="col-sm-3"><label for="cnumber">Customer No:</label></div>
				    <div class="col-sm-3">
						<input type="cnumber"
						class="form-control" id="cnumber" name="cnumber"
						placeholder="Enter Customer No">				    
				    </div>
				    <div class="col-sm-3"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-3">
						<input type="cname"
						class="form-control" id="cname" name="cname"
						placeholder="Enter Customer Name">				    
				    </div>				    
				  </div>

				  <div class="row">
				    <div class="col-sm-3"><label for="qref">Receipt Amounts:</label></div>
				    <div class="col-sm-3">
						<input type="qref"
						class="form-control" id="qref" name="qref"
						placeholder="Enter Quotation Reference">				    
				    </div>
				    <div class="col-sm-3"><label for="currency">Currency:</label></div>
				    <div class="col-sm-3">
						<input type="currency"
						class="form-control" id="currency" name="currency"
						placeholder="currency">				    
				    </div>				    
				  </div>

				  <div class="row">
				    <div class="col-sm-3"><label for="iamount">Invoice Amount:</label></div>
				    <div class="col-sm-3">
						<input type="iamount"
						class="form-control" id="addr2" name="iamount"
						placeholder="Enter Invoice Amount">				    
				    </div>

				    <div class="col-sm-3"><label for="baccount">Bank Account:</label></div>
				    <div class="col-sm-3">
						<input type="baccount"
						class="form-control" id="baccount" name="baccount"
						placeholder="Enter Bank Account">				    
				    </div>
				    				    
				  </div>

				  <div class="row">
				    <div class="col-sm-3"><label for="bname">Bank Name:</label></div>
				    <div class="col-sm-3">
						<input type="bname"
						class="form-control" id="bname" name="bname"
						placeholder="Enter Bank Name">				    
				    </div>

				    <div class="col-sm-3"><label for="cnumber">Cheque Number:</label></div>
				    <div class="col-sm-3">
						<input type="cnumber"
						class="form-control" id="cnumber" name="cnumber"
						placeholder="Enter Cheque Rate ">				    
				    </div>
				  </div>

				   <div class="row">
				   <div class="col-sm-3"></div>
				   <div class="col-sm-3"></div>
				   </div>			
				   <br>	  
				   <div class="row">
				   <div class="col-sm-3"></div>
				   <div class="col-sm-3">
					<button type="submit" class="btn btn-default">Save</button>
									  		  
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					
					<button type="submit" class="btn btn-default">Search</button>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>