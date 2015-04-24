<%@page import="vn.edu.cit.model.Server"%>
<%@page import="vn.edu.cit.model.User"%>
<%
	User user = (User) session.getAttribute("user");
	if(user!=null){
		 
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
			    <a href="#" title="<%=server.getServerName()%>">
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
<%
}
%>