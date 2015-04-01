<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Copy command to your Server</h1>

	</section>
	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<div class="">
				You should Enable Root login to server with SSH
				sudo apt-get install nano && sudo nano /etc/ssh/sshd_config
				
				Find "PermitRootLogin without-password. " change to "PermitRootLogin yes"
				Find "PasswordAuthentication no" change to "PasswordAuthentication yes"
				
				sudo service ssh restart
			</div>
			<div class="form-group"></div>
			<textarea rows="10" cols="100">${text }</textarea>
		</div>
		<a class="btn btn-default btn-flat" href="${pageContext.request.contextPath}/">OK</a>
	</section>
</aside>