<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <link href="<c:url value="/resources/public/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/public/css/toastr.min.css" />" rel="stylesheet">
  </head>
  <body>
  	<sec:authorize access="isAuthenticated()">
  	<div class="container">
    	<h1>Hello, world!</h1>
    	<a href="<c:url value='/logout' />" class="btn btn-primary">Đăng xuất</a>
    </div>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
    <div class="col-md-4 col-md-offset-4">
    	<form id="frm_login" role="form" action='<c:url value="/login" />' method="post">
    		<h3>Đăng nhập</h3>
			<div class="form-group">
				<input type="email" class="form-control floating-label"
					id="focusedInput" placeholder="Email" required name="email">
			</div>
			<div class="form-group">
				<input type="password" class="form-control floating-label"
					id="focusedInput" placeholder="Mật khẩu" required name="password">
			</div>
			<button type="submit" class="btn btn-primary">
				<i class="mdi-action-done"></i> Đăng nhập
			</button>
		</form>
	</div>
	</sec:authorize>
    <script src="<c:url value="/resources/public/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/public/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/public/js/toastr.min.js" />"></script>
    <script>
    $(document).ready(function() {
		toastr.options = {"positionClass": "toast-bottom-right"};
		<%
			String notify = (String) request.getAttribute("notify");
			if (notify != null && !notify.equals("")) {
				out.write(notify);
			}
		%>
		});		
    </script>
  </body>
</html>