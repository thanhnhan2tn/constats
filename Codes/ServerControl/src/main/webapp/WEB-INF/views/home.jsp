<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	String p = (String) request.getAttribute("page");
	if (p.equals("home")) {
%>
<tiles:insertDefinition name="home-default" />
<%
	} else {
%>
<tiles:insertDefinition name="login" />
<%
	}
%>