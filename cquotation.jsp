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
				<h2>Update Quotation </h2>
				
				<form method="post" action="update-quotation" class="form-inline">
					<c:forEach items="${quotationById}" var="val">
						<input type="hidden" name="id" value="${val.key}">
						
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
				    <div class="col-sm-4"><label for="qdate">Quotation Date:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="qdate" name="qdate"
						value="${val.value.qdate}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="remarks">Remarks:</label></div>
				    <div class="col-sm-4">
						<input type="remarks"
						class="form-control" id="remarks" name="remarks"
						value="${val.value.remarks}s">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="tprice">Total Price:</label></div>
				    <div class="col-sm-4">
						<input type="tprice"
						class="form-control" id="tprice" name="tprice"
						value="${val.value.totalprice}">				    
				    </div>
				  </div>
				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="ddate">Delivery Date:</label></div>
				    <div class="col-sm-4">
						<input type="ddate"
						class="form-control" id="ddate" name="ddate"
						value="${val.value.ddate}">				    
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
					<button type="submit" class="btn btn-default">Update</button>
									  		  
					<button type="submit" class="btn btn-default">Delete</button>
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
				
					</div>					
					</div>
					 								
						
					</c:forEach>
				</form>


			</c:when>
			<c:otherwise>
				<h2>Create Quotation </h2>
				<form method="post" action="add-quotation" class="form-inline">
		
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
				    <div class="col-sm-4"><label for="qdate">Quotation Date:</label></div>
				    <div class="col-sm-4">
						<input type="text"
						class="form-control" id="qdate" name="qdate"
						placeholder="Enter Quotation Date">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="remarks">Remarks:</label></div>
				    <div class="col-sm-4">
						<input type="remarks"
						class="form-control" id="remarks" name="remarks"
						placeholder="Enter Remarks">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="tprice">Total Price:</label></div>
				    <div class="col-sm-4">
						<input type="tprice"
						class="form-control" id="tprice" name="tprice"
						placeholder="Enter Total Price ">				    
				    </div>
				  </div>
				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="ddate">Delivery Date:</label></div>
				    <div class="col-sm-4">
						<input type="ddate"
						class="form-control" id="ddate" name="ddate"
						placeholder="Enter Delivery Date ">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="ddate">ADD MATERIAL:</label></div>
				    <div class="col-sm-4">
						<a href="addMatToQuo.jsp" type="submit" class="btn btn-default">Add Material</a>
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
					<button type="submit" class="btn btn-default">Save Quotation</button>
									  		  
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					
					<button type="submit" class="btn btn-default">Search</button>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
		
			<h2>Materials for the Quotation </h2>
				<table class="table table-striped">
				<thead>
					<tr>
						<th>Line Item</th>
						<th>Material Number</th>
						<th>Material Name</th>
						<th>Net Price</th>
						<th>Currency</th>
						<th>Quantity</th>
						<th>Remarks</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${quoMaterialList}" var="val">
							<tr>
								<td><c:out value="${val.value.qmsnumber}" /></td>
								<td><a href="#" >
									<i> <c:out value="${val.value.qnumber}" />
									</i> </a></td>
								<td><c:out value="${val.value.mnumber}" /></td>
								<td><c:out value="${val.value.netprice}" /></td>
								<td>CAD</td>
								<td><c:out value="${val.value.quantity}" /></td>
								<td><c:out value="${val.value.remarks}" /></td>
								<td><a href="update-contact?id=${val.key}"
									class="btn btn-info" role="button">Update</a></td>
								<td><a href="delete-mat-quotation?id=${val.key}"
									class="btn btn-info" role="button">Delete</a></td>
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