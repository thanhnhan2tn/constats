<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Dashboard <small>Control panel</small>
		</h1>
		<div class="btn-group btn-add">
			<button class="btn btn-success" data-toggle="modal"
				data-target="#AddServer">
				<i class="glyphicon glyphicon-plus"></i> Add Server
			</button>
		</div>
		<!-- AddServer Modal -->
		<div class="modal fade" id="AddServer" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<!--  -->
			<tiles:insertAttribute name="addServerForm" />
		</div>
	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<tiles:insertAttribute name="mainContent" />
		</div>
	</section>
	<!--  End Main Content -->
</aside>