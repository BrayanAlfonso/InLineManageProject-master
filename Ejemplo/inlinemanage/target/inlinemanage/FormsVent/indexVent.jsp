
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
            <button class="btnMenu"><a href="ControllerInline?enviar=registerVent">Agregar</a></button>
            <form action="/inlinemanage/reportVent">
                <button class="btnMenu" id="generateReportVent">Generar reporte</button>
            </form>
            
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
                
            <%-- Verificar si hay usuarios y mostrarlos --%>
            <% if (ventas != null && !ventas.isEmpty()) { %>
            <table class="<%=(ventas.size() > 8) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="7" class="title-table">VENTAS</th>
                </tr>
                <tr>
                    <th rowspan="2">N#</th>
                    <th rowspan="2">fecha de venta</th>
                    <th rowspan="2">Nombre de vendedor</th>
                    <th colspan="3">Acciones</th>
                </tr>
                <tr>
                    <th>
                        Ver Más.
                    </th>
                    <th>
                        Actualizar
                    </th>
                    <th>
                        Eliminar
                    </th>
                </tr>
                <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
                <% for (VentaVo venta : ventas) { %>
                <tr>
                    <td><%= venta.getIdVenta() %></td>
                    <td><%= venta.getFechaVenta() %></td>
                    <td><%= venta.getIdUsuario() %></td>
                    <td class="iconCenter"><button style="color: #0eb1de;"><a href="ControllerInLine?enviar=consultVent&idVenta=<%= venta.getIdVenta() %>">Más Info.</a></button></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=updateVent&idVenta=<%= venta.getIdVenta() %>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=deleteVent&idVenta=<%= venta.getIdVenta() %>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
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

<%@ include file="../plantillas/footer2.jsp"%>