<%@page import="vn.edu.cit.model.Server"%>
<%@page import="vn.edu.cit.model.User"%>
<%
	User user = (User) session.getAttribute("user");
	if(user!=null){
		 
%>
<aside class="left-side ">
	<!-- sidebar -->
	<section class="sidebar">
		<!-- Sidebar user panel
            	<div class="user-panel">
            	//image
            	</div>
        -->
		<ul class="sidebar-menu">
			<li class="header">LIST SERVERS</li>
			<%
				if (user.getServers() != null && !user.getServers().isEmpty()) {
							for (Server server : user.getServers()) {
			%>
			<li class="list-item list-server-left"  data-id="<%=server.getServerAddress()%>">
			    <a title="<%=server.getServerName()%>">
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