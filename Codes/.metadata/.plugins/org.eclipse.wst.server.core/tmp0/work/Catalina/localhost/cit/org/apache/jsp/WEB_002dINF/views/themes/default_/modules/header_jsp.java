/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-04-03 13:07:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.themes.default_.modules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.edu.cit.dao.UserDAOImpl;
import vn.edu.cit.dao.UserDAO;
import vn.edu.cit.model.*;
import vn.edu.cit.services.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1421222476495L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//UserService userService = new UserService();
	// 	UserDAOImpl userDAO = new UserDAOImpl();
	// 	String username = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\" class=\"logo\">ConStats</a>\r\n");
      out.write("<!-- Header Navbar -->\r\n");
      out.write("<nav class=\"navbar navbar-static-top\" role=\"navigation\">\r\n");
      out.write("\t<!-- toggle button -->\r\n");
      out.write("\t<a href=\"#\" class=\"navbar-btn sidebar-toggle\" data-toggle=\"offcanvas\"\r\n");
      out.write("\t\trole=\"button\"> <span class=\"sr-only\">Sidebar</span> <span\r\n");
      out.write("\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<div class=\"navbar-right\">\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t<!-- li message -->\r\n");
      out.write("\t\t\t<li class=\"dropdown messages-menu\"><a href=\"#\"\r\n");
      out.write("\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fa fa-envelope\"></i> <span class=\"label label-success\">4</span>\r\n");
      out.write("\t\t\t</a> <!-- ul message -->\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t<li class=\"header\">You have 4 Message</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"position: relative; overflow: hidden; width: auto; height: 200px;\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"slimScrollDiv\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul style=\"overflow: hidden; width: 100%; height: 200px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"menu\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background: none repeat scroll 0% 0% rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 0px; z-index: 99; right: 1px; height: 156.863px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"slimScrollBar\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; background: none repeat scroll 0% 0% rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"slimScrollRail\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"footer\"><a href=\"#\">View all</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul> <!-- end ul message --></li>\r\n");
      out.write("\t\t\t<!-- end li message -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- li user menu -->\r\n");
      out.write("\t\t\t<li class=\"dropdown user user-menu\">\r\n");
      out.write("\t\t\t\t<!--  Da dang nhap --> <a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"dropdown\"> <i class=\"glyphicon glyphicon-user\"></i>\r\n");
      out.write("\t\t\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFirstName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getLastName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<i\r\n");
      out.write("\t\t\t\t\t\tclass=\"caret\"></i></span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t<!-- User image -->\r\n");
      out.write("\t\t\t\t\t<li class=\"user-header bg-light-blue\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"img-circle\" alt=\"User Image\" />\r\n");
      out.write("\t\t\t\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getFirstName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.getLastName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t<small>User </small> -->\r\n");
      out.write("\t\t\t\t\t\t</p></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- Menu Footer-->\r\n");
      out.write("\t\t\t\t\t<li class=\"user-footer\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/profile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-default btn-flat\">Profile</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/signout\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"btn btn-default btn-flat\">Sign out</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul> <!-- Da dang nhap -->\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<!-- end li user menu -->\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<!-- end ul nav menu -->\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>\r\n");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/themes/default/modules/header.jsp(59,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/themes/default/images/avatar.png");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
