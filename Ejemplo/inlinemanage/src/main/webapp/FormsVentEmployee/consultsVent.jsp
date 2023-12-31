<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>


<%@ include file="../plantillas/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="model.DetalleVentVo" %>
<%@ page import="model.DetalleVentDao" %>

<main class="main">
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="Vent?enviar=ventEp"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
        </div>

        <% 
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
        %>
                        <div class="content-consult">
                            <h2><strong>Detalles de la Venta</strong></h2>
                            <div class="content-info">
                                <p><strong>Id de Producto: </strong> </p>

                                <p><%= dtventa.getIdProducto() %></p>
                            </div>

                                <br>

                            <div class="content-info">
                                <p><strong>Id de Venta: </strong> </p>

                                <p><%= dtventa.getIdVenta() %></p>
                            </div>

                                <br>

                            <div class="content-info">
                                <p><strong>Precio: </strong> </p> 

                                <p><%= dtventa.getPrecioProducto() %></p>
                            </div>
                            
                                <br>

                            <div class="content-info">
                                <p><strong>Cantidad: </strong> </p> 

                                <p><%= dtventa.getCantidad() %></p>

                            </div>
                                <br>
                        </div>
        <%
                    }
                } else {
        %>
                    <p>No se encontraron detalles de venta para la venta con ID <%= idVenta %>.</p>
        <%
                }
            } else {
        %>
                <p>No se proporcionó un ID de venta válido.</p>
        <%
            }
        %>
    </div>
</main>

<%@ include file="../plantillas/footer.jsp" %>

<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>