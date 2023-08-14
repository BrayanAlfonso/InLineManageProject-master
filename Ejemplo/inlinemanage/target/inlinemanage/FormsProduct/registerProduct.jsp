<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Productos</h1>
        <div class="contentForm">

            <div class="unidadesDisponibles">
                <label for="unidadesDisponibles">Unidades Disponibles:</label>
                <input type="text" id="unidadesDisponibles" name="unidadesDisponibles" class="inputForm">
            </div>

            <div class="nameProduct">
                <label for="nameProduct">Nombre de producto:</label>
                <input type="text" id="nameProduct" name="nameProduct" class="inputForm">
            </div>
    
            <div class="precio">
                <label for="precio">Precio:</label>
                <input type="text" id="precio" name="precio" class="inputForm">
            </div>
    
            <div class="descripcion">
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" class="inputForm">
            </div>

            <div class="serial">
                <label for="serial">Numero serial:</label>
                <input type="text" id="serial" name="serial" class="inputForm">
            </div>

            <div class="garantiaEntrada">
                <label for="garantiaEntrada">Garantia de entrada:</label>
                <input type="text" id="garantiaEntrada" name="garantiaEntrada" class="inputForm">
            </div>

            <div class="garantiaVentas">
                <label for="garantiaVentas">Garantia de venta:</label>
                <input type="text" id="garantiaVentas" name="garantiaVentas" class="inputForm">
            </div>
    
            <div class="categoria">
                <label for="categoria">Categoria:</label>
                <input type="text" id="categoria" name="categoria" class="inputForm">
            </div>
    

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerProduct">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>