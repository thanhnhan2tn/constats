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
		</h1>
		<div class="btn-group pull-right" role="group">
			<button type="button" class="btn btn-danger"
				onclick="location.href='${pageContext.request.contextPath }/serviceconfig/dhcp/stop/${server.serverAddress}/${cc }'"
				title="Stop service">
				<i class="glyphicon glyphicon-arrow-down"></i>
			</button>
			<button type="button" class="btn btn-success"
				onclick="location.href='${pageContext.request.contextPath }/serviceconfig/dhcp/start/${server.serverAddress}/${cc }'"
				title="Start service">
				<i class="glyphicon glyphicon-arrow-up"></i>
			</button>
			<button type="button" class="btn btn-warning"
				onclick="location.href='${pageContext.request.contextPath }/serviceconfig/dhcp/restart/${server.serverAddress}/${cc }'"
				title="Restart Service">
				<i class="glyphicon glyphicon-repeat"></i>
			</button>
			<button type="button" class="btn btn-warning remove-iface"
				onclick="location.href='${pageContext.request.contextPath }/serviceconfig/dhcp/remove/${server.serverAddress}/${cc }'"
				title="Restart Service">
				<i class="glyphicon glyphicon-remove"></i>
			</button>
		</div>

	</section>
	<script>
		
	</script>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<%
				DHCP dhcp = (DHCP) request.getAttribute("dhcp");
				if (dhcp != null) {
			%>
			<div style="display: none ${display}" id="login-alert"
				class="alert alert-danger col-sm-12">${message}</div>
			<div style="display: none ${displaysuccess}" id="login-alert"
				class="alert alert-success col-sm-12">${message}</div>

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
						<div class="form-group">
							<label for="log_facitily" class="col-md-2">Log facility:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="log_facitily" placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label for="domain_name" class="col-md-2">Domain Name:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="domain_name" placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label for="domain_name_servers" class="col-md-2">Domain Name
								Servers:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="domain_name_servers"
									placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label for="default_lease_time" class="col-md-2">Default Lease
								Time:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="default_lease_time"
									placeholder="" />
							</div>
						</div>
						<div class="form-group">
							<label for="max_lease_time" class="col-md-2">Max Lease Time:</label>
							<div class="col-md-9">
								<form:input class="form-control" path="max_lease_time" placeholder="" />
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
								href="${pageContext.request.contextPath }/serviceconfig/dhcp/logs/${server.serverAddress}/${cc}">Logs... <i class="glyphicon glyphicon-chevron-right pull-right"></i>
							</a>
						</h3>
					</div>
				</div>
				<form:button type="submit" class="btn btn-primary" value="Save"
					id="savedhcp">Save</form:button>
				<button type="button" class="btn btn-default" onclick="history.go(-1);">Back</button>
			</form:form>
			<%
				} else {
			%>
			<div class="panel-body">
				<a class="col-md-4"
					href="${pageContext.request.contextPath }/serviceconfig/dhcpinstall/${server.serverAddress}/${cc}">
					Click here to Install ISC-DHCP-SERVER Service..</a>
			</div>
			<%
				}
			%>
		</div>
	</section>
	<!--  End Main Content -->
</aside>