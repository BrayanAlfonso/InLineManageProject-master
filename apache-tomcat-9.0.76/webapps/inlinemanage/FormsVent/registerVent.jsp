<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>
<%@ page import="model.ProductoVo"%>
<%@ page import="model.ProductoDao"%>

<main class="main" id="mainForm">
    <div>
        <a href="ControllerInline?enviar=vent"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div>

    <form action="ControllerInline" method="post" id="formValidacion" novalidate>
        <h1 class="title-table">Registro de Ventas</h1>
        <div class="contentForm">

            <div class="dateVent">
                <label for="dateVent">Fecha de la venta:</label>
                <input type="date" id="dateVent" name="dateVent" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="idUsuario">
                <label for="idUsuario">Usuario:</label>
                <select name="idUsuario" id="idUsuario">
                    <option value="0">Seleccionar...</option>
                    <option value="1">Brayan</option>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="Producto">
                <!-- Categorias -->
                <%List <CategoriaVo> categorias = null;
                    try {
                     categorias = new CategoriaDao().listar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                 %>

                <!-- Producto -->
                <%List <ProductoVo> productos = null;
                    try {
                        productos = new ProductoDao().listar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>

                    <label for="idCategory">Categoria:</label>
                
                <select name="idCategory" id="idCategory">
                    <option value="0">Seleccionar su categoria...</option>
                    <% for (CategoriaVo categoria : categorias) { %>
                    <option value=<%= categoria.getIdCategoria() %>><%=categoria.getNombreCategoria()%></option>
                    <% }%>
                </select>
                <br>
                <!-- Crear metodo para tener el IdCategoria -->
                
                <label for="idProducto">Producto:</label>
                <select name="idProducto" id="idProducto">
                    <option value="0">Selecciona el producto...</option>
                    <%  %>
                    <% for (ProductoVo producto : productos) { %>
                    <option value=<%=producto.getIdProducto()%>><%=producto.getNombreProducto()%></option>
                    <% }%>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="precioProducto">
                <label for="precioProducto">Precio:</label>
                <input type="text" id="precioProducto" name="precioProducto" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="Cantidad">
                <label for="Cantidad">Cantidad:</label>
                <input type="text" id="Cantidad" name="Cantidad" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerProduct">Registrar</button>
            </div>

            <div class="codigoDeBarras">
                <label for="codigoDeBarras">Código de Barras:</label>
                <input type="text" id="codigoDeBarrasInput" name="codigoDeBarras" class="inputForm">
            </div>
            
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsProd/registerProd1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>