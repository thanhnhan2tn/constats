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
			<form:form id="nic-config-form1" modelAttribute="nicForm"
				action="${pageContext.request.contextPath }/serviceconfig/nic/save/${server.serverAddress}/${cc }" class="form-horizontal" method="POST">
				<input type="hidden" name="cc" value="${cc }"> 
				<c:forEach items="${nicForm.eth }" var="e" varStatus="status">
					<c:if test="${e.iface!=null}">
						<c:if test="${!e.address.equals(server.serverAddress)}">
						<!--  check null fir ifaces -->
						<div class="panel panel-default">
							<div class="panel-heading">
								iFace: <b>${e.iface}</b>
								<div class="btn-group pull-right" role="group">
									<button type="button" class="btn btn-danger"
										onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/stop/${server.serverAddress}/${e.iface}/${cc }'"
										title="Stop service">
										<i class="glyphicon glyphicon-arrow-down"></i>
									</button>
									<button type="button" class="btn btn-success"
										onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/start/${server.serverAddress}/${e.iface}/${cc }'"
										title="Start service">
										<i class="glyphicon glyphicon-arrow-up"></i>
									</button>
									<button type="button" class="btn btn-warning"
										onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/restart/${server.serverAddress}/${e.iface}/${cc }'"
										title="Restart Service">
										<i class="glyphicon glyphicon-repeat"></i>
									</button>
									<button type="button" class="btn btn-warning"
										onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/remove/${server.serverAddress}/${e.iface}/${cc }'"
										title="Remove Service">
										<i class="glyphicon glyphicon-remove"></i>
									</button>
								</div>
							</div>

							<div class="panel-body">
								<input
									type="hidden" name="eth[${status.index}].iface"
									value="${e.iface}">
								<div class="form-group">
									<label for="inet" class="col-md-2">iNet: *</label>
									<div class="col-md-3">
										<input class="form-control" type="text"
											name="eth[${status.index}].inet" value="${e.inet}"
											placeholder="iNet name" required="required" />
									</div>
								</div>
								<c:if test='${!e.inet.equals("loopback")}'>
									<!--  check loopback -->

									<div class="form-group">
										<label for="iface" class="col-md-2">Address: </label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].address" value="${e.address }"
												placeholder="IP Address" />
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">NetMask:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].netmask" value="${e.netmask }"
												placeholder="NetMask Address" />
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">GateWay:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].gateway" value="${e.gateway }"
												placeholder="Gateway name" />
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">Broadcast:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index}].broadcast"
												value="${e.broadcast}" placeholder="Broadcast Address" />
										</div>
									</div>

								</c:if>
								<!--  // check loopback -->
							</div>
						</div>
					</c:if>
					<c:if test="${e.address.equals(server.serverAddress)}">
						<div class="panel-body">
								<input
									type="hidden" name="eth[${status.index}].iface"
									value="${e.iface}">
								<div class="form-group">
									<label for="inet" class="col-md-2">iNet: *</label>
									<div class="col-md-3">
										<input class="form-control" type="text"
											name="eth[${status.index}].inet" value="${e.inet}" disabled/>
									</div>
								</div>
								<c:if test='${!e.inet.equals("loopback")}'>
									<!--  check loopback -->

									<div class="form-group">
										<label for="iface" class="col-md-2">Address: </label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].address" value="${e.address }" disabled />
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">NetMask:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].netmask" value="${e.netmask }" disabled/>
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">GateWay:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].gateway" value="${e.gateway }" disabled/>
										</div>
									</div>
									<div class="form-group">
										<label for="iface" class="col-md-2">Broadcast:</label>
										<div class="col-md-9">
											<input class="form-control" type="text"
												name="eth[${status.index }].broadcast"
												value="${e.broadcast }" disabled />
										</div>
									</div>

								</c:if>
								<!--  // check loopback -->
							</div>
					</c:if>
					</c:if>
					
				</c:forEach>
				<form:button type="submit" class="btn btn-default">Save</form:button>
			</form:form>
		</div>
	</section>
	<!--  End Main Content -->
</aside>