<%@page import="vn.edu.cit.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title>${title }</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<tiles:insertAttribute name="head" ignore="true" />
</head>
<body class="container layout-boxed">
	<header class="header">
		<tiles:insertAttribute name="header" />
	</header>
	<!-- start wrapper -->
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column -->
		<tiles:insertAttribute name="sidebar" />
		<!-- Right side column -->
		<tiles:insertAttribute name="left-content" />
	</div>
	<footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>