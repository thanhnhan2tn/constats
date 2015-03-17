<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
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
		<spring:form action="addserver" method="POST" role="form"
			commandName="Server" class="form-horizontal">
			<div class="modal-body">

				<div class="form-group">
					<label for="ip" class="col-md-3 control-label">IP: *</label>
					<div class="col-md-9">
						<spring:input path="serverAddress" class="ip form-control"
							name="ip" placeholder="IP Address" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="username" class="col-md-3 control-label">Root
						Username: *</label>
					<div class="col-md-9">
						<spring:input path="serverUsername" class="username form-control"
							name="username"
							placeholder="Username have root permision login to Server"
							required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password:
						*</label>
					<div class="col-md-9">
						<spring:password path="serverPassword"
							class="password form-control" name="password"
							placeholder="Input your server user password" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="ssh-port" class="col-md-3 control-label">SSH
						Port: *</label>
					<div class="col-md-9">
						<spring:input path="port" class="port form-control"
							placeholder="SSH Port" required="required" />
					</div>
				</div>
				<div style="display: none" id="signup-err"
					class="alert alert-danger col-sm-12 signup-err"></div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save changes</button>
			</div>
		</spring:form>
	</div>
</div>