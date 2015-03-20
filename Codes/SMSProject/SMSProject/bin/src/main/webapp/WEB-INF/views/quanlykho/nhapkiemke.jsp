<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="">
<head>
    <title>Nhập thông tin kiểm kê kho</title>
    <meta charset="UTF-8">
    <meta name=description content="">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
    <!-- Style -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" media="screen">
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" media="screen">
    
    <!-- Add row to table -->
    <script type="text/javascript">
        function addRow(tableID) {
            var table = document.getElementById(tableID);
    
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            var colCount = table.rows[0].cells.length;
    
            for (var i = 0; i < colCount; i++) {
                var newcell = row.insertCell(i);
                newcell.innerHTML = table.rows[1].cells[i].innerHTML;
                switch (newcell.childNodes[0].type) {
                case "text":
                    newcell.childNodes[0].value = "";
                    break;
                }
            }
        }
    </script>
</head>
<body>
    <div class="container homepage">
        <div class="row">
            <jsp:include page="../inc/navigation_top.jsp" />
            <jsp:include page="../inc/left_menu.jsp" />
            <div class="col-sm-9 col-md-9">
				<div class="well">
					<h3>Nhập thông tin kiểm kê kiểm kê kho</h3>
					<form action="nhapPhieuKiemKe" method="POST" role="form" class="form-horizontal" id="nhapkiemke">

						<div class="form-group">
							<label for="" class="col-sm-2 control-label">Mã kiểm kê</label>
							<div class="col-sm-5">
							    <input type="text" class="form-control" id="maKiemKe" name="maKiemKe" placeholder="" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">Ngày kiểm kê</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="ngayKiemKe" name="ngayKiemKe" placeholder="" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">Mã kho</label>
							<div class="col-sm-5">
								<select name="maKho" id="maKho" class="form-control" required="required">
								    <option  value="-1" selected="selected" disabled="disabled">Chọn kho</option>
									<c:forEach var="maKho" items="${stoList}">
										<option  value=${maKho.stockId }>${maKho.stockName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<table class="table table-bordered table-hover table-striped"
							id="nhapkiemke" onkeypress="addRow('nhapkiemke')">
							<thead>
								<tr>
									<th class="text-center table-head" id="col-1">Mã hàng</th>
									<th class="text-center table-head" id="col-2">Tên hàng</th>
									<th class="text-center table-head" id="col-3">Đơn vị tính</th>
									<th class="text-center table-head" id="col-4">Số lượng</th>
								</tr>
							</thead>
							<tbody>
                                <tr id="addr1">
                                    <td><input type="text" name='maHang1'  placeholder='Mã hàng' class="form-control"/></td>
                                    <td><input type="text" name='tenHang1'  placeholder='Tên hàng' class="form-control"/></td>
                                    <td><input type="number" name='dvt1'  placeholder='Đơn vị tính' class="form-control"/></td>
                                    <td><input type="number" name='soLuong1'  placeholder='Số lượng' class="form-control"/></td>
                                </tr>
							</tbody>
						</table>
						
						<button type="submit" class="btn btn-primary btn-submit">Lưu</button>
						<a href="home" class="btn btn-default btn-back">Trở về</a>
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