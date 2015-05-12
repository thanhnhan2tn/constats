<%@page import="vn.edu.cit.services.UserService"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="org.springframework.data.mongodb.core.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <script type="text/javascript" src="<c:url value='/resources/themes/default/js/Queue.js'/>"></script> --%>
<script src="http://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/stock/modules/exporting.js"></script>

<script>
var ip = "${server.serverAddress}";
var ramArray=[0];
var cpuArray=[0];

$("#monitoring").ready(function () {
loadRamCpu();
function loadRamCpu() {
	 // getram
	  $.ajax({
         url: '${pageContext.request.contextPath}/getram/' + ip + '/' + cc
         , type: 'GET'
         , data1: {}
         //, timeout: '10000'
         , error: function () {
       	 // $("td.ram").html("Can not get RAM info of this server...");
         }, // neu load thnh cong
         success: function (data1, status) {
          
          if ((data1[0] == "null") || (data1[0] == "")) {
        	
       	   if(ramArray.length>10){
      	   		ramArray.shift();
      	   		}
          		ramArray.push(0);
       	   //$("td.ram").html("Can not get RAM info of this server...");
           }else{
         	  var ramfree = parseFloat(data1[0]) / 1024;
               var ramtotal = parseFloat(data1[1]) / 1024;
               var ramuse = ramtotal-ramfree;
               var ram = (ramuse/ramtotal)*100;
               if(ramArray.length>10){
       	   		ramArray.shift();
       	   	}
           	ramArray.push(parseInt(ram)+Math.floor((Math.random() * 9) + 1));
            $("td.ram").html(ram.toFixed(1)+"% ("+ramuse.toFixed(1)+"/"+ramtotal.toFixed(1)+" MB)");
           
          	setInterval(loadRamCpu(),5000); //10s
           }
           }});
     //load CPU
     $.ajax({
         url: '${pageContext.request.contextPath}/getcpu/' + ip + '/' + cc
         , type: 'GET'
         , cpu: {}
         , async: true
         , timeout: '7000'
         , error: function () {
         	 // $("span.textcpu").text("Can not get CPU info of this server...");
           }
         , // neu load thnh cong
         success: function (cpu, status) {
           //data = $.trim(data);
          if ((cpu == "null") || (cpu == "")) {
       	   	if(cpuArray.length>10){
       	   		cpuArray.shift();
       	   	}
          		cpuArray.push(0);
           }else{
           	if(cpuArray.length>10){
       	   		cpuArray.shift();
       	   	}
           	cpuArray.push(parseInt(cpu)+Math.floor((Math.random() * 5) + 0));
           	$("span.textcpu").text("");
           	$("span.cpu-value").removeClass("hidden");
           	$("span.cpu-value").css("width", parseFloat(cpu).toFixed(1)+"%");
         	  	$("span.cpu-value").text(parseFloat(cpu).toFixed(1)+"%");
           }}});
}	  
});

/* JS load chart*/
$(function () {

    Highcharts.setOptions({
        global : {
            useUTC : false
        }
    });

    // Create the chart
    $('#cpu').highcharts({
        chart : {
        	type: 'spline',
            events : {
                load : function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = cpuArray[cpuArray.length-1];
                        series.addPoint([x, y], true, true);
                    }, 5000);
                }
            }
        },

        xAxis: {
        	title: {
                text: 'Time'
            },
        	type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: 'Used (%)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },

        title : {
            text : 'CPU data'
        },

        exporting: {
            enabled: false
        },

        series : [{
            name : '% CPU',
            data : (function () {
                // generate an array of random data
                var data = [], time = (new Date()).getTime(), i;

                for (i = -19; i <= 0; i ++) {
                    data.push([time + i * 5000, Math.round(0)]);
                }
                return data;
            }())
        }]
    });
// draw chart for RAMs
      $('#ram').highcharts({
                chart: {
                    type: 'spline',
                    //animation: Highcharts.svg, // don't animate in old IE
                    marginRight: 10,
                    events: {
                        load: function () {

                            // set up the updating of the chart each second
                            var series = this.series[0];
                            setInterval(function () {
                                var x = (new Date()).getTime(), // current time
                                    y = ramArray[ramArray.length-1]
                                series.addPoint([x, y], true, true);
                            }, 5000);
                        }
                    }
                },
                title: {
                    text: 'RAM data'
                },
                xAxis: {
                	title: {
                        text: 'Time'
                    },
                    type: 'datetime',
                    tickPixelInterval: 150
                },
                yAxis: {
                    title: {
                        text: 'Used (%)'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' +this.y +" "+ this.series.name + '</b><br/>' +
                            Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '%<br/>' +
                            Highcharts.numberFormat(this.y, 0);
                    }
                },
                legend: {
                    enabled: true
                },
                exporting: {
                    enabled: false
                },
                series: [{
                    name: '% RAM Used',
                    data: (function () {
                        // generate an array of random data
                        var data = [],
                            time = (new Date()).getTime(),
                            i;

                        for (i = -19; i <= 0; i += 1) {
                            data.push({
                                x: time + i * 5000,
                                y: Math.round(0)
                            });
                        }
                        return data;
                    }())
                }]
            });
});

/* JS Load infomation of Server*/
$(document)
.ajaxStart(function () {
  $(".wait")
    .css("display", "block");
});
//loading ServerInfomation

$("#serverinfomation").ready(function () {
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
      html += '<tr><td>Memory:</td><td class="ram">Loading...</td></tr>';
      html += '<tr><td>CPU Usage:</td><td class="cpu"><span class="textcpu"></span><div class="progress"><div class="progress-bar progress-bar-green cpu-value" style="width: ' + parseFloat(data.cpu_usage) +'%;"><span class="cpu-value">'+data.cpu_usage + '%</span></div></div></td></tr>';
      html += '<tr><td>Cpu Loadaverage:</td><td class="cpu-load"><div class="sparkline" data-type="pie" data-offset="90" data-width="100px" data-height="100px">' + data.cpu_loadaverage + '</div></td></tr></table>';
      //	alert(html);
      $(".serverinfomation")
        .html(html);
      $(".wait")
        .css("display", "none");
      
    }
  });
	//end set time load
	
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
	<section class="content-header" id="serverinfo">
		<h1>
			Control Services Server<small> (${server.serverAddress})</small>
		</h1>
	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content panel-group" id="accordion">
			<ul class="nav nav-tabs" id="serverTab">
				<li class="${de }active"><a data-toggle="tab" href="#sysinfo">System
						Infomation</a></li>
				<li class="${graphactive }"><a data-toggle="tab" href="#monitor">Ram - CPU using</a></li>
				<li class="${configactive }"><a data-toggle="tab" href="#services">Service Configuation</a></li>
			</ul>
			<hr>
			<div class="tab-content">
				<div class="clear-fix">
				<div style="display: none ${display}" id="login-alert"
					class="alert alert-danger col-sm-12">${message}</div>
				<div style="display: none ${displaysuccess}" id="login-alert"
					class="alert alert-success col-sm-12">${message}</div>
				</div>
				<!-- Tabs Monitor Config -->
				<div class="tab-pane ${de }active" id="sysinfo">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">System Infomation</h3>
						</div>
						<div id="">
							<div class="panel-body">
								<div id="serverinfomation" class="serverinfomation">
									<span class="wait"
										style="display: none: text-align:center; displar: block; margin:10px 50%;">
										<img
										src="<c:url value='/resources/themes/default/images/loading.gif'/>" />
									</span>

								</div>
							</div>
							<!-- // Panel Body -->
						</div>
					</div>

					
				</div>
				
				<!--  tab monitor -->
				<div class="tab-pane" id="monitor">
					<div class="panel panel-default" id="info-monitor">
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
											<div id="cpu" style="height: 400px; min-width: 710px"></div>
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
											<div id="ram" style="height: 400px; min-width: 710px"></div>
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
				
				<div class="tab-pane ${configactive }" id="services">
				
					<c:if test="<%=(session.getAttribute(\"sudouser\") == null)%>">
						<div class="panel panel-default">
							<div class="panel-heading">
								
							</div>
							<div class="panel-body">
							<div class="alert alert-warning">
							For using this action, please input your server SUDOER user, it is required to using to config any services to server. <b/>It will not save.
							</div>
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
							<center>
								<a type="button" class="btn btn-lg btn-danger "
									onclick="return confirmAction()" href='${pageContext.request.contextPath }/services/shutdown/${server.serverAddress}/${cc }'
									title="Stop Server">
									<i class="glyphicon glyphicon-off"></i>
								</a>
								<a type="button" class="btn btn-lg btn-warning"
									onclick="return confirmAction()" href='${pageContext.request.contextPath }/services/restart/${server.serverAddress}/${cc }'
									title="ReBoot Server">
									<i class="glyphicon glyphicon-repeat"></i>
								</a>
								</center>
							</div>
						</div>

						<!-- Network Card -->
						<div class="panel panel-default" id="network-card">
							<div class="panel-heading">
								<h3 class="panel-title">
									<a href="#network-card" data-toggle="collapse" data-target="#network-card-config">Network
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
<!-- 						DNS Bind 9 -->
<!-- 						<div class="panel panel-default disabled"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 								<h3 class="panel-title"> -->
<!-- 									<a -->
<%-- 										${pageContext.request.contextPath }/serviceconfig/bind9/${server.serverAddress}/${cc} --%>
<!-- 										href="#" -->
<!-- 										onclick="return alert('Under Construction');">DNS Bind9 Server -->
<!-- 										Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i> -->
<!-- 									</a> -->
<!-- 								</h3> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						Apache Service -->
<!-- 						<div class="panel panel-default disabled"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 								<h3 class="panel-title"> -->
<!-- 									<a -->
<%-- 										${pageContext.request.contextPath }/serviceconfig/apache/${server.serverAddress}/${cc} --%>
<!-- 										href="#" -->
<!-- 										onclick="return alert('Under Construction');">Apache Server -->
<!-- 										Configuration <i class="glyphicon glyphicon-chevron-down pull-right"></i> -->
<!-- 									</a> -->
<!-- 								</h3> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</c:if>
				</div>
				<!-- End Service -->
			</div>
		</div>
	</section>
	<!--  End Main Content -->
</aside>

