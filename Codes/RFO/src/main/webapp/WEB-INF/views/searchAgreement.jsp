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
<link href="<c:url value="/resources/css/datepicker.css" />"
	rel="stylesheet" media="screen">
<!-- jQuery -->
<script src="/fpt/resources/js/jquery-1.11.1.min.js"></script>
<!-- Bootstrap JavaScript -->
<script src="/fpt/resources/js/bootstrap.min.js"></script>
<!-- Bootstrap Date-picker -->
<script src="/fpt/resources/js/bootstrap-datepicker.js"></script>
<!--  Bootstrap table -->
<script src="/fpt/resources/js/jquery.dataTables.min.js"></script>
<link href="<c:url value="/resources/css/jquery.dataTables.min.css" />"
	rel="stylesheet" media="screen">
<script>
	$(document).ready(function() {
		$("#startDate").datepicker();
		$("#endDate").datepicker();
	});
</script>
<script type="text/javascript">
	function searchAgreement() {
		$.ajax({
			type : "post",
			url : "searchAgreement",
			cache : false,
			data : "customerType=" + $('#customerType').val() + "&name="
					+ $('#name').val() + "&rfoNumber=" + $('#rfoNumber').val()
					+ "&postCode=" + $('#postCode').val() + "&statusId="
					+ $('#statusId').val() + "&startDate="
					+ $('#startDate').val() + "&endDate=" + $('#endDate').val()
					+ "&agreementNumber=" + $('#agreementNumber').val(),
			success : function(response) {
				$('#searchResult').html(response).hide().fadeIn();
			},
			error : function() {
				alert('Error while request..');
			}
		});
	}

	function hideMessage() {
		$('#message').hide();
	}

</script>
</head>


<body>
	<nav class="navbar navbar-default navbar-fixed-top noboder"
		role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 nav-brand">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img
					src="/fpt/resources/images/hondalogo.png" class="img-responsive"
					alt="Image">
				</a>

			</div>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#" style="font-size: 24px; color: #15A4FA">Corporate
						Sales Solution</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Cars</a></li>
				<li><a href="#">Motorcycles</a></li>
				<li><a href="#">Power equipment</a></li>
				<li><a href="#">Intranet</a></li>
				<li><a href="#">System</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<div class="container-fluid nopadding">
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 leftbar nopadding">
			<h1></h1>
			<div class="panel panel-default">
				<div class="list-group">
					<a href="" class="list-group-item"><span
						class="glyphicon glyphicon-home baricon"></span>Home</a>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title panel-title-bar">Agreements</h3>
				</div>
				<div class="list-group">
					<a href="addAgreement" class="list-group-item"><span
						class="glyphicon glyphicon-plus baricon"></span>Add New</a> <a
						href="#" class="list-group-item"><span
						class="glyphicon glyphicon-search baricon"></span>Search</a> <a
						href="viewAwaitingAgreement" class="list-group-item"><span
						class="glyphicon glyphicon-time baricon"></span>Awaiting Approve</a> <a
						href="dailyStatus" class="list-group-item"><span
						class="glyphicon glyphicon-list-alt baricon"></span>Daily Stats</a>
				</div>
			</div>
			<div class="panel panel-default" name="user">
				<div class="panel-heading">
					<h3 class="panel-title panel-title-bar">${username }</h3>
				</div>
				<div class="list-group">
					<a href="logout" class="list-group-item"><span
						class="glyphicon glyphicon-off baricon"></span>Log out</a>
				</div>
			</div>
		</div>
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">&nbsp;</div>
		<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
			<div class="page-header">
				<h4>Search Agreement</h4>
			</div>

			<form action="" method="POST" class="form-horizontal" role="form">
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Customer
						Type</label>
					<div class="col-sm-4">
						<select name="customerType" id="customerType" class="form-control"
							required="required">
							<option value="">All</option>
							<c:forEach var="customerType" items="${map.customerTypes }">
								<option value=${customerType.customerTypeId }>${customerType.customerType }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-4">
						<input type="text" name="name" id="name" class="form-control"
							value="" required="required" pattern="" title="">
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Customer
						Code</label>
					<div class="col-sm-2">
						<input type="text" name="rfoNumber" id="rfoNumber"
							class="form-control" value="" required="required" pattern=""
							title="">
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">PostCode</label>
					<div class="col-sm-2">
						<input type="text" name="postCode" id="postCode"
							class="form-control" value="" required="required" pattern=""
							title="">
					</div>
				</div>
				<div class="form-group"></div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Status</label>
					<div class="col-sm-4">
						<select name="statusId" id="statusId" class="form-control"
							required="required">
							<option value="">All</option>
							<c:forEach var="agreementStatus"
								items="${map.agreementStatuses }">
								<option value="${agreementStatus.statusId }">${agreementStatus.status }</option>
							</c:forEach>

						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Start
						Date</label>
					<div class="col-sm-2">
						<input type="text" name="startDate" id="startDate"
							class="form-control" value="" required="required" title="">
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">End Date</label>
					<div class="col-sm-2">
						<input type="text" name="endDate" id="endDate"
							class="form-control" value="" required="required" title="">
					</div>
				</div>
				<div class="form-group">
					<label for="input" class="col-sm-2 control-label">Agreement
						Number</label>
					<div class="col-sm-4">
						<input type="text" name="agreementNumber" id="agreementNumber"
							class="form-control" value="" required="required" pattern=""
							title="">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10 col-sm-offset-2">
						<button type="button" onclick="searchAgreement()"
							class="btn btn-primary">
							<span class="glyphicon glyphicon-search baricon"></span> Search
						</button>
					</div>
				</div>
			</form>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<table
					class="table table-hover table-striped table-bordered"
					id="example">
					<thead>
						<tr>
							<th>RFO Number</th>
							<th>Customer</th>
							<th>Postcode</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Agreement</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="searchResult">
						<c:forEach var="agreement" items="${map.agreements }">
							<tr>
								<td>${agreement.rfoNumber.RFONumber }</td>
								<td>${agreement.rfoNumber.RFOName }</td>
								<td>${agreement.rfoNumber.postCode }</td>
								<td>${agreement.startDate }</td>
								<td>${agreement.endDate }</td>
								<td>${agreement.agreementNumber }/
									${agreement.variantNumber }</td>
								<td>${agreement.agreementStatus.status }</td>
								<td>
									<form action="viewAgreementHandling">
										<input name="agreementId" value=${agreement.agreementId }
											type="hidden" />
										<button type="submit" name="submit" value="copy"
											class="btn btn-xs btn-default">Copy</button>
										&nbsp;
										<button type="submit" name="submit" value="view"
											class="btn btn-xs btn-default">View</button>
									</form>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>