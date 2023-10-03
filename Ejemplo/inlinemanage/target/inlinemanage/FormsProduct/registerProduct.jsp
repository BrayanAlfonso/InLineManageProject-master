<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>
<main class="main" id="mainForm">
    <div>
        <a href="ControllerInline?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div>

    <form action="ControllerInline" method="post" id="formValidacion" novalidate>
        <h1 class="title-table">Registro de Productos</h1>
        <div class="contentForm">

            <div class="unidadesDisponibles">
                <label for="unidadesDisponibles">Unidades Disponibles:</label>
                <input type="text" id="unidadesDisponibles" name="unidadesDisponibles" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="nameProduct">
                <label for="nameProduct">Nombre de producto:</label>
                <input type="text" id="nameProduct" name="nameProduct" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="precio">
                <label for="precio">Precio:</label>
                <input type="text" id="precio" name="precio" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <div class="descripcion">
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="serial">
                <label for="serial">Numero serial:</label>
                <input type="text" id="serial" name="serial" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="garantiaEntrada">
                <label for="garantiaEntrada">Meses de garantia de entrada:</label>
                <input type="text" id="garantiaEntrada" name="garantiaEntrada" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>

            <div class="garantiaVentas">
                <label for="garantiaVentas">Meses de garantia de venta:</label>
                <input type="text" id="garantiaVentas" name="garantiaVentas" class="inputForm">
                <span class="fbForm">Hola Mundo</span>
            </div>
    
            <% List<CategoriaVo> categorias = null;
                try {
                    categorias = new CategoriaDao().listar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
             %>
            <div class="categoria">
                <label for="categoria">Categoría:</label>
                <select id="categoria" name="categoria" class="inputForm">
                    <option value="" disabled selected>-- Seleccione una categoría --</option>
                    <% for (CategoriaVo categoria : categorias) { %>
                        <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNombreCategoria() %></option>
                    <% } %>
                </select>
                <span class="fbForm">Hola Mundo</span>
            </div>
                    
            
    

            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="registerProduct">Registrar</button>
            </div>
        </div>
    </form>
</main> 
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsProd/registerProd1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>