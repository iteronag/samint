<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer Report</title>
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
<h2>Customer Report Information</h2>
<form action="report-customer">
<button type="submit">Get Report</button>
</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer Number</th>
					<th>Customer Name</th>					
					<th>Address1</th>
					<th>Address2</th>
					<th>PO Box</th>
					<th>City</th>
					<th>Country</th>
					<th>Currency</th>
					<th>Contact Person Name</th>
					<th>Phone Number</th>
					<th>MailID</th>					
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${customerAllById}" var="val">
					<tr>
						<td><c:out value="${val.value.cnumber}" /></td>
						<td><c:out value="${val.value.cname}" /></td>
						<td><c:out value="${val.value.oname}" /></td>
						<td><c:out value="${val.value.addr1}" /></td>
						<td><c:out value="${val.value.addr2}" /></td>
						<td><c:out value="${val.value.pobox}" /></td>
						<td><c:out value="${val.value.city}" /></td>
						<td><c:out value="${val.value.country}" /></td>
						<td><c:out value="${val.value.currency}" /></td>
						<td><c:out value="${val.value.cont_per_name}" /></td>
						<td><c:out value="${val.value.phoneno}" /></td>
						<td><c:out value="${val.value.mail_id}" /></td>
						
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