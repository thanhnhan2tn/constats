/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-04-07 03:30:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.themes.default_.modules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.edu.cit.servercontrol.nic.Eth;
import vn.edu.cit.servercontrol.nic.Nic;

public final class editserver_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.1.4.RELEASE.jar", Long.valueOf(1423281066880L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1421222476495L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("jar:file:/D:/Github/lv-nhan/contats/Codes/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServerControl/WEB-INF/lib/spring-webmvc-4.1.4.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1419881820000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005ftitle_005fpath_005fname_005fdisabled_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fpath_005fname_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fplaceholder_005fpath_005fclass_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005ftitle_005fpath_005fname_005fdisabled_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fpath_005fname_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fplaceholder_005fpath_005fclass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fform_0026_005frole_005fmethod_005fcommandName_005fclass_005faction.release();
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005ftitle_005fpath_005fname_005fdisabled_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fpath_005fname_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005fpassword_0026_005frequired_005fplaceholder_005fpath_005fname_005fclass_005fnobody.release();
    _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.release();
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
      out.write("<aside class=\"right-side\">\r\n");
      out.write("\t<!-- Content Header (Page header) -->\r\n");
      out.write("\t<section class=\"content-header\">\r\n");
      out.write("\t\t<h1>\r\n");
      out.write("\t\t\tNetword Interface Cards Config :<small>\r\n");
      out.write("\t\t\t\t(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.serverAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(")</small>\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!--  End Content Header -->\r\n");
      out.write("\t<!--  Main Content -->\r\n");
      out.write("\t<section class=\"content\">\r\n");
      out.write("\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_spring_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
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
    // /WEB-INF/views/themes/default/modules/editserver.jsp(18,3) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }/editserver/${server.serverAddress}/${cc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/views/themes/default/modules/editserver.jsp(18,3) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setMethod("POST");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(18,3) null
    _jspx_th_spring_005fform_005f0.setDynamicAttribute(null, "role", "form");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(18,3) name = commandName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fform_005f0.setCommandName("server");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(18,3) null
    _jspx_th_spring_005fform_005f0.setDynamicAttribute(null, "class", "form-horizontal");
    int[] _jspx_push_body_count_spring_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fform_005f0 = _jspx_th_spring_005fform_005f0.doStartTag();
      if (_jspx_eval_spring_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
          out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t\t<label for=\"ip\" class=\"col-md-3 control-label\">IP: *</label>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f0(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t\t<label for=\"username\" class=\"col-md-3 control-label\">Root\r\n");
          out.write("\t\t\t\t\t\t\tUsername: *</label>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f1(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t\t<label for=\"password\" class=\"col-md-3 control-label\">Password:\r\n");
          out.write("\t\t\t\t\t\t\t*</label>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_spring_005fpassword_005f0(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t\t<label for=\"ssh-port\" class=\"col-md-3 control-label\">SSH\r\n");
          out.write("\t\t\t\t\t\t\tPort: *</label>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_spring_005finput_005f2(_jspx_th_spring_005fform_005f0, _jspx_page_context, _jspx_push_body_count_spring_005fform_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t<div style=\"display: none\" id=\"signup-err\"\r\n");
          out.write("\t\t\t\t\t\tclass=\"alert alert-danger col-sm-12 signup-err\"></div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div class=\"form-group\">\r\n");
          out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\"\r\n");
          out.write("\t\t\t\t\t\tonclick=\"history.back()\">Back</button>\r\n");
          out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t");
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
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005ftitle_005fpath_005fname_005fdisabled_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f0.setPath("serverAddress");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "class", "ip form-control");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) name = disabled type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f0.setDisabled(true);
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "name", "ip");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) null
    _jspx_th_spring_005finput_005f0.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.serverAddress}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/views/themes/default/modules/editserver.jsp(25,7) name = title type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f0.setTitle("You can not edit IP Address");
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
      _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005ftitle_005fpath_005fname_005fdisabled_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005finput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_005fform_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f1 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fpath_005fname_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/editserver.jsp(33,7) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f1.setPath("serverUsername");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(33,7) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "class", "username form-control");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(33,7) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "name", "username");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(33,7) null
    _jspx_th_spring_005finput_005f1.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.serverUsername}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/views/themes/default/modules/editserver.jsp(33,7) null
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
      _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fpath_005fname_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f1);
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
    // /WEB-INF/views/themes/default/modules/editserver.jsp(42,7) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fpassword_005f0.setPath("serverPassword");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(42,7) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "class", "password form-control");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(42,7) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "name", "password");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(42,7) null
    _jspx_th_spring_005fpassword_005f0.setDynamicAttribute(null, "placeholder", "Input your server user password");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(42,7) null
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
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_spring_005finput_005f2 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_spring_005finput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_spring_005finput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_005fform_005f0);
    // /WEB-INF/views/themes/default/modules/editserver.jsp(52,7) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005finput_005f2.setPath("port");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(52,7) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "class", "port form-control");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(52,7) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${server.port}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /WEB-INF/views/themes/default/modules/editserver.jsp(52,7) null
    _jspx_th_spring_005finput_005f2.setDynamicAttribute(null, "placeholder", "SSH Port");
    // /WEB-INF/views/themes/default/modules/editserver.jsp(52,7) null
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
      _005fjspx_005ftagPool_005fspring_005finput_0026_005fvalue_005frequired_005fplaceholder_005fpath_005fclass_005fnobody.reuse(_jspx_th_spring_005finput_005f2);
    }
    return false;
  }
}
