<%@page import="java.util.List"%>
<%@page import="model.dhcp.Subnet"%>
<%@page import="model.dhcp.DHCP"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="model.nic.Eth"%>
<%@page import="model.nic.Nic"%>

<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			DHCP Server Config :<small> (${server.serverAddress})</small>
			<hr />
		</h1>
	</section>
	<section class="content">
		<div class="main-content">
		<div style="display: none ${display}"  
			class="box alert alert-danger col-sm-12">${messageErr}</div>
			<div style="display: none ${displaysuccess}"  
				class="box alert alert-success col-sm-12">${message}</div>
			<div class=""></div>
		<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Install/Remove service</h3>
				</div>
				<div class="panel-body">
					<center>
						<div class="btn-group">
			 <a class="btn-lg btn-danger" onclick="return confirmAction()" href="${pageContext.request.contextPath }/serviceconfig/dhcp/stop/${server.serverAddress}/${cc }"
				title="Stop service">
				<i class="glyphicon glyphicon-arrow-down"></i>
			</a>
			<a type="button" class="btn-lg btn-success"
				 onclick="return confirmAction()" href='${pageContext.request.contextPath }/serviceconfig/dhcp/start/${server.serverAddress}/${cc }'
				title="Start service">
				<i class="glyphicon glyphicon-arrow-up"></i>
			</a>
			<a type="button" class="btn-lg btn-warning"
				 onclick="return confirmAction()" href='${pageContext.request.contextPath }/serviceconfig/dhcp/restart/${server.serverAddress}/${cc }'
				title="Restart Service">
				<i class="glyphicon glyphicon-repeat"></i>
			</a>
			<a type="button" class="btn-lg btn-warning remove-iface" onclick="return confirmAction()" href="${pageContext.request.contextPath }/serviceconfig/dhcp/remove/${server.serverAddress}/${cc }"
				title="Restart Service">
				<i class="glyphicon glyphicon-remove"></i>
			</a>
						</div>
					</center>
				</div>
			</div>
		

			<%
				DHCP dhcp = (DHCP) request.getAttribute("dhcp");
				if (dhcp != null) {
			%>
			

			<form:form id="dhcp-config-form" modelAttribute="configchung"
				action="${pageContext.request.contextPath }/serviceconfig/dhcp/save/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<input type="hidden" name="cc" value="${cc }">
				<div class="panel panel-default">
					<div class="panel-heading">General</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="updatestyle" class="col-md-2">DNS update style:</label>
							<div class="col-md-9">
								<label for="dns_update_none">Default/Null </label>
								<form:checkbox path="dns_update_style" id="dns_update_none" />
							</div>
						</div>
						<div class="form-group">
							<label for="updatestyle" class="col-md-2">Authoritative:</label>
							<div class="col-md-9">
								<label for="authoritative_yes">Visible/Null </label>
								<form:checkbox path="authorative" id="authoritative_yes" />
							</div>
						</div>
						<div class="form-group log_facitily">
							<label for="log_facitily" class="col-md-2">Log facility:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="log_facitily" placeholder="" />
								 <span class="err" style="color:red"></span>
									<br>
									<i>(Ex: local2)</i>
							</div>
						</div>
						<div class="form-group">
							<label for="domain_name" class="col-md-2">Domain Name:</label>
							<div class="col-md-9 domain_name">
								<form:input class="form-control" path="domain_name" placeholder="" /> 
								</i>(Format: xxx.xxx, Ex: domain.com)</i>
									<br>
									<span class="err" style="color:red"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="domain_name_servers" class="col-md-2">Domain Name
								Servers:</label>
							<div class="col-md-9 domain_name_servers">
								<form:input class="form-control" path="domain_name_servers"
									placeholder="" />
									 <span class="err" style="color:red"></span>
									<br>
									<i>(Format: xxx.xxx, Ex: domain.com)</i>
									
							</div>
							
						</div>
						<div class="form-group default_lease_time">
							<label for="default_lease_time" class="col-md-2">Default Lease
								Time:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="default_lease_time" type="number"
									placeholder="" />
									 <span class="err" style="color:red"></span>
									<br>
							</div>
						</div>
						<div class="form-group max_lease_time">
							<label for="max_lease_time" class="col-md-2">Max Lease Time:</label>
							<div class="col-md-9">
								<form:input class="form-control" type="number" path="max_lease_time" placeholder="" />
								 <span class="err" style="color:red"></span>
							</div>
						</div>

					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a
								href="${pageContext.request.contextPath }/serviceconfig/dhcp/subnets/${server.serverAddress}/${cc}">
								Subnets Configuration <i
								class="glyphicon glyphicon-chevron-right pull-right"></i>
							</a>
						</h3>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a
								href="${pageContext.request.contextPath }/serviceconfig/dhcp/hostfixs/${server.serverAddress}/${cc}">HostFixs
								Configuration <i class="glyphicon glyphicon-chevron-right pull-right"></i>
							</a>
						</h3>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a
								href="${pageContext.request.contextPath }/serviceconfig/dhcp/file/${server.serverAddress}/${cc}">Edit
								config file... <i class="glyphicon glyphicon-chevron-right pull-right"></i>
							</a>
						</h3>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a
								href="${pageContext.request.contextPath }/serviceconfig/dhcp/logs/${server.serverAddress}/${cc}">Logs...
								<i class="glyphicon glyphicon-chevron-right pull-right"></i>
							</a>
						</h3>
					</div>
				</div>
				<form:button type="submit" class="btn btn-primary" value="Save" onclick="return dhcpValid()"
					id="savedhcp">Save</form:button>
				<button type="button" class="btn btn-default" onclick="window.history.back();">Back</button>
			</form:form>
			<%
				} else {
			%>
			<script>
				$('.install-btn').click(function() {
					var btn = $(this)
					btn.button('Installing isc-dhcp-server...')
					setTimeout(function() {
						btn.button('reset')
					}, 3000)
				});
			</script>
			<div class="panel-body">
				<button class="btn btn-primary btn-block install-btn"
					onclick="location.href='${pageContext.request.contextPath }/serviceconfig/dhcpinstall/${server.serverAddress}/${cc}'">
					<i class="glyphicon glyphicon-download-alt"></i> Click here to Install
					ISC-DHCP-SERVER
				</button>
			</div>
			<%
				}
			%>
		</div>
	</section>
	<!--  End Main Content -->
</aside>
<script type="text/javascript">
function dhcpValid(){
	var domainName = $("#domain_name").val();
	var domainNameReg = /[\w+.]+/;
	var logfac= $("#log_facitily").val();
	var logfacReg = /\w+/;
	var dnserver = $("#domain_name_servers").val();
	var dnserverReg = /^(\w+.\w+.\w+.\w+|\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3})/;
	//alert("check");
	var test = false;
	if(logfacReg.test(logfac)){
		test=true;
	}else{
		$(".log_facitily").find(".err").text("* log facitily is not correct format");
		$("#log_facitily").focus();
	}
	if(domainNameReg.test(domainName)){
		test=true;
	}else{
		$(".domain_name").find(".err").text("* Domain name is not correct format");
		$("#domain_name").focus();
	}
	if(dnserverReg.test(dnserver)){
		test=true;
	}else{
		$(".domain_name_servers").find(".err").text("* Domain name server is not correct format");
		$("#domain_name_servers").focus();
	}
	return test;
}
</script>