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
</head>
<body>
	<div class="container">

		<c:choose>
			<c:when test="${param.update == 'true'}">
				<h2>Edit Customer</h2>
				<form method="post" action="update-customer" class="form-inline">
									
					<c:set var="norecord" scope="session" value="true"/>
									
					<c:forEach items="${customerById}" var="val">
										   <input type="hidden" name="id" value="${val.key}">
				   
				   <div class="row">
				    <div class="col-sm-4"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-4">
						<input type="cname"
						class="form-control" id="cname" name="cname"
						value="${val.value.cname}">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="oname">Organization Name:</label></div>
				    <div class="col-sm-4">
						<input type="oname"
						class="form-control" id="oname" name="oname"
						value="${val.value.oname}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="addr1">Address1:</label></div>
				    <div class="col-sm-4">
						<input type="addr1"
						class="form-control" id="addr1" name="addr1"
						value="${val.value.addr1}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="oname">Address2:</label></div>
				    <div class="col-sm-4">
						<input type="addr2"
						class="form-control" id="addr2" name="addr2"
						value="${val.value.addr2}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="pobox">PO Box:</label></div>
				    <div class="col-sm-4">
						<input type="pobox"
						class="form-control" id="pobox" name="pobox"
						value="${val.value.pobox}">				    
				    </div>
				  </div>
				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="city">City:</label></div>
				    <div class="col-sm-4">
						<input type="city"
						class="form-control" id="city" name="city"
						value="${val.value.city}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="country">Country:</label></div>
				    <div class="col-sm-4">
						<input type="country"
						class="form-control" id="country" name="country"
						value="${val.value.country}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="currency">Currency:</label></div>
				    <div class="col-sm-4">
						<input type="currency"
						class="form-control" id="currency" name="currency"
						value="${val.value.currency}">			    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cont_per_name">Contact Person Name:</label></div>
				    <div class="col-sm-4">
						<input type="cont_per_name"
						class="form-control" id="cont_per_name" name="cont_per_name"
						value="${val.value.cont_per_name}">		    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="phoneno">Phone Number:</label></div>
				    <div class="col-sm-4">
						<input type="phoneno" 
						class="form-control" id="phoneno" name="phoneno"
						value="${val.value.phoneno}">		    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="mail_id">Mail Id:</label></div>
				    <div class="col-sm-4">
						<input type="mail_id"
						class="form-control" id="mail_id" name="mail_id"
						value="${val.value.mail_id}">				    
				    </div>
				  </div>	

				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4"></div>
				   </div>			
				   <br>	  
					<c:set var="norecord" scope="session" value="false"/>

					<button type="submit" class="btn btn-default" >Edit</button>
					
					<form action="scustomer.jsp">
						<button type="submit" class="btn btn-default" >Back</button>
						<button type="submit" class="btn btn-default" >Cancel</button>
					</form>
											
					</c:forEach>
				</form>
				
				<c:if test="${norecord==true}">
				   <form action="scustomer.jsp">
					<p>No Customer Found  <c:out value="${val.key}"/><p>
					<button type="submit" class="btn btn-default" >Back</button>
					</form>
				</c:if>
				
				<c:if test="${norecord==false}">
				<form action="delete-customer">
										<c:forEach items="${customerById}" var="val">
										   <input type="hidden" name="id" value="${val.key}">
										 </c:forEach>
					<button type="submit" class="btn btn-default" >Delete</button>				
				</form>
				</c:if>
				
			</c:when>
			<c:otherwise>
				<h2>Create Customer</h2>
				<form method="post" action="add-customer" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="cname">Customer Name:</label></div>
				    <div class="col-sm-4">
						<input type="cname"
						class="form-control" id="cname" name="cname"
						placeholder="Enter Customer Name">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="oname">Organization Name:</label></div>
				    <div class="col-sm-4">
						<input type="oname"
						class="form-control" id="oname" name="oname"
						placeholder="Enter Organization Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="addr1">Address1:</label></div>
				    <div class="col-sm-4">
						<input type="addr1"
						class="form-control" id="addr1" name="addr1"
						placeholder="Enter Address1">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="oname">Address2:</label></div>
				    <div class="col-sm-4">
						<input type="addr2"
						class="form-control" id="addr2" name="addr2"
						placeholder="Enter Address2 Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="pobox">PO Box:</label></div>
				    <div class="col-sm-4">
						<input type="pobox"
						class="form-control" id="pobox" name="pobox"
						placeholder="Enter PO Box ">				    
				    </div>
				  </div>
				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="city">City:</label></div>
				    <div class="col-sm-4">
						<input type="city"
						class="form-control" id="city" name="city"
						placeholder="Enter City ">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="country">Country:</label></div>
				    <div class="col-sm-4">
						<input type="country"
						class="form-control" id="country" name="country"
						placeholder="country ">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="currency">Currency:</label></div>
				    <div class="col-sm-4">
						<input type="currency"
						class="form-control" id="currency" name="currency"
						placeholder="Currency ">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cont_per_name">Contact Person Name:</label></div>
				    <div class="col-sm-4">
						<input type="cont_per_name"
						class="form-control" id="cont_per_name" name="cont_per_name"
						placeholder="cpname">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="phoneno">Phone Number:</label></div>
				    <div class="col-sm-4">
						<input type="phoneno" 
						class="form-control" id="phoneno" name="phoneno"
						placeholder="Phone Number">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="mail_id">Mail Id:</label></div>
				    <div class="col-sm-4">
						<input type="mail_id"
						class="form-control" id="mail_id" name="mail_id"
						placeholder="Mail Id">				    
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
					<button type="submit" class="btn btn-default">Save</button>
									  		  
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					
					<button type="submit" class="btn btn-default">Search</button>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
		</div>
</body>
</html>