<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>

<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo" %>
<%@ page import="model.CategoriaDao" %>

<main class="main" id="mainForm">  
    <div>
        <a href="ControllerInline?enviar=categoria"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
    </div><br>
    
    <%-- Obtener el id del producto seleccionado de la URL --%>
    <% String cateId = request.getParameter("idCategoria"); %>
    <% int id = Integer.parseInt(cateId); %>
    <% CategoriaVo categoria = null;
    try {
        categoria = new CategoriaDao().obtenerCategorytPorId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Verificar si se encontró el usuario y mostrar el formulario de actualización --%>
    <% if (categoria != null) { %>
    <form action="ControllerInline" method="post">
        <h1 class="title-table">Actualizacion de categoria</h1>

        <input type="hidden" name="idCategoria" id="idCategoria" value="<%= categoria.getIdCategoria() %>">

        <div class="contentForm">
    
            <div class="divNameProd">
                <label for="UpdateNameCategory">Nombre de producto:</label>
                <input type="text" id="UpdateNameCategory" name="UpdateNameCategory"value="<%=  categoria.getNombreCategoria() %>" class="inputForm">
            </div>

    
            <div class="divBtnForm">
                <button class="btnForm" name="enviar" value="updateCategory">Actualizar</button>
            </div>
        </div>
    </form>
    <% } else { %>
        <p>No se encontró el usuario.</p>
    <% } %>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>


updateCategory.jsp