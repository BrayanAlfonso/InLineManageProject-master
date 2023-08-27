<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductoVo"%>
<%@ page import="model.ProductoDao"%>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="ControllerInline?enviar=registerProduct">Agregar</a></button>
            <button class="btnMenu" ><a href="ControllerInline?enviar=categoria">Categoria</a></button>
            <button class="btnMenu"><a href="ControllerInline?enviar=existence">Existencia</a></button>
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">


        
            <%List <ProductoVo> productos = null;
            try {
                productos = new ProductoDao().listar();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        
            <%-- Verificar si hay productos y mostrarlos --%>
            <%if (productos != null && !productos.isEmpty()) {%>
                <table class="<%=(productos.size() > 8) ? "" : "few-rows"%>">
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
                            <td><%=producto.getIdCategoria()%></td>
                            <td class="iconCenter"><a href="ControllerInline?enviar=updateProduct&idProducto=<%= producto.getIdProducto() %>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                            <td class="iconCenter"><a href="ControllerInline?enviar=deleteProduct&idProducto=<%= producto.getIdProducto() %>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
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

<%@ include file="../plantillas/footer2.jsp"%>