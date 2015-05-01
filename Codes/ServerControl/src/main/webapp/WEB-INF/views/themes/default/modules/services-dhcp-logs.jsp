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
		<h2>Logs</h2>
		</section>
	<script>
	$(document)
	  .ajaxStart(function () {
	    $(".wait")
	      .css("display", "block");
	  });
	//loading ServerInfomation
	var ip = "${server.serverAddress}";
	$(document)
	  .ready(function () {
	    $.ajax({
	      url: '${pageContext.request.contextPath}/serviceconfig/dhcp/getlogs/' + ip + '/' + cc
	      , type: 'GET'
	      , data: {}, //timeout : 60000,
	      success: function (data, status) {
	        //if(data != null){
	       
	        //	alert(html);
	        $(".dhcp-logs")
	          .html("Finish");
	        $(".wait")
	          .css("display", "none");
	        //}
	      }
	    });
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
				<div class="box-body dhcp-logs">
					<span class="wait"
								style="display: none: text-align:center; margin: auto;"> <img
								src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
					</span> 
				</div>
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>