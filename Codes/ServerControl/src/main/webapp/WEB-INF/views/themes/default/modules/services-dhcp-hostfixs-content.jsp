<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
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
		<h2>Config Subnets</h2>
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

			<form:form id="dhcp-config-form" modelAttribute="dhcp"
				action="${pageContext.request.contextPath }/serviceconfig/dhcp/hostfixs/save/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<input type="hidden" name="cc" value="${cc }">
				<c:forEach items="${hostfixs }" var="s" varStatus="status">
					<div class="panel panel-default">
						<div class="panel-heading">hostfixesName : ${s.hostname }</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="hostname" class="col-md-2">HostName: *</label>
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="hostfixes[${status.index}].hostname" value="${s.hostname}"
										placeholder="Hostname.." required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="hardware_internet" class="col-md-2">Hardware
									Internet:</label>
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="hostfixes[${status.index}].hardware_internet"
										value="${s.hardware_internet}" placeholder="Hardware Internet.." />
								</div>
							</div>
							<div class="form-group">
								<label for="filename" class="col-md-2">FileName :</label>
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="hostfixes[${status.index}].filename" value="${s.filename}"
										placeholder="Filename ..." />
								</div>
							</div>
							<div class="form-group">
								<label for="servername" class="col-md-2">Server Name :</label>
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="hostfixes[${status.index}].servername" value="${s.servername}"
										placeholder="Server name ...." />
								</div>
							</div>
							<div class="form-group">
								<label for="fixed_address" class="col-md-2">Fixed Address:</label>
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="hostfixes[${status.index}].fixed_address"
										value="${s.fixed_address}" placeholder="Fixed Address ..." />
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--  // Foreach Subnet -->
				<button type="button" class="btn btn-default" onclick="window.history.back();">Back</button>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#addHostfix">New...</button>

				<c:if test="${hostfixs.size()>0}">
					<form:button class="btn btn-primary" type="submit" value="Save"
						id="savedhcp">Save</form:button>
				</c:if>
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

<div class="modal fade" id="addHostfix" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="addSubnet">Add Subnet</h4>
			</div>
			<form:form commandName="hostNew" 
				action="${pageContext.request.contextPath }/serviceconfig/dhcp/hostfixs/addhostfix/${server.serverAddress}/${cc}"
				method="POST" role="hostfix" class="form-horizontal">
				<div class="modal-body">
					<div class="form-group">
						<label for="hostname" class="col-md-2">HostName: *</label>
						<div class="col-md-9">
							<form:input class="form-control" type="text"
								path="hostname"
								placeholder="Hostname.." required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="hardware_internet" class="col-md-2">Hardware Internet:</label>
						<div class="col-md-9">
							<form:input class="form-control" type="text"
								path="hardware_internet" placeholder="Hardware Internet.." />
						</div>
					</div>
					<div class="form-group">
						<label for="filename" class="col-md-2">FileName :</label>
						<div class="col-md-9">
							<form:input class="form-control" type="text"
								path="filename"
								placeholder="Filename ..." />
						</div>
					</div>
					<div class="form-group">
						<label for="servername" class="col-md-2">Server Name :</label>
						<div class="col-md-9">
							<form:input class="form-control" type="text"
								path="servername"
								placeholder="Server name ...." />
						</div>
					</div>
					<div class="form-group">
						<label for="fixed_address" class="col-md-2">Fixed Address:</label>
						<div class="col-md-9">
							<form:input class="form-control" type="text"
								path="fixed_address" placeholder="Fixed Address ..." />
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</form:form>
		</div>
	</div>
</div>