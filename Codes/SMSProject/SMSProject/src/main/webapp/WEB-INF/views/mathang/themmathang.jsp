<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Quản Lý Mặt Hàng</title>
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

</head>
<body>
	<div class="container homepage">
		<div class="row">

			<jsp:include page="../inc/navigation_top.jsp"/>
			<jsp:include page="../inc/left_menu.jsp"/>

			<div class="col-sm-9 col-md-9">
				<div class="well">
				<c:if test="${SUCCESS != null}">
					<div class="alert alert-success" role="alert">${SUCCESS}</div>
				</c:if>
				<c:if test="${ERROR != null}">
					<div class="alert alert-danger" role="alert"> ${ERROR} </div>
				</c:if>
					<h1>Thêm Mặt Hàng</h1>
					<form class="form-horizontal">
						<div class="form-group">
							<label for="invtId" class="col-sm-2 control-label">Mã Hàng</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="invtId" name="invtId" required="required" maxlength="20"
									placeholder="Nhập Mã Hàng" onblur="checkNo();">
							</div>
						</div>
						<div class="form-group">
							<label for="invtName" class="col-sm-2 control-label">Tên Hàng</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="invtName" name="invtName" required="required" maxlength="50"
									placeholder="Nhập Tên Hàng">
							</div>
						</div>
						<div class="form-group">
							<label for="className" class="col-sm-2 control-label">Loại Hàng</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="className" name="className" required="required" maxlength="50"
									placeholder="Nhập loại hàng">
							</div>
						</div>
						<div class="form-group">
							<label for="unitT" class="col-sm-2 control-label">Đơn vị tính sỉ</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="unitT" name="unitT" required="required" maxlength="50"
									placeholder="Nhập đơn vị tính sỉ">
							</div>
						</div>
						<div class="form-group">
							<label for="unitRate" class="col-sm-2 control-label">Số lượng/đơn vị</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="unitRate" name="unitRate" required="required" min="0" max="2147483647"
									placeholder="Nhập số lượng / đơn vị">
							</div>
						</div>
						<div class="form-group">
							<label for="salesPriceT" class="col-sm-2 control-label">Đơn giá sỉ</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="salesPriceT" name="salesPriceT" required="required" maxlength="10"
									placeholder="Nhập đơn giá sỉ">
							</div>
						</div>
						<div class="form-group">
							<label for="unitL" class="col-sm-2 control-label">Đơn vị tính lẻ</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="unitL" name="unitL" required="required" maxlength="50"
									placeholder="Nhập đơn vị tính lẻ">
							</div>
						</div>
						<div class="form-group">
							<label for="salesPriceL" class="col-sm-2 control-label">Đơn giá lẻ</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="salesPriceL" name="salesPriceL" required="required" maxlength="10"
									placeholder="Nhập đơn giá lẻ">
							</div>
						</div>
						<div class="form-group">
							<label for="slsTax" class="col-sm-2 control-label">Thuế</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="slsTax" name="slsTax" required="required" min="0" max="100"
									placeholder="Nhập % thuế">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="button">
									<button type="submit" class="btn btn-primary" formaction="addItem" formmethod="post">Thêm</button>
									<button type="submit" class="btn btn-warning" formaction="deleteItem" formmethod="post">Xóa</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkNo(){
			var invtId = {invtId: $("#invtId").val()};
			 $.ajax({
		            url: 'autoFillItem',
		            type: 'post',
		            dataType: 'json',
		            success: function (data) {
		            	$("#invtName").val(data.invtName);
						$("#className").val(data.className);
						$("#unitT").val(data.unitT);
						$("#unitRate").val(data.unitRate);
						$("#salesPriceT").val(data.salesPriceT);
						$("#unitL").val(data.unitL);
						$("#salesPriceL").val(data.salesPriceL);
						$("#slsTax").val(data.slsTax);
		            },
		            data: invtId
		        });
	
		}
	</script>

	<!-- jQuery -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
	<!-- Bootstrap JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>