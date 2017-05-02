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
				<h2>Edit Material</h2>
				<form method="post" action="update-material" class="form-inline">
				
				<c:set var="norecordm" scope="session" value="true"/>
				
					<c:forEach items="${materialById}" var="val">
						<input type="hidden" name="id" value="${val.key}">
						
 				<div class="row">
				    <div class="col-sm-4"><label for="mdesc">Material Description:</label></div>
				    <div class="col-sm-4">
						<input type="mdesc"
						class="form-control" id="mdesc" name="mdesc"
						value="${val.value.mdesc}">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="attr">Attribute:</label></div>
				    <div class="col-sm-4">
						<input type="attr"
						class="form-control" id="attr" name="attr"
						value="${val.value.attr}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="uom">UOM :</label></div>
				    <div class="col-sm-4">
						<input type="uom" 
						class="form-control" id="uom" name="uom"
						value="${val.value.uom}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="dprice">Default Price :</label></div>
				    <div class="col-sm-4">
						<input type="dprice" 
						class="form-control" id="dprice" name="dprice"
						value="${val.value.dprice}">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="stockInHand">Stock in Hand :</label></div>
				    <div class="col-sm-4">
						<input type="stockInHand" 
						class="form-control" id="stockInHand" name="stockInHand"
						value="${val.value.stockInHand}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="price">Price :</label></div>
				    <div class="col-sm-4">
						<input type="price" 
						class="form-control" id="price" name="price"
						value="${val.value.price}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="currency">Currency :</label></div>
				    <div class="col-sm-4">
						<input type="currency" 
						class="form-control" id="currency" name="currency"
						value="${val.value.currency}">				    
				    </div>
				  </div>
				  				  				  
				  				  
				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4"></div>
				   </div>			
				   <br>	  
				   	<c:set var="norecordm" scope="session" value="false"/>
						
						<button type="submit" class="btn btn-default" value="Edit">Edit</button>

					
					<form action="smaterial.jsp">
						<button type="submit" class="btn btn-default" >Back</button>
						<button type="submit" class="btn btn-default" >Cancel</button>
					</form>
											
					</c:forEach>
				</form>


				<c:if test="${norecordm==true}">
				   <form action="smaterial.jsp">
					<p>No Material Found  <c:out value="${val.key}"/><p>
					<button type="submit" class="btn btn-default" >Back</button>
					</form>
				</c:if>
				
				<c:if test="${norecordm==false}">
				<form action="delete-material">
										<c:forEach items="${materialById}" var="val1">
										   <input type="hidden" name="id" value="${val1.key}">
										 </c:forEach>
					<button type="submit" class="btn btn-default" >Delete</button>				
				</form>
				</c:if>
				
			</c:when>
			<c:otherwise>
				<h2>Create Material</h2>
				<form method="post" action="add-material" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="mdesc">Material Description:</label></div>
				    <div class="col-sm-4">
						<input type="mdesc"
						class="form-control" id="mdesc" name="mdesc"
						placeholder="Enter Material Description	">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="attr">Attribute:</label></div>
				    <div class="col-sm-4">
						<input type="attr"
						class="form-control" id="attr" name="attr"
						placeholder="Enter Attribute">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="uom">UOM :</label></div>
				    <div class="col-sm-4">
						<input type="uom" 
						class="form-control" id="uom" name="uom"
						placeholder="Enter UOM">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="dprice">Default Price :</label></div>
				    <div class="col-sm-4">
						<input type="dprice" 
						class="form-control" id="dprice" name="dprice"
						placeholder="Enter Default price">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="stockInHand">Stock in Hand :</label></div>
				    <div class="col-sm-4">
						<input type="stockInHand" 
						class="form-control" id="stockInHand" name="stockInHand"
						placeholder="Enter Stock in Hand">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="price">Price :</label></div>
				    <div class="col-sm-4">
						<input type="price" 
						class="form-control" id="price" name="price"
						placeholder="Enter price">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="currency">Currency :</label></div>
				    <div class="col-sm-4">
						<input type="currency" 
						class="form-control" id="currency" name="currency"
						placeholder="Enter currency">				    
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
									  		  
					<button type="submit" class="btn btn-default">Reset</button>
					
						<a href="home.jsp" class="btn btn-default">	Cancel	</a>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>