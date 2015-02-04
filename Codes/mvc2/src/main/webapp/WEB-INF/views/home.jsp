<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page import= "xml_To_Object.*" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	<%= request.getAttribute("name") %>
	
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
