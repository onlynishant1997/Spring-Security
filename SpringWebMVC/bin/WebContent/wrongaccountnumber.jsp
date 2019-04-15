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
<title>Wrong Account Number</title>
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
				<li><a href="OpenAccount">Open Account</a></li>
				<li><a href="CloseAccount">Close Account</a></li>
				<li><a href="AccountDetails">Account Details</a></li>
				<li><a href="DepositMoney">Deposit Money</a></li>
				<li><a href="WithdrawMoney">Withdraw Money</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1>Account Number Dont Exist</h1>
		</div>
	</div>
</body>
</html>