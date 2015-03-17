<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Quản Lý Mặt Hàng</title>
<meta charset="UTF-8">
<meta name=description content="">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<!-- Style -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" media="screen">

</head>
<body>
	<div class="container homepage">
		<div class="row">
			<jsp:include page="../inc/navigation_top.jsp"/>
			<jsp:include page="../inc/left_menu.jsp"/>
			<div class="col-sm-9 col-md-9">
				<div class="well">
					<h1>Danh Sách Mặt Hàng</h1>
					<table class="table table-striped">
						<tr>
							<th>Mã Hàng</th>
							<th>Tên Hàng</th>
							<th>Loại Hàng</th>
							<th>Đơn vị tính chẵn</th>
							<th>Đơn vị tính lẻ</th>
						</tr>
						<c:forEach items="${listItem}" var="list">
							<tr>
								<td>${list.invtId}</td>
								<td>${list.invtName}</td>
								<td>${list.className}</td>
								<td>${list.unitIdT.unitName}</td>
								<td>${list.unitIdL.unitName}</td>
							</tr>
						</c:forEach>
					</table>
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