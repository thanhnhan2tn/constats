/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.61
 * Generated at: 2015-05-11 11:51:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.themes.default_.modules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.nic.Eth;
import model.nic.Nic;

public final class services_002dssh_002dfile_002dcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<aside class=\"right-side\">\r\n");
      out.write("\t<!-- Content Header (Page header) -->\r\n");
      out.write("\t<section class=\"content-header\">\r\n");
      out.write("\t\t<h1>\r\n");
      out.write("\t\t\tNetword Interface Cards Config :<small> (");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.serverAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(")</small>\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--  End Content Header -->\r\n");
      out.write("\t<!--  Main Content -->\r\n");
      out.write("\t<section class=\"content\">\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t<div class=\"clear-fix\">\r\n");
      out.write("\t\t\t\t<div style=\"display: none ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${display}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"login-alert\"\r\n");
      out.write("\t\t\t\t\tclass=\"alert alert-danger col-sm-12\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div style=\"display: none ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${displaysuccess}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"login-alert\"\r\n");
      out.write("\t\t\t\t\tclass=\"alert alert-success col-sm-12\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<form\r\n");
      out.write("\t\t\t\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/serviceconfig/ssh/editfile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.serverAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\tclass=\"form-horizontal\" method=\"POST\">\r\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t<b>Edit Network Interface Config File</b>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"cc\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"30\" name=\"sshconfig\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sshconfig }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!--  End Panel -->\r\n");
      out.write("\t\t\t\t<div class=\"panel-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\" onclick=\"window.history.back();\">Back</button>\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-primary\" type=\"submit\" >Save</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--  End Main Content -->\r\n");
      out.write("</aside>");
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
