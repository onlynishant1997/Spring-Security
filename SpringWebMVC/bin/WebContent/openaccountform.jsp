<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Open Account</title>
</head>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("user") == null) {
				response.sendRedirect("loginform.jsp");
			}
		}
	%>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="dashboard.jsp">Swiss Bank</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="dashboard.jsp">Home</a></li>
				<li><a href="#" class="active">Open Account</a></li>
				<li><a href="CloseAccount">Close Account</a></li>
				<li><a href="AccountDetails">Account Details</a></li>
				<li><a href="DepositMoney">Deposit Money</a></li>
				<li><a href="WithdrawMoney">Withdraw Money</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Open Account</h2>
		<form action="OpenAccount" method="post">
			<div class="form-group">
				<label for="name">Enter Name:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name">
			</div>
			<div class="form-group">
				<label for="gender">Enter Gender:</label> <input type="text"
					class="form-control" id="gender" placeholder="Enter Gender"
					name="gender">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>