<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Script Jquery -->
<script type="text/javascript"
	src="<c:url value='/resources/themes/default/js/jquery-2.1.1.min.js'/>"></script>
<!-- Script Jquery-UI -->
<script type="text/javascript"
	src="<c:url value='/resources/themes/default/js/jquery-ui.min.js'/>"></script>
<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value='/resources/themes/default/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
	
<!-- bootstrap css framwork -->
<link
	href='<c:url value="/resources/themes/default/plugins/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet" media="screen" type="text/css">
<!-- font Awesome -->
<link
	href='<c:url value="/resources/themes/default/plugins/font-awesome-4.2.0/css/font-awesome.min.css"/>'
	rel="stylesheet" media="screen" type="text/css">
<!-- Morris chart -->

<!-- ContextMenu -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/themes/default/plugins/contextmenu/context.standalone.css'/>">
<link href='<c:url value="/resources/themes/default/plugins/AdminLTE.min.css"/>'
	rel="stylesheet" media="screen" type="text/css">
<!-- Constats Theme Style Sheet file -->
<link href='<c:url value="/resources/themes/default/css/style.css"/>'
	rel="stylesheet" media="screen" type="text/css">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->

<script>
	var cc= '<%=session.getAttribute("cc")%>';
	var check = false;
	var ctx = "${pageContext.request.contextPath}";
</script>