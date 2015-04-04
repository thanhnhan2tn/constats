<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>

<%
	User user = (User) request.getAttribute("user");
%>
<ul class="list-server">
	<%
		if (user.getServers() != null && !user.getServers().isEmpty()) {
			for (Server server : user.getServers()) {
		//check Server status
		if(server.checkStatus()){
	%>
	<li class="server-item col-md-2" name="<%=server.getServerAddress()%>"><a
		href="${pageContext.request.contextPath }/monitor/<%=server.getServerAddress()%>/${cc}"
		title="#"><i class="fa fa-desktop server-icon"></i>
			<ul class="server-info">
				<li>Name: <span>Server DNS</span></li>
				<li>IP: <span><%=server.getServerAddress()%></span></li>
				<li>CPU: <span>10%</span></li>
				<li>RAM: <span>50%</span></li>
				<li>DISK: <span>20%</span></li>
			</ul> </a>
		<div class="control-action">
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-danger"
					onclick="location.href='${pageContext.request.contextPath }/shutdown/<%=server.getServerAddress()%>/${cc }'"
					title="shutdown">
					<i class="glyphicon glyphicon-off"></i>
				</button>
				<button type="button" class="btn btn-warning"
					onclick="location.href='${pageContext.request.contextPath }/restart/<%=server.getServerAddress()%>/${cc }'"
					title="restart">
					<i class="glyphicon glyphicon-repeat"></i>
				</button>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false" id="services-config">
						<i class="glyphicon glyphicon-cog"></i>
					</button>
					<ul class="dropdown-menu" role="menu"
						area-labelledby="services-config">
						<li role="presentation" class="dropdown-header">..:ACTION:..</li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/editserver/<%=server.getServerAddress()%>/${cc}">Edit...</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/removeserver/<%=server.getServerAddress()%>/${cc}">Remove...</a></li>
						<li role="presentation" class="dropdown-header">..:CONFIG:..</li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/serviceconfig/nic/<%=server.getServerAddress()%>/${cc}">NetwordCard...</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/serviceconfig/dns/<%=server.getServerAddress()%>/${cc}">DNS
								Service...</a></li>
					</ul>
				</div>
			</div>
			</div>
			<div><%=server.getServerAddress()%></div>
			</li>
	<%
		}//end check status
			else{
	%>
	<li class="server-item col-md-2"><a href="#" title="#"> <i
			class="fa fa-desktop server-icon server-off"></i>
	</a>
		<div class="control-action">
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-danger disabled"
					onclick="location.href='Shutdown'" title="Shutdown">
					<i class="glyphicon glyphicon-off"></i>
				</button>
				<button type="button" class="btn btn-warning disabled"
					onclick="location.href='Restart'" title="Restart">
					<i class="glyphicon glyphicon-repeat"></i>
				</button>
				<button type="button" class="btn btn-default disabled"
					onclick="controlMenu()">
					<i class="glyphicon glyphicon-cog"></i>
				</button>
			</div>
		</div><div><%=server.getServerAddress()%></div></li>
	<%
		}
			} // end for
		} //end check Server empty 
		else {
	%>
	Chua co server nao.
	<%
		}
	%>



</ul>