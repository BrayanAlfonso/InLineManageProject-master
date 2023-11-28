
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="java.util.List" %>


<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ page import="model.MovimientoVo" %>
<%@ page import="model.MovimientoDao" %>
<%@ include file="plantillas/header.jsp"%>

<main>
    <% List<MovimientoVo> movimientos = null;
        MovimientoDao movimientoDao = new MovimientoDao();
        try {
            movimientos = new MovimientoDao().listar();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>

<div class="buttons">
    <div class="row-buttons">
        
        <div class="Button">
            <a href="User?enviar=user">
            <h1 style="color: black;">Usuarios</h1>
            <i class="fa-solid fa-users" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>

        <div class="Button">
            <a href="Product?enviar=product">
            <h1 style="color: black;">Productos</h1>
            <i class="fa-solid fa-boxes-stacked" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>
    </div>

    <div class="row-buttons">
        <div class="Button">
            <a href="Supplier?enviar=supplier">
            <h1 style="color: black;">Proveedores</h1>
            <i class="fa-solid fa-user-tie" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>

        <div class="Button">
            <a href="Vent?enviar=vent">
            <h1 style="color: black;">Ventas</h1>
            <i class="fa-solid fa-cash-register" style="font-size: 100px; margin-top: 10px; color: #2d8c94;"></i>
            </a>
        </div>
    </div>
</div>
<div class="container-table">
    <div class="tabla-scroll">        
        <% if (movimientos != null && !movimientos.isEmpty()) { %>
            <table class="<%=(movimientos.size() > 8) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="3" class="title-table">Movimientos</th>
                </tr>
                <tr>
                    <th>Id Movimiento</th>
                    <th>Fecha y hora</th>
                    <th>Accion realizada</th>
                </tr>

                <%-- Recorrer la lista de usuarios y mostrar sus detalles --%>
                <% for (MovimientoVo movimiento : movimientos) { %>
                <tr>
                    <td><%= movimiento.getIdMovimiento() %></td>
                    <td><%= movimientoDao.formatDate(movimiento.getFecha_hora()) %></td>
                    <td><%= movimiento.getAccion() %></td>
                </tr>
                <% } %>

            </table>
            <% } else { %>
                <p>No se encontraron movimientos.</p>
            <% } %>

    </div>        

</div>
</main>

<%@ include file="../plantillas/footer.jsp"%>
<!-- Si necesitan un archivo js especifico ira aqui -->
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>
    


