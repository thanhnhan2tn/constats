<!-- Add Server Model FOrm -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">Add new server</h4>
		</div>
		<div class="modal-body">
			<form action="addServer" method="POST" role="form">
				<div style="margin-bottom: 25px" class="input-group">
					IP: <input id="ip"
						type="text" class="form-control" name="ip" value=""
						placeholder="IP Address">
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					Root Username: <input id="root-username"
						type="text" class="form-control" name="root-username" value=""
						placeholder="Input username of Root">
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					Root Password: <input id="root-password"
						type="text" class="form-control" name="root-password" value=""
						placeholder="Input root password">
				</div>
				<div style="margin-bottom: 25px" class="input-group">
					SSH Port: <input id="ssh-port"
						type="text" class="form-control" name="ssh-port" value=""
						placeholder="Input SSH Port">
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save changes</button>
		</div>
	</div>
</div>