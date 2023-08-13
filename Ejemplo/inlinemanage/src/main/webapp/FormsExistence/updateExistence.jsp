
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

        <input type="hidden" name="idExitencia" id="idExistencia" value="<%= existencia.getIdExistencia() %>">

        <div class="contentForm">
    
            <div class="divNumSerial">
                <label for="UpdateNumSerial">Numero serial:</label>
                <input type="text" id="UpdateNumSerial" name="UpdateNumSerial"value="<%= existencia.getNumSerial() %>">
            </div>
            
            <div class="divIdCategoria">
                <label for="UpdateIdCategoria">Num. de categoria:</label>
                <input type="text" id="UpdateIdCategoria" name="UpdateIdCategoria"value="<%= existencia.getIdCategoria() %>">
            </div>

            <div class="divFechGarantia">
                <label for="UpdateFechaGarantia">Fecha de garantia:</label>
                <input type="number" id="UpdateFechaGarantia" name="UpdateFechaGarantia" value="<%= existencia.getFechaGarantia() %>">
            </div>
    
            <div class="divObservaciones">
                <label for="UpdateObservaciones">Observaciones:</label>
                <input type="text" id="UpdateObservaciones" name="UpdateObservaciones" value="<%= existencia.getObservaciones() %>">
            </div>
    
            <div class="divIdEntraProd">
                <label for="UpdateIdEntradaProd">Num. de Entrada de producto:</label>
                <input type="number" id="UpdateIdEntradaProd" name="UpdateIdEntradaProd" value="<%= existencia.getIdEntradaProd() %>">
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