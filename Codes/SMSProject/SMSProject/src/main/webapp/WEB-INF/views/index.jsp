<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
    <title>Đăng nhập</title>
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
	<h1 class="text-center">Sales Manager System</h1>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Đăng nhập vào hệ thống SMS</h1>
				<div class="account-wall">
					<img class="profile-img" src="<c:url value="/resources/img/sales.png" />"
					alt="">
					<form class="form-signin" action="login" method="post">
						<input type="text" name="userName" class="form-control" placeholder="Tài khoản" required autofocus>
						<input type="password" name="password" class="form-control" placeholder="Mật khẩu" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng nhập</button>
						<label class="checkbox pull-left" id="remember-me">
							<input type="checkbox" name="isRemember" value="remember-me">Ghi nhớ đăng nhập
						</label>
						<a href="#" class="pull-right need-help">Trợ giúp? </a><span class="clearfix"></span>
						
					</form>
				</div>
					<!--<a href="#" class="text-center new-account">Create an account </a>-->
				
			</div>
		</div>
	</div>
	<!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <!-- Bootstrap JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>