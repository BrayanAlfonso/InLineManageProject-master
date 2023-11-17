<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=product"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
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
        
            <%-- Verificar si hay productos y mostrarlos --%>
            <%if (categorias != null && !categorias.isEmpty()) {%>
                <table class="<%=(categorias.size() > 8) ? "" : "few-rows"%>">
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
                            <td class="iconCenter"><a href="category?enviar=updateCategory&idCategoria=<%=categoria.getIdCategoria()%>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                            <td class="iconCenter"><a href="category?enviar=deleteCategory&idCategoria=<%=categoria.getIdCategoria()%>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
                        </tr>
                    <%}%>
                </table>
            <%} else{%>
                <p>No se encontraron Productos.</p>
            <%}%>

    </div>
</div>

</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>
<script src="assets/js/JsCate/searchCate.js"></script>