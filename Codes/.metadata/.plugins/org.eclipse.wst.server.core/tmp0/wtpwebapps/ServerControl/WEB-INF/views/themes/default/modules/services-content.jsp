<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(document).ajaxStart(function() {
		$(".wait").css("display", "block");
	});
	//loading ServerInfomation
	var ip = "${server.serverAddress}";
	$(document).ready(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/getserverinfo/' + ip + '/' + cc,
			type : 'GET',
			data : {},
			//timeout : 60000,
			success : function(data, status){
				//if(data != null){
				var html = '<table class="table table-bordered">';
					html+='<tr><td>Hostname:</td><td>'+data.hostname+'</td></tr>';
					html+='<tr><td>OS Version:</td><td>'+data.osversion+'</td></tr>';
					html+='<tr><td>Kernel:</td><td>'+data.kernel+'</td></tr>';
					html+='<tr><td>Processor Info:</td><td>'+data.processor_info+'</td></tr>';
					html+='<tr><td>Uptime:</td><td>'+data.uptime+'</td></tr>';
					html+='<tr><td>Memory:</td><td>'+data.memmory+'</td></tr>';
					html+='<tr><td>Cpu Loadaverage:</td><td>'+data.cpu_loadaverage+'</td></tr></table>';
				//	alert(html);
				$(".serverinfomation").html(html);
				$(".wait").css("display", "none");
				//}
			}
		});
	})
</script>
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
			<ul class="nav nav-tabs" id="serverTab">
				<li class="active"><a data-toggle="tab" href="#monitor">System Infomation</a></li>
				<li><a data-toggle="tab" href="#services">Service Configuation</a></li>
			</ul>
			<hr>
			<div class="tab-content">
				<!-- Tabs Monitor Config -->
				<div class="tab-pane active" id="monitor">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">System Infomation</h3>
						</div>
						<div id="">
							<div class="panel-body serverinfomation" id="serverinfomation">
								<div class="pull-center">
								<span class="wait"
									style="display: none: text-align:center;displar:block; margin: 100px auto;"> <img
									src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
								</span>
							
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Tabs Service Config -->
				<div class="tab-pane" id="services">
					<!-- Network Card -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<a href="#" data-toggle="collapse" data-target="#network-card-config">Network
									Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i>
								</a>
							</h3>
						</div>
						<div id="network-card-config" class="panel-collapse collapse">
							<div class="panel-body">
								<a class="col-md-4"
									href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
									Network Interfaces </a> <a class="col-md-4"
									href="${pageContext.request.contextPath }/serviceconfig/nic/nameservers/${server.serverAddress}/${cc}">
									DNS NameServers... </a> <a class="col-md-4"
									href="${pageContext.request.contextPath }/serviceconfig/nic/edit-file-nic/${server.serverAddress}/${cc}">
									Edit Config File... </a>

							</div>
						</div>
					</div>
					<!-- FTP Service -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<a href="#" data-toggle="collapse" data-target="#ftp-config">FTP
									Server Configuration <i
									class="glyphicon glyphicon-chevron-down pull-right"></i>
								</a>
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
								<a href="#" data-toggle="collapse" data-target="#apache-config">Apache
									Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i>
								</a>
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
								<a href="#" data-toggle="collapse" data-target="#dhcp-config">DHCP
									Service Configuration <i
									class="glyphicon glyphicon-chevron-down pull-right"></i>
								</a>
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
								<a href="#" data-toggle="collapse" data-target="#dns-config">DNS
									Bind9 Configuration <i
									class="glyphicon glyphicon-chevron-down pull-right"></i>
								</a>
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
				<!-- End Service -->
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>
