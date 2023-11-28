<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>

<%@ include file="../plantillas/header.jsp"%>
<%-- Importar la clase UsuarioVo y UsuarioDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo" %>
<%@ page import="model.CategoriaDao" %>

<main class="main" id="mainForm">  
    <div>
        <a href="category?enviar=categoria"><img src="assets/img/back.PNG" alt="backlog" class="backlogForm"></a>
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
    <form action="category" method="post" id="formValidacion">
        <h1 class="title-table">Actualizacion de categoria</h1>

        <input type="hidden" name="idCategoria" id="idCategoria" value="<%= categoria.getIdCategoria() %>">

        <div class="contentForm">
    
            <div class="divCategoria">
                <label for="UpdateNameCategory">Nombre de producto:</label>
                <input type="text" id="UpdateNameCategory" name="UpdateNameCategory"value="<%=  categoria.getNombreCategoria() %>" class="inputForm">
                <span class="fbForm"></span>
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
<script src="assets/js/JsCate/updateCate.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>