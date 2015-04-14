<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="vn.edu.cit.model.Server"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="model.ftp.*"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			FTP Service Config :<small> (${server.serverAddress})</small>
		</h1>
	</section>

	<!--  End Content Header -->
	<!--  Main Content -->
	<section class="content">
		<div class="main-content">
			<%
				Ftp ftp = (Ftp) request.getAttribute("Ftp");
				if (ftp != null) {
			%>
			
			<form:form id="ftp-config-form1" modelAttribute="Ftp"
				action="${pageContext.request.contextPath }/serviceconfig/ftp/save/${server.serverAddress}/${cc }"
				class="form-horizontal" method="POST">
				<input type="hidden" name="cc" value="${cc }">
				<div class="panel panel-default eth">
					<div class="panel-body">
						<div class="form-group">
							<label class="col-md-4">Listen: *</label>
							<div class="col-md-3 form-groups">
								<label for="yes"> Yes</label>
								<form:radiobutton path="listen" class="" name="listen" id="yes"
									value="yes" required="required" />
								<label for="no"> No</label>
								<form:radiobutton path="listen" class="" name="listen" id="no"
									value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Anonymous: *</label>
							<div class="col-md-3 form-groups">
								<label for="anony-yes"> Enable</label>
								<form:radiobutton path="anonymous_enable" name="anonymous"
									id="anony-yes" value="yes" required="required" />
								<label for="anony-no"> Disable</label>
								<form:radiobutton path="anonymous_enable" name="anonymous" id="anony-no"
									value="no" required="required" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4">Local: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="local_enable" name="local_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="local_enable" name="local_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Write: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="write_enable" name="write_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="write_enable" name="write_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Anonymous Upload: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="anon_upload_enable" name="anon_upload_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="anon_upload_enable" name="anon_upload_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Anonymous Make Dir Write: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="anon_mkdir_write_enable" name="anon_mkdir_write_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="anon_mkdir_write_enable" name="anon_mkdir_write_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Connect from port 20?: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Yes</label>
								<form:radiobutton path="connect_from_port_20" name="connect_from_port_20"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> No</label>
								<form:radiobutton path="connect_from_port_20" name="connect_from_port_20"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Deny email: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="deny_email_enable" name="deny_email_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="deny_email_enable" name="deny_email_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Chroot Local user: *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="chroot_local_user" name="chroot_local_user"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="chroot_local_user" name="chroot_local_user"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Chroot List : *</label>
							<div class="col-md-3 form-groups">
								<label for="local-yes"> Enable</label>
								<form:radiobutton path="chroot_list_enable" name="chroot_list_enable"
									id="local-yes" value="yes" required="required" />
								<label for="local-no"> Disable</label>
								<form:radiobutton path="chroot_list_enable" name="chroot_list_enable"
									id="local-no" value="no" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Chroot List File: *</label>
							<div class="col-md-3 form-groups">
								<form:input path="chroot_list_file"  required="required" />
							</div>
						</div>

					</div>
				</div>
				<form:button type="submit" class="btn btn-primary">Save</form:button>
				<button class="btn btn-default" onclick="return history:back()">Back</button>
			</form:form>
			
			<%
				} else {
			%>
			<div class="panel-body">
				<a class="col-md-4"
					href="${pageContext.request.contextPath }/serviceconfig/ftpinstall/${server.serverAddress}/${cc}">
					Click here to Install VSFTPD Service..</a>
			</div>
			<%
				}
			%>
		</div>
	</section>
	<!--  End Main Content -->
</aside>