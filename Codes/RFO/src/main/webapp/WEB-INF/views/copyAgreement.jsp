<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Extend an Agreement</title>
<meta charset="UTF-8">
<meta name=description content="">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Thanh Nhan" />
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
				<h4>Copy Agreement</h4>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<!-- Start Form by Nhan -->
			<form class="form-horizontal" role="form" method="post"
					action="copyAgreementAction">
					<input type="hidden" name="agreementId" value="${agreement.agreementId}" /> 
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Agreement
							Number</label>
						<div class="col-sm-10">
						<input type="hidden" name="newVariantNumber" value="${newVariantNumber}" />
							<p class="form-control-static">${agreement.agreementNumber }
								/ ${agreement.variantNumber }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Agreement
							Name</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.name }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">RFO
							Number</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.rfoNumber.RFONumber }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">
							Customer Name</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.rfoNumber.RFOName }</p>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Start
							Date</label>
						<div class="col-sm-3">
							<p class="form-control-static">${agreement.startDate }</p>
						</div>
					</div>
				
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">End
							Date</label>
						<div class="col-sm-3">
							<p class="form-control-static">${agreement.endDate }</p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<div class="form-group">
								<button type="submit" class="btn btn-default" name="submit" value="newvariant">
									duplicate this agreement with a new variant: ${agreement.agreementNumber}/<strong>${newVariantNumber}</strong>
								</button>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default" name="submit" value="samecustomer">
									duplicate this agreement for a new agreement with <strong>${agreement.rfoNumber.RFOName }</strong>
								</button>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default" name="submit" value="newcustomer">
									duplicate this agreement for a new customer 
								</button>
							</div>
						</div>
					</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>