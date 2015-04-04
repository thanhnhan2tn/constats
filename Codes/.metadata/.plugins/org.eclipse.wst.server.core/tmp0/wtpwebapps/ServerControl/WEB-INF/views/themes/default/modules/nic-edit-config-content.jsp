<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="vn.edu.cit.servercontrol.nic.Eth"%>
<%@page import="vn.edu.cit.servercontrol.nic.Nic"%>
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
			<form
				action="${pageContext.request.contextPath }/serviceconfig/nic/edit-file-nic/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Edit Network Interface Config File</b>
					</div>
					<div class="panel-body">
						<input type="hidden" name="cc" value="${cc }">
							<div class="form-group">
								<div class="col-md-9">
									<textarea class="form-control" rows="30" name="config" ></textarea>
								</div>
							</div>
					</div>
				</div>
				<!--  End Panel -->
				<button type="button" onclick="javascript:history.back()" class="btn btn-default">Back</button>
				<button type="submit" class="btn btn-primary">Save</button>
			</form>
		</div>
	</section>
	<!--  End Main Content -->
</aside>