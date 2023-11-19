
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
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">
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
</div>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>