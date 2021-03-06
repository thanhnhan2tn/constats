<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@page import="java.util.List"%>
<%@page import="model.dhcp.Subnet"%>
<%@page import="model.dhcp.DHCP"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="model.nic.Eth"%>
<%@page import="model.nic.Nic"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			DHCP Server Config :<small> (${server.serverAddress})</small>
		</h1>
		<h2>Logs <small>(Autoload after 5s)</small></h2>
<!-- 		<button type="button"  class="btn btn-warning pull-right" -->
<!-- 				title="Refresh"> -->
<!-- 				<i class="glyphicon glyphicon-refresh"></i> -->
<!-- 		</button> -->
		</section>
	<script>
	$(document).ajaxStart(function () {
	    $(".wait")
	      .css("display", "block");
	  });
	//loading ServerInfomation
	var ip = "${server.serverAddress}";
	$(document).ready(function () {
		setInterval(function () {
		$.ajax({
	      url: '${pageContext.request.contextPath}/serviceconfig/dhcp/getlogs/' + ip + '/' + cc
	      , type: 'GET'
	      , data: {}, //timeout : 60000,
	      success: function (data, status) {
	        //if(data != null){
	       
	        //	alert(html);
	        $(".dhcp-logs")
	          .html("<pre>"+data+"</pre>");
	        $(".wait")
	          .css("display", "none");
	        //}
	      }
	    });
		
	   },5000);
	});
	</script>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">

			<div style="display: none ${display}" id="login-alert"
				class="alert alert-danger col-sm-12">${message}</div>
			<div style="display: none ${displaysuccess}" id="login-alert"
				class="alert alert-success col-sm-12">${message}</div>
			<div class="box box-default">
				<div class="box-header">Logs</div>
				<div class="box-body dhcp-logs" style="max-height:450px; overflow:scroll;">
					<span class="wait"
								style="display: none: text-align:center; margin:0 50%;"> <img
								src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
					</span> 
				</div>
			</div>
			<button type="button" class="btn btn-default" onclick="window.history.back();">Back</button>
		</div>
	</section>
	<!--  End Main Content -->
</aside>