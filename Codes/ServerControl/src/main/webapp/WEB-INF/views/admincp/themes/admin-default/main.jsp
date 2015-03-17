<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta charset="utf-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title }</title>
<tiles:insertAttribute name="head" ignore="true" />
</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="container-fluid">
	<div class="row">
		<tiles:insertAttribute name="sidebar" />
		<div class="content">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<tiles:insertAttribute name="left-content" />
				<tiles:insertAttribute name="right-content" />
			</div>
		</div>
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	</div>
	</div>
	

</body>
</html>