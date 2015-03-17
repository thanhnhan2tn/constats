<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Nhập hóa đơn mua hàng</title>
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

<script type="text/javascript">
	function addRow(tableID) {
            var table = document.getElementById(tableID);

            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            var colCount = table.rows[0].cells.length;

            for(var i=0; i<colCount; i++) {
                var newcell = row.insertCell(i);
                newcell.innerHTML = table.rows[1].cells[i].innerHTML;
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                }
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
					<form action="" method="POST" role="form" class="form-horizontal">
						<h3 class="nhd">Nhập hóa đơn mua hàng</h3>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Số hóa đơn</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="orderNo" name="orderNo" placeholder="" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Ngày hóa đơn</b></label>
							<div class="col-lg-3">
								<input type="date" class="form-control" id="orderDate" name="orderDate" placeholder="">
							</div>
						</div>
						<table class="table table-hover table-bordered table-striped" id="tab_logic">
							<thead>
								<tr>
									<th><b>Mã hàng</b></th>
									<th><b>Tên hàng</b></th>
									<th><b>Số lượng</b></th>
									<th><b>Đơn giá</b></th>
									<th><b>Đơn vị tính</b></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input id='mahang' name='mahang' type="text" class="form-control"></input></td>
									<td><input id='tenhang' name='tenhang' type="text" class="form-control"></input></td>
									<td><input id='soluong' name='soluong' type="text" class="form-control"></input></td>
									<td><input id='dongia' name='dongia' type="text" class="form-control"></input></td>
									<td><input id='dvtinh' name='dvtinh' type="text" class="form-control"></input></td>
								</tr>
								<tr></tr>
							</tbody>
						</table>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="button" class="btn btn-primary button" onclick="addRow('tab_logic')">Thêm dòng</button>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Chiết khấu</b></label>
							<div class="col-lg-3">
								<input type="number" class="form-control" id="discAmt" name="discAmt" placeholder="">
							</div>
							<label for="" class="col-lg-2"><b>Thuế GTGT</b></label>
							<div class="col-lg-3 text-right">
								<input type="number" class="form-control" id="taxAmt" name="taxAmt" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Thành tiền</b></label>
							<div class="col-lg-3">
								<input type="number" class="form-control" id="totalAmt" name="totalAmt" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-primary button" formaction="addPurchaseOrder" formmethod="post">Lưu</button>
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