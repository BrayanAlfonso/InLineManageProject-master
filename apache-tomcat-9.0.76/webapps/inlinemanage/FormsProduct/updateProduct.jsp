
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductoVo" %>
<%@ page import="model.ProductoDao" %>

<main class="main">  
    
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
    
            <div class="divNumSerial">
                <label for="UpdateNumSerial">Numero serial:</label>
                <input type="text" id="UpdateNumSerial" name="UpdateNumSerial"value="<%= producto.getNumSerial() %>">
            </div>
            
            
            <div class="divNameProd">
                <label for="UpdateNameProduct">Nombre de producto:</label>
                <input type="text" id="UpdateNameProduct" name="UpdateNameProduct"value="<%= producto.getNombreProducto() %>">
            </div>

            <div class="divPrecio">
                <label for="UpdatePrecioProd">Precio:</label>
                <input type="number" id="UpdatePrecioProd" name="UpdatePrecioProd" value="<%= producto.getPrecioProducto() %>">
            </div>
    
            <div class="divDescripcion">
                <label for="UpdateDescripcion">Descripcion:</label>
                <input type="text" id="UpdateDescripcion" name="UpdateDescripcion" value="<%= producto.getDescripcion() %>">
            </div>
    
            <div class="divCategoria">
                <label for="UpdateCategoria">Categoria:</label>
                <input type="number" id="UpdateCategoria" name="UpdateCategoria" value="<%= producto.getIdCategoria() %>">
            </div>
    
            <div class="divExistencia">
                <label for="UpdateExistencia">Existencia:</label>
                <input type="number" id="UpdateExistencia" name="UpdateExistencia" value="<%= producto.getIdExistencia() %>">
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