<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	User user = (User) request.getAttribute("user");
%>
<div style="display: none ${display}" id="login-alert"
	class="alert alert-danger col-sm-12">${message}</div>
<ul class="list-server">
	<%
		if (user.getServers() != null && !user.getServers().isEmpty()) {
			for (Server server : user.getServers()) {
				//	Boolean check = false;	
				//check Server status
				//if(server.checkStatus()){
	%>
	<li class="col-md-3 server-listed" data-id="<%=server.getServerAddress()%>">
		<div class="main-content panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<b><%=(server.getServerName() != null) ? server.getServerName() : server.getServerAddress()%></b>
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
								style="display: none: text-align:center; margin: auto;"> <img
								src="<c:url value='/resources/themes/default/images/loading-min.gif'/>" />
							</span> <a class="server-monitor-url" title="#"> <i
								class="fa fa-desktop i-server-icon" title="Server is on"
								style="display: none"></i> <i
								class="fa fa-desktop server-off i-server-icon-off" title="Server is off"
								style="display: none">
								<button type="button" class="btn btn-danger btn-block disabled btn-server-off" style="font-size: 10pt">Server is off!!</button></i>
							</a>
						</div>
						<div class="control-action" style="display: block; margin: 0 auto">
							<div class="" role="" aria-label="...">
								<button type="button" class="btn-control-action btn btn-default btn-block hidden"
									onclick="location.href='${pageContext.request.contextPath }/services/<%=server.getServerAddress()%>/${cc}'"
									id="services-config">
									<i class="glyphicon glyphicon-cog"></i> Configuration...
								</button>
							</div>
						</div>
						<!-- //control action -->
					</div>
					<!-- //Showw server  -->
				</div>
<%-- 				<div class="panel-footer info info_<%=server.getServerAddress()%> hidden" style="font-size: 10pt"> --%>

<!-- 					Progress bars -->
<!-- 					<div class="clearfix"> -->
<%-- 						<span class="pull-left">CPU</span> <small class="pull-right info_<%=server.getServerAddress()%> cpu"></small> --%>
<!-- 					</div> -->
<!-- 					<div class="progress xs"> -->
<%-- 						<div class="progress-bar progress-bar-green info_<%=server.getServerAddress()%> cpu-bar" style="width: 0%;"></div> --%>
<!-- 					</div> -->

<!-- 					<div class="clearfix"> -->
<%-- 						<span class="pull-left">RAM</span> <small class="pull-right info_<%=server.getServerAddress()%> ram"></small> --%>
<!-- 					</div> -->
<!-- 					<div class="progress xs"> -->
<%-- 						<div class="progress-bar progress-bar-red info_<%=server.getServerAddress()%> ram-bar" style="width: 0%;"></div> --%>
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</li>
	<%
		}
		}
	%>
</ul>
