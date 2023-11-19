<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductoVo" %>
<%@ page import="model.ProductoDao" %>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>

<main class="main" id="mainForm"> 
    <div>
        <a href="Product?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
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
    <form action="Product" method="post" id="formValidacion">
        <h1 class="title-table">Actualizacion de productos</h1>

        <input type="hidden" name="idProducto" id="idProducto" value="<%= producto.getIdProducto() %>">

        <div class="contentForm">
    
            <div class="divUnidProd">
                <label for="UpdateUnidadesDisponibles">Unidades de producto:</label>
                <input type="text" id="UpdateUnidadesDisponibles" name="UpdateUnidadesDisponibles"value="<%= producto.getUnidadesDisponibles() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>
            
            <div class="divNameProd">
                <label for="UpdateNameProducto">Nombre de producto:</label>
                <input type="text" id="UpdateNameProducto" name="UpdateNameProducto"value="<%= producto.getNombreProducto() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>

            <div class="divPrecio">
                <label for="UpdatePrecio">Precio:</label>
                <input type="text" id="UpdatePrecio" name="UpdatePrecio" value="<%= producto.getPrecioVenta() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>
    
            <div class="divDescripcion">
                <label for="UpdateDescripcion">Descripcion:</label>
                <input type="text" id="UpdateDescripcion" name="UpdateDescripcion" value="<%= producto.getDescripcion() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>

            <div class="divNumSerial" >
                <label for="UpdateSerial">Numero serial:</label>
                <input type="text" id="UpdateSerial" name="UpdateSerial" value="<%= producto.getSerial() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>

            <div class="divEntrada">
                <label for="UpdateGarantiaEntrada">Meses de garantia de entrada:</label>
                <input type="text" id="UpdateGarantiaEntrada" name="UpdateGarantiaEntrada" value="<%= producto.getGarantiaEntradaMeses() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>

            <div class="divVenta">
                <label for="UpdateGarantiaVentas">Meses de garantia de venta:</label>
                <input type="text" id="UpdateGarantiaVentas" name="UpdateGarantiaVentas" value="<%= producto.getGarantiaVentaMeses() %>" class="inputForm">
                <span class="fbForm"></span>
            </div>

            <% List<CategoriaVo> categorias = null;
                try {
                    categorias = new CategoriaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
             %>
            <div class="categoria">
                <label for="UpdateCategoria">Categoría:</label>
                <select id="UpdateCategoria" name="UpdateCategoria" class="inputForm">
                    <option value="" disabled selected><%= producto.getIdCategoria() %></option>
                    <% for (CategoriaVo categoria : categorias) { %>
                        <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNombreCategoria() %></option>
                    <% } %>
                </select>
                <span class="fbForm">Hola Mundo</span>
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
<script src="assets/js/JsProd/Produpdate.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>