<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../plantillas/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.EntradaVo"%>
<%@ page import="model.EntradaDao"%>
<%@ page import="model.ProveedorVo" %>
<%@ page import="model.ProveedorDao" %>

<main class="main">  
    <div class="content1">
        <div class="options">
            <div class="backlog">
                <a href="ControllerInline?enviar=supplier"><img src="assets/img/back.PNG" alt="backlog" class="backlog"></a>
            </div>
            <button class="btnMenu" ><a href="entrada?enviar=registerEntrada">Agregar</a></button>
            <br>
            <input type="text" placeholder="buscar" class="inputSearch" id="searchInput">
        </div>
        <div class="content2">
        
            <%List <EntradaVo> entradas = null;
               try {
                entradas = new EntradaDao().listar();
               } catch (Exception e) {
                   e.printStackTrace();
               }
            %>

            <% List<ProveedorVo> provs = null;
                try {
                    provs = new ProveedorDao().listarProv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        
            <%-- Verificar si hay entrada de productos y mostrarlos --%>
            <%if (entradas != null && !entradas.isEmpty()) {%>
                <table class="<%=(entradas.size() > 8) ? "" : "few-rows"%>">
                    <tr class="title-table">
                        <th colspan="7" class="title-table">ENTRADAS</th>
                    </tr>
                    <tr>
                        <th rowspan="2">N_entrada</th>
                        <th rowspan="2">Fecha</th>
                        <th rowspan="2">Proveedor</th>
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
                    <%-- Recorrer la lista de entradas y mostrar sus detalles --%>
                    <% for (EntradaVo entrada : entradas) { %>
                        <tr>
                            <td><%=entrada.getIdEntradaProd()%></td>
                            <td><%=entrada.getFechaIngreso()%></td>
                        <% for (ProveedorVo proveedor : provs) { %>
                            <% if(proveedor.getIdProveedor() == entrada.getIdProveedor()){ %>
                            <td><%= proveedor.getNombreProveedor()%></td>
                            <% }%>
                        <% } %>

                            <td class="iconCenter"><a href="entrada?enviar=updateEntrada&idEntradaProd=<%=entrada.getIdEntradaProd()%>"><img src="https://img.icons8.com/ios/100/000000/refresh--v1.png" alt="refresh--v1" class="iconUpdate"/></a></td>
                            <td class="iconCenter"><a href="entrada?enviar=deleteEntrada&idEntradaProd=<%=entrada.getIdEntradaProd()%>"><img height="30" src="https://img.icons8.com/ios/100/000000/delete--v1.png" alt="delete--v1" class="iconDelete"/></a></td>
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
<script src=""></script>