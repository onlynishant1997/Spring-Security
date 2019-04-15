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
				<li><a href="OpenAccount">Open Account</a></li>
				<li><a href="#" class="active">Close Account</a></li>
				<li><a href="AccountDetails">Account Details</a></li>
				<li><a href="DepositMoney">Deposit Money</a></li>
				<li><a href="WithdrawMoney">Withdraw Money</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Close Account</h2>
		<form action="CloseAccount" method="post">
			<div class="form-group">
				<label for="number">Enter Account Number:</label> <input
					type="number" class="form-control" id="number"
					placeholder="Enter account number" name="number">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>