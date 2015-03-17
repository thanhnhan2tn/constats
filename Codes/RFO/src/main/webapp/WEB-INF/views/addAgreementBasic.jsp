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
<link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet"
	media="screen">
	
<!-- jQuery -->
<script src="/fpt/resources/js/jquery-1.11.1.min.js"></script>
<!-- Bootstrap JavaScript -->
<script src="/fpt/resources/js/bootstrap.min.js"></script>
<!-- Boostrap Date-picker -->
<script src="/fpt/resources/js/bootstrap-datepicker.js"></script>
<script>
	$(document).ready(function() {
		$("#startDate").datepicker();
		$("#endDate").datepicker();
	});
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
					Create Agreement
					</h1>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

				<form action="addAgreementNavigation">
					<div class="btn-group step">
						<button type="submit" name="submit" value="1"
							class="btn btn-default btn-done">Customer</button>
						<button type="submit" name="submit" value="2"
							class="btn btn-default btn-active">Basic</button>
						<button type="submit" name="submit" value="3"
							class="btn btn-default">Dealers</button>
						<button type="submit" name="submit" value="4"
							class="btn btn-default">Volume</button>
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
				<form class="form-horizontal" role="form" method="post"
					action="addAgreementBasicHandling">
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">RFO Number</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.rfoNumber.RFONumber }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">Customer Name</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.rfoNumber.RFOName }</p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">Agreement
							Number</label>
						<div class="col-sm-10">
							<p class="form-control-static">${agreement.agreementNumber }
								/ ${agreement.variantNumber }</p>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Agreement
							Name</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								required value=${agreement.name }>
						</div>
					</div>

					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Agreement
							Description</label>
						<div class="col-sm-6">
							<textarea class="form-control" name="description"
								id="description" required>${agreement.description }</textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="startDate" class="col-sm-2 control-label">Start
							Date</label>
						<div class="col-sm-3" data-date-format="yyyy-mm-dd">
							<input type="text" required="required" class="form-control"
								id="startDate" name="startDate" data-date-format="yyyy-mm-dd"
								value=${agreement.startDate }>
						</div>
					</div>

					<div class="form-group">
						<label for="endDate" class="col-sm-2 control-label">End
							Date</label>
						<div class="col-sm-3">
							<input type="text" required="required" class="form-control"
								id="endDate" name="endDate" data-date-format="yyyy-mm-dd" value=${agreement.endDate }>
						</div>
					</div>

					<div class="form-group">
						<label for="fundingMethodId" class="col-sm-2 control-label">Funding
							Method</label>
						<div class="col-sm-3">
							<select name="fundingMethodId" id="fundingMethodId"
								class="form-control" required="required">
								<c:forEach var="fundingMethod" items="${fundingMethods }">
									<option
										${agreement.fundingMethodId == fundingMethod.fundingMethodId ? 'selected' : '' }
										value=${fundingMethod.fundingMethodId }>${fundingMethod.fundingMethodName }</option>
								</c:forEach>

							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="paymentTo" class="col-sm-2 control-label">Payment
							To</label>
						<div class="col-sm-3">
							<select name="paymentTo" id="paymentTo" class="form-control"
								required="required">
								<option value="dealer"
									${agreement.paymentTo == 'dealer' ? 'selected' : '' }>Dealer</option>
								<option value="customer"
									${agreement.paymentTo == 'customer' ? 'selected' : '' }>Customer</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="handlingCharge" class="col-sm-2 control-label">Handling
							Charge</label>
						<div class="col-sm-3">
							<input type="number" min="0" step="0.1" class="form-control"
								id="handlingCharge" name="handlingCharge"
								value=${agreement.handlingCharge }>
						</div>
					</div>

					<div class="form-group">
						<label for="signRequired" class="col-sm-2 control-label">Is
							a signed agreement required?</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<label class="radio-inline"> <input type="radio"
								name="signRequired" id="signRequired" value="1"
								${agreement.signRequired == '1' ? 'checked' : '' } required>
								Yes
							</label> <label class="radio-inline"> <input type="radio"
								name="signRequired" id="signRequired" value="2"
								${agreement.signRequired == '2' ? 'checked' : '' } required>
								No
							</label>
						</div>
					</div>

					<div class="form-group">
						<label for="dealerVisibility" class="col-sm-2 control-label">Dealer
							Visibility</label>
						<div class="col-sm-3">
							<select name="dealerVisibility" id="dealerVisibility"
								class="form-control" required="required">
								<option
									${agreement.dealerVisibility == 'Preferred dealers only' ? 'selected' : '' }
									value="Preferred dealers only">Preferred dealers only</option>
								<option
									${agreement.dealerVisibility == 'All' ? 'selected' : '' }
									value="All">All</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="discountUnit" class="col-sm-2 control-label">Discount
							Unit</label>
						<div class="col-sm-3">
							<select name="discountUnit" id="discountUnit"
								class="form-control" required="required">
								<option ${agreement.discountUnit == '$' ? 'selected' : '' }
									value="%">%</option>
								<option ${agreement.discountUnit == '£' ? 'selected' : '' }
									value="£">£</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="combinability" class="col-sm-2 control-label">Combinability</label>
						<div class="col-sm-3">
							<select name="combinability" id="combinability"
								class="form-control" required="required">
								<option ${agreement.combinability == 'All' ? 'selected' : '' }
									value="End user support only">End user support only</option>
							</select>
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
			</div>
		</div>
	</div>

</body>
</html>