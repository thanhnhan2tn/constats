<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	User user = (User) request.getAttribute("user");
%>
<script language="javascript">
	/*$(document).ready(function() {
		 $(document).ajaxStart(function(){
			 $(".wait").css("display", "block");
		 });
		 $(document).ajaxComplete(function(){
			 $(".wait").css("display", "none");
		 });
		$(".list-server").ready(function() {
			var ip = '';
			$.ajax({
				url : 'checkstatus/' + ip + '/' + cc,
				type : 'GET',
				data : {},
				timeout: '30000',
				success : function(data, status) {
					console.log(ip+data);
					if(data == "true"){
						$(".i-server-icon").css("display", "block");
					}else{
						$("button").addClass("disabled");
						$(".dropdown-toggle").removeClass("disabled");
						$(".show-server .i-server-icon-off").css("display", "block");
						// em khong noois dduocw cai gia tri
						
						// vong lap in 2 cai may tinh do dau?
								// doan code xuat ra html ay??
										// anh can id gi? id con server trong moi lan lap
								// adddress la id luon, con id cua mongo nua, nhung e xet address
								// trong JS lafm sao truyen du lieu dong vao ten cua ID?
										
						$("").css("display", "block");
								
								
					}
				}
			})

		});
	}); */

	$(document).ajaxStart(function() {
		$(".wait").css("display", "block");
	});

	$(document).ready(function() {
		var listServer = $('.server-listed');

		function check_server(index) {
			if (!listServer[index]) {
				return false;
			}

			var data = $(listServer[index]).attr('data-id');

			$.ajax({
				url : 'checkstatus/' + data + '/' + cc,
				type : 'GET',
				data : {},
				timeout : '30000',
				success : function(data, status) {
					data = $.trim(data);
					$(listServer[index]).find(".wait").css("display", "none");
					if (data == 'false') {
						$(listServer[index]).find(".i-server-icon").remove;
						$(listServer[index]).find(".i-server-icon-off").css({
							"display" : "block"
						});
					} else {
						$(listServer[index]).find(".i-server-icon-off").remove;
						$(listServer[index]).find(".i-server-icon").css({
							"display" : "block"
						});
						$(listServer[index]).find(".disabled").removeClass("disabled");
					}
				}
			}).always(function() {
				check_server(++index);
			});
		}

		if (listServer.length > 0) {
			check_server(0);
		}
		// ok e chay thu
	});
</script>
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
			<div class="server-icon">
				<span class="wait" style="display: none: text-align:center">
					<img
					src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
				</span> <a class="server-monitor-url"
					href="${pageContext.request.contextPath }/services/<%=server.getServerAddress()%>/${cc}"
					title="#"> <i class="fa fa-desktop i-server-icon"
					style="display: none"></i> <i
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
								href="${pageContext.request.contextPath }/removeserver/<%=server.getServerAddress()%>/${cc}">Remove...</a>
							</li>

						</ul>
					</div>
				</div>
			</div>
			<!-- //control action -->
		</div>
		<!-- //Showw server  -->
	</li>
	<%
		}}
	%>
</ul>
