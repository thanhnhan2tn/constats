<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theme Manager</title>
</head>
<body>

	<%
		String action = (String) request.getParameter("action");
		if (action != null) {
			if (action.equals("install")) {
	%>
	<form action="${pageContext.request.contextPath }/themes/upload"
		method="POST" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit"
			value="Install">
	</form>

	<%
		} else {
	%>
	Chua cai dat
	<%
		}
		}
	%>
</body>
</html>