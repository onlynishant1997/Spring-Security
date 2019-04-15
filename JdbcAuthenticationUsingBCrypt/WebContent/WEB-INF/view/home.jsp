<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>This is Home</h1>
	<br> User:
	<security:authentication property="principal.username" />
	<br> Roles:
	<security:authentication property="principal.authorities" />
	<br>
	<br>
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">Leaders</a>
	</security:authorize>
	<br>
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems">System Admin</a>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
		mathod="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>