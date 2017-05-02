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
	
<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


<script>
	var q_date=null;
	 var d_date=null;
		 
    $(document).ready(function(){
      q_date=$('input[name="qdate"]'); //our date input has the name "date"
      d_date=$('input[name="ddate"]'); //our date input has the name "date"
      
      var container=$('.container form').length>0 ? $('.container form').parent() : "body";
      
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };

      q_date.datepicker(options);
      d_date.datepicker(options);
    })
    
</script>
	
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
				<h2>Add Materials to Quotation </h2>
				<form method="post" action="add-mat-quotation" class="form-inline">
					<input type="hidden" name="qnumber" value="1">
				  <div class="row">
				    <div class="col-sm-4"><label for="mnumber">Material Number:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="mnumber" name="mnumber"
						placeholder="Enter Material Number">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="mdesc">Material Name:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="mdesc" name="mdesc"
						placeholder="Enter Material Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="nprice">Net Price:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="nprice" name="nprice"
						placeholder="Enter Net Price">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="currency">Currency:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="currency" name="currency"
						placeholder="Enter Currency">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="quantity">Quantity:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="quantity" name="quantity"
						placeholder="Enter Total Quantity">				    
				    </div>
				  </div>
				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="remarks">Remarks:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="remarks" name="remarks"
						placeholder="Enter Remarks ">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"></div>
				    <div class="col-sm-4">
						<button type="submit" class="btn btn-default">Save</button>
						<a href="cquotation.jsp" type="submit" class="btn btn-default">Cancel</a>
							<a href="home.jsp" class="btn btn-default">Home</a>	
					</div>
								    
					<div class="col-sm-4"></div>
				    <div class="col-sm-4">
										
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
					
					</div>					
					</div>
					 										
				</form>
				
			</c:otherwise>
		</c:choose>
</body>
</html>