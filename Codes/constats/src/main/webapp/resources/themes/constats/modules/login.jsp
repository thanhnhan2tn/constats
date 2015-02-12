<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta name=description content="Home">
<%@include file="/resources/themes/constats/modules/header.jsp"%>
</head>

<body class="container">

<form class="form-signin" action="checkLogin" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputEmail" class="sr-only">Email address</label> <input
		type="email" id="inputEmail" class="form-control"
		placeholder="Email address" required autofocus> <label
		for="inputPassword" class="sr-only">Password</label> <input
		type="password" id="inputPassword" class="form-control"
		placeholder="Password" required>
	<div class="checkbox">
		<label> <input type="checkbox" value="remember-me">
			Remember me
		</label>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
		in</button>
</form>
</body>
</html>