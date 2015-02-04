<%@page import="org.springframework.context.annotation.Import"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@page import= "xml_To_Object.*" %>
        <%@page import= "javax.servlet.http.HttpServletRequest" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><%= request.getAttribute("hehe") %></p>
</body>
</html>