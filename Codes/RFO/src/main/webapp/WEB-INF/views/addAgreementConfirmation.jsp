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
				<h4>
					Confirmation
					</h1>
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
							class="btn btn-default btn-done">Volume</button>
						<button type="submit" name="submit" value="4"
							class="btn btn-default btn-done">Model Support</button>
						<button type="submit" name="submit" value="5"
							class="btn btn-default btn-done">Misc Text</button>
						<button type="submit" name="submit" value="6"
							class="btn btn-default btn-active">Confirmation</button>
					</div>
				</form>

				<form action="${ state == 'add' ? 'submit' : 'update' }Agreement" method="POST" class="form-horizontal" role="form">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
						id="agreementContent">

						<div class="form-group">
							<label for="input" class="col-sm-2 control-label">RFO
								Number</label>
							<div class="col-sm-10">
								<p class="form-control-static">${agreement.rfoNumber.RFONumber }</p>
							</div>
						</div>


						<div class="form-group">
							<label for="input" class="col-sm-2 control-label">Customer
								Name</label>
							<div class="col-sm-10">
								<p class="form-control-static">${agreement.rfoNumber.RFOName }</p>
							</div>
						</div>

						<div class="form-group">
							<label for="input" class="col-sm-2 control-label">Start -
								End</label>
							<div class="col-sm-10">
								<p class="form-control-static">${agreement.startDate }-
									${agreement.endDate }</p>
							</div>
						</div>

						<div class="form-group">
							<label for="input" class="col-sm-2 control-label">Status</label>
							<div class="col-sm-10">
								<p class="form-control-static">
									<strong>${agreement.agreementStatus.status }</strong>
								</p>
							</div>
						</div>

						<div class="form-group">
							<ul class="nav nav-tabs" role="tablist">
								<li class="active"><a href="#">Overview</a></li>
								<li><a href="#">Dealers</a></li>
								<li><a href="#">Model support</a></li>
								<li><a href="#">Misc Text</a></li>
							</ul>
							<div class="panel panel-default nav-tabs-content">
								<div class="panel-body">
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Business
											Area</label>
										<div class="col-sm-10">
											<p class="form-control-static">${agreement.rfoNumber.company.businessArea }</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Business
											Area Code</label>
										<div class="col-sm-10">
											<p class="form-control-static"></p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Agreement
											Details</label>
										<div class="col-sm-10">
											<p class="form-control-static">${agreement.description }</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Created
											By</label>
										<div class="col-sm-10">
											<p class="form-control-static">${agreement.createBy }</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Created
											Date</label>
										<div class="col-sm-10">
											<p class="form-control-static">${agreement.createDate }</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Authorised
											By</label>
										<div class="col-sm-10">
											<p class="form-control-static"></p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Authorised
											Date</label>
										<div class="col-sm-10">
											<p class="form-control-static"></p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Sign
											agreement required?</label>
										<div class="col-sm-10">
											<p class="form-control-static">${agreement.signRequired == 1 ? 'YES' : 'NO' }</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Charge
											code</label>
										<div class="col-sm-10">
											<p class="form-control-static">Motability</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Payment
											To</label>
										<div class="col-sm-10">
											<p class="form-control-static">Customer - BAR123</p>
										</div>
									</div>
									<div class="form-group">
										<label for="input" class="col-sm-2 control-label">Handling
											Chardge</label>
										<div class="col-sm-10">
											<p class="form-control-static">£${agreement.handlingCharge }</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="pull-right">
									<button type="submit" name="submit" value="draft"
										class="btn btn-default">Save as draft</button>
									<button type="submit" name="submit" value="back"
										class="btn btn-default">Back</button>
									<button type="submit" name="submit" value="next"
										class="btn btn-primary">Submit</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<!-- jQuery -->
	<script src="/fpt/resources/js/jquery-1.11.1.min.js"></script>
	<script src="/fpt/resources/js/jquery.js"></script>
	<!-- Bootstrap JavaScript -->
	<script src="/fpt/resources/js/bootstrap.min.js"></script>
</body>
</html>