<%@page import="vn.edu.cit.servercontrol.vn.edu.cit.servercontrol.Power"%>
<%@page import="vn.edu.cit.model.Server"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Server sv = new Server(1, "192.168.0.101", 22, "root", "root");
			Server pw = new Server();
			pw.Restart(sv);
	%>
</body>
</html>