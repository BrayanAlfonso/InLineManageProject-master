
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase ExistenciaVo y ExistenciaDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ExistenciaVo" %>
<%@ page import="model.ExistenciaDao" %>

<main class="main">  
    
    <%-- Obtener el id de la existencia seleccionado de la URL --%>
    <% String existId = request.getParameter("idExistencia"); %>
    <% int id = Integer.parseInt(existId); %>
    <% ExistenciaVo existencia = null;
    try {
        existencia = new ExistenciaDao().obtenerExistencePorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró la existencia y mostrar el formulario de actualización --%>
    <% if (existencia != null) { %>
    <form action="ControllerInline" method="post">
        <h1 class="title-table">Actualizacion de existencias</h1>

        <input type="hidden" name="idExistencia" id="idExistencia" value="<%= existencia.getIdExistencia() %>">

        <div class="contentForm">
            
            <div class="divCantidadUnidad">
                <label for="UpdateCantidadUnidad">Cantidad:</label>
                <input type="text" id="UpdateCantidadUnidad" name="UpdateCantidadUnidad"value="<%= existencia.getCantidadUnidad() %>" class="inputForm">
            </div>

            <div class="divPrecioEntrada">
                <label for="UpdatePrecioEntrada">Precio:</label>
                <input type="number" id="UpdatePrecioEntrada" name="UpdatePrecioEntrada" value="<%= existencia.getPrecioEntrada() %>" class="inputForm">
            </div>
    
            <div class="divIdProducto">
                <label for="UpdateIdProducto">Id de Producto:</label>
                <input type="text" id="UpdateIdProducto" name="UpdateIdProducto" value="<%= existencia.getIdProducto() %>" class="inputForm">
            </div>
    
            <div class="divIdEntraProd">
                <label for="UpdateIdEntradaProd">Num. de Entrada de producto:</label>
                <input type="number" id="UpdateIdEntradaProd" name="UpdateIdEntradaProd" value="<%= existencia.getIdEntradaProd() %>" class="inputForm">
            </div>
    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateExistence">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró la existencia.</p>
    <% } %>
</main><br>
    
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>