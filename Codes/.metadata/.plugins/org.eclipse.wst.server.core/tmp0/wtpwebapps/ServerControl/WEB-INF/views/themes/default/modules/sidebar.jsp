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
			<%
				if (user.getServers() != null && !user.getServers().isEmpty()) {
							for (Server server : user.getServers()) {
			%>
			<li class="list-item list-server-left"  data-id="<%=server.getServerAddress()%>">
			    <a href="${pageContext.request.contextPath }/services/<%=server.getServerAddress()%>/${cc}" title="#">
			        <i class="fa fa-desktop server-icon"></i> <%=server.getServerAddress()%>
			    </a>
			</li>
			<%
				}
									}
			%>
		</ul>
	</section>
	<!-- end sidebar -->
</aside>