<ul class="list-server">
	<% for(int i=0;i<3;i++){ %>
	<li class="server-item col-md-2">
		<a href="#" title="#">
			<i class="fa fa-desktop server-icon"></i>
			<ul class="server-info">
				<li>Name: 	<span>Server DNS</span></li>
				<li>IP: 	<span>192.168.2.10</span></li>
				<li>CPU: 	<span>10%</span></li>
				<li>RAM: 	<span>50%</span></li>
				<li>DISK: 	<span>20%</span></li>
			</ul>
		</a>
		<div class="control-action">
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-danger" onclick="location.href='Shutdown'" title="Shutdown"><i class="glyphicon glyphicon-off"></i></button>
				<button type="button" class="btn btn-warning" onclick="location.href='Restart'" title="Restart"><i class="glyphicon glyphicon-repeat"></i></button>
				<button type="button" class="btn btn-default" onclick="controlMenu()"><i class="glyphicon glyphicon-cog"></i></button>
			</div>
		</div>
	</li>
	<%} %>
	<% for(int i=0;i<2;i++){ %>
	<li class="server-item col-md-2">
		<a href="#" title="#">
			<i class="fa fa-desktop server-icon server-off"></i>
			<ul class="server-info">
				<li>Name: 	<span>Server DNS</span></li>
				<li>IP: 	<span>192.168.2.10</span></li>
				<li>CPU: 	<span>10%</span></li>
				<li>RAM: 	<span>50%</span></li>
				<li>DISK: 	<span>20%</span></li>
			</ul>
		</a>
		<div class="control-action">
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-danger disabled" onclick="location.href='Shutdown'" title="Shutdown"><i class="glyphicon glyphicon-off"></i></button>
				<button type="button" class="btn btn-warning disabled" onclick="location.href='Restart'" title="Restart"><i class="glyphicon glyphicon-repeat"></i></button>
				<button type="button" class="btn btn-default disabled" onclick="controlMenu()"><i class="glyphicon glyphicon-cog"></i></button>
			</div>
		</div>
	</li>
	<%} %>
</ul>