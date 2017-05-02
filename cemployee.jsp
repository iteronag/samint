<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SAM International - Employee </title>
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
      var date_input=$('input[name="dob"]'); //our date input has the name "date"
      var container=$('.container form').length>0 ? $('.container form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>
	
</head>
<body>
	<div class="container">

		<c:choose>
			<c:when test="${param.update == 'true'}">
				<h2>Edit Employee </h2>
				
				<form method="post" action="update-employee" class="form-inline">
				
				<c:set var="norecorde" scope="session" value="true"/>
				
					<c:forEach items="${employeeById}" var="val">
						<input type="hidden" name="id" value="${val.key}">
						
				  <div class="row">
				    <div class="col-sm-4"><label for="ename">Employee Name:</label></div>
				    <div class="col-sm-4">
						<input type="ename"
						class="form-control" id="ename" name="ename"
						value="${val.value.ename}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="dob">DOB:</label></div>
				    <div class="col-sm-4">
						<input type="dob"
						class="form-control" id="dob" name="dob"
						value="${val.value.dob}">					    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="gender">Gender:</label></div>
				    <div class="col-sm-4">
						<input type="gender"
						class="form-control" id="gender" name="gender"
						value="${val.value.gender}">					    
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
				    <div class="col-sm-4"><label for="addr2">Address2:</label></div>
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
				    <div class="col-sm-4"><label for="per_mail_id">Personal Mail Id:</label></div>
				    <div class="col-sm-4">
						<input type="per_mail_id"
						class="form-control" id="per_mail_id" name="per_mail_id"
						value="${val.value.per_mail_id}">				    
				    </div>
				  </div>
				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="designation">Designation:</label></div>
				    <div class="col-sm-4">
						<input type="designation"
						class="form-control" id="designation" name="designation"
						value="${val.value.designation}">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="msalary">Monthly Salary:</label></div>
				    <div class="col-sm-4">
						<input type="msalary"
						class="form-control" id="msalary" name="msalary"
						value="${val.value.msalary}">					    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cont_number">Contact Number:</label></div>
				    <div class="col-sm-4">
						<input type="cont_number" 
						class="form-control" id="cont_number" name="cont_number"
						value="${val.value.cont_number}">					    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="alt_cont_number">Alt Contact Number:</label></div>
				    <div class="col-sm-4">
						<input type="alt_cont_number" 
						class="form-control" id="alt_cont_number" name="alt_cont_number"
						value="${val.value.alt_cont_number}">					    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="status">Status Number:</label></div>
				    <div class="col-sm-4">
						<input type="status" 
						class="form-control" id="status" name="status"
						value="${val.value.status}">					    
				    </div>
				  </div>
				  				  
				   <div class="row">
				   <div class="col-sm-4"></div>
				   <div class="col-sm-4"></div>
				   </div>			
				   <br>	  
						<c:set var="norecorde" scope="session" value="false"/>
						
						<button type="submit" class="btn btn-default" value="Edit">Edit</button>
						
					<form action="semployee.jsp">
						<button type="submit" class="btn btn-default" >Back</button>
						<button type="submit" class="btn btn-default" >Cancel</button>
					</form>
											
					</c:forEach>
				</form>


				<c:if test="${norecorde==true}">
				   <form action="semployee.jsp">
					<p>No Employee Found  <c:out value="${val.key}"/><p>
					<button type="submit" class="btn btn-default" >Back</button>
					</form>
				</c:if>
				
				<c:if test="${norecorde==false}">
				<form action="delete-employee">
										<c:forEach items="${employeeById}" var="vale">
										   <input type="hidden" name="id" value="${vale.key}">
										 </c:forEach>
					<button type="submit" class="btn btn-default" >Delete</button>				
				</form>
				</c:if>
				
			</c:when>
			<c:otherwise>
				<h2>Create Employee</h2>
				<form method="post" action="add-employee" class="form-inline">
		
				  <div class="row">
				    <div class="col-sm-4"><label for="ename">Employee Name:</label></div>
				    <div class="col-sm-4">
						<input type="ename"
						class="form-control" id="ename" name="ename"
						placeholder="Enter Employee Name">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="dob">DOB:</label></div>
				    <div class="col-sm-4">
						<input type="dob"
						class="form-control" id="dob" name="dob"
						placeholder="Enter DOB">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="gender">Gender:</label></div>
				    <div class="col-sm-4">
						<input type="gender"
						class="form-control" id="gender" name="gender"
						placeholder="Enter Gender ">				    
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
				    <div class="col-sm-4"><label for="addr2">Address2:</label></div>
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
				    <div class="col-sm-4"><label for="per_mail_id">Personal Mail Id:</label></div>
				    <div class="col-sm-4">
						<input type="per_mail_id"
						class="form-control" id="per_mail_id" name="per_mail_id"
						placeholder="Person Mail Id">				    
				    </div>
				  </div>
				  				  
				  <div class="row">
				    <div class="col-sm-4"><label for="designation">Designation:</label></div>
				    <div class="col-sm-4">
						<input type="designation"
						class="form-control" id="designation" name="designation"
						placeholder="Please Enter Designation">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="msalary">Monthly Salary:</label></div>
				    <div class="col-sm-4">
						<input type="msalary"
						class="form-control" id="msalary" name="msalary"
						placeholder="Enter Monthly Salary">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="cont_number">Contact Number:</label></div>
				    <div class="col-sm-4">
						<input type="cont_number" 
						class="form-control" id="cont_number" name="cont_number"
						placeholder="Enter Contact Number">				    
				    </div>
				  </div>

				  <div class="row">
				    <div class="col-sm-4"><label for="alt_cont_number">Alt Contact Number:</label></div>
				    <div class="col-sm-4">
						<input type="alt_cont_number" 
						class="form-control" id="alt_cont_number" name="alt_cont_number"
						placeholder="Alt Contact Number">				    
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-sm-4"><label for="status">Status Number:</label></div>
				    <div class="col-sm-4">
						<input type="status" 
						class="form-control" id="status" name="status"
						placeholder="Enter Employee Status">				    
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
					
					<button type="submit" class="btn btn-default">Reset</button>
					</div>					
					</div>
					 										
				</form>
			</c:otherwise>
		</c:choose>
</body>
</html>