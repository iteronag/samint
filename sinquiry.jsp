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
      var date_nvd=$('input[name="nextvdate"]'); //our date input has the name "date"
      
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
				<h2>Customer Inquiry - Create</h2>
				<form method="post" action="search-inquiry" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-4">
						<input type="cname"
						class="form-control" id="cname" name="cname"
						placeholder="Enter Customer Name">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cnumber">Contact Number:</label></div>
				    <div class="col-sm-4">
						<input type="cnumber"
						class="form-control" id="cnumber" name="cnumber"
						placeholder="Enter Contact Number">				    
				    </div>
				  </div>
				  		  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="inumber">Inquiry Number:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="inumber" name="inumber"
						placeholder="Inquiry Number">				    
				    </div>
				  </div>
				  				  				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="material">Material:</label></div>
				    <div class="col-sm-4">
						<input type="material"
						class="form-control" id="material" name="material"
						placeholder="Material">				    
				    </div>
				  </div>	


				  <div class="row">
				    <div class="col-sm-4"><label for="cmailid">Marketers Name:</label></div>
				    <div class="col-sm-4">
						<input type="mname"
						class="form-control" id="mname" name="mname"
						placeholder="Marketers Name">				    
				    </div>
				  </div>	
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cmailid">Marketers Manager Name:</label></div>
				    <div class="col-sm-4">
						<input type="mmname"
						class="form-control" id="mmname" name="mmname"
						placeholder="Marketers Manager Name">				    
				    </div>
				  </div>

				  <div class="row">
					<div class="col-sm-4"><label for="nextvdate">Next Visit Date:</label></div>
      				<div class="col-sm-4"> <!-- Date input -->
        				<input type="text" 
        				class="form-control" id="nextvdate" name="nextvdate" 
        	   			placeholder="MM/DD/YYY" />
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
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>