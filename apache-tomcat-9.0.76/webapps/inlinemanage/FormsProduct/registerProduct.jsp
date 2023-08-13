<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Productos</h1>
        <div class="contentForm">

            <div class="numSerial">
                <label for="numSerial">Numero serial:</label>
                <input type="text" id="numSerial" name="numSerial">
            </div>

            <div class="nameProduct">
                <label for="nameProduct">Nombre de producto:</label>
                <input type="text" id="nameProduct" name="nameProduct">
            </div>
    
            <div class="precioProd">
                <label for="precioProd">Precio:</label>
                <input type="text" id="precioProd" name="precioProd">
            </div>
    
            <div class="descripcion">
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion">
            </div>
    
            <div class="categoria">
                <label for="categoria">Categoria:</label>
                <input type="text" id="categoria" name="categoria">
            </div>
    
            <div class="existencia">
                <label for="existencia">Existencia:</label>
                <input type="text" id="existencia" name="existencia">
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerProduct">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>