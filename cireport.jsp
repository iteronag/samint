<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer Inquiry Report</title>
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
<h2>Customer Inquiry Report Information</h2>
<form action="report-inquiry">
<button type="submit">Get Report</button>
</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Inquiry Number</th>
					<th>Customer Name</th>
					<th>Contact Number</th>
					<th>Inquiry Date</th>
					<th>Segments</th>
					<th>Organization</th>
					<th>Inquiry Description</th>
					<th>Material</th>
					<th>Segments</th>
					<th>Marketers Name</th>
					<th>Marketers Manager Name</th>
					<th>Next Visit Date</th>
					<th>Remarks</th>
					<th>Alt Contact Number</th>
					<th>Status</th>
					
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${inquiryAll}" var="val">
					<tr>
						<td><c:out value="${val.value.inumber}" /></td>
						<td><c:out value="${val.value.customerid}" /></td>
						<td><c:out value="${val.value.customerid}" /></td>
						<td><c:out value="${val.value.inqdate}" /></td>
						<td><c:out value="${val.value.segments}" /></td>
						<td><c:out value="${val.value.segments}" /></td>
						<td><c:out value="${val.value.inqdesc}" /></td>						
						<td><c:out value="${val.value.mid}" /></td>
						<td><c:out value="${val.value.mname}" /></td>
						<td><c:out value="${val.value.mmname}" /></td>
						<td><c:out value="${val.value.nextVDate}" /></td>		
						<td><c:out value="${val.value.remarks}" /></td>
						<td><c:out value="alt contact" /></td>
						<td><c:out value="active" /></td>												
	 						
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