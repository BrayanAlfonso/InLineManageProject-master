<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main">
    <div class="backlog">
        <a href="ControllerInline?enviar=existence"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
    </div><br><br>

    <form action="ControllerInline" method="post">
        <h1 class="title-table">Registro de Existencias</h1>
        <div class="contentForm">

            <div class="cantidadUnidad">
                <label for="cantidadUnidad">Cantidad:</label>
                <input type="text" id="cantidadUnidad" name="cantidadUnidad" class="inputForm">
            </div>
    
            <div class="precioEntrada">
                <label for="precioEntrada">Precio:</label>
                <input type="text" id="precioEntrada" name="precioEntrada" class="inputForm">
            </div>
    
            <div class="idProducto">
                <label for="idProducto">Id de Producto:</label>
                <input type="text" id="idProducto" name="idProducto" class="inputForm">
            </div>
    
            <div class="idEntradaProd">
                <label for="idEntradaProd">Num. de Entrada del producto:</label>
                <input type="text" id="idEntradaProd" name="idEntradaProd" class="inputForm">
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerExistence">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>