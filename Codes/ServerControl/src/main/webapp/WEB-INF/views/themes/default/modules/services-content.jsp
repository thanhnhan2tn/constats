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
		$("#m-status").on("click",function(){
			//var id=""
			if($(this).is(":checked")){
				$.ajax({
					url : '${pageContext.request.contextPath}/monitor/start/' + ip + '/' + cc,
					type : 'GET',
					datastatus : {}
				})
			}else{
				$.ajax({
					url : '${pageContext.request.contextPath}/monitor/stop/' + ip + '/' + cc,
					type : 'GET',
					datastatus : {}
			})
			}
		});
		$(".active-sudo").on("click",function(){
			var user = $(".username").val();
			var pass = $(".password").val();
		$.ajax({
			url : '${pageContext.request.contextPath}/serviceconfig/user/'+user+'/'+pass+'/' + ip + '/' + cc,
			type : 'GET',
			datastatus : {},
			success : function(datastatus, status) {
				location.reload();
			}
		});
		});
	});
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
				<li class="active"><a data-toggle="tab" href="#monitor">System
						Infomation</a></li>
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
							<div class="panel-body">
								<div id="serverinfomation" class="serverinfomation">
									<span class="wait"
										style="display: none: text-align:center; displar: block; margin: 100px auto;">
										<img
										src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
									</span>

								</div>
							</div>
							<!-- // Panel Body -->
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								Monitoring
								<div class="pull-right">
									<input id="m-status" type="checkbox" name="status" class="m-checkbox"
										data-toggle="collapse" data-target="#monitoring"> <label
										class="" for="m-status"> On/Off Monitor Service </label>

								</div>
							</h3>

						</div>
						<div id="monitoring" class="monitoring panel-collapse collapse">
							<div class="panel-body">
								<div id="">
									<div id="ram-monitor"></div>
									<div id="cpu-monitor"></div>
									<div id="disk-monitor"></div>
								</div>

							</div>
							<!-- // Panel Body -->
						</div>
					</div>
				</div>

				<!-- Tabs Service Config -->
				<div class="tab-pane" id="services">
					<c:if test="<%=(session.getAttribute(\"sudouser\")==null)%>">
						<div class="panel panel-default">
							<div style="padding-top: 30px" class="panel-body">
								<form action="#" class="form-horizontal" method="POST">
									<div class="form-group ">
										<div class="col-md-9">
											<input class="form-control username" name="username" type="text"
												placeholder="Sudoer Username" />
										</div>
									</div>
									<div class="form-group ">
										<div class="col-md-9">
											<input class="form-control password" name="password" type="password"
												placeholder="Sudoer Password" />
										</div>
									</div>
									<button type="button" class="btn btn-primary active-sudo">OK</button>
								</form>
							</div>
						</div>
					</c:if>
					<c:if test="<%=(session.getAttribute(\"sudouser\")!=null)%>">

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
					</c:if>
				</div>
				<!-- End Service -->
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>

