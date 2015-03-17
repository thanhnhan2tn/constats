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
<!-- jQuery -->
<script src="/fpt/resources/js/jquery-1.11.1.min.js"></script>
<!--<script src="/fpt/resources/js/jquery.js"></script>-->
<!-- Bootstrap JavaScript -->
<script src="/fpt/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	<!-- Luong Duc Duy -->
	$(document).ready(function () {
        //when a submit button is clicked, put its name into the action hidden field
        $(":submit").click(function () {
        	$("#buttonType").val(this.value);
       });
    });
	
	/**
	 * @author Huynh Thanh Nha
	 * function to check end date to current date 
	 */
	 function checkDate() {
			<!-- Check button type-->
			var buttonType = $('#buttonType').val();
			if (buttonType != "terminate") {
				return true;
			}
			// Setup the end date
			var endDateValue = new Date(document.getElementById('endDate').value);
			var endDay = endDateValue.getDate();
			var endMonth = endDateValue.getMonth();
			var endYear = endDateValue.getFullYear();
			var endDate = new Date(endYear, endMonth, endDay);
			
			// Setup current date 
			var currentDayValue = new Date();
			var currentDay = currentDayValue.getDate();
			var currentMonth = currentDayValue.getMonth();
			var currentYear = currentDayValue.getFullYear();
			var currentDay = new Date(currentYear, currentMonth, currentDay);
			
			// Calculate the time difference in miliseconds
			var diff = currentDay.getTime() - endDate.getTime();
			
			// Calculate one day
			// 1 day x 24 hrs/day x 60 min/hr x 60 sec/min x 1000 ms/sec 
			var oneDay = 24 * 60 * 60 * 1000;
			
			// Calculate the number of days from current to end date
			var numOfDays = diff/oneDay; 
			
			if (numOfDays <= 30 ) {
				return confirm("There are less than 30 days left on this agreement. Do you want to terminate it ?");
			}
			return true;
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
				<h4>
					View agreement
					</h1>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form action="updateAgreementInformation" method="POST"
					class="form-horizontal" role="form" onsubmit=" return checkDate()">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
						id="agreementContent">
						<input type="hidden" name="agreementId"
							value="${agreement.agreementId }" />
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
							<input type="hidden" id="endDate" name="endDate"
								value=" ${agreement.endDate}" /> <label for="input"
								class="col-sm-2 control-label">Start - End</label>
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
									<button type="submit" name="submit" value="edit"
										class="btn btn-primary">Edit</button>
									<input type='hidden' value='' id='buttonType' />
									<!-- Huynh Thanh Nha -->
									<!-- Add button "submit" "reject" and "approve" -->
									<c:if test="${agreement.statusId == 1 }">
										<button type="submit" name="submit" value="submit"
											class="btn btn-success">Submit</button>
									</c:if>
									<c:if test="${agreement.statusId == 2 }">
										<button type="submit" name="submit" value="reject"
											class="btn btn-success">Reject</button>
									</c:if>
									<c:if test="${agreement.statusId == 2 }">
										<button type="submit" name="submit" value="approve"
											class="btn btn-success">Approve</button>
									</c:if>
									<c:if test="${agreement.statusId == 4 }">
										<button type="submit" name="submit" value="extend"
											class="btn btn-success">Extend</button>
									</c:if>
									<c:if test="${agreement.statusId == 4 }">
										<button type="submit" name="submit" value="terminate"
											class="btn btn-danger">Terminate</button>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>