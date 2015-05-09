<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="page-header">Admin Dashboard</h1>
<h2 class="sub-header">User Manager</h2>
<div class="panel panel-body">
<div class="">
<div class="col-lg-6 col-xs-6">
	<!-- small box -->
	<div class="small-box bg-yellow">
		<div class="inner">
			<h3>${users.size() }</h3>
			<p>Users</p>
		</div>
		<div class="icon">
			<i class="glyphicon glyphicon-user"></i>
		</div>

	</div>
</div>
<!-- ./col -->
<div class="col-lg-6 col-xs-6">
	<!-- small box -->
	<div class="small-box bg-red">
		<div class="inner">
			<h3>${countserver }</h3>
			<p>Servers</p>
		</div>
		<div class="icon">
			<i class="glyphicon glyphicon-tasks"></i>
		</div>

	</div>
</div>
<!-- ./col -->
<div class="clear-fix"></div>
</div>

</div>
<hr />
<div class="box">
<div class="box box-body">
	<table id="data-table" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Number of Server</th>
				<th>Type</th>
				<th>Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="u" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${u.firstName } ${u.lastName }</td>
					<td>${u.email }</td>
					<td>${u.servers.size() }</td>
					<td><c:if test="${u.role<1}">Banned</c:if>
						<c:if test="${u.role==1}">Member</c:if>
						<c:if test="${u.role==2}">Admin</c:if>
					</td>
					<td>${u.date }</td>
					<td><a href="${pageContext.request.contextPath}/admincp/edituser/${u.email }/${cc}" ><i class=" glyphicon glyphicon-edit"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
<script>
	$(document).ready(function() {
		$('#data-table').dataTable();
	});
</script>