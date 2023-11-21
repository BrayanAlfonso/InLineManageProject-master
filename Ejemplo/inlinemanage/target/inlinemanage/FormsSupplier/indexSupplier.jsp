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
            <button class="btn" id="btnInsertSupplier" > <a href="Supplier?enviar=registerSupplier">Agregar</a></button>
            <button class="btn" id="btnInsertSupplier" > <a href="entrada?enviar=entrada">Entrada de producto</a></button>
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
                    <td class="iconCenter"><a href="Supplier?enviar=updateSupplier&idProveedor=<%= prov.getIdProveedor() %>"><i class="fa-solid fa-repeat" style="color: #54AC9C;" alt="refresh--v1" class="iconUpdate"></i></a></td>
                    <td class="iconCenter"><a href="Supplier?enviar=deleteSupplier&idProveedor=<%= prov.getIdProveedor() %>"><i class="fa-solid fa-trash" style="color: #ff0000;" alt="delete--v1" class="iconDelete"></i></a></td>
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