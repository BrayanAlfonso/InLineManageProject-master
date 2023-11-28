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
<%@ page import="model.ProductoVo"%>
<%@ page import="model.ProductoDao"%>
<%@ page import="model.CategoriaVo"%>
<%@ page import="model.CategoriaDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="Product?enviar=registerProduct">Agregar</a></button>
            <!-- Menú desplegable -->
            <select class="selectMenu" id="selectMenu">
                <option class="opciones" value="" disabled selected>Mas opciones</option>
                <option class="opciones" value="category">Categoria</option>
                <option class="opciones" value="existence">Existencia</option>
            </select>
            <button class="btnMenu" id="abrirModalReportes">Generar reporte Filtrado</button>
            <!-- <button class="btnMenu"><a href="/inlinemanage/Reports?enviar=product_filter?IdCategory=1">Generar reporte Filtrado</a></button> -->
            <input type="text" placeholder="buscar" class="inputSearch" id="searchInput">
        </div>
        <div class="content2">
            
            <div class="modal" id="modalReportes">
                <div class="modalBody">
                    <div class="modalHeader">
                        <h1>Reportes</h1>
                        <span class="cerrarModal" id="cerrarModal">&times;</span>
                    </div>
                    <div class="modalContent">
                        
                        <form action="Reports" class="formReports">
                            <div class="divReports">
                                <div class="divContent">
                                    <button class="btnReport"><a href="/inlinemanage/Reports?enviar=product">Reporte completo</a></button>
                                </div>
                                <% List<CategoriaVo> categorias = null;
                                    try {
                                        categorias = new CategoriaDao().listar();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>
                                <div class="divContent2">
                                    <h1>Reporte filtrado</h1>
                                    <div class="categoria">
                                        <label for="idCategory">Categoría:</label>
                                        <select id="idCategory" name="idCategory" class="inputForm">
                                            <option value="" disabled selected>-- Seleccione una categoría --</option>
                                            <% for (CategoriaVo categoria : categorias) { %>
                                                <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNombreCategoria() %></option>
                                            <% } %>
                                        </select>
                                        <span class="fbForm">Hola Mundo</span>
                                    </div>

                                    <button name="enviar" value="product_filter">Generar reporte filtrado</button>
                                </div>    

                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>

        
            <%List <ProductoVo> productos = null;
            try {
                productos = new ProductoDao().listar();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        <div class="tabla-scroll">
            <%-- Verificar si hay productos y mostrarlos --%>
            <%if (productos != null && !productos.isEmpty()) {%>
                <table>
                    <tr class="title-table">
                        <th colspan="10" class="title-table">PRODUCTOS</th>
                    </tr>
                    <tr>
                        <th rowspan="2">Unidades Disponibles</th>
                        <th rowspan="2">Producto</th>
                        <th rowspan="2">Precio</th>
                        <th rowspan="2">Descripcion</th>
                        <th rowspan="2">serial</th>
                        <th rowspan="2">Garantia de entrada</th>
                        <th rowspan="2">Garantia de venta</th>
                        <th rowspan="2">Categoria</th>
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
                    <% for (ProductoVo producto : productos) { %>
                        <tr>
                            <td><%=producto.getUnidadesDisponibles()%></td>
                            <td><%=producto.getNombreProducto()%></td>
                            <td><%=producto.getPrecioVenta()%></td>
                            <td><%=producto.getDescripcion()%></td>
                            <td><%=producto.getSerial()%></td>
                            <td><%=producto.getGarantiaEntradaMeses()%></td>
                            <td><%=producto.getGarantiaVentaMeses()%></td>
                            
                            <% for (CategoriaVo categoria : categorias) { %>
                                <% if(categoria.getIdCategoria() == producto.getIdCategoria()){ %>
                                  <td><%=categoria.getNombreCategoria()%></td>
                                <% } %>
                            <%}%>
                            <td class="iconCenter"><a href="Product?enviar=updateProduct&idProducto=<%= producto.getIdProducto() %>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                            <td class="iconCenter"><a href="Product?enviar=deleteProduct&idProducto=<%= producto.getIdProducto() %>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
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
<script src="assets/js/JsProd/searchProd1.js"></script>
<%@ include file="../plantillas/footer2.jsp"%>


<%
}else{
    response.sendRedirect(request.getContextPath() + "/ControllerInline?enviar=index");
}
%>