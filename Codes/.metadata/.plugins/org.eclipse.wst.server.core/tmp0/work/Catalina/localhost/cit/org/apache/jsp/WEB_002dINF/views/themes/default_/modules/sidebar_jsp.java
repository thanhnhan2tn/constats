/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-03-21 03:16:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.themes.default_.modules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.edu.cit.model.Server;
import vn.edu.cit.model.User;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	User user = (User) request.getAttribute("user");

      out.write("\r\n");
      out.write("<aside class=\"left-side sidebar-offcanvas\">\r\n");
      out.write("\t<!-- sidebar -->\r\n");
      out.write("\t<section class=\"sidebar\">\r\n");
      out.write("\t\t<!-- Sidebar user panel\r\n");
      out.write("            \t<div class=\"user-panel\">\r\n");
      out.write("            \t//image\r\n");
      out.write("            \t</div>\r\n");
      out.write("        -->\r\n");
      out.write("\t\t<ul class=\"sidebar-menu\">\r\n");
      out.write("\t\t\t<li class=\"list-item active\"><a\r\n");
      out.write("\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fa fa-dashboard\"></i><span>Dashboard</span></a></li>\r\n");
      out.write("\t\t\t");

				if (user.getServers() != null && !user.getServers().isEmpty()) {
									for (Server server : user.getServers()) {
										//check Server status
										if(server.checkStatus()){
			
      out.write("\r\n");
      out.write("\t\t\t<li class=\"list-item\"><a\r\n");
      out.write("\t\t\t\thref=\"{pageContext.request.contextPath }/monitor/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\ttitle=\"#\"><i class=\"fa fa-desktop server-icon\"></i> ");
      out.print(server.getServerAddress());
      out.write("\r\n");
      out.write("\t\t\t\t\t<i style=\"color: green\" class=\"glyphicon glyphicon-ok-circle\"></i></a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t");

				}else{
			
      out.write("\r\n");
      out.write("\t\t\t<li class=\"list-item\"><a\r\n");
      out.write("\t\t\t\thref=\"#\" title=\"#\"><i class=\"fa fa-desktop server-icon\"></i> ");
      out.print(server.getServerAddress());
      out.write("\r\n");
      out.write("\t\t\t\t\t<i style=\"color: red\" class=\"glyphicon glyphicon-ban-circle\"></i></a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t");

				}
					}}
			
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- end sidebar -->\r\n");
      out.write("</aside>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
