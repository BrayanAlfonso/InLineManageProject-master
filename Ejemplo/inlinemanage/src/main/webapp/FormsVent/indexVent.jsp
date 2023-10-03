
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.VentaVo" %>
<%@ page import="model.VentaDao" %>

<main class="main">
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            
        </div>
        <div class="content2">
            <% List<VentaVo> ventas = null;
                try {
                    ventas = new VentaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                %>
                
            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (ventas != null && !ventas.isEmpty()) { %>
            <table class="<%=(ventas.size() > 8) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="7" class="title-table">VENTAS</th>
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
                    <td><%= venta.getIdUsuario() %></td>
                    <td class="btnMenu"><button class="btnMenu">Detalles</button></td>
                </tr>
                <% }%>
            </table>
            <% } else { %>
                <p>No se encontraron ventas.</p>
            <% } %>
    </div>
</div>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>