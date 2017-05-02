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



<form  method="post" action="home">
<!-- 
  <div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div>
 -->
  <div class="container">
  <div class="row">
  	<div class="col-sm-3"><label><b>Username</b></label></div>
    <div class="col-sm-3">
    <input type="text" placeholder="Enter Username" name="uname" required>
 	</div>
  </div>
 
   <div class="row">	
 	<div class="col-sm-3">
    <label><b>Password</b></label></div>
    <div class="col-sm-3">
    <input type="password" placeholder="Enter Password" name="psw" required>
    </div>
    </div>

    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>

  
</div>	
 
</body>
</html>