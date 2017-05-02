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
				
					<c:forEach items="${empPaymentById}" var="val">
						<input type="hidden" name="id" value="${val.key}">
						
 				<form method="post" action="add-emppayment" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="year">Year</label></div>
				    <div class="col-sm-4">
						<input type="year"
						class="form-control" id="year" name="year"
						value="${val.value.year}">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="month">Month:</label></div>
				    <div class="col-sm-4">
						<input type="month"
						class="form-control" id="month" name="month"
						value="${val.value.month}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="empno">Emp Number</label></div>
				    <div class="col-sm-4">
						<input type="empno" 
						class="form-control" id="empno" name="empno"
						value="${val.value.empno}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="ename">Emp Name</label></div>
				    <div class="col-sm-4">
						<input type="ename" 
						class="form-control" id="ename" name="ename"
						value="${val.value.ename}">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="msalary">Salary</label></div>
				    <div class="col-sm-4">
						<input type="msalary" 
						class="form-control" id="msalary" name="msalary"
						value="${val.value.msalary}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="advamt">Advance Amount</label></div>
				    <div class="col-sm-4">
						<input type="advamt" 
						class="form-control" id="advamt" name="advamt"
						value="${val.value.advamt}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="expenses">Expenses</label></div>
				    <div class="col-sm-4">
						<input type="expenses" 
						class="form-control" id="expenses" name="expenses"
						value="${val.value.expenses}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="balamt">Balance Amount</label></div>
				    <div class="col-sm-4">
						<input type="balamt" 
						class="form-control" id="balamt" name="balamt"
						value="${val.value.balamt}">				    
				    </div>
				  </div>
				  				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="remarks">Remarks</label></div>
				    <div class="col-sm-4">
						<input type="remarks" 
						class="form-control" id="remarks" name="remarks"
						value="${val.value.remarks}">				    
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
				<h2>Create Employee Payment</h2>
				<form method="post" action="add-emppayment" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="year">Year</label></div>
				    <div class="col-sm-4">
						<input type="year"
						class="form-control" id="year" name="year"
						value="${empPaymentToSave.year}">				    
				    </div>
				  </div>
		
				  <div class="row">
				    <div class="col-sm-4"><label for="month">Month:</label></div>
				    <div class="col-sm-4">
						<input type="month"
						class="form-control" id="month" name="month"
						value="${empPaymentToSave.month}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="empno">Emp Number</label></div>
				    <div class="col-sm-4">
						<input type="empno" 
						class="form-control" id="empno" name="empno"
						value="${empPaymentToSave.empno}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="ename">Emp Name</label></div>
				    <div class="col-sm-4">
						<input type="ename" 
						class="form-control" id="ename" name="ename"
						value="${empPaymentToSave.ename}">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="msalary">Salary</label></div>
				    <div class="col-sm-4">
						<input type="msalary" 
						class="form-control" id="msalary" name="msalary"
						value="${empPaymentToSave.msalary}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="advamt">Advance Amount</label></div>
				    <div class="col-sm-4">
						<input type="advamt" 
						class="form-control" id="advamt" name="advamt"
						value="${empPaymentToSave.advamt}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="expenses">Expenses</label></div>
				    <div class="col-sm-4">
						<input type="expenses" 
						class="form-control" id="expenses" name="expenses"
						value="${empPaymentToSave.expenses}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="balamt">Balance Amount</label></div>
				    <div class="col-sm-4">
						<input type="balamt" 
						class="form-control" id="balamt" name="balamt"
						value="${empPaymentToSave.balamt}">				    
				    </div>
				  </div>
				  				  				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="remarks">Remarks</label></div>
				    <div class="col-sm-4">
						<input type="remarks" 
						class="form-control" id="remarks" name="remarks"
						value="${empPaymentToSave.remarks}">				    
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