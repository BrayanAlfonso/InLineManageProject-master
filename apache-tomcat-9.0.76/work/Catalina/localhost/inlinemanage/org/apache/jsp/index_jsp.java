/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-11-19 03:00:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/../plantillas/footer.jsp", Long.valueOf(1700336754000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1690725986000L));
    _jspx_dependants.put("jar:file:/C:/Users/USUARIO/Desktop/InLineManageProject-master/apache-tomcat-9.0.76/webapps/inlinemanage/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("/../plantillas/footer2.jsp", Long.valueOf(1700336754000L));
    _jspx_dependants.put("/plantillas/header.jsp", Long.valueOf(1700339764000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>InLineManage</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/index1.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/StylesBarCode.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/indexModule1.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/formsUpdate.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/8232721784.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Caveat&family=Concert+One&family=Oxygen&family=Playfair:ital,wght@0,300;1,500&family=Wix+Madefor+Display:wght@800&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <img src=\"assets/img/LogoInterline.PNG\" alt=\"LogoInterline\" class=\"logo\">\r\n");
      out.write("        <h1 class=\"nameInterline\">INTERLINE COMUNICACIONES</h1>\r\n");
      out.write("        <div class=\"menuUser\">\r\n");
      out.write("            <div id=\"iconUser\">\r\n");
      out.write("                <i class=\"fa-solid fa-user\" style=\"color: #000000;\" ></i>\r\n");
      out.write("            </div>  \r\n");
      out.write("            <div class=\"userOptions\">\r\n");
      out.write("                <h3>Bienvenido</h3>\r\n");
      out.write("                <a href=\"ControllerInline?enviar=index\" class=\"linkMenu\">Cerrar sesión</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<main>\r\n");
      out.write("    <div class=\"welcome\">\r\n");
      out.write("        <h2>Bienvenido a</h2>\r\n");
      out.write("        <h1>Interline Comunicaciones.</h1>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"login-container\">\r\n");
      out.write("        <div class=\"login\">\r\n");
      out.write("            \r\n");
      out.write("                <h1 class=\"nameLogin\">INICIO DE SESIÓN</h1>\r\n");
      out.write("                <form action=\"ControllerInline\" method=\"post\" id=\"formLogin\" novalidate>\r\n");
      out.write("                    <div class=\"inputs\" id=\"divName\">\r\n");
      out.write("                        <label for=\"inputUserName\"><b>Nombre de usuario:</b></label><br><br>\r\n");
      out.write("                        <input type=\"text\" id=\"inputUserName\" name=\"inputUserName\" class=\"inputForm\">\r\n");
      out.write("                        <span class=\"fbForm\"></span> \r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"inputs\" id=\"divPassword\">\r\n");
      out.write("                        <label for=\"inputPassword\"><b>Contraseña:</b></label><br><br>\r\n");
      out.write("                        <input type=\"text\" id=\"inputPassword\" name=\"inputPassword\" class=\"inputForm\">\r\n");
      out.write("                        <span class=\"fbForm\"></span> \r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("\r\n");
      out.write("                    <button name=\"enviar\" id=\"btnLogin\" value=\"index\">INICIAR SESIÓN</button>    \r\n");
      out.write("\r\n");
      out.write("                        <!-- Declaración de la variable mensaje que se trae desde el controlador \"ControllerInline\"-->\r\n");
      out.write("                        ");
 String mensaje = (String) request.getAttribute("mensaje"); 
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("                        <!-- Campo para mostrar el mensaje traido desde Java -->\r\n");
      out.write("                        ");
 if (mensaje == null) {
      out.write("\r\n");
      out.write("                            <div></div>\r\n");
      out.write("                        ");
}else{
      out.write("\r\n");
      out.write("                            <div id=\"mensaje\"></div>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("                \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("<footer>\r\n");
      out.write("    <p>Todos los derechos reservados a InterlineComunicaciones &copy; 2023<p>\r\n");
      out.write("</footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    let mensajeJS=\"");
      out.print( mensaje );
      out.write("\"\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"assets/js/index1.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
