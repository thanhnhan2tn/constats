<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="model.nic.Eth"%>
<%@page import="model.nic.Nic"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Netword Interface Cards Config :<small> (${server.serverAddress})</small>
		</h1>
	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<div class="box">
				<spring:form
					action="${pageContext.request.contextPath }/editserver/${server.serverAddress}/${cc}"
					method="POST" role="form" commandName="server" class="form-horizontal">
					<div class="box-body">
						<div class="form-group">
							<label for="ip" class="col-md-2 control-label">IP: *</label>
							<div class="col-md-9">
								<spring:input path="serverAddress" class="ip form-control"
									readonly="true" name="ip" value="${server.serverAddress}"
									title="You can not edit IP Address" />
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-2 control-label">Password: *</label>
							<div class="col-md-9">
								<spring:password path="serverPassword" class="password form-control"
									name="password" placeholder="Input your server user password"
									required="required" />
							</div>
						</div>
						<div class="form-group">
							<label for="ssh-port" class="col-md-2 control-label">SSH Port: *</label>
							<div class="col-md-9">
								<spring:input path="port" class="port form-control"
									value="${server.port}" placeholder="SSH Port" required="required" />
							</div>
						</div>
						<div style="display: none" id="signup-err"
							class="alert alert-danger col-sm-12 signup-err"></div>

					</div>
					<div class="box-footer">
					 
						<button type="button" class="btn btn-default"
							onclick="window.history.back();">Back</button>
						<button type="submit" class="btn btn-primary">Save changes</button>
					 
					</div>
				</spring:form>
			</div> <!-- Box  -->
		</div>
	</section>
	<!--  End Main Content -->
</aside>