<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    url: '${pageContext.request.contextPath}/getserverinfo/' + ip + '/' + cc
    , type: 'GET'
    , data: {}, //timeout : 60000,
    success: function (data, status) {
      //if(data != null){
      var html = '<table class="table table-bordered">';
      html += '<tr><td>Hostname:</td><td>' + data.hostname + '</td></tr>';
      html += '<tr><td>OS Version:</td><td>' + data.osversion + '</td></tr>';
      html += '<tr><td>Kernel:</td><td>' + data.kernel + '</td></tr>';
      html += '<tr><td>Processor Info:</td><td>' + data.processor_info + '</td></tr>';
      html += '<tr><td>Uptime:</td><td>' + data.uptime + '</td></tr>';
      html += '<tr><td>Memory:</td><td>Used: ' + parseInt(parseInt(data.memused) / 1024) + ' MB - Total: ' + parseInt(parseInt(data.memtotal) / 1024) + ' MB</td></tr>';
      html += '<tr><td>CPU Usage:</td><td><div class="progress xs"><div class="progress-bar progress-bar-green" style="width: ' + data.cpu_usage + '%;"></div></div>' + data.cpu_usage + '%</td></tr>';
      html += '<tr><td>Cpu Loadaverage:</td><td>' + data.cpu_loadaverage + '</td></tr></table>';
      //	alert(html);
      $(".serverinfomation")
        .html(html);
      $(".wait")
        .css("display", "none");
      //}
    }
  });
  $("#m-status")
    .on("click", function () {
      //var id=""
      if ($(this)
        .is(":checked")) {
        $.ajax({
          url: '${pageContext.request.contextPath}/monitor/start/' + ip + '/' + cc
          , type: 'GET'
          , datastatus: {}
        })
      } else {
        $.ajax({
          url: '${pageContext.request.contextPath}/monitor/stop/' + ip + '/' + cc
          , type: 'GET'
          , datastatus: {}
        })
      }
    });
  $(".active-sudo")
    .on("click", function () {
      var user = $(".username")
        .val();
      var pass = $(".password")
        .val();
      $.ajax({
        url: '${pageContext.request.contextPath}/serviceconfig/user/' + user + '/' + pass + '/' + ip + '/' + cc
        , type: 'GET'
        , datastatus: {}
        , success: function (datastatus, status) {
          location.reload();
        }
      });
    });
});

</script>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Control Services Server<small> (${server.serverAddress})</small>
		</h1>
	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content panel-group" id="accordion">
			<ul class="nav nav-tabs" id="serverTab">
				<li class="active"><a data-toggle="tab" href="#monitor">System
						Infomation</a></li>
				<li><a data-toggle="tab" href="#services">Service Configuation</a></li>
			</ul>
			<hr>
			<div class="tab-content">
				<div style="display: none ${display}" id="login-alert"
					class="alert alert-danger col-sm-12">${message}</div>
				<div style="display: none ${displaysuccess}" id="login-alert"
					class="alert alert-success col-sm-12">${message}</div>

				<!-- Tabs Monitor Config -->
				<div class="tab-pane active" id="monitor">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">System Infomation</h3>
						</div>
						<div id="">
							<div class="panel-body">
								<div id="serverinfomation" class="serverinfomation">
									<span class="wait"
										style="display: none: text-align:center; displar: block; margin: 100px auto;">
										<img
										src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
									</span>

								</div>
							</div>
							<!-- // Panel Body -->
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Monitoring</h3>

						</div>
						<div id="monitoring" class="monitoring panel-collapse ">
							<div class="panel-body">
								<div class="box box-default">
									<div class="box-header">
										<h3 class="box-title">CPU Usage</h3>
									</div>
									<div class="box-body">
										<div class="box-body text-center">
											<div class="sparkline" data-type="line" data-spot-Radius="3"
												data-highlight-Spot-Color="#f39c12" data-highlight-Line-Color="#222"
												data-min-Spot-Color="#f56954" data-max-Spot-Color="#00a65a"
												data-spot-Color="#39CCCC" data-offset="90" data-width="100%"
												data-height="100px" data-line-Width='2' data-line-Color='#39CCCC'
												data-fill-Color='rgba(57, 204, 204, 0.08)'>
												0.01,0.03,0.05,0.01,0.03,0.05,0.01,0.03,0.05,0.01,0.03,0.05</div>
										</div>
										<!-- /.box-body -->
									</div>
								</div>
								<div class="box box-default">
									<div class="box-header">
										<h3 class="box-title">RAM</h3>
									</div>
									<div class="box-body">
										<div class="box-body text-center">
											<div class="sparkline" data-type="line" data-spot-Radius="3"
												data-highlight-Spot-Color="#f39c12" data-highlight-Line-Color="#222"
												data-min-Spot-Color="#f56954" data-max-Spot-Color="#00a65a"
												data-spot-Color="#39CCCC" data-offset="90" data-width="100%"
												data-height="100px" data-line-Width='2' data-line-Color='#39CCCC'
												data-fill-Color='rgba(57, 204, 204, 0.08)'>
												6,4,7,2,5,6,7,4,5,7,2,2,5,2,2,5,6,7,4,6,7,4,8,4,3,1,5,7,8,4,3,2,2,5,6,7,4,1,5,7,9,9,8,7,6</div>
										</div>
										<!-- /.box-body -->
									</div>
								</div>
								<div class="box box-default">
									<div class="box-header">
										<h3 class="box-title">DISK Space</h3>
									</div>
									<div class="box-body">
										<div class="box-body text-center">
											<div class="sparkline" data-type="pie" data-offset="90"
												data-width="100px" data-height="100px">6,4,8</div>
										</div>
										<!-- /.box-body -->
									</div>
								</div>

							</div>
							<!-- // Panel Body -->
						</div>
					</div>
				</div>

				<!-- Tabs Service Config -->
				<div class="tab-pane" id="services">
					<c:if test="<%=(session.getAttribute(\"sudouser\") == null)%>">
						<div class="box box-default">
							<div class="box-header">
								Please input your server SUDOER user, it will not save!
							</div>
							<div class="box-body">
								<form
									action="${pageContext.request.contextPath }/serviceconfig/user/${server.serverAddress}/${cc}"
									class="form-horizontal" method="POST">


									<div class="form-group ">
										<div class="col-md-9">
											<input class="form-control username" name="newuser" type="text"
												placeholder="Sudoer Username" />
										</div>
									</div>
									<div class="form-group ">
										<div class="col-md-9">
											<input class="form-control password" name="newpassword"
												type="password" placeholder="Sudoer Password" />
										</div>
									</div>
									<button type="submit" class="btn btn-primary active-sudo">OK</button>

								</form>

							</div>
						</div>
					</c:if>
					<c:if test="<%=(session.getAttribute(\"sudouser\") != null)%>">
						<!-- Power -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Power Control</h3>
							</div>
							<div class="panel-body">
								<button type="button" class="btn btn-lg btn-danger "
									onclick="location.href='${pageContext.request.contextPath }/shutdown/${server.serverAddress}/${cc }'"
									title="shutdown">
									<i class="glyphicon glyphicon-off"></i>
								</button>
								<button type="button" class="btn btn-lg btn-warning"
									onclick="location.href='${pageContext.request.contextPath }/restart/${server.serverAddress}/${cc }'"
									title="restart">
									<i class="glyphicon glyphicon-repeat"></i>
								</button>
							</div>
						</div>

						<!-- Network Card -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a href="#" data-toggle="collapse" data-target="#network-card-config">Network
										Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i>
									</a>
								</h3>
							</div>
							<div id="network-card-config" class="panel-collapse collapse">
								<div class="panel-body">
									<a class="col-md-4"
										href="${pageContext.request.contextPath }/serviceconfig/nic/interfaces/${server.serverAddress}/${cc}">
										Network Interfaces </a> <a class="col-md-4"
										href="${pageContext.request.contextPath }/serviceconfig/nic/nameservers/${server.serverAddress}/${cc}">
										DNS NameServers... </a> <a class="col-md-4"
										href="${pageContext.request.contextPath }/serviceconfig/nic/edit-file-nic/${server.serverAddress}/${cc}">
										Edit Config File... </a>

								</div>
							</div>
						</div>
						<!-- FTP Service -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a
										href="${pageContext.request.contextPath }/serviceconfig/ftp/${server.serverAddress}/${cc}">FTP
										Server Configuration <i
										class="glyphicon glyphicon-chevron-right pull-right"></i>
									</a>
								</h3>
							</div>

						</div>

						<!-- SSH Service -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a
										href="${pageContext.request.contextPath }/serviceconfig/ssh/${server.serverAddress}/${cc}">SSH
										Server Configuration <i
										class="glyphicon glyphicon-chevron-right pull-right"></i>
									</a>
								</h3>
							</div>

						</div>

						<!-- DHCP Service -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a
										href="${pageContext.request.contextPath }/serviceconfig/dhcp/${server.serverAddress}/${cc}">DHCP
										Server Configuration <i
										class="glyphicon glyphicon-chevron-right pull-right"></i>
									</a>
								</h3>
							</div>
						</div>
						<!-- DNS Bind 9 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a
										<%-- ${pageContext.request.contextPath }/serviceconfig/bind9/${server.serverAddress}/${cc} --%>
										href="#"
										onclick="return alert('Under Construction');">DNS Bind9 Server
										Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i>
									</a>
								</h3>
							</div>
						</div>
						<!-- Apache Service -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a
										<%-- ${pageContext.request.contextPath }/serviceconfig/apache/${server.serverAddress}/${cc} --%>
										href="#"
										onclick="return alert('Under Construction');">Apache Server
										Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i>
									</a>
								</h3>
							</div>
						</div>
					</c:if>
				</div>
				<!-- End Service -->
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>

