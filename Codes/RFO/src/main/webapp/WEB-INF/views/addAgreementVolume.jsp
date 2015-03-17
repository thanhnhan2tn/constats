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
<script type="text/javascript">
	function changeBanding(min, max) {
		$('#inputMin').val(min);
		$('#inputMax').val(max);
	}
	function deleteBanding() {
		$.ajax({
			type : "post",
			url : "deleteBanding",
			cache : false,
			success : function(response) {
				$('#bandingList').html(response);
			},
			error : function() {
				alert('Error while request..');
			}
		});
	}

	function addBanding() {
		$.ajax({
			type : "post",
			url : "addBanding",
			cache : false,
			data : "max=" + $('#inputMax').val(),
			success : function(response) {
				var res = response.split('#');
				$('#bandingList').html(res[0]);
				if (res[1] == "1") {
					$('#message').show();
				} else {
					$('#message').hide();
				}
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
						href="searchAgreement" class="list-group-item"><span
						class="glyphicon glyphicon-search baricon"></span>Search</a> <a
						href="viewAwaitingAgreement" class="list-group-item"><span
						class="glyphicon glyphicon-time baricon"></span>Awaiting Approve</a> <a
						href="dailyStatus" class="list-group-item"><span
						class="glyphicon glyphicon-list-alt baricon"></span>Daily Stats</a>
				</div>
			</div>
			<div class="panel panel-default" name="user">
				<div class="panel-heading">
					<h3 class="panel-title panel-title-bar">
					${username }</h3>
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
				<h4>Retro banding</h4>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

				<form action="addAgreementNavigation">
					<div class="btn-group step">
						<button type="submit" name="submit" value="1"
							class="btn btn-default btn-done">Customer</button>
						<button type="submit" name="submit" value="2"
							class="btn btn-default btn-done">Basic</button>
						<button type="submit" name="submit" value="3"
							class="btn btn-default btn-done">Dealers</button>
						<button type="submit" name="submit" value="4"
							class="btn btn-default btn-active">Volume</button>
						<button type="submit" name="submit" value="4"
							class="btn btn-default">Model Support</button>
						<button type="submit" name="submit" value="5"
							class="btn btn-default">Misc Text</button>
						<button type="submit" name="submit" value="6"
							class="btn btn-default">Confirmation</button>
					</div>
				</form>

			</div>
			<!-- End col12-->
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">RFO Number</label>
						<div class="col-sm-4">
							<p class="form-control-static">${agreement.rfoNumber.RFONumber }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">Customer Name</label>
						<div class="col-sm-4">
							<p class="form-control-static">${agreement.rfoNumber.RFOName }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-3 control-label">Banding Value
							From Current To </label>
						<div class="col-sm-2">
							<input type="number" name="min" id="inputMax"
								class="form-control" value="0" min="0" max="" step=""
								required="required" title="">
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary"
								onclick="addBanding()">
								<span class="glyphicon glyphicon-plus"></span> Add
							</button>
						</div>

					</div>

				</form>
				<!-- End form 1 -->
			</div>
			<!-- End col 1 -->
			<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7" id="message"
				style="display: none">
				<div class="alert alert-danger">
					<button type="button" class="close" onclick="hideMessage()">&times;</button>
					<strong>Sorry!</strong> You can not add this value because this
					value must be larger than max banding value ...
				</div>
			</div>

			<form action="addAgreementVolumeHandling" class="form-horizontal" method="post">

				<div class="form-group">
					<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
						<table class="table table-hover table-striped table-bordered">
							<thead>
								<tr>
									<th>Banding Volume</th>
									<th></th>
								</tr>
							</thead>
							<tbody id="bandingList">
								<c:forEach var="banding" items="${bandings }" varStatus="loop">
									<tr>
										<td>${banding.min}<c:choose>
												<c:when test="${banding.max == banding.min }"> +</c:when>
												<c:otherwise>
													- ${banding.max }
												</c:otherwise>
											</c:choose>
										</td>
										<td><c:if test="${loop.last}">
												<button type='button' class='btn btn-danger btn-xs'
													onclick="deleteBanding()">Delete</button>
											</c:if></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">Trigger
								Credit</label>
							<div class="col-sm-10">
								<select name="triggerCredit" id="input" class="form-control">
									<option value="End of calendar year"
										${agreement.volume.triggerCredit == 'End of calendar
										year' ? 'selected' : '' }>End
										of calendar year</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">Payable to</label>
							<div class="col-sm-10">
								<select name="paymentTo" id="input" class="form-control">
									<option value="Dealer"
										${agreement.volume.paymentTo == 'Dealer' ? 'selected' : '' }>Dealer</option>
									<option value="Customer"
										${agreement.volume.paymentTo == 'Customer' ? 'selected' : '' }>Customer</option>
								</select>
							</div>
						</div>
					</div>

				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="pull-right">
							<button type="submit" name="submit" value="back"
								class="btn btn-default">Back</button>
							<button type="submit" name="submit" value="next"
								class="btn btn-primary">Next</button>
						</div>
					</div>
				</div>
			</form>
			<!-- End form 2 -->
		</div>
	</div>
	<!-- jQuery -->
	<script src="/fpt/resources/js/jquery-1.11.1.min.js"></script>
	<script src="/fpt/resources/js/jquery.js"></script>
	<!-- Bootstrap JavaScript -->
	<script src="/fpt/resources/js/bootstrap.min.js"></script>
</body>
</html>