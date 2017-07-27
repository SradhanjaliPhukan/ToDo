<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
	<spring:url value="/users/save" var="saveURL"></spring:url>
	<form:form action="${saveURL}" method="POST" modelAttribute="userForm">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Save</button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>