<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=supplier"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Proveedores</h1>
        <div class="contentForm">

            <div class="nombreProveedor">
                <label for="nombreProveedor">Nombre:</label>
                <input type="text" id="nombreProveedor" name="nombreProveedor" class="inputForm">
            </div>

            <div class="direccionProveedor">
                <label for="direccionProveedor">Dirección:</label>
                <input type="text" id="direccionProveedor" name="direccionProveedor" class="inputForm">
            </div>
    
            <div class="idProveedor">
                <label for="idProveedor">Existencia:</label>
                <input type="text" id="idProveedor" name="idProveedor" class="inputForm">
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerSupplier">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>