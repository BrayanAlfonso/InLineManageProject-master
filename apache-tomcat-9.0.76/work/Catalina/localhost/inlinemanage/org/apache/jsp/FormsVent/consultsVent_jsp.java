/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-11-28 23:27:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.FormsVent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import java.util.List;
import model.DetalleVentVo;
import model.DetalleVentDao;

public final class consultsVent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/FormsVent/../plantillas/footer2.jsp", Long.valueOf(1701198980000L));
    _jspx_dependants.put("/FormsVent/../plantillas/header.jsp", Long.valueOf(1701203368000L));
    _jspx_dependants.put("/FormsVent/../plantillas/footer.jsp", Long.valueOf(1701198980000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("javax.servlet.http.HttpServletRequest");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.DetalleVentDao");
    _jspx_imports_classes.add("javax.servlet.RequestDispatcher");
    _jspx_imports_classes.add("model.DetalleVentVo");
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
      out.write("\r\n");

    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){

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
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/StylesBarCode1.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/indexModule1.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/modalReports1.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./LogoInterline.ico\" type=\"image/x-icon\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/8232721784.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        function toggleMenu() {\r\n");
      out.write("            var menu = document.querySelector('.menuUser');\r\n");
      out.write("            menu.classList.toggle('active');\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Caveat&family=Concert+One&family=Oxygen&family=Playfair:ital,wght@0,300;1,500&family=Wix+Madefor+Display:wght@800&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <img src=\"assets/img/LogoInterline.PNG\" alt=\"LogoInterline\" class=\"logo\">\r\n");
      out.write("        <h1 class=\"nameInterline\">INTERLINE COMUNICACIONES</h1>\r\n");
      out.write("        <div class=\"menuUser\" onclick=\"toggleMenu()\">\r\n");
      out.write("            <div id=\"iconUser\">\r\n");
      out.write("                <i class=\"fa-solid fa-user\" style=\"color: #000000;\" ></i>\r\n");
      out.write("            </div>  \r\n");
      out.write("            <div class=\"userOptions\">\r\n");
      out.write("                <h3>Bienvenido</h3>\r\n");
      out.write("                <a href=\"ControllerInline?enviar=closeSession\" class=\"linkMenu\">Cerrar sesión</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<main class=\"main\">\r\n");
      out.write("    <div class=\"content1\">\r\n");
      out.write("        <div class=\"options\">\r\n");
      out.write("            <div class=\"backlog\">\r\n");
      out.write("                <a href=\"Vent?enviar=vent\"><img src=\"assets/img/back.PNG\" alt=\"backlog\" class=\"backlog\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
 
            // Obtener el parámetro "idVenta" de la solicitud
            String idVentaParam = request.getParameter("idVenta");
            System.out.println(idVentaParam);
            
            if (idVentaParam != null && !idVentaParam.isEmpty()) {
                // Convertir el parámetro a tipo int
                int idVenta = Integer.parseInt(idVentaParam);

                // Obtener la lista de detalles de venta relacionados con la venta específica
                List<DetalleVentVo> dtventas = null;
                try {
                    dtventas = new DetalleVentDao().listarPorIdVenta(idVenta);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Mostrar los detalles de venta
                if (dtventas != null && !dtventas.isEmpty()) {
                    for (DetalleVentVo dtventa : dtventas) {
        
      out.write("\r\n");
      out.write("                        <div class=\"content-consult\">\r\n");
      out.write("                            <h2><strong>Detalles de la Venta</strong></h2>\r\n");
      out.write("                            <div class=\"content-info\">\r\n");
      out.write("                                <p><strong>Id de Producto: </strong> </p>\r\n");
      out.write("\r\n");
      out.write("                                <p>");
      out.print( dtventa.getIdProducto() );
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                                <br>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"content-info\">\r\n");
      out.write("                                <p><strong>Id de Venta: </strong> </p>\r\n");
      out.write("\r\n");
      out.write("                                <p>");
      out.print( dtventa.getIdVenta() );
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                                <br>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"content-info\">\r\n");
      out.write("                                <p><strong>Precio: </strong> </p> \r\n");
      out.write("\r\n");
      out.write("                                <p>");
      out.print( dtventa.getPrecioProducto() );
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                                <br>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"content-info\">\r\n");
      out.write("                                <p><strong>Cantidad: </strong> </p> \r\n");
      out.write("\r\n");
      out.write("                                <p>");
      out.print( dtventa.getCantidad() );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                                <br>\r\n");
      out.write("                        </div>\r\n");
      out.write("        ");

                    }
                } else {
        
      out.write("\r\n");
      out.write("                    <p>No se encontraron detalles de venta para la venta con ID ");
      out.print( idVenta );
      out.write(".</p>\r\n");
      out.write("        ");

                }
            } else {
        
      out.write("\r\n");
      out.write("                <p>No se proporcionó un ID de venta válido.</p>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>Todos los derechos reservados a InterlineComunicaciones &copy; 2023<p>\r\n");
      out.write("</footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");

}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}

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
