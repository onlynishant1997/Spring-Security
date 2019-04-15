<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>This is Home</h1>
	<br>
	<form:form action="${pageContext.request.contextPath}/logout"
		mathod="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>