<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	User user = (User) request.getAttribute("user");
%>

<ul class="list-server">
	<%
		if (user.getServers() != null && !user.getServers().isEmpty()) {
			for (Server server : user.getServers()) {
			Boolean check = false;
		//check Server status
		//if(server.checkStatus()){
	%>
	<li class="server-item col-md-2 server-listed"
		data-id="<%=server.getServerAddress()%>"
		id="server-<%=server.getServerAddress()%>">
		<div style="display: block">
			<div class="btn-group pull-right" role="group" style="z-index:99">
				<a type="button" class="dropdown-toggle"
							data-toggle="dropdown" aria-expanded="false" id="services-config">
					<i class="glyphicon glyphicon-chevron-down"></i>
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
			<div class="server-icon">
				<span class="wait"
					style="display: none: text-align:center; margin: 30 auto;">
					<img
					src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
				</span> <a class="server-monitor-url" href="" title="#"> <i
					class="fa fa-desktop i-server-icon" style="display: none"></i> <i
					class="fa fa-desktop server-off i-server-icon-off"
					style="display: none"></i>
				</a>
			</div>
			<div class="control-action">
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
		</div> <!-- //Showw server  -->
	</li>
	<%
		}}
	%>
</ul>
