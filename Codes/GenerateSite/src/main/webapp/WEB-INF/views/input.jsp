<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.thanhnhantn.generate.components.*"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
*{
	outline: solid 1px #ccc;
}
</style>
</head>
<body>
	<%
		Theme theme = (Theme) request.getAttribute("theme");
	%>
	<%
		for (themeFile file : theme.getFiles()) {
	%>
	<%=file.toString()%>
	<%
		}
	%>
</body>
</html>
