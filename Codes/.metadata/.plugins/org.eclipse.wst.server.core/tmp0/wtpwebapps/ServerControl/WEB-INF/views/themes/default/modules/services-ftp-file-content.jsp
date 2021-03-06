<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="model.nic.Eth"%>
<%@page import="model.nic.Nic"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			FTP Service Config :<small> (${server.serverAddress})</small>
		</h1>


	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<form
				action="${pageContext.request.contextPath }/serviceconfig/ftp/editfile/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>FTP Config File</b>
					</div>
					<div class="panel-body">
						<input type="hidden" name="cc" value="${cc }">
							<div class="form-group">
								<div class="col-md-9">
									<textarea class="form-control" rows="30" name="ftpconfig" >${ftpconfig }</textarea>
								</div>
							</div>
					</div>
				</div>
				
				
				<div class="panel panel-footer">
						<button  class="btn btn-default" type="button" onclick="window.history.back();">Back</button>
						<button class="btn btn-primary" type="submit" >Save</button>
				</div>
			</form>
		</div>
	</section>
	<!--  End Main Content -->
</aside>