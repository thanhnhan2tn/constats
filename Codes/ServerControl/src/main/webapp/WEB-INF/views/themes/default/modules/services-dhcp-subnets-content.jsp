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
				action="${pageContext.request.contextPath }/serviceconfig/dhcp/subnets/save/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<input type="hidden" name="cc" value="${cc }">
				<c:if test="${subnets.size()>0}">
				<c:forEach items="${subnets}" var="s" varStatus="status">

					<div class="panel panel-default">
						<div class="panel-heading">Subnet: ${subnet }</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="subnet" class="col-md-2">Subnet:</label>
								<div class="col-md-9">
									<input class="form-control" name="Subnets[${status.index }].subnet"
										value="${s.subnet }" placeholder="Subnet name.." />
								</div>
							</div>
							<div class="form-group">
								<label for="netmask" class="col-md-2">Netmask:</label>
								<div class="col-md-9">
									<input class="form-control" name="Subnets[${status.index }].netmask"
										value="${s.netmask}" placeholder="Netmask address.." />
								</div>
							</div>
							<div class="form-group">
								<label for="range" class="col-md-2">Range:</label>
								<div class="col-md-9">
									<input class="form-control" name="Subnets[${status.index }].range"
										value="${s.range}" placeholder="" />
								</div>
							</div>
							<div class="form-group">
								<label for="dnss" class="col-md-2">Domain name server:</label>
								<div class="col-md-9">
									<input class="form-control"
										name="Subnets[${status.index }].domain_name_server"
										value="${s.domain_name_server}" placeholder="" />
								</div>
							</div>
							<div class="form-group">
								<label for="dn" class="col-md-2">Domain Name:</label>
								<div class="col-md-9">
									<input class="form-control" name="Subnets[${status.index}].domain_name"
										value='${s.domain_name}' placeholder="" />
								</div>
							</div>
							<div class="form-group">
								<label for="router" class="col-md-2">Router gateway:</label>
								<div class="col-md-9">
									<input class="form-control"
										name="Subnets[${status.index}].router_gateway"
										value="${s.router_gateway}" placeholder="" />

								</div>
							</div>
							<div class="form-group">
								<label for="broadcast" class="col-md-2">Broadcast Address:</label>
								<div class="col-md-9">
									<input class="form-control"
										name="Subnets[${status.index}].broadcast_address"
										value="${s.broadcast_address}" placeholder="" />

								</div>
							</div>
							<div class="form-group">
								<label for="leasetime" class="col-md-2">Default lease time:</label>
								<div class="col-md-9">
									<input class="form-control"
										name="Subnets[${status.index}].default_lease_time"
										value="${s.default_lease_time}" placeholder="" />

								</div>
							</div>
							<div class="form-group">
								<label for="maxlease" class="col-md-2">Max lease time:</label>
								<div class="col-md-9">
									<input class="form-control"
										name="Subnets[${status.index}].max_lease_time"
										value="${s.max_lease_time}" placeholder="" />
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
				<!--  // Foreach Subnet -->
				<button type="button" class="btn btn-default" onclick="history.go(-1);">Back</button>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#addSubnet">New...</button>
			
				<c:if test="${subnets.size()>0}">
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
<div class="modal fade" id="addSubnet" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="addSubnet">Add Subnet</h4>
			</div>
			<form:form
				action="${pageContext.request.contextPath }/serviceconfig/dhcp/subnets/addsubnet/${server.serverAddress}/${cc}"
				method="POST" role="subnet" commandName="subnetNew" class="form-horizontal">
				<div class="modal-body">
					<div class="form-group">
						<label for="ip" class="col-md-3 control-label">Subnet: *</label>
						<div class="col-md-9">
							<form:input path="subnet" class="form-control" placeholder="Subnet"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="ip" class="col-md-3 control-label">Netmask: *</label>
						<div class="col-md-9">
							<form:input path="netmask" class="form-control" placeholder="Netmask"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Range: *</label>
						<div class="col-md-9">
							<form:input path="range" class="form-control" placeholder="Range"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Domain Name Server</label>
						<div class="col-md-9">
							<form:input path="domain_name_server" class="form-control"
								placeholder="Domain Name Server" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Domain Name: *</label>
						<div class="col-md-9">
							<form:input path="domain_name" class="form-control"
								placeholder="Domain Name" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Router gateway: *</label>
						<div class="col-md-9">
							<form:input path="router_gateway" class="form-control"
								placeholder="Router gateway" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Broadcast Address: *</label>
						<div class="col-md-9">
							<form:input path="broadcast_address" class="form-control"
								placeholder="Broadcast address" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Default lease time: *</label>
						<div class="col-md-9">
							<form:input path="default_lease_time" class="port form-control"
								placeholder="Default lease time" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-3 control-label">Max Lease Time: *</label>
						<div class="col-md-9">
							<form:input path="max_lease_time" class="port form-control"
								placeholder="Max Lease Time" required="required" />
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