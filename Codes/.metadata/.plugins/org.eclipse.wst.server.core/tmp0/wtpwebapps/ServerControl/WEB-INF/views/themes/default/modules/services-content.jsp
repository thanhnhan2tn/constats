<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Control Services Server<small> (${server.serverAddress})</small>
		</h1>

	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#network-card-config">Network Configuration </a>
					</h3>
				</div>
				<div id="network-card-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							Network Interfaces </a> <a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/nameservers/${server.serverAddress}/${cc}">
							DNS NameServers... </a>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!--  End Main Content -->
</aside>
