<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SAM International </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


<script>
    $(document).ready(function(){
      var date_input=$('input[name="idate"]'); //our date input has the name "date"
      var date_nvd=$('input[name="idateto"]'); //our date input has the name "date"
      
      var container=$('.container form').length>0 ? $('.container form').parent() : "body";
      
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };

      date_input.datepicker(options);
      date_nvd.datepicker(options);
    })
</script>
	
</head>
<body>
	<div class="container">

		<c:choose>
			<c:when test="${param.update == 'true'}">
				<h2>Customer Inquiry Search </h2>
				<table class="table table-striped">
				<thead>
					<tr>
						<th>Customer Name</th>
						<th>Inquiry Number</th>
						<th>Material</th>
						<th>Next Visit Date</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${inquiryAll}" var="val">
							<tr>
								<td><c:out value="${val.value.customerid}" /></td>
								<td><a href="#" >
									<i> <c:out value="${val.value.inumber}" />
									</i> </a></td>
								<td><c:out value="${val.value.mdesc}" /></td>
								<td><c:out value="${val.value.nextVDate}" /></td>
								<td><a href="update-contact?id=${val.key}"
									class="btn btn-info" role="button">Update</a></td>
								<td><a href="delete-contact?id=${val.key}"
									class="btn btn-info" role="button">Delete</a></td>
							</tr>
						</c:forEach>
				</tbody>
				</table>
				<p>
				<form action="reports.jsp">
						<button type="submit" class="btn btn-default">Back</button>
				</form>
				</p>
			</c:when>
			<c:otherwise>
				<h2>Search Customer Invoice </h2>
				<form method="post" action="search-invoice" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="inumber">Invoice Number:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="inumber" name="inumber"
						placeholder="Enter Invoice Number">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="idate">Invoice Date From:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="idate" name="idate"
						placeholder="Enter Invoice Date from ">				    
				    </div>
				  
				  		  				  
				  
				    <div class="col-sm-4"><label for="idateto">Invoice Date to:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="idateto" name="idateto"
						placeholder="Enter Invoice Date to">				    
				    </div>
				  </div>
				  				  				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cnumber">Customer Number:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="cnumber" name="cnumber"
						placeholder="Enter Customer Number">				    
				    </div>
				  	


				  
				    <div class="col-sm-4"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="cname" name="cname"
						placeholder="Enter Customer Name">				    
				    </div>
				  </div>	
				  			
				   <br>	  
				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4">
				
					<button type="submit" class="btn btn-default">Search</button>
				
				<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
		
				<table class="table table-striped">
				<thead>
					<tr>
						<th>Invoice .No</th>
						<th>Invoice Date </th>
						<th>Customer Number</th>
						<th>Customer Name</th>
						<th>Amount</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${invoiceById}" var="val">
							<tr>
						<form>
						<input type="hidden" name="id" value="${val.key}">
							
								<td>
								<input type="text"
						class="form-control" id="inumber" name="inumber"
						value="${val.value.cinumber}">	
								</td>
								<td>
								<input type="text" 
        				class="form-control" id="idate" name="idate" 
        	   			value="${val.value.idate}" />
								</td>
								<td>
								<input type="cnumber"
						class="form-control" id="cnumber" name="cnumber"
						value="${val.value.cnumber}">
</td>
								<td>
								<input type="cname"
						class="form-control" id="cname" name="cname"
						value="${val.value.cname}">	
								</td>
								<td>
						<input type="text"
						class="form-control" id="iamount" name="iamount"
						value="${val.value.iamount}">									
								</td>
								
								<td> 
								<a href="update-invoice?id=${val.key}"
									class="btn btn-info" role="button">Update</a> 
									
								
								<a href="delete-invoice?id=${val.key}"
									class="btn btn-info" role="button">Delete</a>  
									
									</td>
									<td></td>
									</form>
							</tr>
						</c:forEach>
				</tbody>
				</table>
				<p><!-- 
				<form action="reports.jsp">
						<button type="submit" class="btn btn-default">Back</button>
				</form>
				 --> </p>
				 		
</body>
</html>