<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.RequestDispatcher"%>

<%
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("idUsuario")!=null){
%>


<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="Product?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="category?enviar=registerCategory">Agregar</a></button>
            <br>
            <input type="text" placeholder="buscar" class="inputSearch" id="searchInput">
        </div>
        <div class="content2">
        
            <%List <CategoriaVo> categorias = null;
               try {
                categorias = new CategoriaDao().listar();
               } catch (Exception e) {
                   e.printStackTrace();
               }
            %>
        <div class="tabla-scroll">
            <%-- Verificar si hay productos y mostrarlos --%>
            <%if (categorias != null && !categorias.isEmpty()) {%>
                <table>
                    <tr class="title-table">
                        <th colspan="7" class="title-table">CATEGORIA</th>
                    </tr>
                    <tr>
                        <th rowspan="2">N_Categoria</th>
                        <th rowspan="2">Nombre de categoria</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                    <tr>
                        <th>
                            Actualizar
                        </th>
                        <th>
                            Eliminar
                        </th>
                    </tr>
                    <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                    <% for (CategoriaVo categoria : categorias) { %>
                        <tr>
                            <td><%=categoria.getIdCategoria()%></td>
                            <td><%=categoria.getNombreCategoria()%></td>
                            <td class="iconCenter"><a href="category?enviar=updateCategory&idCategoria=<%=categoria.getIdCategoria()%>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                            <td class="iconCenter"><a href="category?enviar=deleteCategory&idCategoria=<%=categoria.getIdCategoria()%>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
                        </tr>
                    <%}%>
                </table>
            <%} else{%>
                <p>No se encontraron Productos.</p>
            <%}%>
        </div>
    </div>
</div>

<!-- Declaración de la variable mensaje que se trae desde el controlador "ControllerInline"-->
                        <% String mensaje1 = (String) request.getAttribute("mensaje1"); %> 
    
                        <!-- Campo para mostrar el mensaje traido desde Java -->
                        <% if (mensaje1 == null) {%>
                            <div></div>
                        <%}else{%>
                            <div id="mensaje1"></div>
                        <%}%>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script>
    let mensajeJS="<%= mensaje1 %>"
</script>
<script src="assets/js/JsCate/searchCate.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>

<%
}else{
    request.setAttribute("mensaje", "Debes iniciar sesión.");
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>