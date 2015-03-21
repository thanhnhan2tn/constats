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
	<script>
		$(document).ready(function() {
			 $(document).ajaxStart(function(){
				 $(".wait").css("display", "block");
			 });
			 $(document).ajaxComplete(function(){
				 $(".wait").css("display", "none");
			 });
			$(".list-server").ready(function() {
				var ip = '<%=server.getServerAddress()%>';
				$.ajax({
					url : 'checkstatus/' + ip + '/' + cc,
					type : 'GET',
					data : {},
					success : function(data, status) {
						if(data=="true"){
							$(".show-server").css("display", "block");
						}else{
							$(".server-icon").empty();
							$(".server-icon").html("<i class=\"fa fa-desktop server-icon server-off\"></i>");
							$("button").addClass("disabled");
							$(".dropdown-toggle").removeClass("disabled");
							$(".menu-config").remove();
							
							$(".show-server").css("display", "block");
						}
					}
				})

			});
		});
	</script>
	<li class="server-item col-md-2">
	<span class="wait" style="display: none: text-align:center">
		<img src="<c:url value='/resources/themes/default/images/loading.gif'/>" /></span>
	<div class="show-server" style="display: none">
		<div class="server-icon">
		<a class="server-monitor-url" href="${pageContext.request.contextPath }/monitor/<%=server.getServerAddress()%>/${cc}"
		title="#"><i class="fa fa-desktop server-icon"></i>
			<ul class="server-info">
				<li>Name: <span>Server DNS</span></li>
				<li>IP: <span><%=server.getServerAddress()%></span></li>
				<li>CPU: <span>10%</span></li>
				<li>RAM: <span>50%</span></li>
				<li>DISK: <span>20%</span></li>
			</ul> 
		</a>
		</div>
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
					<ul class="dropdown-menu config" role="menu"
						area-labelledby="services-config">
						<li role="presentation" class="dropdown-header">..:ACTION:..</li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/editserver/<%=server.getServerAddress()%>/${cc}">Edit...</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/removeserver/<%=server.getServerAddress()%>/${cc}">Remove...</a></li>
						<div class="menu-config">
						<li role="presentation" class="dropdown-header">..:CONFIG:..</li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/serviceconfig/nic/<%=server.getServerAddress()%>/${cc}">NetwordCard...</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="${pageContext.request.contextPath }/serviceconfig/dns/<%=server.getServerAddress()%>/${cc}">DNS
								Service...</a>
						</div></li>
					</ul>
				</div>
			</div>
		</div> <!-- //control action -->
		</div><!-- //Showw server  -->
		</li>
	<%
		}}
	%>
</ul>
