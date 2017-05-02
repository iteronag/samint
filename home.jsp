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
          <a data-toggle="collapse" href="#collapse1">Customer</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="ccustomer">Create</a></li>
          <li class="list-group-item"><a href="scustomer.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div>
  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2">Material</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="cmaterial.jsp">Create</a></li>
          <li class="list-group-item"><a href="smaterial.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div>
  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse3">Employee</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="cemployee.jsp">Create</a></li>
          <li class="list-group-item"><a href="semployee.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div>
  
    <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse4">Inquiry</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="cinquiry.jsp">Create</a></li>
          <li class="list-group-item"><a href="sinquiry.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div> 
  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse6">Quotation</a>
        </h4>
      </div>
      <div id="collapse6" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="cquotation.jsp">Create</a></li>
          <li class="list-group-item"><a href="squotation.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div>   
    
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse12">Invoice</a>
        </h4>
      </div>
      <div id="collapse12" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="ccinvoice.jsp">Create</a></li>
          <li class="list-group-item"><a href="sinvoice.jsp">Search</a></li>
        </ul>
        
      </div>
    </div>
  </div> 
   
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse8">Receipts / Payments</a>
        </h4>
      </div>
      <div id="collapse8" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="creceipt.jsp">Create</a></li>
          <li class="list-group-item">Search</li>
        </ul>
        
      </div>
    </div>
  </div> 
   
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse9">Employee Payments</a>
        </h4>
      </div>
      <div id="collapse9" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="cepayment.jsp">Create</a></li>
          <li class="list-group-item">Search</li>
        </ul>
        
      </div>
    </div>
  </div>   
   
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse10">Bank Balance </a>
        </h4>
      </div>
      <div id="collapse10" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item">
          <a href="search-bankbalance">Create</a></li>
          <li class="list-group-item">Search</li>
        </ul>
        
      </div>
    </div>
  </div>  
   
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse11">Reports </a>
        </h4>
      </div>
      <div id="collapse11" class="panel-collapse collapse">
        <ul class="list-group">
          <li class="list-group-item"><a href="reports.jsp">Create</a></li>
          <li class="list-group-item">Search</li>
        </ul>
        
      </div>
    </div>
  </div>       
     
</div>	
 
</body>
</html>