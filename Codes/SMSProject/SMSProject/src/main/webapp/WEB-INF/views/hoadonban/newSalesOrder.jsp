<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Nhập hóa đơn mới</title>
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
<!-- jQuery -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
<script>
	$(document).ready(function() {
		$("#date").blur(function() {
			$(this).css("background-color", "#cccccc");
			var date = $("#date").val();
			var d = new Date(date);
			var month = d.getMonth() + 1;
			d.setMonth(month);
			$("#overdate").val(d);
		});
	});

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
					<c:if test="${SUCCESS != null}">
						<div class="alert alert-success" role="alert">${SUCCESS}</div>
					</c:if>
					<c:if test="${ERROR != null}">
						<div class="alert alert-danger" role="alert">${ERROR}</div>
					</c:if>
					<form action="" method="post" role="form"
						class="form-horizontal">
						<h1 class="nhd">Nhập hóa đơn bán hàng mới</h1>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Số hóa đơn</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id=""
									placeholder="Nhập số hóa đơn" required="required"
									name="orderId">
							</div>
							<label for="" class="col-lg-2"><b>Mã KH</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="custId"
									placeholder="" required="required" name="custId"
									onblur="checkNo();">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Ngày hóa đơn</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="date" placeholder="MM-DD-YYYY"
									name="date">
							</div>
							<label for="" class="col-lg-2"><b>Tên KH</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="custName"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Ngày quá hạn TT</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="overdate"
									placeholder="" name="overDate">
							</div>
							<label for="" class="col-lg-2"><b>Ghi chú</b></label>
							<div class="col-lg-3">
								<textarea class="form-control" id="" placeholder="" name="note"></textarea>
							</div>
						</div>
						<table class="table table-hover table-bordered table-striped"
							id="tab_logic" onkeypress="addRow('tab_logic')">
							<thead>
								<tr>
									<th><b>Mã hàng</b></th>
									<th><b>Tên hàng</b></th>
									<th><b>Số lượng</b></th>
									<th><b>Đơn giá</b></th>
									<th><b>Đơn vị tính</b></th>
									<th><b>Chiết khấu</b></th>
									<th><b>VAT</b></th>
									<th><b>Thành tiền</b></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input name='mahang0' type="text" class="form-control"></input>
									</td>
									<td><input name='tenhang0' type="text"
										class="form-control"></input></td>
									<td><input name='soluong0' type="text"
										class="form-control"></input></td>
									<td><input name='dongia0' type="text" class="form-control"></input>
									</td>
									<td><input name='dvtinh0' type="text" class="form-control"></input>
									</td>
									<td><input name='chietkhau0' type="text"
										class="form-control"></input></td>
									<td><input name='VAT0' type="text" class="form-control"></input>
									</td>
									<td><input name='thanhtien0' type="text"
										class="form-control"></input></td>
								</tr>
								<tr></tr>
							</tbody>
						</table>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="button" class="btn btn-primary button"
									onclick="addRow('tab_logic')">Add Row</button>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Chiết khấu</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="" placeholder="">
							</div>
							<label for="" class="col-lg-2"><b>Thuế GTGT</b></label>
							<div class="col-lg-3 text-right">
								<input type="text" class="form-control" id="" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-lg-2"><b>Thành tiền</b></label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 text-center">
								<button type="submit" class="btn btn-primary button" formaction="createNewSalesOrder" formmethod="post">Lưu</button>
								
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkNo() {
			var custId = $("#custId").val();
			$.getJSON('autoFillCustName?custId=' + custId, function(data) {
				$("#custName").val(data.custName);
			});
		}
	</script>
	
	<!-- Bootstrap JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
</body>
</html>