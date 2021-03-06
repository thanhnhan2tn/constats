<%@page import="vn.edu.cit.controller.Calculator"%>
<%@page import="vn.edu.cit.model.User"%>
<%
	User user = (User) session.getAttribute("user");
%>
<section class="right-side">
	<section class="content-header">
		<h1>Hello ${user.firstName }!</h1>
	</section>
	<section class="content">
		<form action="${pageContext.request.contextPath }/edit-profile/${cc }"
			method="POST">
			<table class="table table-bordered">

				<tr>
					<td class="col-md-3 info">G-Avatar:</td>
					<td class="col-md-9" style="text-align: center"><img
						src="http://www.gravatar.com/avatar/<%=Calculator.md5Hex(user.getEmail())%>"><br />
						This is using Gravatar, you can change your Avatar in <a
						href="https://vi.gravatar.com/">Gravatar</a></td>
				</tr>
				<tr>
					<td class="col-md-3 info">First Name:</td>
					<td class="col-md-9"><input class="form-control" name="firstName" value="${user.firstName }"/></td>
				</tr>
				<tr>
					<td class="col-md-3 info">Last Name:</td>
					<td class="col-md-9"><input class="form-control" name="lastName" value="${user.lastName }" /></td>
				</tr>
				<tr>
					<td class="col-md-3 info">Email:</td>
					<td class="col-md-9">${user.email }</td>
				</tr>
				<tr>
					<td class="col-md-3 info">Password:</td>
					<td class="col-md-9"><input class="form-control" type="password" name="passWord" placeholder="Keep it blank to use the current password" /></td>
				</tr>
				<tr>
					<td class="col-md-3 info">Phone:</td>
					<td class="col-md-9"><input class="form-control" type="tel" name="sdt" value="${user.sdt }" /></td>
				</tr>
				<tr>
					<td class="col-md-3 info">Number of server(s):</td>
					<td class="col-md-9"><a href="${pageContext.request.contextPath }/">${user.servers.size() }</a></td>
				</tr>
				
			</table>
			<input class="btn btn-primary" type="submit" value="Save">
		</form>
	</section>
</section>