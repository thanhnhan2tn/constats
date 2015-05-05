<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="page-header">Admin Dashboard</h1>
<h2 class="sub-header">User Manager</h2>
<hr />
<div class=>
	<table id="data-table" class="table table-bordered table-hover" >
		 <thead>
		<tr>
			<th>No.</th><th>Name</th><th>Email</th><th>Number of Server</th><th>Active</th><th>Date</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${users }" var="u" varStatus="status">
		<tr>
			<td>${status.index+1}</td><td>${u.firstName } ${u.lastName }</td><td>${u.email }</td><td>${u.servers.size() }</td>
			<td><c:if test="${u.role<1}">No</c:if><c:if test="${u.role>=1}">Yes</c:if></td><td>10/01/2015</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script>
$(document).ready(function() {
    $('#data-table').dataTable();
} );
</script>