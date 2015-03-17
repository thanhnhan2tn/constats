<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
	<title>Trang chủ</title>
	<link rel="Shortcut Icon" type="image/ico" href="<c:url value="/resources/img/sales.ico" />">
	<meta charset="UTF-8">
	<meta name=description content="">
	<meta name=viewport content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
	<!-- Style -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" media="screen">
	<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" media="screen">
</head>
<body>
	<div class="container homepage">
		<div class="row">
		
			<jsp:include page="./inc/navigation_top.jsp"/>
			<jsp:include page="./inc/left_menu.jsp"/>
			
			<div class="col-sm-9 col-md-9">
				<div class="well">
					<div class="page-header">
						<h1>
							Sales Manager System
						</h1>
					</div>
					<p>Hệ thống xin chúc bạn có một ngày bán hàng thật là LỜI.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<!-- Bootstrap JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>