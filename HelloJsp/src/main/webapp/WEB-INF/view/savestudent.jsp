<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Student</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3> Save Student</h3>
		<form action="/HelloJsp/students/save" method="post">
			<input type="hidden" name="id" value="${student.id}">
			<div class="form-inline">
			<input type="text"  name="name" value="${student.name}" placeholder="Student Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="department" value="${student.department}" placeholder="Student Department" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="country" value="${student.country}" placeholder="Country" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>
		
		<a href="/HelloJsp/students/list">Back to Student List</a>
	
	</div>
</body>
</html>