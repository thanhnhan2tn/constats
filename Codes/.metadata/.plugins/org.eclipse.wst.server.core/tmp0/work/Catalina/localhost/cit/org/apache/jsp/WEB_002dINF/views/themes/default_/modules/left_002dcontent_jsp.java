/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-03-24 05:02:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.themes.default_.modules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.edu.cit.services.UserService;
import vn.edu.cit.model.*;
import org.springframework.data.mongodb.core.*;

public final class left_002dcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.1.4.RELEASE.jar", Long.valueOf(1423281066880L));
    _jspx_dependants.put("/WEB-INF/views/themes/default/modules/addServerForm.jsp", Long.valueOf(1426815377000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1421222476495L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/spring-webmvc-4.1.4.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1419881820000L));
    _jspx_dependants.put("/WEB-INF/views/themes/default/modules/mainContent.jsp", Long.valueOf(1427173358113L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction.release();
    _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.release();
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

      out.write("<aside class=\"right-side\">\r\n");
      out.write("\t<!-- Content Header (Page header) -->\r\n");
      out.write("\t<section class=\"content-header\">\r\n");
      out.write("\t\t<h1>\r\n");
      out.write("\t\t\tDashboard <small>Control panel</small>\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\t\t<div class=\"btn-group btn-add\">\r\n");
      out.write("\t\t\t<button class=\"btn btn-success\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\tdata-target=\"#AddServer\">\r\n");
      out.write("\t\t\t\t<i class=\"glyphicon glyphicon-plus\"></i> Add Server\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- AddServer Modal -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"AddServer\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t<!--  -->\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("<!-- Add Server Model FOrm -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal-dialog\">\r\n");
      out.write("\t<div class=\"modal-content\">\r\n");
      out.write("\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">Add new server</h4>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_spring_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--  End Content Header -->\r\n");
      out.write("\t<!--  Main Content -->\r\n");
      out.write("\t<section class=\"content\">\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	User user = (User) request.getAttribute("user");

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t/*$(document).ready(function() {\r\n");
      out.write("\t\t $(document).ajaxStart(function(){\r\n");
      out.write("\t\t\t $(\".wait\").css(\"display\", \"block\");\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t $(document).ajaxComplete(function(){\r\n");
      out.write("\t\t\t $(\".wait\").css(\"display\", \"none\");\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t$(\".list-server\").ready(function() {\r\n");
      out.write("\t\t\tvar ip = '';\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : 'checkstatus/' + ip + '/' + cc,\r\n");
      out.write("\t\t\t\ttype : 'GET',\r\n");
      out.write("\t\t\t\tdata : {},\r\n");
      out.write("\t\t\t\ttimeout: '30000',\r\n");
      out.write("\t\t\t\tsuccess : function(data, status) {\r\n");
      out.write("\t\t\t\t\tconsole.log(ip+data);\r\n");
      out.write("\t\t\t\t\tif(data == \"true\"){\r\n");
      out.write("\t\t\t\t\t\t$(\".i-server-icon\").css(\"display\", \"block\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"button\").addClass(\"disabled\");\r\n");
      out.write("\t\t\t\t\t\t$(\".dropdown-toggle\").removeClass(\"disabled\");\r\n");
      out.write("\t\t\t\t\t\t$(\".show-server .i-server-icon-off\").css(\"display\", \"block\");\r\n");
      out.write("\t\t\t\t\t\t// em khong noois dduocw cai gia tri\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// vong lap in 2 cai may tinh do dau?\r\n");
      out.write("\t\t\t\t\t\t\t\t// doan code xuat ra html ay??\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t// anh can id gi? id con server trong moi lan lap\r\n");
      out.write("\t\t\t\t\t\t\t\t// adddress la id luon, con id cua mongo nua, nhung e xet address\r\n");
      out.write("\t\t\t\t\t\t\t\t// trong JS lafm sao truyen du lieu dong vao ten cua ID?\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$(\"\").css(\"display\", \"block\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}); */\r\n");
      out.write("\r\n");
      out.write("\t$(document).ajaxStart(function() {\r\n");
      out.write("\t\t$(\".wait\").css(\"display\", \"block\");\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\tvar listServer = $('.server-listed');\r\n");
      out.write("\r\n");
      out.write("\t\tfunction check_server(index) {\r\n");
      out.write("\t\t\tif (!listServer[index]) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar data = $(listServer[index]).attr('data-id');\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : 'checkstatus/' + data + '/' + cc,\r\n");
      out.write("\t\t\t\ttype : 'GET',\r\n");
      out.write("\t\t\t\tdata : {},\r\n");
      out.write("\t\t\t\ttimeout : '30000',\r\n");
      out.write("\t\t\t\tsuccess : function(data, status) {\r\n");
      out.write("\t\t\t\t\tdata = $.trim(data);\r\n");
      out.write("\t\t\t\t\t$(listServer[index]).find(\".wait\").css(\"display\", \"none\");\r\n");
      out.write("\t\t\t\t\tif (data == 'false') {\r\n");
      out.write("\t\t\t\t\t\t$(listServer[index]).find(\".i-server-icon\").remove;\r\n");
      out.write("\t\t\t\t\t\t$(listServer[index]).find(\".i-server-icon-off\").css({\r\n");
      out.write("\t\t\t\t\t\t\t\"display\" : \"block\"\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$(listServer[index]).find(\".i-server-icon-off\").remove;\r\n");
      out.write("\t\t\t\t\t\t$(listServer[index]).find(\".i-server-icon\").css({\r\n");
      out.write("\t\t\t\t\t\t\t\"display\" : \"block\"\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$(listServer[index]).find(\".disabled\").removeClass(\"disabled\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}).always(function() {\r\n");
      out.write("\t\t\t\tcheck_server(++index);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (listServer.length > 0) {\r\n");
      out.write("\t\t\tcheck_server(0);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// ok e chay thu\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<ul class=\"list-server\">\r\n");
      out.write("\t");

		if (user.getServers() != null && !user.getServers().isEmpty()) {
			for (Server server : user.getServers()) {
			Boolean check = false;
		//check Server status
		//if(server.checkStatus()){
	
      out.write("\r\n");
      out.write("\t<li class=\"server-item col-md-2 server-listed\"\r\n");
      out.write("\t\tdata-id=\"");
      out.print(server.getServerAddress());
      out.write("\"\r\n");
      out.write("\t\tid=\"server-");
      out.print(server.getServerAddress());
      out.write("\">\r\n");
      out.write("\t\t<div style=\"display: block\">\r\n");
      out.write("\t\t\t<div class=\"server-icon\">\r\n");
      out.write("\t\t\t\t<span class=\"wait\" style=\"display: none: text-align:center\">\r\n");
      out.write("\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\tsrc=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("\t\t\t\t</span> <a class=\"server-monitor-url\"\r\n");
      out.write("\t\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/services/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\ttitle=\"#\"> <i class=\"fa fa-desktop i-server-icon\"\r\n");
      out.write("\t\t\t\t\tstyle=\"display: none\"></i> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fa fa-desktop server-off i-server-icon-off\"\r\n");
      out.write("\t\t\t\t\tstyle=\"display: none\"></i>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"control-action\">\r\n");
      out.write("\t\t\t\t<div class=\"btn-group\" role=\"group\" aria-label=\"...\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-danger disabled\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shutdown/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"shutdown\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"glyphicon glyphicon-off\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-warning disabled\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/restart/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"restart\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"glyphicon glyphicon-repeat\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\" role=\"group\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-toggle=\"dropdown\" aria-expanded=\"false\" id=\"services-config\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-cog\"></i>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu config\" role=\"menu\"\r\n");
      out.write("\t\t\t\t\t\t\tarea-labelledby=\"services-config\">\r\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\" class=\"dropdown-header\">..:ACTION:..</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/editserver/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Edit...</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/removeserver/");
      out.print(server.getServerAddress());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Remove...</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- //control action -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- //Showw server  -->\r\n");
      out.write("\t</li>\r\n");
      out.write("\t");

		}}
	
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_spring_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_spring_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_spring_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fform_005f0.setParent(null);
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(14,2) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setAction("addserver");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(14,2) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setMethod("POST");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(14,2) null
    _jspx_th_spring_005fform_005f0.setDynamicAttribute(null, "role", "form");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(14,2) name = commandName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setCommandName("Server");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(14,2) null
    _jspx_th_spring_005fform_005f0.setDynamicAttribute(null, "class", "form-horizontal");
    int[] _jspx_push_body_count_spring_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fform_005f0 = _jspx_th_spring_005fform_005f0.doStartTag();
      if (_jspx_eval_spring_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<div class=\"modal-body\">\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t<label for=\"ip\" class=\"col-md-3 control-label\">IP: *</label>\r\n");
          out.write("\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f0(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t<label for=\"username\" class=\"col-md-3 control-label\">Root\r\n");
          out.write("\t\t\t\t\t\tUsername: *</label>\r\n");
          out.write("\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f1(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t<label for=\"password\" class=\"col-md-3 control-label\">Password:\r\n");
          out.write("\t\t\t\t\t\t*</label>\r\n");
          out.write("\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_spring_005fpassword_005f0(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t<label for=\"ssh-port\" class=\"col-md-3 control-label\">SSH\r\n");
          out.write("\t\t\t\t\t\tPort: *</label>\r\n");
          out.write("\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f2(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div style=\"display: none\" id=\"signup-err\"\r\n");
          out.write("\t\t\t\t\tclass=\"alert alert-danger col-sm-12 signup-err\"></div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t\t<div class=\"modal-footer\">\r\n");
          out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
          out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_spring_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_spring_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction.reuse(_jspx_th_spring_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005finput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(21,6) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f0.setPath("serverAddress");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(21,6) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "class", "ip form-control");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(21,6) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "name", "ip");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(21,6) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "placeholder", "IP Address");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(21,6) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "required", "required");
    int[] _jspx_push_body_count_spring_005finput_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005finput_005f0 = _jspx_th_spring_005finput_005f0.doStartTag();
      if (_jspx_th_spring_005finput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005finput_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005finput_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005finput_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005finput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f1 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(29,6) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f1.setPath("serverUsername");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(29,6) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "class", "username form-control");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(29,6) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "name", "username");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(29,6) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "placeholder", "Username have root permision login to Server");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(29,6) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "required", "required");
    int[] _jspx_push_body_count_spring_005finput_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005finput_005f1 = _jspx_th_spring_005finput_005f1.doStartTag();
      if (_jspx_th_spring_005finput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005finput_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005finput_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005finput_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fpassword_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:password
    org.springframework.web.servlet.tags.form.PasswordInputTag _jspx_th_spring_005fpassword_005f0 = (org.springframework.web.servlet.tags.form.PasswordInputTag) _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.PasswordInputTag.class);
    _jspx_th_spring_005fpassword_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fpassword_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(39,6) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fpassword_005f0.setPath("serverPassword");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(39,6) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "class", "password form-control");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(39,6) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "name", "password");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(39,6) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "placeholder", "Input your server user password");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(39,6) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "required", "required");
    int[] _jspx_push_body_count_spring_005fpassword_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fpassword_005f0 = _jspx_th_spring_005fpassword_005f0.doStartTag();
      if (_jspx_th_spring_005fpassword_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fpassword_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fpassword_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fpassword_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.reuse(_jspx_th_spring_005fpassword_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005finput_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f2 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(48,6) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f2.setPath("port");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(48,6) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "class", "port form-control");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(48,6) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "placeholder", "SSH Port");
    // /WEB-INF/views/themes/default/modules/addServerForm.jsp(48,6) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "required", "required");
    int[] _jspx_push_body_count_spring_005finput_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005finput_005f2 = _jspx_th_spring_005finput_005f2.doStartTag();
      if (_jspx_th_spring_005finput_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005finput_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005finput_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005finput_005f2.doFinally();
      _005fjspx_005ftagPool_005fspring_005finput_0026_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/themes/default/modules/mainContent.jsp(110,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/themes/default/images/loading.gif");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
