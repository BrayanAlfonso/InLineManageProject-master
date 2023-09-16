<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<main class="main" id="mainForm">
    <div>
        <a href="ControllerInline?enviar=existence"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br><br>

    <form action="ControllerInline" id="formValiderE" method="post">
        <h1 class="title-table">Registro de Existencias</h1>
        <div class="contentForm">

            <div class="cantidadUnidad" id="divCantidadUnidad">
                <label for="cantidadUnidad">Cantidad:</label>
                <input type="number" id="cantidadUnidad" class="inputForm" name="cantidadUnidad" required>
                <span class="fbForm"></span> 
            </div>
    
            <div class="precioEntrada" id="divPrecioEntrada">
                <label for="precioEntrada">Precio:</label>
                <input type="number" id="precioEntrada" class="inputForm" name="precioEntrada" required>
                <span class="fbForm"></span> 
            </div>
    
            <div class="idProducto" id="divIdProducto">
                <label for="idProducto">Id de Producto:</label>
                <input type="number" id="idProducto" class="inputForm" name="idProducto" required>
                <span class="fbForm"></span> 
            </div>
    
            <div class="idEntradaProd" id="divIdEntradaProd">
                <label for="idEntradaProd">Num. de Entrada del producto:</label>
                <input type="number" id="idEntradaProd" class="inputForm" name="idEntradaProd" required>
                <span class="fbForm"></span> 
            </div>
       
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerExistence">Registrar</button>
            </div>
            <div id="mensaje"></div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<% String mensaje = (String) request.getAttribute("mensaje"); %>

<script>
    window.onload = function() {
        var mensajeVE = document.getElementById("mensaje");
        if (mensaje != null) { 
            mensajeVE.textContent = "<%= mensaje %>";
        }
    };
</script>
<script src="assets/js/JsExist/validerExistence.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>