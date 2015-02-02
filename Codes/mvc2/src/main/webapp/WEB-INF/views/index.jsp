<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.edu.vn.*"%>
<html>

<head>
<title>Home</title>
<style>
input{
background-color: green;
}
</style>
</head>

<body>
	<h1>
		Convert XML to Object <br>
		<%=request.getAttribute("name2")%>

	</h1>

	<P></P>
</body>
</html>
