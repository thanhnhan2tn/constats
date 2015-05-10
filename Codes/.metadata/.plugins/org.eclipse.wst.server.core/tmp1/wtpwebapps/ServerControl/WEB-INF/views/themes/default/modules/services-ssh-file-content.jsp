<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<div class="clear-fix">
				<div style="display: none ${display}" id="login-alert"
					class="alert alert-danger col-sm-12">${message}</div>
				<div style="display: none ${displaysuccess}" id="login-alert"
					class="alert alert-success col-sm-12">${message}</div>
			</div>
			<form
				action="${pageContext.request.contextPath }/serviceconfig/ssh/editfile/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Edit Network Interface Config File</b>
					</div>
					<div class="panel-body">
						<input type="hidden" name="cc" value="${cc }">
							<div class="form-group">
								<div class="col-md-9">
									<textarea class="form-control" rows="30" name="config" >${sshconfig }</textarea>
								</div>
							</div>
					</div>
				
				<!--  End Panel -->
				<div class="panel-footer">
						<button class="btn btn-default" type="button" onclick="window.history.back();">Back</button>
						<button class="btn btn-primary" type="submit" >Save</button>
				</div>
				</div>
			</form>
		</div>
	</section>
	<!--  End Main Content -->
</aside>