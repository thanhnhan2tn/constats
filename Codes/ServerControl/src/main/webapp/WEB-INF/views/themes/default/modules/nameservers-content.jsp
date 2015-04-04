<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="vn.edu.cit.servercontrol.nic.Eth"%>
<%@page import="vn.edu.cit.servercontrol.nic.Nic"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Netword Interface Cards Config :<small>
				(${server.serverAddress})</small>
		</h1>


	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<form:form modelAttribute="nicForm"
				action="${pageContext.request.contextPath }/serviceconfig/nic/save/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>DNS NameServer</b>
					</div>
					<div class="panel-body">
						<input type="hidden" name="cc" value="${cc }">
						<c:forEach items="${nicForm.dns_nameservers }" var="dns"
							varStatus="status">

							<div class="form-group">
								<div class="col-md-9">
									<input class="form-control" type="text"
										name="dns_nameservers[${status.index }]" value="${dns}" />
								</div>
							</div>

						</c:forEach>
						<c:if test="${nicForm.dns_nameservers==null }">

							<div class="form-group">
								<div class="col-md-9">
									<input class="form-control" type="text" name="dns_nameservers1" />
								</div>
							</div>

						</c:if>

					</div>
				</div>
				<!--  End Panel -->

				<form:button type="submit" class="btn btn-default">Save</form:button>
			</form:form>
		</div>
	</section>
	<!--  End Main Content -->
</aside>