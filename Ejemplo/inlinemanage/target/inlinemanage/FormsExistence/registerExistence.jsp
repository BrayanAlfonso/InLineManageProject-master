<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=existence"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Existencias</h1>
        <div class="contentForm">

            <div class="numSerial">
                <label for="numSerial">Numero serial:</label>
                <input type="text" id="numSerial" name="numSerial">
            </div>

            <div class="idCategoria">
                <label for="idCategoria">Num. de categoria:</label>
                <input type="text" id="idCategoria" name="idCategoria">
            </div>
    
            <div class="fechaGarantia">
                <label for="fechaGarantia">Fecha de garantia:</label>
                <input type="text" id="fechaGarantia" name="fechaGarantia">
            </div>
    
            <div class="observaciones">
                <label for="observaciones">Observación:</label>
                <input type="text" id="observaciones" name="observaciones">
            </div>
    
            <div class="idEntradaProd">
                <label for="idEntradaProd">Num. de Entrada del producto:</label>
                <input type="text" id="idEntradaProd" name="idEntradaProd">
            </div>
    
            <div class="idExistencia">
                <label for="idExistencia">Existencia:</label>
                <input type="text" id="idExistencia" name="idExistencia">
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerExistence">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>