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
			<%
				Nic nics = (Nic)request.getAttribute("nics");
											System.out.println(nics);
										for(Eth eth : nics.getEth()){
											if(eth.getIface()!=null){
			%>
			<div class="panel panel-default">
				<div class="panel-heading">
					iFace: <b><%=eth.getIface()%></b>
					<div class="btn-group pull-right" role="group">
						<button type="button" class="btn btn-danger"
							onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/stop/${server.serverAddress}/<%=eth.getIface()%>/${cc }'"
							title="Stop service">
							<i class="glyphicon glyphicon-arrow-down"></i>
						</button>
						<button type="button" class="btn btn-success"
							onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/start/${server.serverAddress}/<%=eth.getIface()%>/${cc }'"
							title="Start service">
							<i class="glyphicon glyphicon-arrow-up"></i>
						</button>
						<button type="button" class="btn btn-warning"
							onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/restart/${server.serverAddress}/<%=eth.getIface()%>/${cc }'"
							title="Restart Service">
							<i class="glyphicon glyphicon-repeat"></i>
						</button>
						<button type="button" class="btn btn-warning"
							onclick="location.href='${pageContext.request.contextPath }/serviceconfig/nic/remove/${server.serverAddress}/<%=eth.getIface()%>/${cc }'"
							title="Remove Service">
							<i class="glyphicon glyphicon-remove"></i>
						</button>
					</div>
				</div>

				<div class="panel-body">
					<form name="networkcard" id="nic-config-form1"
						action="serviceconfig/nic/save/${server.serverAddress}"
						class="form-horizontal" method="POST">
						<input type="hidden" name="cc" value="${cc }">
						<div class="form-group">
							<label for="inet" class="col-md-2">iNet: *</label>
							<div class="col-md-3">
								<input class="form-control" type="text" name="inet"
									value="<%=eth.getInet()%>" placeholder="iNet name"
									required="required" />
							</div>
						</div>
						<%if(!eth.getInet().equals("loopback")){ %>
						
						<div class="form-group">
							<label for="iface" class="col-md-2">Address: </label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="address"
									value="<%=eth.getAddress()%>" placeholder="IP Address" />
							</div>
						</div>
						<div class="form-group">
							<label for="iface" class="col-md-2">NetMask:</label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="netmask"
									value="<%=eth.getNetmask()%>" placeholder="NetMask Address" />
							</div>
						</div>
						<div class="form-group">
							<label for="iface" class="col-md-2">GateWay:</label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="gateway"
									value="<%=eth.getGateway()%>" placeholder="Gateway name" />
							</div>
						</div>
						<div class="form-group">
							<label for="iface" class="col-md-2">Broadcast:</label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="broadcast"
									value="<%=eth.getBroadcast()%>" placeholder="Broadcast Address" />
							</div>
						</div>
						<div class="form-group">
							<label for="iface" class="col-md-2">DNS-NameServer: </label>
							<div class="col-md-9">
								<input class="form-control" type="text" name="dnsnameserver"
									value="<%=eth.getDns_nameservers()%>" placeholder="DNS Address" />
							</div>
						</div>
						<%}%>
					</form>

				</div>
			</div>
			<%
				} // end check null
							}
			%>
			<button type="submit" class="btn btn-default" form="networkcard">Save</button>
		</div>
	</section>
	<!--  End Main Content -->
</aside>