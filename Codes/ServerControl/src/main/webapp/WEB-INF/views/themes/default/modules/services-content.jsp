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
		<div class="main-content">
			<ul>
				<li><a
					href="${pageContext.request.contextPath }/serviceconfig/nic/${server.serverAddress}/${cc}">
						NetwordCard... </a></li>
				<li><a
					href="${pageContext.request.contextPath }/serviceconfig/dns/${server.serverAddress}/${cc}">
						DNS Service... </a></li>
			</ul>

		</div>
	</section>
	<!--  End Main Content -->
</aside>
