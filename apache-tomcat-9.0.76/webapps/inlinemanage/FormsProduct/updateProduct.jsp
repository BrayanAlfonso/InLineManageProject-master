<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductoVo" %>
<%@ page import="model.ProductoDao" %>

<main class="main" id="mainForm"> 
    <div>
        <a href="ControllerInline?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div> 
    
    <%-- Obtener el id del producto seleccionado de la URL --%>
    <% String prodId = request.getParameter("idProducto"); %>
    <% int id = Integer.parseInt(prodId); %>
    <% ProductoVo producto = null;
    try {
        producto = new ProductoDao().obtenerProductPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró el usuario y mostrar el formulario de actualización --%>
    <% if (producto != null) { %>
    <form action="ControllerInline" method="post">
        <h1 class="title-table">Actualizacion de usuarios</h1>

        <input type="hidden" name="idProducto" id="idProducto" value="<%= producto.getIdProducto() %>">

        <div class="contentForm">
    
            <div class="divUnidProd">
                <label for="UpdateUnidadesDisponibles">Unidades de producto:</label>
                <input type="text" id="UpdateUnidadesDisponibles" name="UpdateUnidadesDisponibles"value="<%= producto.getUnidadesDisponibles() %>" class="inputForm">
            </div>
            
            <div class="divNameProd">
                <label for="UpdateNameProducto">Nombre de producto:</label>
                <input type="text" id="UpdateNameProducto" name="UpdateNameProducto"value="<%= producto.getNombreProducto() %>" class="inputForm">
            </div>

            <div class="divPrecio">
                <label for="UpdatePrecio">Precio:</label>
                <input type="number" id="UpdatePrecio" name="UpdatePrecio" value="<%= producto.getPrecioVenta() %>" class="inputForm">
            </div>
    
            <div class="divDescripcion">
                <label for="UpdateDescripcion">Descripcion:</label>
                <input type="text" id="UpdateDescripcion" name="UpdateDescripcion" value="<%= producto.getDescripcion() %>" class="inputForm">
            </div>

            <div class="divNumSerial">
                <label for="UpdateSerial">Numero serial:</label>
                <input type="text" id="UpdateSerial" name="UpdateSerial" value="<%= producto.getSerial() %>" class="inputForm">
            </div>

            <div class="divEntrada">
                <label for="UpdateGarantiaEntrada">Garantia de entrada:</label>
                <input type="number" id="UpdateGarantiaEntrada" name="UpdateGarantiaEntrada" value="<%= producto.getGarantiaEntradaMeses() %>" class="inputForm">
            </div>

            <div class="divVenta">
                <label for="UpdateGarantiaVentas">Garantia de venta:</label>
                <input type="number" id="UpdateGarantiaVentas" name="UpdateGarantiaVentas" value="<%= producto.getGarantiaVentaMeses() %>" class="inputForm">
            </div>

            <div class="divCategoria">
                <label for="UpdateCategoria">Categoria:</label>
                <input type="number" id="UpdateCategoria" name="UpdateCategoria" value="<%= producto.getIdCategoria() %>" class="inputForm">
            </div>
    

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateProduct">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró el usuario.</p>
    <% } %>
</main><br>
    
<%@ include file="../plantillas/footer.jsp"%>

<%@ include file="../plantillas/footer2.jsp"%>