<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%-- Importar la clase ProveedorVo y ProveedorDao --%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>

<main class="main">
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=main"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btn" id="btnInsertSupplier" > <a href="ControllerInline?enviar=registerSupplier">Agregar</a></button>
            <button class="btn" id="btnInsertSupplier" > <a href="ControllerInline?enviar=entrada">Entrada de producto</a></button>
            <input type="text" placeholder="buscar" class="inputSearch">
        </div>
        <div class="content2">

            <%-- Obtener la lista de proveedores desde la base de datos --%>
            <% List<ProveedorVo> provs = null;
            try {
                provs = new ProveedorDao().listarProv();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>

            <%-- Verificar si hay proveedores y mostrarlos --%>
            <% if (provs != null && !provs.isEmpty()) { %>
            <table class="<%=(provs.size() > 10) ? "" : "few-rows"%>">
                <tr class="title-table">
                    <th colspan="7">PROVEEDORES</th>
                </tr>
                <tr>
                    <th rowspan="2">Nombre</th>
                    <th rowspan="2">Dirección</th>
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
                
                <%-- Recorrer la lista de proveedores y mostrar sus detalles --%>
                <% for (ProveedorVo prov : provs) { %>
                <tr>
                    <td><%= prov.getNombreProveedor() %></td>
                    <td><%= prov.getDireccionProveedor() %></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=updateSupplier&idProveedor=<%= prov.getIdProveedor() %>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                    <td class="iconCenter"><a href="ControllerInline?enviar=deleteSupplier&idProveedor=<%= prov.getIdProveedor() %>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
                </tr>
                <% } %>

            </table>

            <% } else { %>
                <p>No se encontraron proveedores.</p>
            <% } %>

    </div>


</div>
<div class="form">
    
</div>
</main>
    
    
<%@ include file="../plantillas/footer.jsp"%>