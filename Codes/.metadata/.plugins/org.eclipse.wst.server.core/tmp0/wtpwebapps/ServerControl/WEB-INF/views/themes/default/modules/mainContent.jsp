<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
	User user = (User) request.getAttribute("user");
%>
<div style="display: none ${display}" id="login-alert" class="alert alert-danger col-sm-12">${message}</div>
<ul class="list-server">
	<%
		if (user.getServers() != null && !user.getServers().isEmpty()) {
			for (Server server : user.getServers()) {
		//	Boolean check = false;
		//check Server status
		//if(server.checkStatus()){
	%>
	<li class="col-md-3 server-listed"
		data-id="<%=server.getServerAddress()%>">
		<div class="main-content panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<b><%=(server.getServerName()!=null)?server.getServerName():server.getServerAddress()%></b>
						<div class="btn-group pull-right" role="group" style="z-index: 99">
							<a type="button" class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false" id="services-config"> <i
								class="glyphicon glyphicon-chevron-down"></i>
							</a>
							<ul class="dropdown-menu config" role="menu"
								area-labelledby="services-config">
								<li role="presentation" class="dropdown-header">..:ACTION:..</li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath }/editserver/<%=server.getServerAddress()%>/${cc}">Edit...</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="${pageContext.request.contextPath }/removeserver/<%=server.getServerAddress()%>/${cc}">Remove...</a>
								</li>

							</ul>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="text-center" style="display: block">
						<div class="server-icon">
							<span class="wait"
								style="display: none: text-align:center; margin:auto;">
								<img
								src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
							</span> <a class="server-monitor-url" href="" title="#"> 
								<i class="fa fa-desktop i-server-icon" title="Server is on" style="display: none"></i> 
								<i class="fa fa-desktop server-off i-server-icon-off" title="Server is off" style="display: none"></i>
							</a>
						</div>
						<div class="control-action" style="display: block;margin: 0 auto">
							<div class="btn-group" role="group" aria-label="...">
								<button type="button" class="btn btn-danger disabled"
									onclick="location.href='${pageContext.request.contextPath }/shutdown/<%=server.getServerAddress()%>/${cc }'"
									title="shutdown">
									<i class="glyphicon glyphicon-off"></i>
								</button>
								<button type="button" class="btn btn-warning disabled"
									onclick="location.href='${pageContext.request.contextPath }/restart/<%=server.getServerAddress()%>/${cc }'"
									title="restart">
									<i class="glyphicon glyphicon-repeat"></i>
								</button>

								<button type="button" class="btn btn-default disabled"
									onclick="location.href='${pageContext.request.contextPath }/services/<%=server.getServerAddress()%>/${cc}'"
									id="services-config">
									<i class="glyphicon glyphicon-cog"></i>
								</button>
							</div>
						</div>
						<!-- //control action -->
					</div>
					<!-- //Showw server  -->
				</div>
				<div class="panel-footer" style="font-size: 10pt">
				CPU:<span class="badge">10%</span> 
				- RAM:<span class="badge">20%</span> 
				- ..</div>
			</div>
		</div>
	</li>
	<%
		}}
	%>
</ul>