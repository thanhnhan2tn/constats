<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Trang chủ</title>
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
<link href="<c:url value="/resources/css/ttNPP.css" />"
	rel="stylesheet" media="screen">	

</head>
<body>
	<div class="container homepage">
		<div class="row">
            <jsp:include page="../inc/navigation_top.jsp" />
            <jsp:include page="../inc/left_menu.jsp" />
			<div class="col-sm-9 col-md-9">
				<div class="well">
					<form action="" method="POST" role="form" class="form-horizontal">
						<h3 class="npp">Nhà phân phối thanh toán tiền cho công ty</h3>
						<div class="form-group">
							<label for="" class="col-lg-2">Mã chuyển tiền</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="dPaymentNo" name="dPaymentNo" placeholder="" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2">Ngày chuyển</label>
							<div class="col-lg-3">
								<input type="date" class="form-control" id="dPaymentDate" name="dPaymentDate"placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2">Tổng tiền</label>
							<div class="col-lg-3">
								<input type="number" class="form-control" id="dPaymentAmt" name="dPaymentAmt" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2">Ghi chú</label>
							<div class="col-lg-4">
								<textarea class="form-control" id="" placeholder=""></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 text-left">
								<button type="submit" class="btn btn-primary button" formaction="addDistributorPayment" formmethod="post">Đồng ý</button>
								<a href="home"><button type="button" class="btn btn-primary button">Trở về</button></a>
							</div>
						</div>

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