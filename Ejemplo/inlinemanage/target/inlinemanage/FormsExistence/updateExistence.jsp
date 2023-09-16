
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase ExistenciaVo y ExistenciaDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ExistenciaVo" %>
<%@ page import="model.ExistenciaDao" %>

<main class="main" id="mainForm">  
    <div>
        <a href="ControllerInline?enviar=existence"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>
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
            
            <div class="divCantidadUnidad" id="divCantidadUnidad">
                <label for="UpdateCantidadUnidad">Cantidad:</label>
                <input type="text" id="UpdateCantidadUnidad" class="inputForm" name="UpdateCantidadUnidad"value="<%= existencia.getCantidadUnidad() %>">
                <span class="fbForm"></span> 
            </div>

            <div class="divPrecioEntrada" id="divPrecioEntrada">
                <label for="UpdatePrecioEntrada">Precio:</label>
                <input type="number" id="UpdatePrecioEntrada" class="inputForm" name="UpdatePrecioEntrada" value="<%= existencia.getPrecioEntrada() %>">
                <span class="fbForm"></span> 
            </div>
    
            <div class="divIdProducto" id="divIdProducto">
                <label for="UpdateIdProducto">Id de Producto:</label>
                <input type="text" id="UpdateIdProducto" class="inputForm" name="UpdateIdProducto" value="<%= existencia.getIdProducto() %>">
                <span class="fbForm"></span> 
            </div>
    
            <div class="divIdEntraProd" id="divIdEntraProd">
                <label for="UpdateIdEntradaProd">Num. de Entrada de producto:</label>
                <input type="number" id="UpdateIdEntradaProd" class="inputForm" name="UpdateIdEntradaProd" value="<%= existencia.getIdEntradaProd() %>">
                <span class="fbForm"></span> 
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
<script src="assets/js/JsExist/updateValiderExistence.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>