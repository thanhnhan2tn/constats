<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String type = (String) request.getAttribute("type");
	String p = (String) request.getAttribute("p");
	String f = null;
	if (p != null) {
		if (type == "modules") {
			f = "/resources/themes/constats/modules/" + p + ".jsp";
		} else if (type == null || type.isEmpty()) {
			f = "/resources/themes/constats/" + p + ".jsp";
		}
	} else {
		f = "/resources/themes/constats/home.jsp";
	}
	RequestDispatcher r = request.getRequestDispatcher(f);
	r.include(request, response);
%>


