<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		mathod="POST">
		<c:if test="${param.error != null}">
			<i>Sorry! you entered wrong credentials.</i>
		</c:if>
		<c:if test="${param.logout != null}">
			<i>You have been logged out.</i>
		</c:if>
		<br>
		Username : <input type="text" name="username" />
		<br>
		Password : <input type="password" name="password" />
		<br>
		<input type="submit" value="Login" />
	</form:form>

</body>
</html>