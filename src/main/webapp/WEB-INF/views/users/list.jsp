<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<spring:url value="/users/add" var="addURL"></spring:url>
	<a href="${addURL}">Add New User</a>
	<table width="100%" border="1">
	    <tr>
	    	<td>First Name</td>
	    	<td>Last Name</td>
	    	<td>Email</td>
	    	<td colspan="2"> Action</td>
	    </tr>
	    <c:forEach items="${ list}" var="user">
	    	<tr>
	    		<td>${user.firstName}</td>
	    		<td>${user.lastName}</td>
	    		<td>${user.email}</td>
	    		<td>
	    			<spring:url value="/users/update/${user.id}" var="updateURL"></spring:url>
	    			<a href="${updateURL}">Update</a>
	    		</td>
	    		<td>
	    			<spring:url value="/users/delete/${user.id}" var="deleteURL"></spring:url>
	    			<a href="${deleteURL}">Delete</a>
	    		</td>
	    	</tr>
	    </c:forEach>
	</table>
</body>
</html>