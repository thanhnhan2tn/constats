/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-03-28 02:12:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nic_002dedit_002dconfig_002dfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/tiles-jsp-3.0.5.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1411317130000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1421222476495L));
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.5.jar", Long.valueOf(1425383764292L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

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
      response.setContentType("text/html; charset=UTF-8");
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
      if (_jspx_meth_tiles_005finsertDefinition_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("\tSpring MVC Template with Tiles\r\n");
      out.write("\tSource: https://www.youtube.com/watch?v=hbM8tccsIQM\r\n");
      out.write("-->");
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

  private boolean _jspx_meth_tiles_005finsertDefinition_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertDefinition
    org.apache.tiles.jsp.taglib.InsertDefinitionTag _jspx_th_tiles_005finsertDefinition_005f0 = (new org.apache.tiles.jsp.taglib.InsertDefinitionTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertDefinition_005f0);
    _jspx_th_tiles_005finsertDefinition_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/views/nic-edit-config-file.jsp(5,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertDefinition_005f0.setName("nic-edit-config-default");
    _jspx_th_tiles_005finsertDefinition_005f0.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertDefinition_005f0);
    return false;
  }
}
