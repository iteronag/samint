<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Material Report</title>
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
<h2>Material Report Information</h2>
<form action="report-material">
<button type="submit">Get Report</button>
</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Material Number</th>
					<th>Material Description</th>
					<th>Stock in hand</th>
					<th>Price</th>
					<th>Currency</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${materialAllById}" var="val">
					<tr>
						<td><c:out value="${val.value.mnumber}" /></td>
						<td><c:out value="${val.value.mdesc}" /></td>
						<td><c:out value="${val.value.stockInHand}" /></td>
						<td><c:out value="${val.value.price}" /></td>
						<td><c:out value="${val.value.currency}" /></td>						
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
</body>
</html>