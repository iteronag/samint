<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SAM International</title>
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
  

<div class="container" >

  <h2>SAM International </h2>

  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Reports</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="ireport.jsp">Invoice Report</a></li>
          <li class="list-group-item"><a href="creport.jsp">Customer Report</a></li>
          <li class="list-group-item"><a href="mreport.jsp">Material Report</a></li>
          <li class="list-group-item"><a href="ereport.jsp">Employee Report</a></li>
          <li class="list-group-item"><a href="cireport.jsp">Customer Inquiry Report</a></li>
          <li class="list-group-item"><a href="qreport.jsp">Quotation Report</a></li>                    
        </ul>
        
      </div>
    </div>
  </div>
  
      
		<p>
		<form action="home.jsp">
				<button type="submit" class="btn btn-default">Home</button>
		</form>
		</p>     
</div>	
 
</body>
</html>