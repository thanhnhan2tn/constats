<%@page import="vn.edu.cit.dao.UserDAOImpl"%>
<%@page import="vn.edu.cit.dao.UserDAO"%>
<%@page import="vn.edu.cit.model.*"%>
<%@page import="vn.edu.cit.services.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//UserService userService = new UserService();
	// 	UserDAOImpl userDAO = new UserDAOImpl();
	// 	String username = (String) session.getAttribute("username");
%>
<a href="${pageContext.request.contextPath}/" class="logo">ConStats</a>
<!-- Header Navbar -->
<nav class="navbar navbar-static-top" role="navigation">
	<!-- toggle button -->
	<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
		role="button"> <span class="sr-only">Sidebar</span> <span class="icon-bar"></span>
	</a>
	<div class="navbar-right">
		<ul class="nav navbar-nav">
			<!-- li message 
			<li class="dropdown messages-menu"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> <i class="fa fa-envelope"></i> <span
					class="label label-success">4</span>
			</a>
				<ul class="dropdown-menu">
					<li class="header">You have 4 Message</li>
					<li>
						<div
							style="position: relative; overflow: hidden; width: auto; height: 200px;"
							class="slimScrollDiv">
							<ul style="overflow: hidden; width: 100%; height: 200px;" class="menu">

							</ul>
							<div
								style="background: none repeat scroll 0% 0% rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 0px; z-index: 99; right: 1px; height: 156.863px;"
								class="slimScrollBar"></div>
							<div
								style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; background: none repeat scroll 0% 0% rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"
								class="slimScrollRail"></div>
						</div>
					</li>
					<li class="footer"><a href="#">View all</a></li>

				</ul></li>
			end li message -->

			<!-- li user menu -->
			<li class="dropdown user user-menu">
				<!--  Da dang nhap --> <a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> <i class="glyphicon glyphicon-user"></i> <span>${user.getFirstName()}
						${user.getLastName()}<i class="caret"></i>
				</span>
			</a>
				<ul class="dropdown-menu">
					<!-- User image -->
					<li class="user-header bg-light-blue"><img
						src="<c:url value='/resources/themes/default/images/avatar.png'/>"
						class="img-circle" alt="User Image" />
						<p>${user.getFirstName()}${user.getLastName()}
							<!-- 							<small>User </small> -->
						</p></li>

					<!-- Menu Footer-->
					<li class="user-footer">
						<div class="pull-left">
							<a href="${pageContext.request.contextPath}/profile/${cc}"
								class="btn btn-default btn-flat">Profile</a>
						</div>
						<div class="pull-right">
							<a href="${pageContext.request.contextPath}/signout"
								class="btn btn-default btn-flat">Sign out</a>
						</div>
					</li>
				</ul> <!-- Da dang nhap -->
			</li>
			<!-- end li user menu -->
		</ul>
		<!-- end ul nav menu -->
	</div>
</nav>

