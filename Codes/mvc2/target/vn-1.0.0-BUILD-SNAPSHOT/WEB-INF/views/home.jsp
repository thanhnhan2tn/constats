<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page  import = "javax.servlet.http.HttpServletRequest"%>
<%@page import="com.edu.vn.*" %>>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<%= request.getAttribute("name") %>
</h1>

<P>   </P>
</body>
</html>
