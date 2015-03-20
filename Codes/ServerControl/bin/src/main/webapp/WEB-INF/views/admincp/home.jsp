<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	String action = (String) request.getParameter("action");
	if (action != null) {
		if (action.equals("usermanager") || action == "usermanager") {
%>
<tiles:insertDefinition name="admin.usermanager" />
<%
	}
	} else {
%>
<tiles:insertDefinition name="admin.home" />
<%
	}
%>

