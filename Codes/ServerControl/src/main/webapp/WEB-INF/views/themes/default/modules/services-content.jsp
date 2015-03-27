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
		<!-- Network Card -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#network-card-config">Network Configuration
							<i class="glyphicon glyphicon-chevron-down pull-right"></i> 
						</a>
					</h3>
				</div>
				<div id="network-card-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							Network Interfaces </a> 
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/nameservers/${server.serverAddress}/${cc}">
							DNS NameServers... </a>
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/edit-file-nic/${server.serverAddress}/${cc}">
							Edit Config File... </a>
							
					</div>
				</div>
			</div>
			<!-- FTP Service -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#ftp-config">FTP Server Configuration 
							<i class="glyphicon glyphicon-chevron-down pull-right"></i> </a>
					</h3>
				</div>
				<div id="ftp-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							FTP.. </a> 
					</div>
				</div>
			</div>
			
			<!-- Apache Service -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#apache-config">Apache Configuration 
							<i class="glyphicon glyphicon-chevron-down pull-right"></i> </a>
					</h3>
				</div>
				<div id="apache-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							Apache/... </a> 
					</div>
				</div>
			</div>
			<!-- DHCP Service -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#dhcp-config">DHCP Service Configuration 
							<i class="glyphicon glyphicon-chevron-down pull-right"></i> </a>
					</h3>
				</div>
				<div id="dhcp-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							DHCP ... </a> 
					</div>
				</div>
			</div>
			<!-- DNS Bind 9 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="#" data-toggle="collapse"
							data-target="#dns-config">DNS Bind9 Configuration 
							<i class="glyphicon glyphicon-chevron-down pull-right"></i> </a>
					</h3>
				</div>
				<div id="dns-config" class="panel-collapse collapse">
					<div class="panel-body">
						<a class="col-md-4"
							href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
							DNS .. </a> 
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>
