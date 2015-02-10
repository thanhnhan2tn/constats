<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="vn.edu.cit.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<%
		List<User> users = (List<User>) request.getAttribute("users");
	%>
	<%
		for (User user : users) {
			pageContext.setAttribute("username", user.getUserName());
			pageContext.setAttribute("userid", user.getUserId());
			pageContext.setAttribute("diachi", user.getDiaChi());
			
	%>
	<div>${username}</div>
	<div>${userid}</div>
	<div>${diachi}</div>
	<%
		}
	%>
</body>
</html>