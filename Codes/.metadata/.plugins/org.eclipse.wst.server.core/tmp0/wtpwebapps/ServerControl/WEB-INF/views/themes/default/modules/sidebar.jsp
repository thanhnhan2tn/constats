<%@page import="vn.edu.cit.model.Server"%>
<%@page import="vn.edu.cit.model.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<aside class="left-side sidebar-offcanvas">
	<!-- sidebar -->
	<section class="sidebar">
		<!-- Sidebar user panel
            	<div class="user-panel">
            	//image
            	</div>
        -->
		<ul class="sidebar-menu">
			<li class="list-item active"><a
				href="${pageContext.request.contextPath}/"> <i
					class="fa fa-dashboard"></i><span>Dashboard</span></a></li>
			<%
				if (user.getServers() != null && !user.getServers().isEmpty()) {
									for (Server server : user.getServers()) {
										//check Server status
										if(server.checkStatus()){
			%>
			<li class="list-item"><a
				href="{pageContext.request.contextPath }/monitor/<%=server.getServerAddress()%>/${cc}"
				title="#"><i class="fa fa-desktop server-icon"></i> <%=server.getServerAddress()%>
					<i style="color: green" class="glyphicon glyphicon-ok-circle"></i></a>
			</li>
			<%
				}else{
			%>
			<li class="list-item"><a
				href="#" title="#"><i class="fa fa-desktop server-icon"></i> <%=server.getServerAddress()%>
					<i style="color: red" class="glyphicon glyphicon-ban-circle"></i></a>
			</li>
			<%
				}
					}}
			%>
		</ul>
	</section>
	<!-- end sidebar -->
</aside>

