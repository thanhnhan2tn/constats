<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name=description content="">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
</head>
<body style="padding: 0">
	<div class="container-fluid" style="padding: 0">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 login-left"
			style="height: 100%; background-color: #AD3333;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
				style="height: 40%;"></div>
			<h1 style="color: white; text-align: center; font-size: 70px;">Login</h1>
		</div>
		<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8"
			style="height: 100%; background-color: #222;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
				style="height: 35%;"></div>
			<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				<form action="loginCheck" method="POST" class="form-horizontal"
					role="form">
					<div class="form-group">
						<input type="text" name="username" id="username"
							class="form-control login-control" value="" required="required"
							placeholder="Username">
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password"
							class="form-control login-control" value="" required="required"
							title="" placeholder="Password">
					</div>

					<div class="form-group">

						<button type="submit" class="btn btn-default login-button"
							style="width: 100%;">Login</button>

					</div>
				</form>
			</div>

		</div>
	</div>
	<!-- jQuery -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<!-- Bootstrap JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>