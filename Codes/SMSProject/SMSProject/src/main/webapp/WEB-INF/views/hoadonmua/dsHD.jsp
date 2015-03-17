<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Danh sách hóa đơn mua hàng</title>
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
<link href="<c:url value="/resources/css/nhapHD.css" />"
	rel="stylesheet" media="screen">

</head>
<body>
	<div class="container homepage">
		<div class="row">
            <jsp:include page="../inc/navigation_top.jsp" />
            <jsp:include page="../inc/left_menu.jsp" />
			<div class="col-sm-9 col-md-9">
				<div class="well">
					<form action="" method="POST" role="form">
						<h3 class="nhd">Danh sách hóa đơn mua hàng</h3>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Số hóa đơn</th>
									<th>Ngày hóa đơn</th>
									<th>Chiết khấu</th>
									<th>VAT</th>
									<th>Thành tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listOrder}" var="list">
									<tr>
										<td>${list.orderNo}</td>
										<td>${list.orderDate}</td>
										<td>${list.discAmt}</td>
										<td>${list.taxAmt}</td>
										<td>${list.totalAmt}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="home"><button type="button" class="btn btn-primary">Trở về</button></a>
					</form>
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