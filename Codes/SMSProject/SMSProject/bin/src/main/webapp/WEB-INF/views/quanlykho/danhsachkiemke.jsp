<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
    <title>Danh sách kiểm kê kho</title>
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
            <jsp:include page="../inc/navigation_top.jsp" />
            <jsp:include page="../inc/left_menu.jsp" />
            <div class="col-sm-9 col-md-9">
                <div class="well">
                    <h3>Danh sách kiểm kê kho</h3>
                    <table class="table table-bordered table-hover table-striped header-fixed" id="dskiemke">
                        <thead>
                            <tr>
                                <th class="text-center table-head" id="col-1">Mã kiểm kê</th>
                                <th class="text-center table-head" id="col-2">Ngày kiểm kê</th>
                                <th class="text-center table-head" id="col-3">Mã kho</th>
                            </tr>
                        </thead>
						<tbody>
							<c:forEach var="wareInvtList" items="${wiList}">
								<tr>
									<td>${wareInvtList.wInventoryNo}</td>
									<td>${wareInvtList.wInventoryDate}</td>
									<td>${wareInvtList.stock.stockId}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="home" class="btn btn-primary btn-back">Trở về</a>
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