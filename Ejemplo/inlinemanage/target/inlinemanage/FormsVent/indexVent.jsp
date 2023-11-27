
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.UsuarioVo" %>
<%@ page import="model.UsuarioDao" %>
<%@ page import="model.VentaVo" %>
<%@ page import="model.VentaDao" %>
<%@ page import="model.DetalleVentVo" %>
<%@ page import="model.DetalleVentDao" %>

<main class="main">
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu"><a href="Vent?enviar=registerVent">Agregar</a></button>
            <button class="btnMenu" id="abrirModalReportes">Generar reporte</button>

            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">

            <div class="modal" id="modalReportes">
                <div class="modalBody">
                    <div class="modalHeader">
                        <h1>Reportes</h1>
                        <span class="cerrarModal" id="cerrarModal">&times;</span>
                    </div>
                    <div class="modalContent">
                        
                        <form action="Reports" class="formReports">
                            <div class="divReports">
                                <div class="divContent">
                                    <button class="btnReport"><a href="Reports?enviar=DeVent">Reporte completo</a></button>
                                </div>

                                <div class="divContent2">
                                    <h1>Reporte filtrado</h1>

                                    <input type="date" name="dateFilter" id="dateFilter">
                                    <button name="enviar" value="DeVentFilter">Generar reporte filtrado</button>
                                </div>    

                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
            <% List<VentaVo> ventas = null;
                try {
                    ventas = new VentaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
            
                
            <% List<DetalleVentVo> dtventas = null;
                try {
                    dtventas = new DetalleVentDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>

            <% List<UsuarioVo> usuarios = null;
                try {
                    usuarios = new UsuarioDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
                
            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (usuarios != null && !usuarios.isEmpty()) { %>
            <% if (ventas != null && !ventas.isEmpty()) { %>
            <table class="<%=(ventas.size() > 8) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="4">VENTAS</th>
                </tr>
                <tr>
                    <th>N#</th>
                    <th>fecha de venta</th>
                    <th>Nombre de vendedor</th>
                    <th>Acciones</th>
                </tr>
                <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
                <% for (VentaVo venta : ventas) { %>
                    <tr>
                        <td><%= venta.getIdVenta() %></td>
                        <td><%= venta.getFechaVenta() %></td>
                        <% for (UsuarioVo usuario : usuarios) { %>
                            <% if (usuario.getIdUsuario() == venta.getIdUsuario()) { %>
                                <td><%= usuario.getNombre() %></td>
                            <% } %>
                        <% } %>

                        <td class="iconCenter">
                            <button style="color: #0eb1de;">
                                <a href="Vent?enviar=consultsVent&idVenta=<%= venta.getIdVenta() %>">Más Info.</a>
                            </button>
                        </td>
                    </tr>
                <% } %>                
                <% } %>
            </table>
            <% } else { %>
                <p>No se encontraron ventas.</p>
            <% } %>
    </div>
            <!-- Declaración de la variable mensaje que se trae desde el controlador "Vent"-->
            <% String mensajeInventario = (String) request.getAttribute("mensajeInventario"); %> 
            <% if (mensajeInventario == null) {%>
                <div></div>
            <%}else{%>
                <div class="mensajeInventario" id="mensajeInventario"></div>
            <%}%>



            <!-- Declaración de la variable mensaje que se trae desde el controlador "ControllerInline"-->
            <% String mensaje = (String) request.getAttribute("mensaje"); %> 

            <!-- Campo para mostrar el mensaje traido desde Java -->
            <% if (mensaje == null) {%>
                <div></div>
            <%}else{%>
                <div id="mensaje"></div>
            <%}%>
</div>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script>
    let mensajeJS="<%= mensaje %>"
    let mensajeInventario="<%= mensajeInventario %>"
</script>
<script src="assets/js/JsVent/indexVent1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>